import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Gift_Cards {


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

    //Automatically Brings up our desired menu
    public void gift_Cards() throws InterruptedException {
        WebElement giftCard = driver.findElement(By.linkText("Gift Cards"));
        giftCard.click();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void Test_1() throws InterruptedException {
        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        //Searching for and selecting desired button
        WebElement arch_Card = driver.findElement(By.linkText("Buy an Arch Card"));
        arch_Card.click();
        Thread.sleep(3000);
    }



    @Test(priority = 2)
    public void bulk() throws InterruptedException {

        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        //Searching for and selecting desired button
        WebElement in_bulk = driver.findElement(By.linkText("Buy in Bulk"));
        in_bulk.click();
        Thread.sleep(3000);



    }

    @Test(priority = 3)
    public void balance() throws InterruptedException {

        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(3000);
        //Searching for and selecting desired button
        WebElement check_balance = driver.findElement(By.linkText("Check Your Balance"));
        check_balance.click();
        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public void reload_your_card() throws InterruptedException {

        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(3000);
        //Searching for and selecting desired button
        WebElement reload = driver.findElement(By.linkText("Reload Your Card"));
        reload.click();
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void contact_us() throws InterruptedException {

        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
        //Searching for and selecting desired button
        WebElement contact = driver.findElement(By.linkText("Contact Us"));
        contact.click();
        Thread.sleep(3000);


    }


}