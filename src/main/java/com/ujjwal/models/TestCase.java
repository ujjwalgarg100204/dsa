package com.ujjwal.models;

public record TestCase<Input, ExpectedOutput>(Input input, ExpectedOutput expectedOutput) {
}
