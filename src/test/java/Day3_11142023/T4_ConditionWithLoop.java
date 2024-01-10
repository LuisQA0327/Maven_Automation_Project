package Day3_11142023;

public class T4_ConditionWithLoop {
    public static void main(String[] args) {
       String[] fruitBasket = new String[] {"Orange","Apple","Mango","Grape"};
       //pick out only apple from the basket
        //start the for loop because we need to check everything in the basket/ array
        for (int i = 0; i < fruitBasket.length; i++) {
            // == (double equal sign) means its a comparison operator
            // = (single equal sign) assigns a value to a variable
            if (fruitBasket[i] == "Apple") {
                System.out.println("An Apple a day keeps the defects away");
            } //end of if clause
            else if (fruitBasket[i] == "Grape") {
          System.out.println("My fruit is " + fruitBasket[i]);
            }//end of else if
        }//end of loop
    }//end of main
}//end of class
