import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class SeleniumHandlingCalendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

        //Calendar with month select
        String requiredMonth = "April 2022";
        driver.findElement(By.id("travel_date")).click();
        while (!requiredMonth.equals(driver.findElement(By.cssSelector("div[class=datepicker-days] th[class=datepicker-switch]")).getText())) {
            driver.findElement(By.cssSelector("div[class=datepicker-days] th[class=next]")).click();
        }

        //Calenders with date select
        String requiredDate = "15";
        List<WebElement> listOfDates = driver.findElements(By.cssSelector("div[class=datepicker-days] td[class=day]"));
        for (int i=0; i<listOfDates.size(); i++) {
            String selectDate = listOfDates.get(i).getText();
            if (selectDate.equals(requiredDate)) {
                driver.findElement(By.cssSelector("div[class=datepicker-days] td[class=day]")).click();
                break;
            }
        }
        //driver.close();
    }
}