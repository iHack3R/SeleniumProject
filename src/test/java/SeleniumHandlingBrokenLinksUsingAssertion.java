import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class SeleniumHandlingBrokenLinksUsingAssertion {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        SoftAssert assertion = new SoftAssert();

        //Check broken links using assertion
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //(Reducing the scope to footer only)
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footerDriver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int urlResponse = connection.getResponseCode();
            System.out.println(urlResponse);
            assertion.assertTrue(urlResponse<400, link.getText() + " link is broken with " + urlResponse + " respose code.");
        }
        assertion.assertAll();
        driver.close();
    }
}
