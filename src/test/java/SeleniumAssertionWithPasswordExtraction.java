import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class SeleniumAssertionWithPasswordExtraction {
    public static void main (String[] args) throws InterruptedException {
        String userName = "udit247@gmail.com";
        String website = "https://www.rahulshettyacademy.com/locatorspractice/";
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = passwordExtraction(driver);
        driver.get(website);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.logout-btn")).click();
        Thread.sleep(2000);
        driver.close();
    }

    public static String passwordExtraction (WebDriver driver) throws InterruptedException {
        String name = "Udit";
        String email = "udit247@gmail.com";
        String phone = "1234567890";
        String website = "https://www.rahulshettyacademy.com/locatorspractice/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(website);
        driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys(phone);
        driver.findElement(By.xpath("//form/div/button[2]")).click();
        System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
        String passwordExtractionFirstPart = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String passwordExtractionRemainingPart = passwordExtractionFirstPart.split("'")[1];
        String actualPassword = passwordExtractionRemainingPart.split("'")[0];
        driver.findElement(By.xpath("//button[contains(@class,'go-to')]")).click();
        return actualPassword;
    }
}
