public class NullExceptionMain {
    public static void main(String[] args) {
        try {
            NullExceptionGenerator.generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Exception occurred!");
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
