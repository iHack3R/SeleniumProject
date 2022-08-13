import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumHandlingWebElements2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Javascript pop-up
        String name = "Udit";
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        if (driver.switchTo().alert().getText().contains(name)) {
            System.out.println("Name in alert is correct");
        }
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        driver.close();
    }
}
