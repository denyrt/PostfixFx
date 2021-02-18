package syntax;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mathematic.*;
import mathematic.algebra.ReservedOperations;
import mathematic.algebra.SimpleOperandToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

public final class MathSyntaxAnalyzer {

    private final ArrayList<OperationToken<Double>> operationTokens;
    private final ObservableList<ErrorEntry> errorEntries;

    public MathSyntaxAnalyzer() {
        this(ReservedOperations.getBaseOperationTokens());
    }

    public MathSyntaxAnalyzer(Collection<OperationToken<Double>> operationTokens) {
        if (operationTokens == null)
            throw new NullPointerException("'operationTokens' was null.");

        this.operationTokens = new ArrayList<>(operationTokens);
        this.errorEntries = FXCollections.emptyObservableList();
        this.operationTokens.sort(new SimpleOperationTokenComparator());
    }

    public ObservableList<ErrorEntry> getErrorEntries() {
        return errorEntries;
    }

    public ArrayList<Token<Double>> parseInfix(String infixStringExpression) {
        errorEntries.clear();
        var tokens = new ArrayList<Token<Double>>();
        var index = 0;

        while (index <= infixStringExpression.length() - 1) {

            if (Character.isSpaceChar(infixStringExpression.charAt(index)))
            {
                ++index;
                continue;
            }

            Token<Double> token = null;

            for (var operation: operationTokens) {

                if (operation.getKey().length() > infixStringExpression.length() - index)
                    continue;

                if (infixStringExpression.startsWith(operation.getKey(), index)) {
                    token = operation;

                    var lastOperation = tokens.size() == 0 ? null : tokens.get(tokens.size() - 1);
                    if (lastOperation == null ||
                       (lastOperation instanceof BinaryToken || lastOperation instanceof OpenTagToken))
                    {
                        var sameUnary = operationTokens.stream()
                                .filter(op -> op.getKey() == operation.getKey() && op instanceof UnaryToken)
                                .findFirst();

                        if (sameUnary != null)
                            token = sameUnary.get();
                    }

                    index += operation.getKey().length();
                    break;
                }
            }

            if (token == null) {
                var numberPattern = Pattern.compile("(\\d)+(\\.?(\\d)+)?");
                var matcher = numberPattern.matcher(infixStringExpression);
                var match = matcher.find(index);

                if (match) {
                    var stringValue = infixStringExpression.substring(matcher.start(), matcher.end());

                    try {
                        var value = Double.parseDouble(stringValue);
                        token = new SimpleOperandToken<>(value);
                        index = matcher.end();
                    }
                    catch (Exception ex) {
                        var lastSpaceIndex = infixStringExpression.indexOf(' ', index);
                        if (lastSpaceIndex == -1) lastSpaceIndex = infixStringExpression.length() - 1;
                        var error = new ErrorEntry(ex.getMessage(), index, lastSpaceIndex);
                        errorEntries.add(error);
                        index = lastSpaceIndex;
                    }
                }
            }

            if (token != null)
                tokens.add(token);
            else
                ++index;
        }

        return tokens;
    }
}