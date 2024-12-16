package org.epanikas.mathexcercise;

import org.apache.commons.io.IOUtils;
import org.epanikas.mathexcercise.generators.impl.MathGeneratorImpl;
import org.epanikas.mathexcercise.operation.MathExample;
import org.epanikas.mathexcercise.operation.OperationConfig;
import org.epanikas.mathexcercise.operation.OperationName;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {


    public static void main(String[] args) throws IOException {

        InputStream templateResource = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("template/index.tmpl.html");
        if (templateResource == null) {
            throw new IllegalArgumentException("template not found: classpath:" + "template/index.tmpl.html");
        }
        String html = IOUtils.toString(templateResource, StandardCharsets.UTF_8);


//        html = new PlusMinusMathGenerator(html).generate("%table1%");
//        html = new PlusMinusMathGenerator(html).generate("%table2%");
        List<MathExample> mathExamples = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            mathExamples.add(new MathGeneratorImpl(3, createOperationsConfig()).generateRandom());
        }

        html = replacePlaceholder(html, "%table1%", mathExamples, 10);

        BufferedWriter writer = new BufferedWriter(new FileWriter("out/plus-excercises.html"));
        writer.write(html);
        writer.close();

    }

    private static Map<OperationName, OperationConfig> createOperationsConfig() {
        Map<OperationName, OperationConfig> allowedOperations = new HashMap<>();

        allowedOperations.put(OperationName.plus, new OperationConfig(100));
        allowedOperations.put(OperationName.minus, new OperationConfig(100));
        allowedOperations.put(OperationName.logarithm, new OperationConfig(1));
        allowedOperations.put(OperationName.power, new OperationConfig(1));
        allowedOperations.put(OperationName.root, new OperationConfig(1));

        return allowedOperations;
    }


    private static String replacePlaceholder(String template, String placeholder, List<MathExample> mathExamples, int pageSize) {



//        List<String> rows = new ArrayList<>();
//        String sign = "+";
//        for (int i = 0; i < 18; ++i) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean closed = false;
        int page = 0;
        for (int i = 0; i < mathExamples.size(); ++i) {
//            rows.add("$$\\sqrt{4}$$");
//            sign = sign.equals("+") ? "-" : "+";
//            rows.add("$${" + getRandom() + " " + sign + " " + getRandom() + " + " + "\\sqrt{4}}$$");
            if (i % pageSize == 0) {
                stringBuilder.append("<table>\n");
                closed = false;
                page++;
            }

//            rows.add("$${" + mathExample.asMathMl() + "}$$");
            stringBuilder
                    .append("\t<tr>\n")
                    .append("\t\t<td class='ind'>").append(i + 1).append("</td>\n")
                    .append("\t\t<td class='expr'>").append("$${").append(mathExamples.get(i).asMathMl()).append("}$$").append("</td>\n")
                    .append("\t\t<td class='equals'>").append(" = ").append("</td>\n")
                    .append("\t\t<td class='answer'>").append(" ").append("</td>\n")
                    .append("\t\t</tr>\n");

            if (i % pageSize == pageSize - 1) {
                stringBuilder.append("</table>\n");
                closed = true;
                if (page % 2 == 0) {
                    stringBuilder.append("\n<div class=\"pagebreak\"> </div>\n");
                }
            }


        }

        if (!closed) {
            stringBuilder.append("</table>\n");
        }



        return template.replace(placeholder, stringBuilder.toString());

    }

}


