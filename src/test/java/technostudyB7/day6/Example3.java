package technostudyB7.day6;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example3 extends UtilityClass {
    /**
     * /** Navigate to https://www.phptravels.net
     * * Click on Account button
     * * Click on Customer Sign Up
     * * Fill the form
     * * Check the "I am not robot" check box
     * * Click on Sign Up button
     * * Check if the title is "Login - PHPTRAVELS"
     * * Enter same login information that you used during registration and click login
     * * Verify the welcome message contains the first name that you used during registration then close the browser
     * *
     * * Note: You can use any locator you want.
     * *
     */
    public static void main(String[] args) {
        driver.get("https://www.phptravels.net");

        WebElement accountButton = driver.findElement(By.id("ACCOUNT"));
        accountButton.click();

        WebElement customerSignUpButton = driver.findElement(By.xpath("//a[text()='Customer Signup']"));
        customerSignUpButton.click();

        WebElement nameInput = driver.findElement(By.name("first_name"));
        nameInput.sendKeys("John");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Doe");

        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.sendKeys("123987");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("abc@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("asdqwe");

        WebElement iAmNotARobotCheckBox = driver.findElement(By.id("recaptcha-anchor"));
        iAmNotARobotCheckBox.click();

    }
}
