import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumMiscFunctions {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://saucelabs.com/");

        //Maximise browser
        //driver.manage().window().maximize();

        //Delete all cookies
        //driver.manage().deleteAllCookies();

        //Delete specific cookie
        //driver.manage().deleteCookieNamed("sessionKey");

        //Taking screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/uditkumar/Library/Mobile Documents/com~apple~CloudDocs/IdeaProjects/SeleniumProject/Screenshots/Screenshot.jpg"));

        //Close open tab
        driver.close();
    }
}
