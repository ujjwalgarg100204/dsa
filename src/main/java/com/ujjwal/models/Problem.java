package com.ujjwal.models;

import com.ujjwal.annotations.Solution;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Problem<Input, Output extends Comparable<Output>>{
    public abstract
    String getName();

    public abstract String getProblemLink();

    public abstract List<TestCase<Input, Output>> getTestCases();

    public List<Method> getImplementations() {
        List<Method> implementations = new ArrayList<>();

        // get all methods from the class
        Method[] methods = getClass().getDeclaredMethods();

        for (Method method: methods) {
            if (method.isAnnotationPresent(Solution.class)) {
                implementations.add(method);
            }
        }

        return implementations;
    }
}
