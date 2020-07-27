// develped by sachin sharma 
// github --> Sachinsharma01

package Personal_Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Computer_Choices {
        int System_choice() {
                int system_choice = (int) (10 * Math.random());
                if (system_choice == 0)
                        system_choice = (int) (10 * Math.random());
                return system_choice;
        }
        int user_choice(){
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the place you want to insert your character : ");
                int user;

                // handling Exception if user enter other than integer
                try {
                        user = sc.nextInt();
//                        return user;
                } catch (InputMismatchException e) {
                        System.out.print("Please Enter the valid Choice : ");
                        user = sc.nextInt();
                }
                return user;
        }
}
