package actionitems;

public class ActionItem02_a2 {
    public static void main (String[] args){
        // declare an integer as a grade that can be manually changed
        int grade = 96;
        // declare else if statements to reflect a grade value for the variable integer above
                if(grade >=90 && grade<=100){
                    System.out.println("Grade is A");
                } else if (grade >=80 && grade <90){
                    System.out.println("Grade is B");
                } else if (grade >=70 && grade <80){
                    System.out.println("Grade is C");
                } else if (grade >=60 && grade <70){
                    System.out.println("Grade is D");
                } else if (grade < 60) {
                    System.out.println("Grade is F");
        }//end of else if statement
    }//end of main
}//end of class
