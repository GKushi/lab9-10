public class CustomExceptionMain {
    public static void main(String[] args) {
        Account account = new Account("Janusz Tracz", 1000, "1234567890123456");

        try {
            account.transfer(2000);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Errpr: " + e.getClass().getSimpleName());
            e.printStackTrace();
        } finally {
            System.out.println("Balance: " + account.getBalance());
        }
    }
}
