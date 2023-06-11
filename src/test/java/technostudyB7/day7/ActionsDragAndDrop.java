package technostudyB7.day7;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop extends UtilityClass {
    public static void main(String[] args) {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement washington = driver.findElement(By.id("box3"));
        System.out.println(washington.getCssValue("background-color")); // Check the initial background color
        WebElement unitedStates = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);
        Action dragAndDropWashington = actions.dragAndDrop(washington,unitedStates).build();
        dragAndDropWashington.perform();
        System.out.println(washington.getCssValue("background-color")); // Check the last color

        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement denmark = driver.findElement(By.id("box104"));

        Action dragAndDropCopenhagen = actions.dragAndDrop(copenhagen,denmark).build();
        dragAndDropCopenhagen.perform();

    }
}
