package zheva;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectTest extends TestBase {

    @Test
    void RegistrationTest() {
        String firstName = "Dmitriy";
        String lastName = "Zheva";
        String eMail = "Zheva@zheva.com";
        String mobilePhone = "9216666666";
        String currentAddress = "Russia";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender("Male")
                .setPhone(mobilePhone)
                .setBirthDate("08", "November", "1990");



        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        //Check-out
        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName +" "+ lastName)
                .verifyResults("Student Email", eMail)
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", mobilePhone)
                .verifyResults("Date of Birth", "08 November,1990" );

        $(".modal-content").shouldHave(text("Computer Science"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("123.png"));
        $(".modal-content").shouldHave(text("Russia"));
        $(".modal-content").shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}
