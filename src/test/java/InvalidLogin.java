import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class InvalidLogin {
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
}
