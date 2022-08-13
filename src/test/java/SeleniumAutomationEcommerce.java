import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumAutomationEcommerce {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        //Wait method for selenium synchronization
        WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String[] itemsNeeded = {"Apple", "Carrot", "Banana"};
        String coupon = "rahulshettyacademy";
        String country = "India";
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        //Executing addItems method
        addItems(driver, itemsNeeded);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys(coupon);
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        //Executing checkOut method
        checkOut(driver, country);
        driver.close();
    }
    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
    public static void checkOut (WebDriver driver, String country) {
        WebElement countrySelector = driver.findElement(By.xpath("//div/select"));
        Select dropDown = new Select(countrySelector);
        dropDown.selectByVisibleText(country);
        dropDown.getFirstSelectedOption().click();
        driver.findElement(By.cssSelector("input.chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}

