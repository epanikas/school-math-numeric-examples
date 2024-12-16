package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MathExample {

    private final Operation operation;

    public String asMathMl() {
        return operation.asMathMl();
    }

}
