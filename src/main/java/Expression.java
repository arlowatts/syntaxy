public interface Expression {
    /**
     * Check the syntax of a `String` against the pattern associated with this `Expression`.
     * @param value the string to be matched.
     * @return `true` if `value` matches this `Expression`, `false` otherwise.
     **/
    public boolean matches(String value);

    /**
     * Generate a `String` according to the pattern associated with this `Expression`.
     * When more than one `String` matches this `Expression`, one is chosen at random (not necessarily uniformly).
     * @return a `String` that matches this `Expression`.
     **/
    public String generate();

    /**
     * Serialize this `Expression` using the default `String` representation.
     * If the `Expression`'s pattern includes special characters, it may not be possible to deserialize the returned `String` or the result may be different from what is expected.
     * @return a `String` representation of this `Expression`.
     **/
    public String toString();
}
