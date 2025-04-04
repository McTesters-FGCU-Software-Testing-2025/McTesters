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
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        //Scrolling further down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        //Scrolling back to the top
        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(1500);

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
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        //Scrolling further down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        //Scrolling back to the top
        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(1500);

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
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        //Scrolling further down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        //Scrolling back to the top
        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(1500);


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
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2500);
        //Selecting an option on the menu
        WebElement mcnuggets_1 = driver.findElement(By.xpath("//button[.//span[contains(text(), 'McNuggets')]]"));
        mcnuggets_1.click();
        Thread.sleep(1500);
        WebElement mcnuggets_2 = driver.findElement(By.xpath("//button[.//span[contains(text(), 'McNuggets')]]"));
        mcnuggets_2.click();
        Thread.sleep(1500);

    }

    @Test(priority = 5)
    public void food_Experts() throws InterruptedException {
        //Initializing the about_Our_Food function to ensure proper page is loaded
        about_Our_Food();
        //Scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
        //Locating and selecting desired button
        WebElement foodExperts = driver.findElement(By.cssSelector("a.cmp-teaser__action-link[href='/us/en-us/about-our-food/meet-our-food-experts.html']"));
        foodExperts.click();
        Thread.sleep(3000);
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,1500)");
        //Clicking "Meet Our Chefs"
        WebElement meet_chefs = driver.findElement(By.className("cmp-teaser__action-link"));
        meet_chefs.click();
        //Scrolling down the page
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        //Scrolling further down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        //Scrolling back to the top
        js.executeScript("window.scrollBy(0,0)");
        Thread.sleep(1500);

    }


}