import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DemoqaAutoformRemoteTests {
    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Переходим на сайт с формой", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Заполняем форму", () -> {
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
        });
        step("Проверяем правильность отображения результата", () -> {
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
        });


    }
}
