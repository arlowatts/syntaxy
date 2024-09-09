public class Main {
    public static void main(String[] args) {
        Identifier identifier1 = new Identifier("identifier1");
        Identifier identifier2 = new Identifier("identifier2");

        identifier1.setExpression(
            new Option(
                new Terminal("terminal1")
            )
        );

        identifier2.setExpression(
            new Concatenation(
                new Alternation(
                    new Repetition(1, 3,
                        new Terminal("terminal2")
                    ),
                    new Option(
                        new Concatenation(
                            identifier1,
                            new Terminal("terminal4")
                        )
                    ),
                    new Alternation(
                        new Concatenation(
                            new Terminal("terminal5"),
                            new Terminal("terminal6"),
                            new Terminal("terminal7")
                        ),
                        new Option(
                            identifier1
                        )
                    )
                ),
                new Terminal("terminal10")
            )
        );

        System.out.println("Expecting true:");
        System.out.println(identifier2.matches("terminal10"));
        System.out.println(identifier2.matches("terminal2terminal10"));
        System.out.println(identifier2.matches("terminal2terminal2terminal10"));
        System.out.println(identifier2.matches("terminal2terminal2terminal2terminal10"));
        System.out.println(identifier2.matches("terminal4terminal10"));
        System.out.println(identifier2.matches("terminal1terminal4terminal10"));
        System.out.println(identifier2.matches("terminal5terminal6terminal7terminal10"));
        System.out.println(identifier2.matches("terminal1terminal10"));

        System.out.println("Expecting false:");
        System.out.println(identifier2.matches("terminal1"));
        System.out.println(identifier2.matches("terminal101"));
        System.out.println(identifier2.matches("terminal2terminal2terminal2terminal2terminal10"));
        System.out.println(identifier2.matches("terminal2terminal1terminal4terminal10"));
        System.out.println(identifier2.matches("terminal5terminal6terminal10"));
        System.out.println(identifier2.matches("terminal6terminal7terminal10"));
        System.out.println(identifier2.matches(""));
        System.out.println(identifier2.matches("terminal1terminal4"));

        for (int i = 0; i < 8; i++) {
            String generatedString = identifier2.generate();

            System.out.println("\"" + generatedString + "\" matches: " + identifier2.matches(generatedString));
        }
    }
}
