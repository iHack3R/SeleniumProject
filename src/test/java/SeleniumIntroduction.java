import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class SeleniumIntroduction {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //Method to enter text
        driver.findElement(By.id("inputUsername")).sendKeys("udit247@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys("Password");
        //Method to click
        driver.findElement(By.className("signInBtn")).click();
        //Method to get text
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        //Java wait method
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Udit");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("udit247@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//form/div/button[2]")).click();
        System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
        driver.findElement(By.xpath("//button[contains(@class,'go-to')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("udit247@gmail.com");
        driver.findElement((By.xpath("//input[@placeholder='Password']"))).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//form/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.logout-btn")).click();
        Thread.sleep(2000);
        driver.close();
    }
}