package technostudyB7.day8;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ArrowKeysAction extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/auto-complete");

        /**
         * Move to element
         * Click on the element
         * Type b
         * press down arrow key
         * press Enter key
         * */


        WebElement input = driver.findElement(By.id("autoCompleteMultipleInput"));
        Actions actions = new Actions(driver);
        Action typeBAction = actions.moveToElement(input).click().sendKeys("b").build();
        typeBAction.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Action arrowKeyAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
        arrowKeyAction.perform();

        quitDriver(4);


    }
}
