public class Option implements Expression {
    private static final String BEGINNING = "[ ";
    private static final String ENDING = " ]";

    private Expression expression;

    public Option(Expression expression) {
        this.expression = expression;
    }

    public boolean matches(String value) {
        return value.isEmpty() || expression.matches(value);
    }

    public String generate() {
        if (Math.random() < 0.5) {
            return expression.generate();
        }

        return "";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BEGINNING);
        stringBuilder.append(expression);
        stringBuilder.append(ENDING);

        return stringBuilder.toString();
    }
}
