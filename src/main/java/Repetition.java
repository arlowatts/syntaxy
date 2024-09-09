public class Repetition implements Expression {
    private static final String BEGINNING = "{ ";
    private static final String ENDING = " }";
    private static final String SEPARATOR = " ";

    private static final String RANGE_BEGINNING = "{ ";
    private static final String RANGE_ENDING = " }";
    private static final String RANGE_SEPARATOR = ",";

    private int minimum;
    private int maximum;
    private Expression expression;

    public Repetition(int minimum, int maximum, Expression expression) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.expression = expression;
    }

    public boolean matches(String value) {
        return matches(value, 0);
    }

    private boolean matches(String value, int repetitionCount) {
        if (repetitionCount == maximum) {
            return value.isEmpty();
        }

        if (value.isEmpty()) {
            return repetitionCount >= minimum;
        }

        for (int i = 0; i <= value.length(); i++) {
            if (expression.matches(value.substring(0, i)) && matches(value.substring(i), repetitionCount + 1)) {
                return true;
            }
        }

        return false;
    }

    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = (int)(Math.random() * (maximum - minimum + 1)) + minimum; i > 0; i--) {
            stringBuilder.append(expression.generate());
        }

        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BEGINNING);

        stringBuilder.append(RANGE_BEGINNING);
        stringBuilder.append(minimum);
        stringBuilder.append(RANGE_SEPARATOR);
        stringBuilder.append(maximum);
        stringBuilder.append(RANGE_ENDING);

        stringBuilder.append(SEPARATOR);

        stringBuilder.append(expression);

        stringBuilder.append(ENDING);

        return stringBuilder.toString();
    }
}
