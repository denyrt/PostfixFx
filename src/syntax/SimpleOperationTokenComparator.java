package syntax;

import mathematic.OperationToken;

import java.util.Comparator;

public final class SimpleOperationTokenComparator<T> implements Comparator<OperationToken<T>> {

    @Override
    public int compare(OperationToken<T> o1, OperationToken<T> o2) {
        return Integer.compare(o1.getKey().length(), o2.getKey().length());
    }
}