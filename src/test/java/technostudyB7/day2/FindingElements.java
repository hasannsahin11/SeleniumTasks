package technostudyB7.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements {
    public static void main(String[] args) throws InterruptedException {
        // set up the browser driver (Selenium is going to knock the door of browser driver (Chrome Driver)).
        WebDriverManager.chromedriver().setup();

        // to open the browser
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techno.study");
        Thread.sleep(2000);

        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);
        driver.navigate().back();

        // get()method wait the page for loading, navigate().to method doesn't wait for the page to load
        driver.navigate().forward();

        // finding the webelement of facebook page(Connect with friends and the world around you on Facebook.)

        WebElement sloganText = driver.findElement(By.className("_8eso"));
        String expSloganText = "Connect with friends and the world around you on Facebook.";
        String actSloganText = sloganText.getText();

        if (expSloganText.equals(actSloganText)) {
            System.out.println("Verification is done: PASS");
        } else {
            System.out.println("Verification is failed.");
            System.out.println("Actual slogan text is: " + actSloganText);
        }
    }
}
