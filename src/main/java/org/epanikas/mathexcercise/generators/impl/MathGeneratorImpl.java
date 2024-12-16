package org.epanikas.mathexcercise.generators.impl;

import lombok.RequiredArgsConstructor;
import org.epanikas.mathexcercise.generators.MathExcerciseGenerator;
import org.epanikas.mathexcercise.operation.IntNumber;
import org.epanikas.mathexcercise.operation.LogarithmOperation;
import org.epanikas.mathexcercise.operation.MathExample;
import org.epanikas.mathexcercise.operation.MinusOperation;
import org.epanikas.mathexcercise.operation.Operation;
import org.epanikas.mathexcercise.operation.OperationConfig;
import org.epanikas.mathexcercise.operation.OperationName;
import org.epanikas.mathexcercise.operation.PlusOperation;
import org.epanikas.mathexcercise.operation.PowerOperation;
import org.epanikas.mathexcercise.operation.RootOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MathGeneratorImpl implements MathExcerciseGenerator {

    private final int min = 1;
    private final int max = 99;




    private final int numOperations;
    private final Map<OperationName, OperationConfig> allowedOperations;

    private Operation generateRandomOperand(int numOperations) {

        int numOperationsOperand1 = (int)Math.round((numOperations - 1) / 2.0);
        int numOperationsOperand2 = numOperations - 1 - numOperationsOperand1;

        if (numOperations == 0) {
            return IntNumber.createRandom(0, 200);
        }

        List<OperationName> allowed = new ArrayList<>(allowedOperations.keySet());
        if (numOperations > 1) {
            allowed = allowed.stream().filter(oc -> allowedOperations.get(oc).getNumOperationsInOperand() > 1).toList();
        }

        OperationName operationName = allowed.get(IntNumber.createRandom(0, allowed.size() - 1).getValue());

//        if (operationName != OperationName.plus && operationName != OperationName.minus) {
//            operationName = OperationName.logarithm;
//        }

        switch (operationName) {
            case plus -> {
                Operation a = generateRandomOperand(numOperationsOperand1);
                Operation b = generateRandomOperand(numOperationsOperand2);
                return new PlusOperation(a, b);
            }
            case minus -> {
                Operation a = generateRandomOperand(numOperationsOperand1);
                Operation b = generateRandomOperand(numOperationsOperand2);

                int resA = a.result();
                int resB = b.result();
                if (resA > resB) {
                    return new MinusOperation(a, b);
                } else {
                    return new MinusOperation(b, a);
                }
            }
            case logarithm -> {
//                Operation b = generateRandomOperand(0);
//                return new LogOperation(3, b);
                return LogarithmOperation.createRandom(7, 400);
            }
            case power -> {
//                Operation b = generateRandomOperand(0);
//                return new PowerOperation(3, b);
                return PowerOperation.createRandom(7, 400);
            }
            case root -> {
//                Operation b = generateRandomOperand(0);
//                return new RootOperation(3, b);
                return RootOperation.createRandom(7, 400);
            }
            default -> {
                return IntNumber.create(-79);
            }
        }
    }


    @Override
    public MathExample generateRandom() {

        Operation op = generateRandomOperand(numOperations);




//        Operation op = new PlusOperation(
//                new MinusOperation(
//                        new RootOperation(3,
//                                new LogOperation(4, IntNumber.create(16))
//                        ),
//                        IntNumber.create(6)
//                ),
//                new PowerOperation(4, IntNumber.create(16)));

        return new MathExample(op);

    }

}
