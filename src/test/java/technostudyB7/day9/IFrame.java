package technostudyB7.day9;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFrame extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");

        //driver.switchTo().frame("frame1");


//        WebElement iFrame = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(iFrame);


        driver.switchTo().frame(0);

        WebElement topicInput = driver.findElement(By.tagName("input"));
        topicInput.sendKeys("John Snow");

        driver.switchTo().parentFrame();
 //       driver.switchTo().defaultContent();

        WebElement header = driver.findElement(By.xpath("//span[text()='Not a Friendly Topic']"));
        System.out.println(header.getText());

    }
}
