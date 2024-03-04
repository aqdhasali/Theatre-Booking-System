/*I declare that my work contains of no  examples of misconduct, such as plagiarism, or collusion. Any code takes from other sources is referenced within my solution.
Student ID : 20210860 / w1954000
 */

import java.util.*;
import java.io.*;

public class Theatre {
    public static int[] row1 = {0,0,0,0,0,0,0,0,0,0,0,0}; //the first row of 12 seats
    public static int[] row2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //the second row of 16 seats
    public static int[] row3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //the third row of 20 seats

    public static ArrayList <Tickets> tickets_List = new ArrayList <Tickets>(); //To save the tickets

    public static void main(String[] args) {
        System.out.println("                                  Welcome To The New Theatre!                                       "); //Welcome message
            while(true)
            {
                Scanner input = new Scanner(System.in);

                System.out.println("\n-----------------------------------------------------------------------------------------");

                System.out.println("Please select an option: ");

                System.out.println("1.Buy a Ticket.\n" + "2.Print Seating Area.\n" + "3.Cancel Ticket.\n" + "4.List available seats.\n" +
                        "5.Save to file.\n" + "6.Load from file.\n" + "7.Print ticket information and total price.\n" + "8.Sort tickets by price.\n" +
                        "    0.Quit");

                System.out.println("-----------------------------------------------------------------------------------------");

                System.out.println("Enter Option : ");
                //To ask the user to select an option.
                int main = input.nextInt();

                switch (main){
                    case 1:
                        buy_ticket(tickets_List);
                        break;
                    case 2:
                        print_seating_area(row1,row2,row3);
                        break;
                    case 3:
                        cancel_ticket(tickets_List);
                        break;
                    case 4:
                        show_available(row1,row2,row3);
                        break;
                    case 5:
                        save(row1,row2,row3);
                        break;
                    case 6:
                        load(row1,row2,row3);
                        break;
                    case 7:
                        show_tickets_info(tickets_List);
                        break;
                    case 8:
                        sort_tickets(tickets_List);
                        break;
                    case 0:
                        System.out.println("Exiting Program");
                        return;
                    default:
                        System.out.println("Invalid Input");
            }
        }
    }

    private static void buy_ticket(ArrayList tickets_list) //Buy_Tickets Method.
    {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Enter Row number:");
            int row_number;
            if (input.hasNextInt()) //to check whether the row number is an integer
            {
                row_number = input.nextInt();
                //Printing this message so that the user is aware of the range of the seats
                System.out.println("No of Seats in : \nRow 1 - 12 Seats\nRow 2 - 16 Seats\nRow 3 - 20 Seats\n(Please Enter Within The Correct Range)");
                System.out.println(" ");
                System.out.println("Enter Seat Number:");
                int seat_number;
                if (input.hasNextInt()) { //to check whether the seat row number is an integer
                    seat_number = input.nextInt();

                    if (row_number > 0 && row_number <= 3) { //checking whether the row number is valid
                        if (row_number == 1 && seat_number > 0 && seat_number <= 12) //checking whether the seat number is valid for that row
                        {
                            if (row1[seat_number - 1] == 0) {
                                System.out.print("Seat Available");

                                row1[seat_number - 1] = 1; //now the seat is booked

                                // Asking customer's information
                                System.out.println("\n" + "Enter Name : ");
                                String customer_name = input.next();

                                System.out.println("Enter Surname : ");
                                String customer_surname = input.next();

                                System.out.println("Enter Email : ");
                                String customer_email = input.next();

                                //Asking user to enter the ticket price
                                System.out.println("Enter your ticket price : ");
                                double ticket_price = 0.0;
                                if(input.hasNextDouble()){ //If the price is valid
                                   ticket_price = input.nextDouble();
                                }
                                else {
                                    System.out.println("Invalid Type");
                                }

                                System.out.print("\n" + "Your Seat has been booked Successfully");

                                Person person = new Person(customer_name, customer_surname, customer_email); //Creating the person object

                                Tickets tickets = new Tickets(person, row_number, seat_number, ticket_price); // Creating the ticket object
                                tickets_list.add(tickets); //adding the tickets to the ArrayList (tickets_list)


                                System.out.println("\n");
                                Tickets.print(person, row_number, seat_number, ticket_price); //Printing the ticket information
                            } else {
                                System.out.println("Seat Already Booked");
                            }
                        }
                        else if (row_number == 2 && seat_number > 0 && seat_number <= 16) //checking whether the seat number is valid for that row
                        {
                            if (row2[seat_number - 1] == 0) {
                                System.out.print("Seat Available");

                                row2[seat_number - 1] = 1; //now the seat is booked

                                //Asking customer's information
                                System.out.println("\n" + "Enter Name : ");
                                String customer_name = input.next();

                                System.out.println("Enter Surname : ");
                                String customer_surname = input.next();

                                System.out.println("Enter Email : ");
                                String customer_email = input.next();

                                System.out.println("Enter your ticket price : ");
                                double ticket_price = 0.0;
                                if(input.hasNextDouble()){ //If the price is valid
                                    ticket_price = input.nextDouble();
                                }
                                else {
                                    System.out.println("Invalid Type");
                                }

                                System.out.print("\n" + "Your Seat has been booked Successfully");

                                Person person = new Person(customer_name, customer_surname, customer_email); //Creating person object

                                Tickets tickets = new Tickets(person, row_number, seat_number, ticket_price); //Creating ticket object
                                tickets_list.add(tickets); //Adding the ticket to the ArrayList

                                System.out.println("\n");
                                Tickets.print(person, row_number, seat_number, ticket_price); //Printing the ticket information.

                            }
                            else
                            {
                                System.out.println("Seat Already Booked");
                            }
                        }
                        else if (row_number == 3 && seat_number > 0 && seat_number <= 20) //checking whether the seat number is valid for that row
                        {
                            if (row3[seat_number - 1] == 0) {
                                System.out.print("Seat Available");

                                row3[seat_number - 1] = 1; //now the seat is booked

                                //Asking user's information
                                System.out.println("\n" + "Enter Name : ");
                                String customer_name = input.next();

                                System.out.println("Enter Surname : ");
                                String customer_surname = input.next();

                                System.out.println("Enter Email : ");
                                String customer_email = input.next();

                                System.out.println("Enter your ticket price : ");
                                double ticket_price = 0.0;
                                if(input.hasNextDouble()){ //To check if price is valid
                                    ticket_price = input.nextDouble();
                                }
                                else {
                                    System.out.println("Invalid Type");
                                }

                                System.out.print("\n" + "Your Seat has been booked Successfully");

                                Person person = new Person(customer_name, customer_surname, customer_email); //Creating person object

                                Tickets tickets = new Tickets(person, row_number, seat_number, ticket_price); //Creating ticket object
                                tickets_list.add(tickets); //Adding ticket to ArrayList

                                System.out.println("\n");
                                Tickets.print(person, row_number, seat_number, ticket_price);

                            }
                            else
                            {
                                System.out.println("Seat Already Booked");
                            }
                        }
                        else
                        {
                            System.out.println("Seat Number Not In Range For This Row");
                        }
                    }
                    else
                    {
                        System.out.println("Row Number Not In Range (Required row range 1-3)");
                    }
                }
            }

            System.out.print("\nTo Buy More Tickets Enter Y or N To go to main menu : ");
            String to_repeat = input.next(); // asking if the user wants to add more tickets.
            to_repeat = to_repeat.toLowerCase();

            if (to_repeat.equals("y")) {
                continue;
            } else if (to_repeat.equals("n")) {
                System.out.println("Exiting Booking Process Thank you!");
                break;
            } else {
                System.out.println("Invalid Input");
                break;
            }
        }
    }

    private static void print_seating_area(int[] row1,int[] row2,int[] row3)
    {
        System.out.println("    ***********" );
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");
        System.out.print("    ");
        for (int seats=0;seats < row1.length;seats++) //Row 1 seating area
        {
            if (row1[seats] == 0) //if seat is booked
            {
                System.out.print("O");
                if (seats==5)
                {
                    System.out.print("  ");
                }
            }
            else if(row1[seats]== 1) //if seat is not booked
            {
                System.out.print("X");
            }
        } System.out.println();


        System.out.print("  ");
        for(int seats=0; seats < row2.length; seats++) //Row 2 seating area
        {
            if (row2[seats]==0)
            {
                System.out.print("O");
                if (seats==7)
                {
                    System.out.print("  ");
                }

            }
            else if (row2[seats]==1)
            {
                System.out.print("X");
            }

        } System.out.println();

        for(int seats=0; seats < row3.length;seats++)
        {
            if(row3[seats]==0)
            {
                System.out.print("O");
                if (seats==9)
                {
                    System.out.print("  ");
                }
            }
            else if(row3[seats]==1)
            {
                System.out.print("X");
            }
        }

    }

    private static void cancel_ticket( ArrayList tickets_list)
    {
        while (true)
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter Row Number & Seat Number:");

            System.out.println("Row number:");
            int row_number;
            if(input.hasNextInt()) //to check if row number is integer
            {
                row_number = input.nextInt();
                System.out.println("No of Seats in :\nRow 1 - 12 Seats\nRow 2 - 16 Seats\nRow 3 - 20 Seats\nPlease Enter Within The Correct Range");
                System.out.println("");
                System.out.println("Seat Number:");
                int seat_number;
                if(input.hasNextInt()) { //to check if seat number is integer
                    seat_number = input.nextInt();
                    if (row_number > 0 && row_number <= 3) { // if the row number is valid
                        if (row_number == 1 && seat_number > 0 && seat_number <= 12) { //if the seat number is valid
                            if (row1[seat_number - 1] == 1)
                            {
                                System.out.println("Seat not available");
                                row1[seat_number - 1] = 0;
                                System.out.print("\n" + "Your Seat has been cancelled Successfully");

                                for(int element = 0; element < tickets_list.size();element++) //to Check and delete the row number from the ticket list.
                                {
                                    Tickets ticket  = (Tickets)tickets_list.get(element);

                                    if(ticket.getRow_number() == row_number && ticket.getSeat_number() == seat_number)
                                    {
                                        tickets_list.remove(element);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("This Seat Number Has Not Been Booked Early Please Check Your Seat Number Again!");
                            }
                        } else if (row_number == 2 && seat_number > 0 && seat_number <= 16) {
                            if (row2[seat_number - 1] == 1)
                            {
                                System.out.println("Seat not available");
                                row2[seat_number - 1] = 0;
                                System.out.print("\n" + "Your Seat has been cancelled Successfully");

                                for(int element = 0; element < tickets_list.size();element++) //to Check and delete the row number fr0m the ticket list.
                                {
                                    Tickets ticket  = (Tickets)tickets_list.get(element);

                                    if(ticket.getRow_number() == row_number && ticket.getSeat_number() == seat_number)
                                    {
                                        tickets_list.remove(element);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("This Seat Number Has Not Been Booked Early Please Check Your Seat Number Again!");
                            }
                        } else if (row_number == 3 && seat_number > 0 && seat_number <= 20) {
                            if (row3[seat_number - 1] == 1)
                            {
                                System.out.println("Seat not available");
                                row3[seat_number - 1] = 0;
                                System.out.print("\n" + "Your Seat has been cancelled Successfully");

                                for(int element = 0; element < tickets_list.size();element++) //to Check and delete the row number fr0m the ticket list.
                                {
                                    Tickets ticket  = (Tickets)tickets_list.get(element);

                                    if(ticket.getRow_number() == row_number && ticket.getSeat_number() == seat_number)
                                    {
                                        tickets_list.remove(element);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("This Seat Number Has Not Been Booked Early Please Check Your Seat Number Again!");
                            }
                        }
                        else
                        {
                            System.out.println("Seat Number Not In Range");
                        }
                    }
                    else
                    {
                        System.out.println("Row Number Not In Range");
                    }
                }
                else
                {
                    System.out.println("Please Enter An Integer");
                }
            }
            else
            {
                System.out.println("Please Enter An Integer");
            }


            System.out.print("\nTo Cancel More Tickets Enter Y or N To Go To Main Menu : ");
            String to_repeat = input.next();
            to_repeat=to_repeat.toLowerCase();

            if (to_repeat.equals("y"))
            {
                continue;
            }
            else if (to_repeat.equals("n"))
            {
                System.out.println("Exiting Cancelling Process Thank you!");
                break;

            }
            else
            {
                System.out.println("Invalid Input");
                break;
            }

        }

    }

    private static void show_available(int[] row1, int[] row2, int[] row3)
    {
        System.out.print("Available Seats in row 1 :");
        int seat_number_row1 = 1; // This variable will print the number of index until 12 starting from 1:
        for (int seats = 0; seats < row1.length; seats++) {

            if (row1[seats] == 0) {
                System.out.print(seat_number_row1 + ",");
            }
            seat_number_row1++;

        }
        System.out.println("\b.");
        System.out.println("");

        System.out.print("Available Seats in row 2 :");
        int seat_number_row2=1; // This variable will print the number of index until 12 starting from 1:
        for (int seats = 0; seats < row2.length; seats++) {

            if (row2[seats] == 0) {
                System.out.print(seat_number_row2 + ",");
            }
            seat_number_row2++;

        }
        System.out.println("\b.");
        System.out.println("");

        System.out.print("Available Seats in row 3 :");
        int seat_number_row3=1;
        for (int seats = 0; seats < row3.length; seats++) {

            if (row3[seats] == 0) {
                System.out.print(seat_number_row3 + ",");
            }
            seat_number_row3++;

        }
        System.out.println("\b.");
    }

    private static void save(int row1[], int row2[], int[] row3){
        try
        {
            FileWriter saveArray = new FileWriter("Seats.txt"); //Creating text file using the Filewriter
            saveArray.write("Row 1 : ");
            for (int seats = 0; seats < row1.length; seats++) //Writing the seats of row1 to the file
            {

                saveArray.write(row1[seats] + " ");

            }

            saveArray.write("\nRow 2 : ");
            for (int seats = 0; seats < row2.length; seats++) //Writing the seats of row2 to the file
            {

                saveArray.write(row2[seats] + " ");

            }

            saveArray.write("\nRow 3 : ");
            for (int seats = 0; seats < row3.length; seats++) //Writing the seats of row3 to the file
            {

                saveArray.write(row3[seats] + " ");

            }
            saveArray.close();
            System.out.println("Your information was stored successfully");


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void load(int row1[], int row2[], int[] row3) {
        try {
            File file = new File("Seats.txt");
            Scanner readFile = new Scanner(file); //reads the file using the Scanner class
            String seatsData;

            while (readFile.hasNext()) {
                seatsData = readFile.nextLine();
                System.out.println(seatsData); //prints the row
            }
            readFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void show_tickets_info(ArrayList <Tickets> tickets_list)
    {
        double ticket_price_total = 0;//to calculate the ticket total
        int ticket_num = 1;
        for(Tickets ticket : tickets_list)
        {
            System.out.println("Ticket "+ticket_num+":");
            System.out.println(ticket.displayDetails());
            ticket_price_total += ticket.getTicket_price();
            ticket_num++;
            System.out.println(" ");
        }

        System.out.println("Total Price For Tickets : "+ticket_price_total); //print the total price for the tickets that are booked
    }

    private static void sort_tickets(ArrayList <Tickets> tickets_List)
    {
        int listLength = tickets_List.size(); //getting the number of tickets in the tickets_list array

        for(int i = 0; i < listLength-1;i++) //using bubble sort algorithms to sort the list in ascending order
        {
            for(int j=0; j < listLength-1;j++)
            {

                Tickets current_ticket = (Tickets) tickets_List.get(j);
                Tickets next_ticket = (Tickets) tickets_List.get(j+1);

                if(current_ticket.getTicket_price() > next_ticket.getTicket_price())
                {
                    Tickets temp_ticket = tickets_List.get(j);
                    tickets_List.set(j,tickets_List.get(j+1));
                    tickets_List.set(j+1,temp_ticket);
                }
            }
        }
        show_tickets_info(tickets_List);
     }

}
