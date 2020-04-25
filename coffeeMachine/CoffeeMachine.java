package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scan.next();

            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String coffeeType = scan.next();
                switch (coffeeType) {
                    case "1": {
                        //espresso
                        if (water < 250) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (beans < 16) {
                            System.out.println("Sorry, not enough coffee!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not enough disposable cup!");
                            break;
                        } else {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            beans -= 16;
                            cups -= 1;
                            money += 4;
                        }
                        break;
                    }
                    case "2": {
                        //latte
                        if (water < 350) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (milk < 75) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        } else if (beans < 20) {
                            System.out.println("Sorry, not enough coffee!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not enough disposable cup!");
                            break;
                        } else {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups -= 1;
                            money += 7;
                        }
                        break;
                    }
                    case "3": {
                        //cappuccino
                        if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (milk < 100) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        } else if (beans < 12) {
                            System.out.println("Sorry, not enough coffee!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not enough disposable cup!");
                            break;
                        } else {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups -= 1;
                            money += 6;
                        }
                        break;
                    }
                    case "back": {
                        break;
                    }

                    default: {
                        System.out.println("Wrong character. Make an order again");
                        break;
                    }
                }
            }
            if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int fwater = scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                int fmilk = scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int fbeans = scan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int fcups = scan.nextInt();

                water += fwater;
                milk += fmilk;
                beans += fbeans;
                cups += fcups;

            }
            if (action.equals("take")) {
                System.out.printf("I gave you $%d\n", money);
                money = 0;
            }
            if (action.equals("remaining")) {
                System.out.println("The coffee machine has:");
                System.out.printf("%d of water\n", water);
                System.out.printf("%d of milk\n", milk);
                System.out.printf("%d of coffee beans\n", beans);
                System.out.printf("%d of disposable cups\n", cups);
                System.out.printf("%d of money\n", money);

            }
            if (action.equals("exit")) {
                return;
            }
        }
    }
}
