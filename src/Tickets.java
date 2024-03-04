public class Tickets {

    public int getRow_number() {
        return row_number;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public Person getPerson() {
        return person;
    }

    public int row_number;
    public int seat_number;
    private double ticket_price;

     Person person;

    
    

    public Tickets(Person person,int row_number,int seat_number,double ticket_price)
    {
        this.person = person;
        this.row_number = row_number;
        this.seat_number = seat_number;
        this.ticket_price = ticket_price;
    }

    public static void  print(Person person,int row_number, int seat_number,double ticket_price)
    {
        System.out.println(person.displayDetails());
        System.out.println("Row Number : " + row_number);
        System.out.println("Seat Number : " + seat_number);
        System.out.println("Ticket Price : £" + ticket_price);

    }

    public String displayDetails(){
        return "Row Number : " + row_number + "\nSeat Number : " + seat_number + "\nPerson Details : \n" + person.displayDetails() + "\nTicket Price : £"  + ticket_price;

    }

}

