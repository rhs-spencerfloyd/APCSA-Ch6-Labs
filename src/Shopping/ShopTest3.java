package Shopping;

import java.util.Scanner;

public class ShopTest3 {
    public static void main(String[] args) {

        Scanner giveMeThe = new Scanner(System.in);

        ShoppingCart3 cart = new ShoppingCart3();

        System.out.print("Would you like to go shopping? (yes or no)");
        boolean stillShopping = yesno(giveMeThe.nextLine());

        do {
            System.out.print("What do you want to buy? ");
            String name = giveMeThe.nextLine();

            System.out.print("How much does it cost? ");
            double price = giveMeThe.nextDouble();

            System.out.print("How many do you want? ");
            int quantity = giveMeThe.nextInt();

            cart.addToCart(name, price, quantity);

            System.out.print("Would you like to get anything else? (yes or no)");
            giveMeThe.nextLine();
            stillShopping = yesno(giveMeThe.nextLine());
        } while (stillShopping);

        System.out.println(cart.toString());

    }

    public static boolean yesno(String yesno) {
        if (yesno.toLowerCase().equals("yes"))
            return true;
        return false;
    }
}
