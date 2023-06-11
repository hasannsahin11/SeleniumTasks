package technostudyB7.day7;

import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class getCssValue extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com");

        //<input autocomplete="off" name="keyword" type="text" class="col-xs-20
        // searchformInput keyword" id="inputValEnter" onkeypress="clickGo(event, this)"
        // placeholder="Search products &amp; brands" value="">
        WebElement searchInput = driver.findElement(By.id("inputValEnter"));
        searchInput.getAttribute("autocomplete");
        System.out.println("getAttribute(autocomplete): " + searchInput.getAttribute("autocomplete"));
        searchInput.getAttribute("name");
        System.out.println("getAttribute(name): " + searchInput.getAttribute("name"));
        searchInput.getAttribute("id");
        System.out.println("getAttribute(id): " +searchInput.getAttribute("id"));
        searchInput.getCssValue("background");
        System.out.println(searchInput.getCssValue("background"));
        searchInput.getCssValue("font-family");
        System.out.println(searchInput.getCssValue("font-family"));
        searchInput.getCssValue("color");
        System.out.println(searchInput.getCssValue("color"));
    }
}
