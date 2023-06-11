package technostudyB7.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisabled {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Visit the page
        //Locate the enable button
        //Click on the button
        //Verify if it is enabled

        // <form id="input-example">
        //    <input type="text" disabled="" style="width: 30%;">
        //    <button autocomplete="off" type="button" onclick="swapInput()">Enable</button>
        //  </form>

        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));
        WebElement inputField =  driver.findElement(By.cssSelector("#input-example>input"));

        boolean isInputFieldEnabled = inputField.isEnabled();
        System.out.println("Before click on enable button: " +isInputFieldEnabled);

        enableButton.click();
        Thread.sleep(5000);

        boolean isInputFieldEnabled2 = inputField.isEnabled();
        System.out.println("After click on enable button: " + isInputFieldEnabled2);

        Thread.sleep(2000);
        driver.quit();
    }
}
