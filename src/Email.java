import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity;
    private int defaultCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive first & last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        setMailboxCapacity(defaultCapacity);


        //Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +
                "." + companySuffix;

    }


    //Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + ". DEPARTMENT CODES\n1 for sales\n2 for Development\n3 " +
                "for Accounting\n0 for none \nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){return "sales";}
        if(depChoice == 2){return "dev";}
        if(depChoice == 3){return "acct";}
        else{return "";}
    }
    //Generate Random Password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set mailbox capacity

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    //Set the alternate email

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
