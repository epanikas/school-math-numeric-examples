package org.epanikas.mathexcercise.operation;

public interface BinaryOperation extends Operation {

    Operation getOperand1();
    Operation getOperand2();

}
