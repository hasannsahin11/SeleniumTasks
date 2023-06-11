package technostudyB7.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String email = "hasannsahin1@gmail.com";

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");


        //<input autofocus="" type="text" class="form-control" placeholder="Please enter your Message" id="user-message">
        WebElement messageBox = driver.findElement(By.id("user-message"));
        messageBox.sendKeys("Hello Selenium");

        // <button type="button" onclick="showInput();" class="btn btn-default">Show Message</button>
        WebElement messageButton = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        messageButton.click();

        // <span id="display">Hello Selenium</span>
        WebElement result = driver.findElement(By.id("display"));
        System.out.println(result.getText());


        String expResult = "Hello Selenium";
        String actResult = result.getText();

        if (expResult.equals(actResult)) {
            System.out.println("Verification is done : PASS");
        } else {
            System.out.println("Verification is : FAILED");
        }

        // <input type="text" class="form-control" placeholder="Enter value" id="sum1">
        WebElement valueA = driver.findElement(By.id("sum1"));
        valueA.sendKeys("3");

        // <input type="text" class="form-control" placeholder="Enter value" id="sum2">
        WebElement valueB = driver.findElement(By.id("sum2"));
        valueB.sendKeys("5");

        // <button type="button" onclick="return total()" class="btn btn-default">Get Total</button>
        WebElement totalButton = driver.findElement(By.cssSelector("button[onclick='return total()']"));
        totalButton.click();

        // /<span id="displayvalue">10</span>/
        WebElement total = driver.findElement(By.id("displayvalue"));
        String expRes = "8";
        String actRes = total.getText();

        if (expRes.equals(actRes)){
            System.out.println("Verification: PASS");
        } else {
            System.out.println("Verification: FAILED");
        }
    }
}