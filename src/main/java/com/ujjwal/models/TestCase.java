package com.ujjwal.models;

public record TestCase<Input, Output extends Comparable<Output>>(Input input, Output expected) {
}
