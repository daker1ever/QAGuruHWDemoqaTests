import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;


public class QAGuruHW3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1900x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Filipp");
        $("#lastName").setValue("Vorobev");
        $("#userEmail").setValue("randomMail@email.com");

        $("#genterWrapper").$(byText("Male")).click();

       /* SelenideElement gender = $("[id=gender-radio-3]");
        actions().moveToElement(gender).click(gender).perform();*/

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
        /*SelenideElement hob1 = $("[id=hobbies-checkbox-1]");
        SelenideElement hob2 = $("[id=hobbies-checkbox-2]");
        SelenideElement hob3 = $("[id=hobbies-checkbox-3]");
        actions().moveToElement(hob1).click(hob1).perform();
        actions().click(hob2).perform();
        actions().click(hob3).perform();*/

        File file = new File("D:\\2023-07-20 202614.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("some adress");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        /*$("#stateCity-wrapper > div:nth-of-type(2) svg").click();
        $("#react-select-3-option-0").click();
        $("div:nth-of-type(3) div.css-1hwfws3").click();
        $("#react-select-4-option-0").click();*/

        $("#submit").scrollTo().click();
        //Selenide.sleep(10000);
    }
}
