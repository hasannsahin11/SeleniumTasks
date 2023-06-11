package saturdayProjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        // <select class="form-control" id="select-demo">
        //				<option value="" selected="" disabled="">Please select</option>
        //				 <option value="Sunday">Sunday</option>
        //				  <option value="Monday">Monday</option>
        //				  <option value="Tuesday">Tuesday</option>
        //				  <option value="Wednesday">Wednesday</option>
        //				  <option value="Thursday">Thursday</option>
        //				  <option value="Friday">Friday</option>
        //				  <option value="Saturday">Saturday</option>
        //			  </select>

        WebElement dropDownMenu = driver.findElement(By.id("select-demo"));
        Select dropDown = new Select(dropDownMenu);
        dropDown.selectByIndex(1);
        Thread.sleep(2000);
        dropDown.selectByValue("Monday");
        Thread.sleep(2000);
        dropDown.selectByVisibleText("Tuesday");
        Thread.sleep(2000);
        dropDown.selectByIndex(7);
        System.out.println(dropDown.getFirstSelectedOption().getText());
    }
}
