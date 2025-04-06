import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


        //To Adjust Firefox options.
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();

        // disabling firefox "Use your location" prompt
        profile.setPreference("permissions.default.geo", 2); //2 denies permission

        options.setProfile(profile);
        driver = new FirefoxDriver(options); //now init the driver with my options
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
        Thread.sleep(500);

        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(2000);
        System.out.println("Test Complete");
    }

    @Test(priority = 2, groups = "Careers Pages")
    public void restaurant_jobs() throws InterruptedException
    {
        getURL("https://careers.mcdonalds.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement jobs = driver.findElement(By.className("l-layout__content-text"));
        js.executeScript("arguments[0].scrollIntoView(true);", jobs);
        Thread.sleep(1500);

        // Find and click on restaurant jobs.
        WebElement restaurantJobs = driver.findElement(By.linkText("Restaurant Jobs"));
        restaurantJobs.click();
        Thread.sleep(2000);

        // creating an action to use to scroll.
        Actions actions = new Actions(driver);

        // i have to Scroll down using repeated PAGE_DOWN keypresses since this page is built on react, and
        //i have been having trouble with the scroll command.
        for (int i = 0; i < 20; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(300); // adjust timing for smoother scroll
        }

        Thread.sleep(2000); 
        System.out.println("Test Complete");
    }


    @Test(priority = 3, groups = "Careers Pages")
    public void corporate_careers() throws InterruptedException {

        getURL("https://careers.mcdonalds.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement jobs = driver.findElement(By.className("l-layout__content-text"));
        js.executeScript("arguments[0].scrollIntoView(true);", jobs);
        Thread.sleep(1500);

        // Find and click on corporate jobs.
        WebElement restaurantJobs = driver.findElement(By.linkText("Corporate Careers"));
        restaurantJobs.click();
        Thread.sleep(1500);


        //scroll to bottom of new page.
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 150;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(5000);
        System.out.println("Test Complete");

    }

    @Test(priority = 4, groups = "Careers Pages")
    public void become_a_franchisee() throws InterruptedException {

        getURL("https://careers.mcdonalds.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("scrollTo(0,500)");
        Thread.sleep(1500);

        //save the original tab
        String originalWindow = driver.getWindowHandle();

        // Find and click on corporate jobs.
        WebElement franchise = driver.findElement(By.linkText("Become a Franchisee"));
        franchise.click();
        Thread.sleep(1500);


        // set of the tabs
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);

        //switch to last
        driver.switchTo().window(handlesList.get(handlesList.size() - 1));


        js = (JavascriptExecutor) driver;
        //scroll to bottom of new page.
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 250;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(3500);

        driver.close(); //close the franchisee window

        // switch back to main window
        driver.switchTo().window(originalWindow);

        Thread.sleep(500);
        System.out.println("Test Complete");
        //original window should now close on AfterMethod
    }

    @Test(priority = 5, groups = "Careers Pages")
    public void university_careers() throws InterruptedException {

        getURL("https://careers.mcdonalds.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("scrollTo(0,500)");
        Thread.sleep(1500);

        // Find and click on corporate jobs.
        WebElement restaurantJobs = driver.findElement(By.linkText("University"));
        restaurantJobs.click();
        Thread.sleep(1500);

        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 250;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(1500);
        System.out.println("Test Complete");
    }
}

