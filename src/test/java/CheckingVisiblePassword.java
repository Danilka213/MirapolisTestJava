import com.codeborne.selenide.selector.ByText;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingVisiblePassword {
    @Before
    public void set() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");

    }

    @Test
    public void should_in_not_visible_password() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $("input[name=\'password\']").shouldHave(attribute("type", "password"));
    }

    @Test
    public void should_corrent_word_visible_password() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[type=\'password\']").setValue("z0K6CTQR");
        $("button[type=\'button\']").click();
        $("input[name=\'password\']").shouldHave(attribute("type", "text"));
    }
    @Test
    public void should_corrent_word_visible_password_after_activate() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $("button[type=\'button\']").click();
        $("button[type=\'button\']").click();
        $("input[name=\'password\']").shouldHave(attribute("type", "password"));
    }
}
