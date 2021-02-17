package mathematic;

import org.jetbrains.annotations.Contract;

import java.util.ArrayDeque;
import java.util.Queue;

public final class PolishNotation {

    private PolishNotation() {

    }

    public static <T> Queue<Token<T>> infixToPostfix(Iterable<Token<T>> collection) {
        if (collection == null)
            throw new NullPointerException("'collection' parameter was null.");

        var postfix = new ArrayDeque<Token<T>>();
        var tmpOperations = new ArrayDeque<OperationToken<T>>();

        for (var token: collection) {
            if (token instanceof OperandToken) {
                postfix.addLast(token);
            }
            else if (token instanceof OpenTagToken) {
                tmpOperations.push((OperationToken<T>) token);
            }
            else if (token instanceof CloseTagToken) {
                var closeTag = (CloseTagToken) token;
                OperationToken<T> current;

                while ((current = tmpOperations.pop()) != closeTag.getOpenTag()) {
                    postfix.addLast(current);
                }
            }
            else if (token instanceof OperationToken) {
                var currentOperation = (OperationToken) token;

                while (tmpOperations.size() > 0) {
                    var operation = tmpOperations.pop();

                    if (operation.getPriority() >= currentOperation.getPriority()) {
                        postfix.addLast(operation);
                    }
                    else {
                        tmpOperations.push(operation);
                        break;
                    }
                }

                tmpOperations.push(currentOperation);
            }
            else {
                throw new UnsupportedOperationException("Unsupported instance of Token.");
            }
        }

        while (tmpOperations.size() > 0)
        {
            postfix.addLast(tmpOperations.pop());
        }

        return postfix;
    }

    public static <T> OperandToken<T> calculate (Queue<Token<T>> postfix) {
        if (postfix == null)
            throw new NullPointerException("'postfix' parameter was null.");

        var stackResult = new ArrayDeque<OperandToken<T>>();

        while (postfix.size() > 0) {
            var token = postfix.poll();

            if (token instanceof OperandToken) {
                stackResult.push((OperandToken)token);
            }
            else if (token instanceof BinaryToken) {
                var operationToken = (BinaryToken<T>)token;
                var right = stackResult.pop();
                var left = stackResult.pop();
                var result = operationToken.calculate(left, right);
                stackResult.push(result);
            }
            else if (token instanceof UnaryToken) {
                var operationToken = (UnaryToken<T>)token;
                var value = stackResult.pop();
                var result = operationToken.calculate(value);
                stackResult.push(result);
            }
            else {
                throw new UnsupportedOperationException("Unsupported 'token' implementation.");
            }
        }

        if (stackResult.size() != 1)
            throw new UnsupportedOperationException("Incorrect calculation.");

        return stackResult.pop();
    }
}