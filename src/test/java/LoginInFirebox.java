import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class LoginInFirebox {
    @Before
    public void set() {
        Configuration.browser = "firefox";
        open("https://lmslite47vr.demo.mirapolis.ru/mira");

    }

    @Test
    public void InvalidLogin() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[type=\'password\']").setValue("z0K6CTQR");
        $("button[type=\'submit\']").click();
        switchTo().alert().accept();
    }

    @Test
    public void Input_with_corrent_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[type=\'password\']").setValue("1P73BP4Z");
        $("button[type=\'submit\']").click();
        //switchTo().alert().accept();
    }

    @Test
    public void should_recovery_with_data_entry_and_correct_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        //$("a[class='mira-default-login-page-link']").click();
        $("a[class='mira-default-login-page-link'] div").click();
        $("input[name=\'loginOrEmail\']").setValue("fominaelena");
        $("button[type=\'submit\']").click();
        $("div[class=\'success\']").should(exist);
    }

}
