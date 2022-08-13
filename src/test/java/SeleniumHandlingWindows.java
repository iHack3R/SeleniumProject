import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumHandlingWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        String password = "password";
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Actions browserAction = new Actions(driver);
        driver.findElement(By.className("blinkingText")).click();
        //Method to get browser windows ids.
        Set<String> windows = driver.getWindowHandles();
        //Method to iterate between windows to get each id.
        Iterator<String> iterate = windows.iterator();
        String parentWindow = iterate.next();
        String childWindow = iterate.next();
        //Method to switch window.
        driver.switchTo().window(childWindow);
        String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
        String username = text.split("at")[1].trim().split(" ")[0];
        //Method to switch window.
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("span.checkmark")).click();
        driver.findElement(By.id("okayBtn")).click();
        //Method to store Web Element
        WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
        Select dropDown = new Select(staticDropdown);
        //Method to select 3rd option from static dropdown
        dropDown.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        //driver.close();
    }
}