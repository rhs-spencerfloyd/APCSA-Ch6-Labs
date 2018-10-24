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

public class ShoppingCart2
{
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    private Item[] cart; // Declare a cart instance variable


    // Creates an empty shopping cart with a capacity of 5 items
    public ShoppingCart2()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new Item[capacity]; //Initialize the cart instance variable to the appropriate size
    }


    //Adds an item to the shopping cart.
    //@param itemName
    //@param price
    //@param quantity
    public void addToCart(String itemName, double price, int quantity)
    {
        // Complete the addToCart method
        if (itemCount == capacity) {
            increaseSize();
        }

        cart[itemCount] = new Item(itemName, price, quantity);
        itemCount++;
        totalPrice += price * quantity;

    }

    // Complete the getter method getTotalPrice. Remember the getter should not print anything.
    public double getTotalPrice() {
        return totalPrice;
    }


    public int getCartLength()
    {
        return cart.length;
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
        contents += String.format("%-15s%10.2f%10d%10.2f\n",cart[i].getName(),cart[i].getPrice(), cart[i].getQuantity(),
                                                            (cart[i].getPrice()*cart[i].getQuantity()));

    }

	contents += "\nTotal Price: " + fmt.format(getTotalPrice());
	contents += "\n";

	return contents;
    }


    /**
     * Increases the size of the shopping cart by 3.
     */
    private void increaseSize() {
        capacity += 3;
        Item[] tempcart = new Item[capacity];

        for (int i = 0; i < itemCount; i++) {
            tempcart[i] = cart[i];
        }

        cart = tempcart;
    }

}
