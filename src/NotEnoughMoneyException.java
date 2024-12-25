public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(int balance, int amount) {
        super("Not enough money. Balance: "
                + balance + ", requested amount: " + amount);
    }
}
