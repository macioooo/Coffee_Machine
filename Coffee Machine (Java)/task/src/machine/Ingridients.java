package machine;

class Ingridients {

    protected static int waterSupply = 400;
    protected static int milkSupply = 540;
    protected static int beansSupply = 120;
    protected static int cupsSupply = 9;
    protected static int money = 550;

    static void Supplies() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", waterSupply);
        System.out.printf("%d ml of milk\n", milkSupply);
        System.out.printf("%d g of coffee beans\n", beansSupply);
        System.out.printf("%d disposable cups\n", cupsSupply);
        System.out.printf("%d$ of money\n", money);
    }
}