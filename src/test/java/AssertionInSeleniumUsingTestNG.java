import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AssertionInSeleniumUsingTestNG {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Static dropdown
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropdown);
        dropDown.selectByIndex(3);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "USD");
        Thread.sleep(1000);
        dropDown.selectByVisibleText("AED");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "AED");
        Thread.sleep(1000);
        dropDown.selectByValue("INR");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "INR");

        //Static dropdown 2
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();

        //Dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='GOI'][normalize-space()='Goa (GOI)'])[2]")).click();
        Thread.sleep(1000);

        //Auto suggest dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for (WebElement option : options) {
            if (option.getText().equals("India")) {
                option.click();
                break;
            }
        }

        //Checkboxes
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        Thread.sleep(1000);
        driver.close();
    }
}
