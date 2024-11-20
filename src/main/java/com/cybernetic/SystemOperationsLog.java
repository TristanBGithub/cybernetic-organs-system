package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SystemOperationsLog {
    private int top;
    private SystemOperation[] stack;
    private int size;

    public SystemOperationsLog(int size) {
        this.size = size;
        stack = new SystemOperation[size];
        top = -1;
    }

    public void pushOperation(SystemOperation operation) {
        if (isFull())
            throw new IndexOutOfBoundsException("Log is full.");

        stack[++top] = operation;
    }

    public SystemOperation popLastOperation() {
        if (isEmpty())
            throw new IllegalArgumentException("Log is empty");

        return stack[top--];
    }

    public SystemOperation peekLastOperation() {
        if (isEmpty())
            throw new IllegalArgumentException("Log is empty");

        return stack[top];
    }

    public void undoLastOperation() {
        if (isEmpty())
            throw new IllegalArgumentException("Log is empty");

        if (stack[top].isReversible)
            popLastOperation();
    }

    public List<SystemOperation> getRecentOperations(int count) {
        List<SystemOperation> recent = new ArrayList<>(Arrays.stream(Arrays.copyOfRange(stack, 0, count)).toList());
        Collections.reverse(recent);
        return recent;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }
}
