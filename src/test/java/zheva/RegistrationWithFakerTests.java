package zheva;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import zheva.TestBase;

import java.util.Locale;

import static Utils.RandomUtils.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static zheva.TestData.*;

public class RegistrationWithFakerTests extends TestBase {


    @Test
    void fillFromTest() {
        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String eMail = faker.internet().emailAddress();
        String mobilePhone = faker.phoneNumber().subscriberNumber(10);
        String currentAddress = faker.address().fullAddress();

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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
        $(".modal-content").shouldHave(text(currentAddress));
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

    }
}
