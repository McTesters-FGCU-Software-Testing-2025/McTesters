import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

//8 classes, 5 methods/test per class.
// Running the testng.xml to test our methods

//TestNG hierarchy: Test Suite -> Test -> Class -> Method

public class Community_Overview {


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

    //Automatically brings up our desired menu

    public void getURL(String url) throws InterruptedException
    {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1500);
    }


    @Test(priority = 1, groups = "Community Overview")
    public void communityFooterLink() throws InterruptedException
    {
        //tests the community overview link on the home page footer, to ensure that it works.

        getURL("https://www.mcdonalds.com/us/en-us.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll gradually
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 350;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(3000);

        //select community
        WebElement communityOverview = driver.findElement(By.linkText("Community Overview"));
        communityOverview.click();
        Thread.sleep(500);

        //scroll through the community overview page
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(4000);
    }


    @Test(priority = 2, groups = "Community Overview")
    public void r_m_House_Charities() throws InterruptedException
    {
        //tests the charity link, to ensure that it works.
        getURL("https://www.mcdonalds.com/us/en-us/community.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //find charity link
        WebElement learnMoreLink = driver.findElement(By.xpath("//a[contains(@href, 'giving-back-with-ronald-mcdonald-house')]"));
        //scroll to charity link
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        learnMoreLink.click();

        //scroll gradually
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(4000);
    }



    @Test(priority = 3, groups = "Community Overview")
    public void scholarships() throws InterruptedException
    {
        //tests the scholarship link, to ensure that it works.
        getURL("https://www.mcdonalds.com/us/en-us/community.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //find scholarships link
        WebElement learnMoreLink = driver.findElement(By.xpath("//a[contains(@href, 'mcdonalds-scholarships')]"));
        //scroll to charity link
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1500);
        learnMoreLink.click();

        //scroll gradually
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(4000);
    }

    @Test(priority = 4, groups = "Community Overview")
    public void meetTheCrew() throws InterruptedException
    {
        //tests the meetTheCrew link, to ensure that it works.

        getURL("https://www.mcdonalds.com/us/en-us/community.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //find meet our crew link
        WebElement learnMoreLink = driver.findElement(By.xpath("//a[contains(@href, 'now-serving')]"));
        //scroll to meet our crew link
        js.executeScript("window.scrollBy(0,2100)");
        Thread.sleep(1500);
        learnMoreLink.click();

        //scroll gradually
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(4000);
    }

    @Test(priority = 5, groups = "Community Overview")
    public void exploreOurDeals() throws InterruptedException
    {
        //tests the explore our deals link, to ensure that it works.

        getURL("https://www.mcdonalds.com/us/en-us/community.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //find deals link
        WebElement learnMoreLink = driver.findElement(By.linkText("Explore Our Deals"));
        //scroll to deals link
        js.executeScript("window.scrollBy(0,2100)");
        Thread.sleep(1500);
        learnMoreLink.click();

        //scroll gradually
        js.executeScript(
                "let totalHeight = 0;" +
                        "let distance = 100;" +
                        "let timer = setInterval(() => {" +
                        "  window.scrollBy(0, distance);" +
                        "  totalHeight += distance;" +
                        "  if (totalHeight >= document.body.scrollHeight) clearInterval(timer);" +
                        "}, 100);"
        );
        Thread.sleep(4000);
    }
}
