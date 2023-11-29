package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String methodName;
        String returnType;
        String accessModifier = null;
        StringTokenizer r = new StringTokenizer(signatureString, "(/)");
        String x1 = r.nextToken();
        List<MethodSignature.Argument> ar = new ArrayList<>();
        if (r.hasMoreTokens()) {
            String arg = r.nextToken();
            StringTokenizer a1 = new StringTokenizer(arg, ",");

            while (a1.hasMoreTokens()) {
                String a12 = a1.nextToken();
                StringTokenizer a2 = new StringTokenizer(a12, " ");
                String type = a2.nextToken();
                String name = a2.nextToken();
                ar.add(new MethodSignature.Argument(type, name));

            }
        }

        StringTokenizer r2 = new StringTokenizer(x1, " ");

        if (r2.countTokens() == 3) {
            accessModifier = r2.nextToken();
        }
        returnType = r2.nextToken();
        methodName = r2.nextToken();
        MethodSignature ms1 = new MethodSignature(methodName, ar);
        ms1.setMethodName(methodName);
        ms1.setAccessModifier(accessModifier);
        ms1.setReturnType(returnType);
        return ms1;
    }
}
