import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFromTest() {
        String userName = "Zheva";
        String Email = "Zheva@zheva.com";
        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(Email);
        $("#currentAddress").setValue("Address-Kupchino");
        $("#permanentAddress").setValue("Address-Frunzenskiy District");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(Email));

    }
}
