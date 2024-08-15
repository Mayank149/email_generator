import java.util.Random;
import java.util.Scanner;

class email{
    private String firstName;
    private String lastName;
    private String department = "";
    private String company;
    private String password;
    private String altEmail;

    public void askDetails(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first name");
        firstName = input.next();
        System.out.println("Please enter the last name");
        lastName = input.next();


    }

    public void generatePassword(){
        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#_";
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < 17; i++) {
            int randIndex=rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
        }
        System.out.println("Generating password.....");
        System.out.println("Your password is:-");
        password = res.toString();
        System.out.println(password);
    }

    public void set_department(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the department name");
        department = input.nextLine();
    }
    public void set_company(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the company name");
        company = input.nextLine();
    }

    public void generate_email(){
        System.out.println("Generating email.......");
        System.out.println("The email is:-");
        if(department.isEmpty()){
            System.out.println(firstName.toLowerCase()+lastName.toLowerCase()+"@"+company.toLowerCase()+".com");
        }
        else {
            System.out.println(firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + "/" + company.toLowerCase() + ".com");
        }
    }

}

public class Email_Generator {

    public static void main(String[] args) {
        email e = new email();
        Scanner input = new Scanner(System.in);
        e.set_company();

        while(true){
            System.out.println("Welcome to email generator for workers");
            System.out.println("Please press 'c' to continue");
            System.out.println("Please press 'x' to exit!");
            String response = input.next();

            if(response.equalsIgnoreCase("x")){
                System.out.println("Exiting.....");
                break;
            }
            else if(response.equalsIgnoreCase("c")){
                e.askDetails();
                System.out.println("Would you like to add department?(Y/N)");
                String res = input.next();
                if(res.equalsIgnoreCase("y")){
                    e.set_department();
                }
                else if(res.equalsIgnoreCase("N")) {
                    System.out.println("Continuing without department");
                }
                else{
                    System.out.println("Please enter the correct input!");
                }

                e.generate_email();
                e.generatePassword();

            }
            else{
                System.out.println("Please enter the correct input!");
            }

        }

    }

}
