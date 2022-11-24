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
        String firstName = "Dmitriy";
        String lastName = "Zheva";
        String Email = "Zheva@zheva.com";
        String mobilePhone = "9216666666";
        String currentAddress = "Russia";
        String bDate = "08 Nov 1990";


        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(Email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(mobilePhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--08").click(); // НАДО решить как выбрать нужный день

        $("#dateOfBirthInput").setValue(bDate);
        $("#subjectsInput").setValue("Guns");
        $("#hobbies-checkbox-1").setValue("1");
//        $("#uploadPicture").click();
        $("#currentAddress").setValue(currentAddress);
//        $("#state").setValue(currentAddress);
        $("submit").click();




        $("class=modal-body").shouldBe(visible);

    }
}
