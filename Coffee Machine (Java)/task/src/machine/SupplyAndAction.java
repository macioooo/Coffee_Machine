package machine;

import java.util.Scanner;

public class SupplyAndAction {


    static void Action() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> buy();

                case "fill" -> fill();

                case "take" -> take();

                case "exit" -> System.exit(0);

                case "remaining" -> Ingridients.Supplies();
            }

        }
    }


    private static void buy() {
        System.out.println("What do you want to buy? 1 -  espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int cost = 0;
        switch (choice) {
            case "1": // Espresso
                waterNeeded = 250;
                beansNeeded = 16;
                cost = 4;
                break;
            case "2": // Latte
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                cost = 7;
                break;
            case "3": // Cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                cost = 6;
                break;
            case "back": //Back
                Action();
            default:
                return;
        }
        if (canMakeCoffee(waterNeeded, milkNeeded, beansNeeded)) {
            System.out.println("I have enough resources, making you a coffee!");
            Ingridients.waterSupply -= waterNeeded;
            Ingridients.milkSupply -= milkNeeded;
            Ingridients.beansSupply -= beansNeeded;
            Ingridients.money += cost;
            Ingridients.cupsSupply--;
        } else {

            String notEnough = (Ingridients.waterSupply < waterNeeded ? "water" : Ingridients.milkSupply < milkNeeded ? "milk" : Ingridients.beansSupply < beansNeeded ? "beans" : "");
            System.out.printf("Sorry, not enough %s.", notEnough);
        }
    }

    private static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        Ingridients.waterSupply = Ingridients.waterSupply + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Ingridients.milkSupply = Ingridients.milkSupply + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Ingridients.beansSupply = Ingridients.beansSupply + scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        Ingridients.cupsSupply = Ingridients.cupsSupply + scanner.nextInt();
    }

    private static void take() {
        System.out.printf("I gave you %s\n", Ingridients.money);
        Ingridients.money = 0;
    }

    private static boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        int possibleCups;
        int waterPossible = Ingridients.waterSupply / waterNeeded;
        int milkPossible = milkNeeded > 0 ? Ingridients.milkSupply / milkNeeded : Ingridients.milkSupply;
        int beansPossible = Ingridients.beansSupply / beansNeeded;
        possibleCups = Math.min(Math.min(waterPossible, milkPossible), beansPossible);
        return possibleCups >= 1;
    }
}