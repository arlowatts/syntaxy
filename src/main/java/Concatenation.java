public class Concatenation implements Expression {
    private static final String BEGINNING = "( ";
    private static final String ENDING = " )";
    private static final String SEPARATOR = " ";

    private Expression[] expressions;

    public Concatenation(Expression... expressions) {
        this.expressions = expressions;
    }

    public boolean matches(String value) {
        return matches(value, 0);
    }

    private boolean matches(String value, int expressionIndex) {
        if (expressionIndex >= expressions.length) {
            return value.isEmpty();
        }

        for (int i = 0; i <= value.length(); i++) {
            if (expressions[expressionIndex].matches(value.substring(0, i)) && matches(value.substring(i), expressionIndex + 1)) {
                return true;
            }
        }

        return false;
    }

    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Expression expression : expressions) {
            stringBuilder.append(expression.generate());
        }

        return stringBuilder.toString();
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
