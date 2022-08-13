import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class SeleniumScope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();

        //Get page link count
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Get footer link count (Limiting web driver scope)
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //Get footer link count of first column (Further limiting the scope of web driver)
        WebElement limitedFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(limitedFooterDriver.findElements(By.tagName("a")).size());

        //Get footer link count of first column and check whether the links are working or not.
        for (int i=1; i<limitedFooterDriver.findElements(By.tagName("a")).size(); i++) {
            String keyCombinations = Keys.chord(Keys.COMMAND, Keys.ENTER);
            limitedFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(keyCombinations);
            Thread.sleep(2000);
        }

        //Get title of all the tabs or pages that open
        Set<String> browserWindows = driver.getWindowHandles();
        Iterator<String> it = browserWindows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
        //driver.close();
}