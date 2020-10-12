package ca.bcit.comp2522.assignments.a3;

public class Stack {
    /** The stack. */
    private int[] stackValues;
    /** Number of values in the stack. */
    private int count = 0;

    /**
     * Stack constructor.
     * @param arraySize
     */
    public Stack(final int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Size must be 1 or greater.");
        } else {
            stackValues = new int[arraySize];
        }
    }

    /**
     * Capacity method.
     * @return stack capacity.
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Stack size.
     * @return Number of values in stack.
     */
    public int size() {
        return count;
    }

    /**
     * Unused values.
     * @return unused values in stack.
     */
    public int unused() {
        return stackValues.length - count;
    }

    /**
     * Adds value into stack.
     * @param value
     */
    public void push(final int value) throws StackOverflowException {
        if (this.unused() == 0) {
            throw new StackOverflowException();
        } else {
            stackValues[count] = value;
            count++;
        }
    }

    /**
     * Pop method.
     * @return removed item from stack.
     */
    public int pop() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.pop() on an empty stack!");
        } else {
            return stackValues[--count];
        }
    }

    /**
     * Peek method.
     * @return top value of stack.
     */
    public int peek() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.peek() on an empty stack!");
        } else {
            return stackValues[count];
        }
    }


}
