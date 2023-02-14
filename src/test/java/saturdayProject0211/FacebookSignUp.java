package saturdayProject0211;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookSignUp {
    /**
     * Test Case
     * 1-Go to https://www.facebook.com/
     * 2-Click on "Create new account"
     * 3-Fill out the form and skip date of birth.
     * 4-Click on Sing Up button
     * 5-Verify if you see this popup alert message: "It looks like you entered the wrong info. Please be sure to use your real birthday."
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.facebook.com/");

        //Locate Create New Account Button
        // <a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"
        // href="#" ajaxify="/reg/spotlight/" id="u_0_0_T9" data-testid="open-registration-form-button"
        // rel="async">Create new account</a>
        WebElement createNewAccountButton = driver.findElement(By.cssSelector("a[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createNewAccountButton.click();

        //Locate first name field & enter a valid first name
        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text"
        // name="firstname" value="" aria-required="true" placeholder="" aria-label="First name"
        // id="u_2_b_Sl" tabindex="0" aria-describedby="js_68">
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Burkino");

        //Locate last name field & enter a valid last name
        //<input type="text" class="inputtext _58mg _5dba _2ph-"
        // data-type="text" name="lastname" value="" aria-required="true"
        // placeholder="" aria-label="Last name" id="u_2_d_xF">
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Faso");

        //Locate phone number or email field & enter a valid email address
        //<input type="text" class="inputtext _58mg _5dba _2ph-"
        // data-type="text" name="reg_email__" value="" aria-required="true"
        // placeholder="" aria-label="Mobile number or email" id="u_a_g_6N">
        WebElement numberOrEmail = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        numberOrEmail.sendKeys("burkinofaso@nesimeshur.com");

        //Locate phone number or email confirmation field & enter the same email address
        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text"
        // name="reg_email_confirmation__" value="" aria-required="true"
        // placeholder="" aria-label="Re-enter email" id="u_2_j_Yi">
        WebElement reEnterEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        reEnterEmail.sendKeys("burkinofaso@nesimeshur.com");

        //Locate password field & enter a valid password
        //<input type="password" class="inputtext _58mg _5dba _2ph-" data-type="password" \
        //autocomplete="new-password" name="reg_passwd__" id="password_step_input"
        // aria-required="true" placeholder="" aria-label="New password">
        WebElement password = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        password.sendKeys("burkinofasolokumu");

        //Locate gender buttons & select male
        //<label class="_58mt" for="u_2_5_cy">Male</label>
        //<input type="radio" class="_8esa" name="sex" value="2" id="u_2_5_cy">
        WebElement selectSex = driver.findElement(By.cssSelector("input[value='2']"));
        selectSex.click();

        //Locate SignUp button & Click
        //<button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v"
        // name="websubmit" id="u_2_s_L6">Sign Up</button>
        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUpButton.click();

        //Verify pop up alert message
        //<div class="_5633 _5634 _53ij" id="js_ez">It looks like you entered the wrong info. Please be sure to use your real birthday.</div>
        WebElement popUpAlert = driver.findElement(By.cssSelector("div[class='_5633 _5634 _53ij']"));
        String popUpAlertMessage = "It looks like you entered the wrong info. Please be sure to use your real birthday.";

        if (popUpAlertMessage.equals(popUpAlert.getText())) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        Thread.sleep(3500);
        driver.quit();
    }
}
