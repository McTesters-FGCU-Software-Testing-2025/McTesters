import com.fasterxml.jackson.annotation.JsonValue;
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
    public void quality() throws InterruptedException {
        //Initializing the about_Our_Food function to ensure proper page is loaded
        about_Our_Food();
        //Scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
        //Locating and selecting desired button
        WebElement learn_about_quality = driver.findElement(By.linkText("Learn More About Our Quality"));
        learn_about_quality.click();
        Thread.sleep(3000);

    }



    @Test(priority = 2)
    public void food() throws InterruptedException {
        //Initializing the about_Our_Food function to ensure proper page is loaded
        about_Our_Food();
        //Scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
        //Locating and selecting desired button
        WebElement learn_about_food = driver.findElement(By.linkText("Learn More About Our Ingredients"));
        learn_about_food.click();
        Thread.sleep(3000);

    }

    @Test(priority = 3)
    public void food_Philosophy() throws InterruptedException {
        //Initializing the about_Our_Food function to ensure proper page is loaded
        about_Our_Food();
        //Scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
        //Locating and selecting desired button
        WebElement foodPhilosophy = driver.findElement(By.cssSelector("a.cmp-teaser__action-link[href='/us/en-us/about-our-food/our-food-philosophy.html']"));
        foodPhilosophy.click();
        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public void nutrition_Calculator() throws InterruptedException {
        //Initializing the about_Our_Food function to ensure proper page is loaded
        about_Our_Food();
        //Scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
        //Locating and selecting desired button
        WebElement nutritionCalculator = driver.findElement(By.cssSelector("a.cmp-teaser__action-link[href='/us/en-us/about-our-food/nutrition-calculator.html']"));
        nutritionCalculator.click();
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void Test_5() throws InterruptedException {
        about_Our_Food();


    }


}