package technostudyB7.day11;

import Utilities.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot extends UtilityClass {
    public static void main(String[] args) throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
        //<input class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="" data-v-844e87dc="">
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("12313");

        //<button type="submit" class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button" \
        // data-v-7e88b27e="" data-v-30b9e6c4=""><!----> Login <!----></button>
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //<div class="oxd-alert-content oxd-alert-content--error" data-v-0b423d90=""><i class="oxd-icon bi-exclamation-circle oxd-alert-content-icon"
        // data-v-013b3fcc="" data-v-0b423d90=""></i><p class="oxd-text oxd-text--p oxd-alert-content-text"
        // data-v-7588b244="" data-v-0b423d90="">Invalid credentials</p></div>
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")));
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));

//        each time we run the code it overwrites the previous screenshot
//        if (errorMessage.isDisplayed()) {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // got  the screenshot
//            File screenShotInTheMemory = takesScreenshot.getScreenshotAs(OutputType.FILE);  // created a file
//            FileUtils.copyFile(screenShotInTheMemory, new File("src/test/java/technostudyB7/screenshots/screen.png"));
//        }

        // Each time we run the code iut creates a new file for the screenshot
        if (errorMessage.isDisplayed()) {
            LocalDateTime localDateTime = LocalDateTime.now();
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // got  the screenshot
            File screenShotInTheMemory = takesScreenshot.getScreenshotAs(OutputType.FILE);  // created a file
            FileUtils.copyFile(screenShotInTheMemory, new File("src/test/java/technostudyB7/screenshots/" +dateTime+ "screen.png"));
        }
        driver.quit();
    }
}
