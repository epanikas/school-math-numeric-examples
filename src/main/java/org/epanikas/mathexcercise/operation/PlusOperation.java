package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlusOperation implements BinaryOperation {

    private final Operation a;
    private final Operation b;

    @Override
    public Operation getOperand1() {
        return a;
    }

    @Override
    public Operation getOperand2() {
        return b;
    }

    @Override
    public String asMathMl() {
        return a.asMathMl() + " + " + b.asMathMl();
    }

    @Override
    public int result() {
        return a.result() + b.result();
    }
}
