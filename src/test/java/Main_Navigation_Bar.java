import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import java.util.Set;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Main_Navigation_Bar {


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

    public void getURL() throws InterruptedException {
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test (priority = 1, groups = "Main Navigation Bar")
    public void menu_dropdown() throws InterruptedException {
        //System.out.println("Hello World_1");
        //Gets URL & Maximizes Window
        getURL();
        WebElement menu = driver.findElement(By.cssSelector(".cmp-global-header__primary-nav > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(1)"));
        menu.click();
        Thread.sleep(3000);
        menu.click();
        Thread.sleep(3000);
    }

    @Test (priority = 2, groups = "Main Navigation Bar")
    public void Mc_App_Link() throws InterruptedException {

        //Gets URL & Maximizes Window
        getURL();
        WebElement app_link = driver.findElement(By.cssSelector(".cmp-global-header__primary-nav > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
        app_link.click();
        Thread.sleep(3000);

        WebElement scroll = driver.findElement(By.className("cmp-teaser__action-link"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test (priority = 3, groups = "Main Navigation Bar")
    public void McRewards() throws InterruptedException {
        //System.out.println("Hello World_3");

        //Gets URL & Maximizes Window
        getURL();

        WebElement rewards = driver.findElement(By.linkText("MyMcDonald's Rewards"));
        rewards.click();
        Thread.sleep(3000);

        //How do Mac Points work?
        WebElement earn_points = driver.findElement(By.className("cmp-teaser__title"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", earn_points);
        Thread.sleep(6000);

        //We need to locate the terms and conditions on this page.
        WebElement FAQ = driver.findElement(By.linkText("Frequently Asked Questions"));
        js.executeScript("arguments[0].scrollIntoView(true);", FAQ);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test (priority = 4, groups = "Main Navigation Bar")
    public void McValueDeals() throws InterruptedException {
        //System.out.println("Hello World_4");

        //Gets URL & Maximizes Window
        getURL();


        WebElement mcValue = driver.findElement(By.linkText("McValue™ & Deals"));
        mcValue.click();
        Thread.sleep(3000);

        WebElement mcOrder = driver.findElement(By.linkText("Order in the App"));
        mcOrder.click();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test (priority = 5, groups = "Main Navigation Bar")
    public void About_Food() throws InterruptedException {
        //System.out.println("Hello World_5");

        //Gets URL & Maximizes Window
        getURL();


        WebElement about_food = driver.findElement(By.linkText("About Our Food"));
        about_food.click();
        Thread.sleep(3000);

        WebElement food_info = driver.findElement(By.id("teaser-b5c2f7926b"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", food_info);
        Thread.sleep(3000);

        driver.findElement(By.linkText("Learn More About Our Quality")).click();
        Thread.sleep(3000);

        WebElement learn_more = driver.findElement(By.className("cmp-teaser__content"));
        js.executeScript("arguments[0].scrollIntoView(true);", learn_more);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }

    @Test (priority = 6, groups = "Main Navigation Bar")
    public void McDelivery() throws InterruptedException {

        //Gets URL & Maximizes Window
        getURL();

        WebElement mcDelivery = driver.findElement(By.linkText("McDelivery®"));
        mcDelivery.click();
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 450);", "");

        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test (priority = 7, groups = "Main Navigation Bar")
    public void McGiftCard() throws InterruptedException {
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        String parentWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("buy in bulk")).click();
        Thread.sleep(3000);


        driver.findElement(By.linkText("Yes, Continue")).click();
        Thread.sleep(3000);


        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All Window Handles: " + allWindowHandles);


        // Iterate through the window handles and switch to the child window (Google login window)
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindow)) {
                // Switch to Google login window
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to Gift Card Window");
                //Breaking down all drivers
                driver.close();
                break;

            }
        }

        // After completing the site transfer, switch back to the main window
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to Parent Window");
        Thread.sleep(3000);
    }

}