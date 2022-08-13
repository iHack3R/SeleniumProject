import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumHandlingBrowserBehaviour {
    public static void main(String[] args) throws InterruptedException {
        //Handling HTTPS certificates
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver(browserOptions);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
