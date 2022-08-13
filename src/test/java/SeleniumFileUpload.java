import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumFileUpload {
    public static void main (String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.findElement(By.xpath("//input[@name='files[]']")).sendKeys("/Users/uditkumar/Desktop/Screenshot 2022-05-16 at 10.47.32 PM.png");
    }
}
