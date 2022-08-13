/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class SeleniumHandlingPageScroll {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Window scroll
        javascriptExecutor js = (javascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebDriver> values = driver.findElements(By.cssSelector("tableFixHead td:nth-child(4)"));
        int sum=0;
        for (int i;i<values.size();i++) {
        sum = sum+Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

        //Table scroll in a page
    }
}
*/
