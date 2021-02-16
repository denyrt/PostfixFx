package mathematic.algebra;

import mathematic.CloseTagToken;
import mathematic.OpenTagToken;

public final class SimpleCloseTagToken<T> implements CloseTagToken<T> {

    @Override
    public OpenTagToken<T> getCloseTag() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}