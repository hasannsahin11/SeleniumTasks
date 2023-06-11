package technostudyB7.day10;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll3 extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");
        WebElement element = driver.findElement(By.xpath("//div[text()='Hire faster']"));

        Wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(element.getText());
        quitDriver(2);
    }
}
