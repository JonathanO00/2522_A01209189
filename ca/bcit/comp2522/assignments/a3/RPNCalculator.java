package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

public class RPNCalculator {
    /** Minimum stack size. */
    private static final int MIN_STACK_SIZE = 2;
    /** The stack. */
    private Stack stack;

    /**
     * Calculator constructor.
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
     * @return
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
                    push(scan.nextInt());
                } else {
                    Operation o = getOperation((scan.next());
                }
            }
        }

        return getResult();
    }

    private void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("Stack is full!");
        } else {
            stack.push(operand);
        }
    }

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

    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        } else {
            return stack.peek();
        }
    }

    private void perform(final Operation operation) {

    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *               to be created followed by the expression to evaluate.
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
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
}
