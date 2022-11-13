import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String prompt = "What do you want to do to the list? A-Add an item D-Delete an item P- Display the List Q- Quit";
        boolean done = false;

        do {
//            display(list);
            String userInput = SafeInput.getRegExString(in,prompt,"[AaDdPpQq]");
            System.out.println();
            userInput = userInput.toUpperCase();

            switch (userInput){
                case "A":
                    display(list);
                    add(list);
                    break;
                case "D":
                    display(list);
                    if (list.size() == 0 ){
                        System.out.println("There are no items in the list to delete. Try to add items first.");
                        break;
                    }
                    delete(list);
                    break;
                case "P":
                    display(list);
                    if(list.size() == 0){
                        System.out.println("The list is empty please add some lines");
                    }
                    break;
                case"Q":
                   done = SafeInput.getYNConfirm(in,"Are you sure you want to quit? [Y/N]");
                   break;
                default:
                    System.out.println("Please try again");
            }
        }while(!done);
        System.out.println("Thank you for using this list maker.");

    }

    private static void display(ArrayList<String>list) {
        System.out.println("Your current list:");
        for (int i = 0; i < list.size();i++) {
            System.out.printf("%n %d %s ",i, list.get(i));
        }
    }
    private static void add(ArrayList<String>list){
        Scanner in = new Scanner(System.in);
        System.out.println("\nWhat do you want to add to the list?");
        String userString = "";
        if (in.hasNext()) {
            userString = in.nextLine();
        } else {
            System.out.println("You entered an invalid string: " + userString + " Please try again");
        }
        list.add(userString);

    }
    private static void delete(ArrayList<String>list){
        Scanner in = new Scanner(System.in);
         int deleteInput = SafeInput.getRangedInt(in,"\nWhat is the index number that you want to delete?",0,(list.size()-1));
         if (list.size() == 0 ){

         }
         list.remove(deleteInput);



    }
}
