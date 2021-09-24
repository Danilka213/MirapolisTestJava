import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingLoginPageElements {
    @Before
    public void set() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");

    }

    @Test
    public void should_input_login_and_password() {
        $("input[type=\'text\']").shouldBe(visible);
        $("input[type=\'password\']").shouldBe(visible);
        $("button[type=\'submit\']").shouldBe(visible);
        $(By.linkText("Забыли пароль?")).shouldBe(visible);
    }
}
