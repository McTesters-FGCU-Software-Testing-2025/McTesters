import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class About_Our_Food {


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
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        driver.manage().window().maximize();
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

    //Automatically brings up our desired menu
    public void about_Our_Food() throws InterruptedException {
        WebElement aboutOurFood = driver.findElement(By.linkText("About Our Food"));
        aboutOurFood.click();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void Test_1() throws InterruptedException {
        about_Our_Food();

    }



    @Test(priority = 2)
    public void Test_2() throws InterruptedException {
        about_Our_Food();



    }

    @Test(priority = 3)
    public void Test_3() throws InterruptedException {
        about_Our_Food();



    }

    @Test(priority = 4)
    public void Test_4() throws InterruptedException {
        about_Our_Food();


    }

    @Test(priority = 5)
    public void Test_5() throws InterruptedException {
        about_Our_Food();


    }


}