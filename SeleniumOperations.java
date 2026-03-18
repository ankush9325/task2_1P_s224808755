package sit707_week2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\palan\\\\OneDrive\\\\文档\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		
		
		 // Find Last Name field
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Habib");
        System.out.println("Filled Last Name: Habib");
        
        // Find Email field
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ahsan.habib@example.com");
        System.out.println("Filled Email");
        
        // Find Phone field (if exists)
        try {
            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("0412345678");
            System.out.println("Filled Phone");
        } catch (Exception e) {
            System.out.println("Phone field not found - skipping");
        }
        
        // Find Password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123"); // Weak password to intentionally fail
        System.out.println("Filled Password (weak - to trigger errors)");
        
        // Find Confirm Password field
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("123");
        System.out.println("Filled Confirm Password");
        
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
     // Try to find Create Account button
        try {
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
            createAccountBtn.click();
            System.out.println("Clicked Create Account button");
        } catch (Exception e) {
            // Alternative way to find button
            try {
                WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
                submitBtn.click();
                System.out.println("Clicked submit button");
            } catch (Exception e2) {
                System.out.println("Could not find button: " + e2.getMessage());
            }
        }
        
        // ============================================================
        
        // Wait a moment for page to respond
        sleep(3);
		
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
        
        try {
            // Cast driver to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            
            // Capture screenshot as File
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            
          
            
         // Save to project folder with a different name
            File destFile = new File("officeworks_registration.png");
            srcFile.renameTo(destFile);
            System.out.println("Screenshot saved (may need to check project folder)");
            
            
            
            System.out.println("Screenshot saved as: officeworks_registration.png");
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
        
        // ============================================================
        
        // Sleep a while
        sleep(2);
		
		
	
		
		// close chrome driver
		driver.close();	
	}
	
	







// NEW METHOD for alternative website
	
	public static void alternative_registration_page(String url) {
	    // ChromeDriver path
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\palan\\OneDrive\\文档\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    
	    System.out.println("\n=== Testing Alternative Website ===");
	    WebDriver driver = new ChromeDriver();
	    
	    // USE A REAL REGISTRATION PAGE (not the local HTML)
	    String realSite = "https://demo.guru99.com/test/login.html";
	    System.out.println("Opening: " + realSite);
	    driver.get(realSite);
	    
	    // Wait for page to load
	    sleep(3);
	    
	    try {
	        // Fill the registration form
	        System.out.println("Filling registration form...");
	        
	        // Email
	        WebElement email = driver.findElement(By.id("email"));
	        email.sendKeys("test@example.com");
	        System.out.println("✓ Filled Email");
	        
	        // Password
	        WebElement password = driver.findElement(By.id("passwd"));
	        password.sendKeys("Test@123");
	        System.out.println("✓ Filled Password");
	        
	        // Click Sign in button
	        WebElement submitBtn = driver.findElement(By.id("SubmitLogin"));
	        submitBtn.click();
	        System.out.println("Clicked Sign in button");
	        
	        sleep(2);
	        
	    } catch (Exception e) {
	        System.out.println("Form filling error: " + e.getMessage());
	    }
	    
	    // TAKE SCREENSHOT
	    try {
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	        
	        // Save to Desktop
	        String desktopPath = "C:\\Users\\palan\\OneDrive\\Desktop\\alternative_registration.png";
	        File destFile = new File(desktopPath);
	        java.nio.file.Files.copy(srcFile.toPath(), destFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
	        
	        System.out.println(" SCREENSHOT SAVED ON DESKTOP: " + desktopPath);
	        
	    } catch (Exception e) {
	        System.out.println("Error saving screenshot: " + e.getMessage());
	    }
	    
	    sleep(2);
	    driver.quit();
	    System.out.println("Alternative website test completed!");
	}
}