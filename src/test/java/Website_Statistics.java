import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import java.util.List;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Website_Statistics {


    WebDriver driver;

    //Function occurs before the entire class.
    @BeforeClass
    public void beforeClass() { System.out.println("Starting Test For Class [" + (++count_vars.class_Count) + "]"); }

    //Occurs before every 'method' annotated with @Test, every single one
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Initializing Method: [" + ( ++count_vars.method_Count ) + "]" );
        System.setProperty("webdriver.firefox.driver", "C://Program Files/Java/firefox-driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    //System.out.println("Method [" + (++method_Count) + "]: Complete");

    //Occurs after every 'method' annotated with @Test, every single one
    @AfterMethod
    public void afterMethod() {
        System.out.println("Method [" + ( count_vars.method_Count ) + "]: Complete");
        //This should close our driver before the next round
        driver.close();
    }

    @AfterClass
    public void afterClass() { System.out.println("Class [" + ( count_vars.class_Count ) + "]: Complete"); }


    @Test(priority = 1)
    public void total_Elements() throws InterruptedException {
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        Thread.sleep(3000);

        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
        System.out.println("Total number of web elements found: " + allElements.size());

        // Step 8. Print details of all elements
        System.out.println("\nList of all web elements:");
        for (int i = 0; i < allElements.size(); i++) {
            WebElement element = allElements.get(i);
            try {
                String tagName = element.getTagName();
                String elementText = element.getText().trim();
                String elementId = element.getAttribute("id");
                String elementClass = element.getAttribute("class");

                System.out.println("Element " + (i + 1) + ":");
                System.out.println("  Tag Name: " + tagName);
                if (!elementId.isEmpty()) {
                    System.out.println("  ID: " + elementId);
                }
                if (!elementClass.isEmpty()) {
                    System.out.println("  Class: " + elementClass);
                }
                if (!elementText.isEmpty() && elementText.length() < 50) {
                    System.out.println("  Text: " + elementText);
                }
                System.out.println("------");
            } catch (Exception e) {
                System.out.println("  Failed to get details for element " + (i + 1));
            }
        }
        System.out.println("Total Elements on Page Verified = " + allElements.size());
        Thread.sleep(3000);
    }



    @Test(priority = 2)
    public void currentURL() throws InterruptedException {
        //System.out.println("Hello World_2");
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        Thread.sleep(3000);

        //Retrieve and print current URL and page title
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Page Title: " + pageTitle);
        Thread.sleep(3000);


    }

    @Test(priority = 3)
    public void Test_3() throws InterruptedException {

        System.out.println("Hello World_3");
        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public void Test_4() throws InterruptedException {

        System.out.println("Hello World_4");
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void Test_5() throws InterruptedException {

        System.out.println("Hello World_5");
        Thread.sleep(3000);


    }


}

