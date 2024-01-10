package actionitems;

import java.util.ArrayList;

public class ExtraActionItem_03 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Sydney");
        cities.add("New York");
        cities.add("London");
        cities.add("Kingston");
        for(String city:cities){
            System.out.println(city);
        }
        for (int i = cities.size() -1; i >= 0; i--) {
            System.out.println(cities.get(i));
        }//end of reverse for loop
    }//end of main
}//end of class