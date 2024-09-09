public class Identifier implements Expression {
    private String value;
    private Expression expression;

    public Identifier(String value) {
        this.value = value;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public boolean matches(String value) {
        return expression.matches(value);
    }

    public String generate() {
        return expression.generate();
    }

    public String toString() {
        return value;
    }
}
