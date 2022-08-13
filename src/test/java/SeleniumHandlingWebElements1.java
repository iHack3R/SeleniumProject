import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumHandlingWebElements1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().minimize();

        //Static dropdown
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropdown);
        dropDown.selectByIndex(3);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        dropDown.selectByVisibleText("AED");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        dropDown.selectByValue("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());

        //Static dropdown 2
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();

        //Dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='GOI'][normalize-space()='Goa (GOI)'])[2]")).click();
        Thread.sleep(1000);

        //Calenders with current date
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@text='Goa (GOI)']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='DEL'][normalize-space()='Delhi (DEL)'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("ui-state-highlight")).click();

        //Calenders with date select
        //Please refer SeleniumHandlingCalendar

        //Calendar with month select
        //Please refer SeleniumHandlingCalendar

        //Check whether a Web Element is enabled or disabled (Method 1).
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        //Check whether a Web Element is enabled or disabled (Method 2).
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("Round trip date is enabled");
        } else {
            System.out.println("Round trip date is disabled");
        }

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

        //Total count of checkboxes on page
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

        //Checkboxes
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Thread.sleep(1000);
        driver.close();
    }
}