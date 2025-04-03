import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Find_Your_Restaurant {

    WebDriver driver;

    //Function occurs before the entire class.
    @BeforeClass
    public void beforeClass() { System.out.println("Starting Test For Class [" + (++count_vars.class_Count) + "]"); }

    //Occurs before every 'method' annotated with @Test, every single one
    @BeforeMethod
    public void beforeMethod()
    {
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

    @Test(priority = 1, groups = "Find Your Restaurant")
    public void find_Your_Restaurant_Link() throws InterruptedException
    {
        getURL("https://www.mcdonalds.com/us/en-us.html");  //start at home page of donnies.

        JavascriptExecutor js = (JavascriptExecutor) driver;    //init js executor for scrolling

        //find and click on Find Your Restaurant link!
        WebElement findYour = driver.findElement(By.linkText("Find Your Restaurant"));
        findYour.click();
        Thread.sleep(3000);

        //scroll down to bring the search field into view.
        WebElement searchField = driver.findElement(By.name("search-val"));
        js.executeScript("arguments[0].scrollIntoView(true);", searchField);

        System.out.println("Test Complete");
        Thread.sleep(3000);


    }



    @Test(priority = 2, groups = "Find Your Restaurant")
    public void searchField_Test() throws InterruptedException
    {

        getURL("https://www.mcdonalds.com/us/en-us/restaurant-locator.html");  //start at 'find your' page

        JavascriptExecutor js = (JavascriptExecutor) driver;    //init js executor for scrolling
        Thread.sleep(1500);

        //scroll to search field:
        //scroll down to bring the search field into view.
        WebElement searchField = driver.findElement(By.id("form-text-1673594539"));
        js.executeScript("arguments[0].scrollIntoView(true);", searchField);
        Thread.sleep(1500);

        //Enter Location
        searchField.sendKeys("Florida Gulf Coast University");
        Thread.sleep(1500);
        searchField.sendKeys(Keys.ENTER); //search
        Thread.sleep(1500);

        //scroll down to bring the results into view.
        js.executeScript("window.scrollBy(0,200);");
        Thread.sleep(1500);

        //select first result and click on it to test to see if it works.
        WebElement firstResult = driver.findElement(By.linkText("17800 Ben Hill Griffin Pky"));
        firstResult.click();
        Thread.sleep(1000);

        //SCROLL
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 500;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        System.out.println("Test Complete");
        Thread.sleep(2000);

    }

    @Test(priority = 3, groups = "Find Your Restaurant")
    public void filterServices_CheckBoxes_Test() throws InterruptedException
    {
        getURL("https://www.mcdonalds.com/us/en-us/restaurant-locator.html");  //start at 'find your' page

        JavascriptExecutor js = (JavascriptExecutor) driver;    //init js executor for scrolling
        Thread.sleep(1500);

        //scroll down to bring the search field into view.
        WebElement searchField = driver.findElement(By.id("form-text-1673594539"));
        js.executeScript("arguments[0].scrollIntoView(true);", searchField);
        Thread.sleep(1500);

        //select filters dropdown
        WebElement filters = driver.findElement(By.cssSelector("div.cmp-restaurant-locator__filter-btn > button"));
        filters.click();
        Thread.sleep(1500);

        //loop through the checkboxes and click each one-by-one.
        for (int i = 0; i < 10; i++)
        {
            String checkBox = "filterItemsInput" + i;   //simple concatenation
            WebElement checkBoxes = driver.findElement(By.id(checkBox));
            js.executeScript("arguments[0].click();", checkBoxes);
            Thread.sleep(500);
        }
        System.out.println("Test Complete");
    }

    @Test(priority = 4, groups = "Find Your Restaurant")
    public void filterDistance_RadioFilters_Test() throws InterruptedException {

        getURL("https://www.mcdonalds.com/us/en-us/restaurant-locator.html");  //start at 'find your' page

        JavascriptExecutor js = (JavascriptExecutor) driver;    //init js executor for scrolling
        Thread.sleep(1500);

        //scroll down to bring the search field into view.
        WebElement searchField = driver.findElement(By.id("form-text-1673594539"));
        js.executeScript("arguments[0].scrollIntoView(true);", searchField);
        Thread.sleep(1500);

        //select filters dropdown
        WebElement filters = driver.findElement(By.cssSelector("div.cmp-restaurant-locator__filter-btn > button"));
        filters.click();
        Thread.sleep(1500);

        //loop through the RadioFilters and click each one-by-one.
        String[] values = {"5", "10", "20", "50"};
        for (String val : values)
        {
            WebElement radioFilters = driver.findElement
                    (By.cssSelector("input[type='radio'][name='radio-filter'][value='" + val + "']"));
            js.executeScript("arguments[0].click();", radioFilters);
            Thread.sleep(500);
        }
        System.out.println("Test Complete");
    }

    @Test(priority = 5, groups = "Find Your Restaurant")
    public void drag_Map_test() throws InterruptedException
    {

        getURL("https://www.mcdonalds.com/us/en-us/restaurant-locator.html");  //start at 'find your' page

        JavascriptExecutor js = (JavascriptExecutor) driver;    //init js executor for scrolling
        Thread.sleep(1500);

        //scroll down to bring google map into frame
        //scroll down to bring the results into view.
        js.executeScript("window.scrollBy(0,600);");
        Thread.sleep(1500);


        //grab map
        WebElement map = driver.findElement(By.className("map"));

        //create new action for dragging
        Actions drag = new Actions(driver);
        //perform click and drag action
        drag.clickAndHold(map).moveByOffset(300,50).release().build().perform();
        Thread.sleep(1500);
        drag.clickAndHold(map).moveByOffset(-300,-50).release().build().perform();  //drag back
        Thread.sleep(1500);

        //wait
        Thread.sleep(1500);
        System.out.println("Test Complete");
    }
}
