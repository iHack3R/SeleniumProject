import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHandlingWebElements3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.com/");
        Actions browserAction = new Actions(driver);

        //Mouse hover on specific web element
        browserAction.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();

        //Write in CAPITAL letters in text box
        browserAction.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("capital letters").build().perform();

        //Double click on text in textbox
        browserAction.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("Click").doubleClick().build().perform();

        //Right click on specific web element
        browserAction.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).contextClick().build().perform();

        driver.close();
    }
}