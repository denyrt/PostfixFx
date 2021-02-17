package mathematic.algebra;

import mathematic.OperandToken;
import mathematic.OperationToken;

import java.util.ArrayList;

public final class ReservedOperations {

    private ReservedOperations() {

    }

    public static ArrayList<OperationToken<Double>> getBaseOperationTokens() {
        var operations = new ArrayList<OperationToken<Double>>();
        var openTag = new SimpleOpenTagToken<Double>("(", 1);
        var closeTag = new SimpleCloseTagToken<Double>(")", 1);
        openTag.setCloseTag(closeTag);
        closeTag.setOpenTag(openTag);
        operations.add(openTag);
        operations.add(closeTag);
        operations.add(new SimpleBinaryToken<>("+", 2, ReservedOperations::plus));
        operations.add(new SimpleBinaryToken<>("-", 3, ReservedOperations::binaryMinus));
        operations.add(new SimpleUnaryToken<>("-", 4, ReservedOperations::unaryMinus));
        operations.add(new SimpleBinaryToken<>("*", 5, ReservedOperations::multiply));
        operations.add(new SimpleBinaryToken<>("/", 5, ReservedOperations::divide));
        operations.add(new SimpleBinaryToken<>("^", 6, ReservedOperations::pow));
        operations.add(new SimpleUnaryToken<>("sin", 7, ReservedOperations::sin));
        operations.add(new SimpleUnaryToken<>("cos", 7, ReservedOperations::cos));
        return operations;
    }

    public static OperandToken<Double> plus(OperandToken<Double> a, OperandToken<Double> b) {
        return new SimpleOperandToken<>(a.getValue() + b.getValue());
    }

    public static OperandToken<Double> binaryMinus(OperandToken<Double> a, OperandToken<Double> b) {
        return new SimpleOperandToken<>(a.getValue() - b.getValue());
    }

    public static OperandToken<Double> unaryMinus(OperandToken<Double> a) {
        return new SimpleOperandToken<>(-a.getValue());
    }

    public static OperandToken<Double> multiply(OperandToken<Double> a, OperandToken<Double> b) {
        return new SimpleOperandToken<>(a.getValue() * b.getValue());
    }

    public static OperandToken<Double> divide(OperandToken<Double> a, OperandToken<Double> b) {
        return new SimpleOperandToken<>(a.getValue() / b.getValue());
    }

    public static OperandToken<Double> pow(OperandToken<Double> a, OperandToken<Double> b) {
        return new SimpleOperandToken<>(Math.pow(a.getValue(), b.getValue()));
    }

    public static OperandToken<Double> sin(OperandToken<Double> a) {
        return new SimpleOperandToken<>(Math.sin(a.getValue()));
    }

    public static OperandToken<Double> cos(OperandToken<Double> a) {
        return new SimpleOperandToken<>(Math.cos(a.getValue()));
    }
}