package technostudyB7.day7;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ActionsClick extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/buttons");

        // <button id="doubleClickBtn" type="button" class="btn btn-primary">Double Click Me</button>

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        Action doubleClickAction = actions.doubleClick(doubleClickButton).build();
        doubleClickAction.perform();

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        Action rightClickAction = actions.contextClick(rightClickButton).build();
        rightClickAction.perform();

        //<button id="wu0gl" type="button" class="btn btn-primary">Click Me</button>
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Action clickAction = actions.click(clickButton).build();
        clickAction.perform();

        //2nd way of using these Actions
        Action doubleClickAction2 = actions.moveToElement(doubleClickButton).doubleClick().build();
        doubleClickAction2.perform();

        //right click
        Action rightClickAction2 = actions.moveToElement(rightClickButton).contextClick().build();
        rightClickAction2.perform();

        // click
        Action clickButton2 = actions.moveToElement(clickButton).click().build();
        clickButton2.perform();
    }
}
