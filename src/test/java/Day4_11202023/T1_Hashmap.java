package Day4_11202023;

import java.util.HashMap;

public class T1_Hashmap {
    public static void main(String[] args) {
        //create a hashmap consisting of name and age for triage students
        HashMap<String, Integer> triageStudents = new HashMap<>();
        //add some values for the triagestudents hashmap
        triageStudents.put("Noor", 25);
        triageStudents.put("Asif", 26);
        triageStudents.put("Justin", 28);
        //print out the size of the triageStudents hashmap
        System.out.println("The size of the hashmap is " + triageStudents.size());
        //print out the content of the hashmap
        System.out.println(triageStudents);

        if (triageStudents.containsKey("Asif")) {
            int asifAge = triageStudents.get("Asif");
            System.out.println("Asifs age is " + asifAge);
        }//end of if condition

        //does not print Afsanas age because we never added her to the data set
        System.out.println("Afsana age is " + triageStudents.get("Afsana"));
    }//end of main
}//end of class
