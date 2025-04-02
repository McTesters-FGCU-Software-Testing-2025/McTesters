import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Find_Your_Restaurant {


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
    public void Test_1() throws InterruptedException {
        System.out.println("Hello World_1");
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        Thread.sleep(3000);

    }



    @Test(priority = 2)
    public void Test_2() throws InterruptedException {

        System.out.println("Hello World_2");
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
