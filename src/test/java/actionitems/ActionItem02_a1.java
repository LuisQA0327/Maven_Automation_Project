package actionitems;

import java.util.ArrayList;

public class ActionItem02_a1 {
    public static void main(String[] args) {
        //make an ArrayList for regions
        ArrayList<String> regions = new ArrayList<String>();
        regions.add("Suffolk");
        regions.add("Nassau");
        regions.add("Queens");
        regions.add("Manhattan");
        //make an ArrayList for area codes
        ArrayList<Integer> areaCodes = new ArrayList<Integer>();
        areaCodes.add(631);
        areaCodes.add(516);
        areaCodes.add(347);
        areaCodes.add(212);
        //create loop
        for (int i = 0; i < areaCodes.size(); i++) {
            System.out.println("My region is " + regions.get(i) + " and my area code is " + areaCodes.get(i));
        }//end of loop

    }//end of main
}//end of class
