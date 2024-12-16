package org.epanikas.mathexcercise.operation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperationConfig {

    private final int numOperationsInOperand;

    public int getNumOperationsInOperand() {
        return numOperationsInOperand;
    }
}
