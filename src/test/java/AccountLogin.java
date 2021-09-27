import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AccountLogin {
    @Before
    public void set() {
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
        switchTo().alert().accept();
    }

    @Test
    public void Input_after_leaving_the_profile_with_corrent_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[type=\'password\']").setValue("1P73BP4Z");
        $("button[type=\'submit\']").click();
        $("[data-mira-id=\'Template26\']").click();
        $("[data-mira-id='Link33'] span[class='mira-link-text']").click();
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[type=\'password\']").setValue("1P73BP4Z");
        $("button[type=\'submit\']").click();
        switchTo().alert().accept();
    }
}
