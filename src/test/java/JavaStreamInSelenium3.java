import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class JavaStreamInSelenium3 {
    public static void main (String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();

        //Define item that needs to be found along with its price
        String itemName = "Apple";
        List<String> itemPrice;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Store all the web elements in a list
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//tr/td[1]"));

        //Get the name of a particular item
        listOfProducts.stream().map(name -> name.getText()).filter(name -> name.contains(itemName)).forEach(name -> System.out.println(name));

        //Get the price of that particular item
        do {
            List<WebElement> listOfItems = driver.findElements(By.xpath("//tr/td[1]"));
            itemPrice = listOfItems.stream().filter(name -> name.getText().contains(itemName)).map(name -> getItemPrice(name)).toList();
            itemPrice.forEach(name -> System.out.println(name));
            if (itemPrice.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (itemPrice.size() < 1);
        driver.close();
    }

    public static String getItemPrice (WebElement listOfProducts) {
        String productPrice = listOfProducts.findElement(By.xpath("following-sibling::td[1]")).getText();
        return productPrice;
    }
}