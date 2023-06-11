package technostudyB7.day9;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFrame2 extends UtilityClass {
    public static void main(String[] args) {
        /**
         * Type your name in the input box
         * Click the check box
         * Print "Not a Friendly Topic"
         * */
        driver.get("https://chercher.tech/practice/frames");
        driver.switchTo().frame(0); // We are in the first frame
        WebElement topicInput = driver.findElement(By.tagName("input"));
        topicInput.sendKeys("John Snow");

        driver.switchTo().parentFrame(); // It takes us to parent/previous frame
        WebElement checkBox = driver.findElement(By.id("a"));
        checkBox.click();

        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
        System.out.println(header.getText());
    }
}
