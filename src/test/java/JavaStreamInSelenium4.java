import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class JavaStreamInSelenium4 {
    public static void main (String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();

        //Define item that needs to be searched in search box
        String itemName = "Apple";

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Search item in search box
        driver.findElement(By.id("search-field")).sendKeys(itemName);

        //Store all the searched web elements in a list
        List<WebElement> searchedProducts = driver.findElements(By.xpath("//tr/td[1]"));

        //Store all the searched item names in a list
        List<String> searchedProductNames = searchedProducts.stream().map(name->name.getText()).toList();

        //Check whether the stored list contains searched item
        System.out.println(searchedProductNames);
        System.out.println(searchedProductNames.contains(itemName));
        driver.close();
    }
}