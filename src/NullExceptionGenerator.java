public class NullExceptionGenerator {
    public static void generateNullPointerException() {
        System.out.println("Generating null pointer exception");
        String text = null;
        text.length();
    }
}
