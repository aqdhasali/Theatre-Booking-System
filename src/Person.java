public class Person {

    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String displayDetails()
    {
        return "Customer Name : " + name + "\nCustomer Surname : " + surname + "\nEmail : " + email;
    }


}
