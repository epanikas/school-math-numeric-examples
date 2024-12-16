package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NegativeOperation implements UnaryOperation {

    private final Operation a;

    @Override
    public Operation getOperand() {
        return a;
    }

    @Override
    public String asMathMl() {
        return "-" + a.asMathMl();
    }

    @Override
    public int result() {
        return -1 * a.result();
    }
}
