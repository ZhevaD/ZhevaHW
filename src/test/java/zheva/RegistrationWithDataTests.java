package zheva;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static zheva.TestData.*;

public class RegistrationWithDataTests {
//    static String firstName,
//            lastName,
//            eMail,
//            mobilePhone,
//            currentAddress;
    @BeforeAll
    static void beforeAll() {
//        firstName = "Dimon";   - плохой вариант
//        lastName = "Zheva";
//        eMail = "Zheva@zheva.com";
//        mobilePhone = "9215554433";
//        currentAddress = "Russia";

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void beforeEach () {
//        firstName = getNewFirstName (); - можно и так но я не понял куда записывать сами данные
//        lastName = getNewLastName ();
    }
    @Test
    void fillFromTest() {
//        String firstName = "Dmitriy",
//                lastName = "zheva",
//                eMail = "Zheva@zheva.com",
//                mobilePhone = "9216666666",
//                currentAddress = "Russia";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(eMail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(mobilePhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/123.png"));
        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        //Check-out
        $(".modal-content").shouldBe(visible);
        $(".modal-content").shouldHave(text(firstName));
        $(".modal-content").shouldHave(text(lastName));
        $(".modal-content").shouldHave(text(eMail));
        $(".modal-content").shouldHave(text(mobilePhone));
        $(".modal-content").shouldHave(text("08 November,1990"));
        $(".modal-content").shouldHave(text("Computer Science"));
        $(".modal-content").shouldHave(text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("123.png"));
        $(".modal-content").shouldHave(text("Russia"));
        $(".modal-content").shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
    @Test
    void someRegistrationTest() {

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(eMail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(mobilePhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/123.png"));
        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        //Check-out
        $(".modal-content").shouldBe(visible);
        //todo
    }
}
