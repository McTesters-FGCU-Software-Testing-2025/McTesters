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

public class Navigation_Bar {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {System.out.println("Starting Test For Class [" + (++count_vars.class_Count) + "]");}

    //Occurs before every 'method' annotated with @Test, every single one
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Initializing Method: [" + (++count_vars.method_Count) + "]");
        System.setProperty("webdriver.firefox.driver", "C://Program Files/Java/firefox-driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    //System.out.println("Method [" + (++method_Count) + "]: Complete");

    //Occurs after every 'method' annotated with @Test, every single one
    @AfterMethod
    public void afterMethod() {

        System.out.println("Method [" + (count_vars.method_Count) + "]: Complete");
        //This should close our driver before the next round
        driver.close();
    }

    @AfterClass
    public void afterClass() {System.out.println("Class [" + (count_vars.class_Count) + "]: Complete");}


    @Test(priority = 1)
    public void menu_dropdown() throws InterruptedException {
        //System.out.println("Hello World_1");
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        Thread.sleep(3000);
        WebElement menu = driver.findElement(By.cssSelector(".cmp-global-header__primary-nav > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(1)"));
        menu.click();
        Thread.sleep(3000);
        menu.click();
        Thread.sleep(3000);
    }



    @Test(priority = 2)
    public void mac_App_Link() throws InterruptedException {
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        Thread.sleep(3000);

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

    @Test(priority = 3)
    public void McRewards() throws InterruptedException {
        //System.out.println("Hello World_3");
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);

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

    @Test(priority = 4)
    public void McValue() throws InterruptedException {

        System.out.println("Hello World_4");
        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void Test_5() throws InterruptedException {

        System.out.println("Hello World_5");
        Thread.sleep(3000);


    }


}
