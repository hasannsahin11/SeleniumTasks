package technostudyB7.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FacebookSignUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

       // <a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"
        // href="#" ajaxify="/reg/spotlight/" id="u_0_0_N3" data-testid="open-registration-form-button"
        // rel="async">Create new account</a>

        WebElement createAccButton = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccButton.click();
    }
}
