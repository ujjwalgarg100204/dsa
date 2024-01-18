package com.ujjwal.models;

import com.ujjwal.annotations.Solution;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public abstract class DSAProblem<Input, Output> {

    public abstract String getProblemLink();

    public abstract List<TestCase<Input, Output>> getTestCases();

    public List<Method> getSolutions() {
        return Arrays.stream(getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Solution.class))
                .toList();
    }
}
