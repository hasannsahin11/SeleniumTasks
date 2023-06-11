package technostudyB7.day10;

import Utilities.UtilityClass;
import jdk.jshell.execution.Util;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;

public class Scroll extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://www.youtube.com/");

        Wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // window.scrollBy(int x, int y) positive y value means scroll down, negative y value means scroll up
                                       // and positive x value means scroll right, negative x value means scroll left
        // window.scrollTo(0, "document.body.scrollHeight") scroll to the end of the page
        // "arguments[0].scrollIntoView(true);" //Scroll to the specified element

        js.executeScript("window.scrollBy(0,3000)"); // scroll down by 3000 pixels
        Wait(2);
        js.executeScript("window.scrollBy(0,-1000)"); // scroll up by 1000 pixels

        quitDriver(3);
    }
}
