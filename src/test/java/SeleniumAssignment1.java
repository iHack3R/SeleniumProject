import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignment1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        //Check box and grab text and pass it to textbox and handle alert as well as grab text from it as well.
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption2")).click();
        String checkboxName = driver.findElement(By.cssSelector("label[for='benz']")).getText();
        Select staticDropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        staticDropdown.selectByVisibleText(checkboxName);
        WebElement staticDropdownName = staticDropdown.getFirstSelectedOption();
        String staticDropdownNameInText = staticDropdownName.getText();
        driver.findElement(By.id("name")).sendKeys(staticDropdownNameInText);
        driver.findElement(By.id("confirmbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        String name = alertText.split(" ")[1].split(",")[0].trim();
        if (name.contains(staticDropdownNameInText)) {
            System.out.println("Test is success");
        }
        else {
            System.out.println("Test is failed");
        }
        driver.switchTo().alert().accept();
        System.out.println(alertText);
        System.out.println(name);
        driver.close();
    }
}