package oop.exercise;
import java.util.Scanner;
import java.util.UUID;

public class ATM {
    final static Scanner input = new Scanner(System.in);
    static int accountBalance = 0;
    final static int acNumber = 123456789;
    final static String PASSWORD = "HelloWorld";
    public static void main(String[] args) {
        atmBooth();
    }

    private static void atmBooth(){
        boolean check = true;
        while(check){
            System.out.println("Enter Your Account Number : ");
            if (input.hasNextInt()){
                int acNo = input.nextInt();
                input.nextLine();
                if (acNo == acNumber){
                    System.out.print("Enter Your Password : ");
                    String passWord = input.nextLine();
                    if (passWord.equals(PASSWORD)){
                        System.out.println("Login Successful.\n");
                        printList();
                        while (check){
                            System.out.print("Enter Choice: \n");
                            int choice = input.nextInt();
                            input.nextLine();
                            switch (choice){
                                case 1 -> printList();
                                case 2 -> deposit();
                                case 3 -> withDraw();
                                case 4 -> {
                                    check = false;
                                    System.out.println("Application exit....");
                                }
                            }
                        }

                    } else System.out.println(" Incorrect Password! ");

                } else System.out.println("Sorry! Account Number not match!");
            } else {
                System.out.println("Please enter number only !!!");
                input.nextLine();
            }
        }
    }

    private static void printList(){
        System.out.println("""
                Main Menu
                
                1: Check Menu
                2: Deposit
                3: Withdraw
                4: Exit
                """);
    }
    private static void deposit(){
        System.out.print("Enter deposit Amount : ");
        int amount = input.nextInt();
        accountBalance = accountBalance+amount;
        UUID uuid = UUID.randomUUID();
        System.out.println("TK "+amount+" Deposit on Your A/C "+ acNumber +" successfully," +
                "\nNow Your total balance is TK "+accountBalance+
                "\nTrxID : "+uuid);
    }

    private static void withDraw(){
        System.out.print("Enter Withdraw Amount : ");
        int amount = input.nextInt();
        UUID uuid = UUID.randomUUID();
        if (amount<accountBalance){
            accountBalance-=amount;
            System.out.println("TK "+amount+" Withdraw from Your A/C "+ acNumber +" successfully," +
                    "\nNow total balance is TK "+accountBalance+
                    "\nTrxID : "+uuid);
        }
        else System.out.println("Insufficient Balance");
    }
}
