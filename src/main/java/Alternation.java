/**
 * An `Alternation` matches a `String` if any of its children matches that `String`.
 **/
public class Alternation implements Expression {
    private static final String BEGINNING = "( ";
    private static final String ENDING = " )";
    private static final String SEPARATOR = " | ";

    private Expression[] expressions;

    /**
     * Initializes a newly created `Alternation` with the given array of `Expression`s.
     * @param expressions an array of `Expression`s.
     **/
    public Alternation(Expression... expressions) {
        this.expressions = expressions;
    }

    public boolean matches(String value) {
        for (Expression expression : expressions) {
            if (expression.matches(value)) {
                return true;
            }
        }

        return false;
    }

    public String generate() {
        return expressions[(int)(Math.random() * expressions.length)].generate();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BEGINNING);

        if (expressions.length > 0) {
            stringBuilder.append(expressions[0]);

            for (int i = 1; i < expressions.length; i++) {
                stringBuilder.append(SEPARATOR);
                stringBuilder.append(expressions[i]);
            }
        }

        stringBuilder.append(ENDING);

        return stringBuilder.toString();
    }
}
