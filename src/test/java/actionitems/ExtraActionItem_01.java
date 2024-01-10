package actionitems;

import java.util.ArrayList;

public class ExtraActionItem_01 {
    public static class extraActionItem {
        public static void main(String[] args) {
            //Create an ArrayList
            ArrayList<String> dogBreeds = new ArrayList<>();
            //create elements for ArrayList
            dogBreeds.add("Australian Shepherd");
            dogBreeds.add("Labrador Retriever");
            dogBreeds.add("Shih Tzu");
            dogBreeds.add("Poodle");
            //create an enhanced for loop
            for (String dogBreed : dogBreeds) {
                System.out.println(dogBreed);
            }//end of enhanced for loop
        }//end of main
    }//end of class
}
