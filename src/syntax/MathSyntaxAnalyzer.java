package syntax;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mathematic.OperandToken;
import mathematic.OperationToken;
import mathematic.Token;
import mathematic.algebra.ReservedOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class MathSyntaxAnalyzer {

    private final ArrayList<OperationToken<Double>> operationTokens;
    private final ObservableList<ErrorEntry> errorEntries;

    public MathSyntaxAnalyzer() {
        this(ReservedOperations.getBaseOperationTokens());
    }

    public MathSyntaxAnalyzer(Collection<OperationToken<Double>> operationTokens) {
        this.operationTokens = new ArrayList<>(operationTokens);
        this.errorEntries = FXCollections.emptyObservableList();
        this.operationTokens.sort(new SimpleOperationTokenComparator());
    }

    public ObservableList<ErrorEntry> getErrorEntries() {
        return errorEntries;
    }

    public ArrayList<Token<Double>> Parse(String infixStringExpression) {
        errorEntries.clear();
        var tokens = new ArrayList<Token<Double>>();
        var index = 0;

        while (index < infixStringExpression.length()) {

        }

        return tokens;
    }
}