import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SeleniumHandlingFrames {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        Actions windowAction = new Actions(driver);
        WebElement frame1 = driver.findElement(By.id("draggable"));
        WebElement frame2 = driver.findElement(By.id("droppable"));
        windowAction.dragAndDrop(frame1,frame2).build().perform();
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.close();
    }
}
