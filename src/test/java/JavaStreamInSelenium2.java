import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class JavaStreamInSelenium2 {
        public static void main (String[] args) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
            WebDriver driver = new EdgeDriver();

            //Define item that needs to be found along with its price
            String itemName = "Rice";

            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

            //Store all the web elements in a list
            List<WebElement> listOfProducts = driver.findElements(By.xpath("//tr/td[1]"));

            //Get the name of a particular item
            listOfProducts.stream().map(name->name.getText()).filter(name->name.contains(itemName)).forEach(name-> System.out.println(name));

            //Get the price of that particular item
            listOfProducts.stream().filter(name->name.getText().contains(itemName)).map(name-> getItemPrice(name)).forEach(name-> System.out.println(name));
            driver.close();
        }
        public static String getItemPrice(WebElement listOfProducts) {
            String itemPrice = listOfProducts.findElement(By.xpath("following-sibling::td[1]")).getText();
            return itemPrice;
        }
}
