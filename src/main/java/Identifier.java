/**
 * An `Identifier` matches a `String` if its referenced `Expression` matches that `String`.
 * Careless use of `Identifier`s can lead to infinite recursion when matching or generating a `String` if there exists a closed loop, such as an `Identifier` referencing itself.
 **/
public class Identifier implements Expression {
    private String value;
    private Expression expression;

    /**
     * Initializes a newly created `Identifier` with the given name and a `null` `Expression`.
     * @param value a `String`.
     **/
    public Identifier(String value) {
        this.value = value;
    }

    /**
     * Sets this `Identifier`'s reference to an `Expression`.
     * @param expression the `Expression` this `Identifier` will reference.
     **/
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
