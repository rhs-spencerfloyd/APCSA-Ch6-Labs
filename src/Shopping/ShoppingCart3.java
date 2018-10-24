package Shopping;

/**
 * Name: Spencer Floyd
 * Date: 10/23/18
 * Period: 1
 *
 * Shopping.ShoppingCart.java
 *
 * Represents a shopping cart as an array of items
 */

import java.text.NumberFormat;
import java.util.ArrayList;

public class ShoppingCart3
{
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    private ArrayList<Item> cart; // Declare a cart instance variable


    // Creates an empty shopping cart with a capacity of 5 items
    public ShoppingCart3()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new ArrayList<Item>();
    }


    //Adds an item to the shopping cart.
    //@param itemName
    //@param price
    //@param quantity
    public void addToCart(String itemName, double price, int quantity)
    {
        // Complete the addToCart method
        cart.add(new Item(itemName, price, quantity));
        itemCount++;
        totalPrice += price * quantity;
    }

    // Complete the getter method getTotalPrice. Remember the getter should not print anything.
    public double getTotalPrice() {
        return totalPrice;
    }


    public int getCartLength()
    {
        return cart.size();
    }


    // @return the contents of the cart together with summary information
    public String toString()
    {
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	String contents = "\nShopping Cart\n";
	contents += String.format("%-15s%10s%10s%10s","Item","Price","Quantity","Total\n");


	for (int i = 0; i < itemCount; i++)
	{
	    //contents += cart[i].toString() + "\n";
        contents += String.format("%-15s%10.2f%10d%10.2f\n",cart.get(i).getName(),cart.get(i).getPrice(), cart.get(i).getQuantity(),
                                                            (cart.get(i).getPrice()*cart.get(i).getQuantity()));

    }

	contents += "\nTotal Price: " + fmt.format(getTotalPrice());
	contents += "\n";

	return contents;
    }

}
