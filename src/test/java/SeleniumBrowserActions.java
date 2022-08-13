import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumBrowserActions {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        //Method to maximize browser
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");
        //Method to navigate to passed URL without wait for page load.
        driver.navigate().to("https://www.microsoft.com");
        Thread.sleep(1000);
        //Method for browser back
        driver.navigate().back();
        Thread.sleep(1000);
        //Method for browser forward
        driver.navigate().forward();
        driver.close();
    }
}
