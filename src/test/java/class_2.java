import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class class_2 {
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        System.out.println("before Class");

    }

    //Occurs before every 'method' annotated with @Test, every single one
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        System.setProperty("webdriver.firefox.driver", "C://Program Files/Java/firefox-driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    //Occurs after every 'method' annotated with @Test, every single one
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");

        //This should close our driver before the next round
        driver.close();
    }

    @AfterClass
    public void afterClass() {System.out.println("After Class");}


    @Test(priority = 1)
    public void Test_1() throws InterruptedException {
        System.out.println("Hello World_1");
        driver.get("https://www.google.com/");
        Thread.sleep(3000);

    }



    @Test(priority = 2)
    public void Test_2() throws InterruptedException {
        System.out.println("Hello World_2");

        Thread.sleep(3000);



    }

    @Test(priority = 3)
    public void Test_3() throws InterruptedException {
        System.out.println("Hello World_3");

        Thread.sleep(3000);



    }

    @Test(priority = 4)
    public void Test_4() throws InterruptedException {
        System.out.println("Hello World_4");

        Thread.sleep(3000);


    }

    @Test(priority = 5)
    public void Test_5() throws InterruptedException {
        System.out.println("Hello World_5");

        Thread.sleep(3000);


    }

}
