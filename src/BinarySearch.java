import java.util.Scanner;

/*
Part2: This algorithm is binary search.
       For an arbitrary array, we need to sort it firstly,
       Then find a mid-point index,compare with the search value to determine a max and min pointer in the array.
       Recursively do above steps until it reaches to a base case of remaining first or last element in array.
 */

/*
Part3: I would use the compareTo method to compare its ASCII value.
       Basing on its different return type,search will be distinguished.
       this will have same procedures,sorts the array,
       finds the mid point,compares it with the search value.
 */

public class BinarySearch {
    /*
    entry
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the integers separate by \",\" that you are looking for:");
        String inputString = input.nextLine();//input integers
        String[] characterArray1 = inputString.split(",");//split input string of integers into an array
        int[] characterArray2 = new int[characterArray1.length];//create an array of integers.

        for (int i = 0; i < characterArray1.length; i++) {//use this loop to convert string inputs to integers
            characterArray2[i] = Integer.parseInt(characterArray1[i]);
        }

        System.out.println("Please input the integer that you are looking for:");
        int searchValue = input.nextInt();//input search value

        int length = characterArray2.length;
        int mid = 0;//initialise a mid point then the binaraySearch method will determine the value of it

        if (length == 0) {//condition for empty array to search
            System.exit(0);
        } else {
            binarySearch(characterArray2, searchValue, length, 0, (length - 1), mid);//do the binary search
        }
    }

    /*
    this method does the actual search in this problem by using binary search
     */
    public static void binarySearch(int[] characterArray, int searchValue, int length, int min, int max, int mid) {
        if (max <= min) {//case that did not find the value(besides first or last elements)
            System.out.println("!");
            System.exit(0);
        } else {
            mid = min + ((max - min) / 2);//mid point: odd number will give exact mid point,even number will give the left one(smaller one)

            if (length == 2) {//base case if the last element or first in the array needs to be searched
                if(searchValue != characterArray[min]&&searchValue != characterArray[max]){//whether the first or the last element is the search value
                    System.out.println("!");
                    System.exit(0);
                }
                else {//first one or the last one contain the search value
                    if(searchValue == characterArray[min]){//first one contains it
                        System.out.println(searchValue + " = " + characterArray[min]);
                        System.exit(0);
                    }else if(searchValue == characterArray[max]){//last one contains it
                        System.out.println(searchValue + " = " + characterArray[max]);
                        System.exit(0);
                    }
                }
            } else {

                if (searchValue == characterArray[mid]) {//case that mid point is the search value
                    System.out.println(searchValue + " = " + characterArray[mid]);
                    System.exit(0);
                } else if (searchValue < characterArray[mid]) {//case that mid point is less than the search value
                    max = mid;
                    int newLength = max - min + 1;
                    System.out.println(searchValue + " < " + characterArray[mid]);
                    binarySearch(characterArray, searchValue, newLength, min, max, mid);//recursion
                } else {//case that mid point is larger than the search value
                    min = mid;
                    int newLength = max - min + 1;
                    System.out.println(searchValue + " > " + characterArray[mid]);
                    binarySearch(characterArray, searchValue, newLength, min, max, mid);//recursion
                }
            }
        }
    }
}