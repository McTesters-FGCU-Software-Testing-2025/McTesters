import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

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
        driver.quit();
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
    public void archCard() throws InterruptedException {
        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        //Searching for and selecting desired button
        WebElement arch_Card = driver.findElement(By.linkText("Buy an Arch Card"));
        arch_Card.click();
        //Continuing to the next handle
        WebElement arch_Card2 = driver.findElement(By.linkText("Yes, Continue"));
        arch_Card2.click();
        Thread.sleep(3000);
        //Switching handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        //Selecting a gift card
        WebElement select_Card = driver.findElement(By.xpath("//img[@alt='Physical Grimace Gift Card']") );
        select_Card.click();
        Thread.sleep(1500);
        //Finding the dropdown by ID and selecting an amount
        Select amountDropdown = new Select(driver.findElement(By.id("giftcard-amount-2610")));
        Thread.sleep(1500);
        amountDropdown.selectByVisibleText("$10");
        //Adding card to the cart
        WebElement add_Card = driver.findElement(By.id("product-addtocart-button"));
        Thread.sleep(1500);
        add_Card.click();
        Thread.sleep(1500);
        //Proceeding to the to shopping cart
        WebElement cart = driver.findElement(By.id("top-cart-btn-checkout"));
        cart.click();
        Thread.sleep(5000);

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
        //Continuing to the next handle
        WebElement arch_Card2 = driver.findElement(By.linkText("Yes, Continue"));
        arch_Card2.click();
        Thread.sleep(3000);
        //Switching handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1500);
        //Checking the approve box
        WebElement check_box = driver.findElement(By.id("arch_terms_conditions-1"));
        check_box.click();
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(1500);
        //Submitting request
        WebElement submit = driver.findElement(By.id("register_submit"));
        submit.click();
        Thread.sleep(1500);

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
        //Continuing to the next handle
        WebElement arch_Card2 = driver.findElement(By.linkText("Yes, Continue"));
        arch_Card2.click();
        Thread.sleep(3000);
        //Switching handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Selecting submit button
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();


    }

    @Test(priority = 4)
    public void reload_your_card() throws InterruptedException {

        //Initializing the gift card function to ensure we open proper window
        gift_Cards();
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(1500);
        //Searching for and selecting desired button
        WebElement reload = driver.findElement(By.linkText("Reload Your Card"));
        reload.click();
        Thread.sleep(1500);
        //Continuing to the next handle
        WebElement arch_Card2 = driver.findElement(By.linkText("Yes, Continue"));
        arch_Card2.click();
        Thread.sleep(2500);
        //Switching handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Inputting test information
        WebElement username = driver.findElement(By.id("j_username"));
        Thread.sleep(1500);
        username.sendKeys("Tester123");
        WebElement password = driver.findElement(By.id("j_password"));
        Thread.sleep(1500);
        password.sendKeys("Tester123");
        Thread.sleep(2000);
        //Clicking login submit
        WebElement submit = driver.findElement(By.id("loginSubmit"));
        submit.click();
        Thread.sleep(1500);
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
        Thread.sleep(1500);
        //Attempting to submit a false request
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(1500);
        WebElement submit = driver.findElement(By.className("submit-button"));
        submit.click();
        Thread.sleep(1500);

    }


}