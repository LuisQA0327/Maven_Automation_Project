package Day3_11142023;

public class T5_MultipleConditionLoop {
    public static void main(String[] args) {
        String[] fruitBasket = new String[]{"Grape", "Orange", "Apple", "Mango"};
        //pick out only apple from the basket
        //start the for loop because we need to check everything in the basket/ array
        for (int i = 0; i < fruitBasket.length; i++) {
            // == (double equal sign) means its a comparison operator
            // = (single equal sign) assigns a value to a variable
            if (fruitBasket[i] == "Apple" || fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            }//end of if clause
        }//end of first for loop
        for (int i = 0; i < fruitBasket.length; i++) {
            if (fruitBasket[i] == "Apple" && fruitBasket[i] == "Grape") {
                System.out.println("my fruit is " + fruitBasket[i]);
            }
            }//end of for loop\2
        }//end of main
    } // end of class
