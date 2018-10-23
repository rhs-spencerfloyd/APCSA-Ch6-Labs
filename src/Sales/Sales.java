package Sales;
/**
 * Name: Spencer Floyd
 * Date: 10/23/18
 * Period: 1
 *
 * Sales.Sales.java
 *
 * Reads in and stores sales for each of 5 salespeople.  Displays
 * sales entered by salesperson id and total sales for all salespeople.
 */
//import sun.jvm.hotspot.oops.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Sales
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);

        System.out.print("How many salespeople? ");
        int salespeople = scan.nextInt();
        int[] sales = new int[salespeople];
        int sum;

        for (int i=0; i < sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        //print the array for verification
        //System.out.println(Arrays.toString(sales));

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i < sales.length; i++)
        {
            System.out.println("\t " + (i+1) + "\t\t\t" + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);


        //average method to print the average sales
        System.out.println("\nAverage sales: " + average(sales));


        //indexOfMax method to print the index of the best sales person
        System.out.println("\nBest salesperson index: " + indexOfMax(sales));
        System.out.println("Best salesperson sales: " + sales[indexOfMax(sales)]);


        // Do the same for the worst sales person
        System.out.println("\nWorst salesperson index: " + indexOfMin(sales));
        System.out.println("Worst salesperson sales: " + sales[indexOfMin(sales)]);



    }

    public static double average(int[] arr) throws IllegalStateException
    {
        //compute and return the average of arr
        //Be sure to use the length instance variable and you may assume that the array is full.
        //If the array does not have at least 1 element in it, throw an IllegalStateException
        if (arr.length == 0)
            throw new IllegalStateException();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public static int indexOfMax(int[] arr)
    {
        // find and return the index of the max value in arr
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    //Do the same for an indexOfMin method
    public static int indexOfMin(int[] arr)
    {
        // find and return the index of the max value in arr
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min])
                min = i;
        }
        return min;
    }

}
