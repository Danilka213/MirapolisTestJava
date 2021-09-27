import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingPasswordRecovery {
    @Before
    public void set() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");

    }

    @Test
    public void should_recovery_with_data_entry_and_correct_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $(By.linkText("Забыли пароль?")).click();
        $("input[name=\'loginOrEmail\']").setValue("fominaelena");
        $("button[type=\'submit\']").click();
        $("div[class=\'success\']").should(exist);
    }

    @Test
    public void should_recovery_with_data_entry_and_not_correct_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $(By.linkText("Забыли пароль?")).click();
        $("input[name=\'loginOrEmail\']").setValue("fominaelenaaa");
        $("button[type=\'submit\']").click();
        $("div[class=\'alert\']").should(exist);
    }

    @Test
    public void should_recovery_with_data_entry_and_empty_data() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $(By.linkText("Забыли пароль?")).click();
        $("button[type=\'submit\']").click();
        $("div[class=\'alert\']").should(exist);
    }

    @Test
    public void should_recovery_without_data_entry_and_come_back_with_empty_data() {
        $(By.linkText("Забыли пароль?")).click();
        $(By.linkText("Назад к входу в систему")).click();
        $("input[type=\'text\']").shouldBe(visible);
        $("input[type=\'password\']").shouldBe(visible);
        $("button[type=\'submit\']").shouldBe(visible);
        $(By.linkText("Забыли пароль?")).shouldBe(visible);
    }

    @Test
    public void should_recovery_without_data_entry_and_come_back() {
        $(By.linkText("Забыли пароль?")).click();
        $("input[name=\'loginOrEmail\']").setValue("fominaelena");
        $(By.linkText("Назад к входу в систему")).click();
        $("input[type=\'text\']").shouldBe(visible);
        $("input[type=\'password\']").shouldBe(visible);
        $("button[type=\'submit\']").shouldBe(visible);
        $(By.linkText("Забыли пароль?")).shouldBe(visible);
    }

    @Test
    public void should_recovery_without_data_entry_and_not_correct_email() {
        $(By.linkText("Забыли пароль?")).click();
        $("input[name=\'loginOrEmail\']").setValue("hygdeq@gmail.com");
        $("button[type=\'submit\']").click();
        $("div[class=\'alert\']").should(exist);
    }

    @Test
    public void should_recovery_without_data_entry_and_correct_email() {
        $("input[type=\'text\']").setValue("fominaelena");
        $("input[name=\'password\']").setValue("z0K6CTQR");
        $(By.linkText("Забыли пароль?")).click();
        $("input[name=\'loginOrEmail\']").setValue("efomina@company.ru");
        $("button[type=\'submit\']").click();
        $("div[class=\'success\']").should(exist);
    }
}
