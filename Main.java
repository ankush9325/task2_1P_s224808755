package sit707_week2;

public class Main 
{
    public static void main( String[] args )
    {
        // TASK 1: Officeworks
        System.out.println("=================================");
        System.out.println("TASK 1: Officeworks Registration");
        System.out.println("=================================");
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        
        // TASK 2: Alternative Website (REAL SITE)
        System.out.println("\n=================================");
        System.out.println("TASK 2: Alternative Website");
        System.out.println("=================================");
        
        // Using real website instead of HTML file
        SeleniumOperations.alternative_registration_page("");
        
        System.out.println("\n BOTH TASKS COMPLETED!");
        System.out.println(" CHECK YOUR DESKTOP FOR 2 SCREENSHOTS:");
        System.out.println("   1. officeworks_registration.png");
        System.out.println("   2. alternative_registration.png");
    }
}