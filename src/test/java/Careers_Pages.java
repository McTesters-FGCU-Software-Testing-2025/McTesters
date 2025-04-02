import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Careers_Pages {

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

    public void getURL(String url) throws InterruptedException
    {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test(priority = 1, groups = "Careers Pages")
    public void careers_link() throws InterruptedException
    {
        getURL("https://www.mcdonalds.com/us/en-us.html");
        WebElement careerLink = driver.findElement(By.linkText("Careers"));
        careerLink.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);

        //scroll back up to bring the jobs into view.
        WebElement jobs  = driver.findElement(By.className("l-layout__content-text"));
        js.executeScript("arguments[0].scrollIntoView(true);", jobs);

        Thread.sleep(3000);

    }

    @Test(priority = 2)
    public void restaurant_jobs() throws InterruptedException
    {
        getURL("https://careers.mcdonalds.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement jobs = driver.findElement(By.className("l-layout__content-text"));
        js.executeScript("arguments[0].scrollIntoView(true);", jobs);
        Thread.sleep(3000);

        // Find and click on restaurant jobs.
        WebElement restaurantJobs = driver.findElement(By.linkText("Restaurant Jobs"));
        restaurantJobs.click();
        Thread.sleep(5000);

        // Use Actions class to simulate real user scrolling
        Actions actions = new Actions(driver);

        // Scroll down using repeated PAGE_DOWN keypresses
        for (int i = 0; i < 20; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(300); // adjust timing for smoother scroll
        }

        Thread.sleep(3000); // optional: pause to visually confirm you're at bottom
    }


    @Test(priority = 3)
    public void corporate_careers() throws InterruptedException {

        System.out.println("Hello World_3");
        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public void become_a_franchisee() throws InterruptedException {

        System.out.println("Hello World_4");
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void university_careers() throws InterruptedException {

        System.out.println("Hello World_5");
        Thread.sleep(3000);


    }


}

