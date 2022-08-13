import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SeleniumHandlingBrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();

        //Check broken links
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //(Reducing the scope to footer only)
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footerDriver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int urlRespose = connection.getResponseCode();
            if (urlRespose>400) {
                System.out.println(link.getText() + " link is broken with " + urlRespose + " respose code.");
            }
            else {
                System.out.println(link.getText() + " link is working.");
            }
        }
        driver.close();
    }
}
