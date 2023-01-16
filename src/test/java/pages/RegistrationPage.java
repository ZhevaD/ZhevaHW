package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private  SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            setEmailInput = $("#userEmail"),
            setGender = $("#genterWrapper"),
            setPhone = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()"); //=убирает рекламу
        executeJavaScript("$('footer').remove()"); //убирает рекламу вроде бы

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

//    public RegistrationPage clearLastName() {
//        lastNameInput.clear();
//
//        return this;
//    }

    public RegistrationPage setEmail(String value) {
        setEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        setGender.$(byText("Male")).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        setPhone.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyResultsModalAppears();

        return this;
    }
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
