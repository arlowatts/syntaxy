/**
 * A `Terminal` matches a single `String`.
 **/
public class Terminal implements Expression {
    private static final String BEGINNING = "\"";
    private static final String ENDING = "\"";

    private String value;

    /**
     * Initializes a newly created `Terminal` with the given value.
     * @param value a `String`.
     **/
    public Terminal(String value) {
        this.value = value;
    }

    public boolean matches(String value) {
        return this.value.equals(value);
    }

    public String generate() {
        return value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BEGINNING);
        stringBuilder.append(value);
        stringBuilder.append(ENDING);

        return stringBuilder.toString();
    }
}
