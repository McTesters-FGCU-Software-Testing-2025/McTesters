import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Dropdown_Mc_Menu {


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

    //Automatically Brings up our dropdown menu
    public void menu_function() throws InterruptedException {
        driver.get("https://www.mcdonalds.com/us/en-us.html");
        driver.manage().window().maximize();
        WebElement menu = driver.findElement(By.cssSelector(".cmp-global-header__primary-nav > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(1)"));
        menu.click();
        Thread.sleep(3000);
    }

    @Test (priority = 1)
    public void McValue() throws InterruptedException {
        //System.out.println("Hello World_1");

        // Function that automates the dropdown menu from the navigation bar.
        menu_function();

        //Navigating to the McValues
        WebElement value_Menu = driver.findElement(By.linkText("McValue™"));
        value_Menu.click();
        Thread.sleep(3000);
        long lastHeight = 0;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Loop that automatically scrolls down a webpage.
        while (true) {
            // Scroll down by a certain amount of pixels
            js.executeScript("window.scrollBy(0, 700)");
            Thread.sleep(1000); // Wait for content to load

            // Get the current scroll height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");

            // Check if the scroll height has reached the bottom
            if (newHeight == lastHeight) {
                Thread.sleep(3000);
                break;
            }
            lastHeight = newHeight;
        }
        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void Breakfast() throws InterruptedException {
        //System.out.println("Hello World_2");

        // Function that automates the dropdown menu from the navigation bar.
        // Sleep built-in (3 Secs)
        menu_function();
        WebElement brake_fast = driver.findElement(By.cssSelector("#desktop-nav-1498826098 > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)"));
        brake_fast.click();
        Thread.sleep(3000);

        WebElement hashBrown = driver.findElement(By.linkText("Hash Browns"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", hashBrown);
        Thread.sleep(3000);
        hashBrown.click();
        Thread.sleep(3000);
        driver.navigate().back();

    }

    @Test (priority = 3)
    public void Beverages() throws InterruptedException {
        //System.out.println("Hello World_3");

        // Function that automates the dropdown menu from the navigation bar.
        // Sleep built-in (3 Secs)
        menu_function();

        WebElement bev = driver.findElement(By.linkText("Beverages"));
        bev.click();
        Thread.sleep(3000);

        WebElement sweet_tea = driver.findElement(By.linkText("Sweet Tea"));

        // Let's locate and scroll into view sweet tea
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", sweet_tea);
        Thread.sleep(2000);
        sweet_tea.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

    }

    @Test (priority = 4)
    public void Happy_Meal() throws InterruptedException {
        //System.out.println("Hello World_4");

        // Function that automates the dropdown menu from the navigation bar.
        // Sleep built-in (3 Secs)
        menu_function();

        WebElement happy_Meal = driver.findElement(By.linkText("Happy Meal®"));
        happy_Meal.click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(2000);



    }

    @Test(priority = 5)
    public void SweetTreats() throws InterruptedException {
        //System.out.println("Hello World_5");

        // Function that automates the dropdown menu from the navigation bar.
        // Sleep built-in (3 Secs)
        menu_function();

        WebElement sweet_treats = driver.findElement(By.linkText("Sweets & Treats"));
        sweet_treats.click();
        Thread.sleep(5000);

        WebElement apple_pie = driver.findElement(By.id("product-category-f7e34a9e55-143d0049c8_image"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView()", apple_pie);
        Thread.sleep(2000);
        apple_pie.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);


    }

}
