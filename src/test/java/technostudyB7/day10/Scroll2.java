package technostudyB7.day10;

import Utilities.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll2 extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");

        Wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);"); // Scroll to the bottom of the page
        Wait(2);
        js.executeScript("window.scrollTo(0,0);"); //Scroll to the top of the page
    }
}
