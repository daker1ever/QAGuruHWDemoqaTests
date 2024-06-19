import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaAutoformTests extends TestBase{


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Filipp");
        $("#lastName").setValue("Vorobev");
        $("#userEmail").setValue("randomMail@email.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--011").click();

        $("#subjectsInput").setValue("a");
        $("#subjectsWrapper").$(byText("Maths")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img.png");

        $("#currentAddress").setValue("some adress");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name Filipp Vorobev"),
                text("Student Email randomMail@email.com"),
                text("Gender Male"),
                text("Mobile 1234567890"),
                text("Date of Birth 11 October,1993"),
                text("Subjects Maths"),
                text("Hobbies Sports, Reading, Music"),
                text("Picture img.png"),
                text("Address some adress"),
                text("State and City NCR Delhi")
        );
    }
}
