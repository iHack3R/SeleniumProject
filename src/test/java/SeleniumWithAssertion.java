import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumWithAssertion {
    public static void main (String[] args) throws InterruptedException {
        String userName = "udit247@gmail.com";
        String password = "rahulshettyacademy";
        String website = "https://www.rahulshettyacademy.com/locatorspractice/";
        String landingPageText = "You are successfully logged in.";
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Method to open URL
        driver.get(website);
        //Method to get open URL
        System.out.println(driver.getCurrentUrl());
        //Method to get open page title
        System.out.println(driver.getTitle());
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        //Java wait method
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        //Assertion method
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), landingPageText);
        System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
        //Assertion method
        Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), "Hello "+userName+",");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.logout-btn")).click();
        Thread.sleep(2000);
        driver.close();
    }
}