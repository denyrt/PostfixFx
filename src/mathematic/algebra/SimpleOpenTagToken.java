package mathematic.algebra;

import mathematic.CloseTagToken;
import mathematic.OpenTagToken;

public final class SimpleOpenTagToken<T> implements OpenTagToken<T> {

    private SimpleOpenTagToken() {

    }

    @Override
    public CloseTagToken<T> getCloseTag() {
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
