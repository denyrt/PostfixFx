package syntax;

public final class ErrorEntry {

    private final String message;
    private final int line;
    private final int index;

    public ErrorEntry(String message, int line, int index) {
        this.message = message;
        this.line = line;
        this.index = index;
    }
}