import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {
//есть тест ID оставленный разрабом data-testid = "email"
        $("[data-testid=email").setValue("1");
        $(by("data-testid", "email")).setValue("1");
//нет тест id но есть id емайла к которому можно подцепиться id = "email"
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $x("//*[@id=email]").setValue("1");
//нет никакого id но есть равенство типа name = "email"
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");
// есть только  class = "inputtext login_from_input_box"
        $("class=login_from_input_box").setValue("1");
        $(".login_from_input_box").setValue("1");
        $(".login_from_input_box.inputtext").setValue("1");
        $("input.login_from_input_box.inputtext").setValue("1");
        $x("//input[@class='login_from_input_box'][@class='inputtext']").setValue("1");

        /*
        <div class = "inputtext">
            <input type = "email" class = "login_from_input_box">
        </div>
         */
        $(".login_from_input_box .inputtext").setValue("1");
        $(".login_from_input_box").$(".inputtext").setValue("1");

        //<div>Hello Zheva</div>
        $x("//div[text()='Hello Zheva']");
        $(byText("Hello Zheva"));
        $(withText("lo Zh"));


    }
}
