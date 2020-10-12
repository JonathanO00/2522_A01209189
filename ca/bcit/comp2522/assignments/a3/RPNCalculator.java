package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

public class RPNCalculator {
    /**
     * Minimum stack size.
     */
    public static final int MIN_STACK_SIZE = 2;
    /**
     * The stack.
     */
    private Stack stack;

    /**
     * Calculator constructor.
     *
     * @param stackSize
     */
    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        } else {
            stack = new Stack(stackSize);
        }
    }

    /**
     * Processes formula.
     * @param formula
     * @return Result.
     * @throws StackOverflowException
     * @throws StackUnderflowException
     * @throws InvalidOperationTypeException
     */
    public int processFormula(final String formula)
            throws StackOverflowException,
            StackUnderflowException,
            InvalidOperationTypeException {
        if (formula == null || formula.trim().length() == 0) {
            throw new IllegalArgumentException();
        } else {
            Scanner scan = new Scanner(formula);

            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    this.push(scan.nextInt());
                } else {
                    Operation o = getOperation(scan.next().charAt(0));
                    this.perform(o);
                }
            }
        }

        return getResult();
    }

    /**
     * Pushes int onto stack.
     * @param operand
     * @throws StackOverflowException
     */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("Stack is full!");
        } else {
            stack.push(operand);
        }
    }

    /**
     * Gets operation.
     * @param symbol
     * @return operation.
     * @throws InvalidOperationTypeException
     */
    private Operation getOperation(final char symbol)
            throws InvalidOperationTypeException {
        switch (symbol) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            default:
                throw new InvalidOperationTypeException(symbol);
        }
    }

    /**
     * Gets result.
     * @return result.
     * @throws StackUnderflowException
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        } else {
            return stack.peek();
        }
    }

    /**
     * Performs operation.
     * @param operation
     * @throws StackUnderflowException
     * @throws StackOverflowException
     */
    public void perform(final Operation operation)
            throws StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        } else {
            int operandB = stack.pop();
            int operandA = stack.pop();
            int result = operation.perform(operandA, operandB);
            stack.push(result);
        }
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     * <p>
     * Example usage: RPNCalculator 10 "1 2 +"
     * <p>
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *             to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }

        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);

        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println(
                    "formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println(
                    "too many operands in the formula, increase stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println(
                    "too few operands in the formula");
        }
    }
}
