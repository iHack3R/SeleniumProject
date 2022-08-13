import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaStreamInSelenium1 {
    public static void main (String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//header/div/div[3]/a[2]")).click();

        //Method to get browser windows ids.
        Set<String> windows = driver.getWindowHandles();

        //Method to iterate between windows to get each id.
        Iterator<String> iterate = windows.iterator();
        String parentWindow = iterate.next();
        String childWindow = iterate.next();

        //Method to switch window.
        driver.switchTo().window(childWindow);

        //Click table title to sort it by name
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Store all the items in list
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = listOfProducts.stream().map(name->name.getText()).toList();
        List<String> sortedList = originalList.stream().sorted().toList();
        //System.out.println(originalList);
        //System.out.println(sortedList);

        //Compare items to check whether sorting is working on website or not.
        Assert.assertEquals(sortedList, originalList, "Sorting functionality is working");
        driver.close();
    }
}
