
import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.DragAndDrop;
import com.codeborne.selenide.commands.SelectRadio;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class QAGuruHW3 {
    @Test
    void fillFormTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Filipp");
        $("[id=lastName]").setValue("Vorobev");
        $("[id=userEmail]").setValue("randomMail@mailemail.com");

        SelenideElement gender = $("[id=gender-radio-3]");
        actions().moveToElement(gender).click(gender).perform();

        $("[id=userNumber]").setValue("9213824198");

        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(9);
        $("[class=react-datepicker__year-select]").selectOption("1993");
        $("[class=react-datepicker__week]").click();


        $("[id=subjectsInput]").setValue("a");
        $("[id=react-select-2-option-0]").click();

        SelenideElement hob1 = $("[id=hobbies-checkbox-1]");
        SelenideElement hob2 = $("[id=hobbies-checkbox-2]");
        SelenideElement hob3 = $("[id=hobbies-checkbox-3]");
        actions().moveToElement(hob1).click(hob1).perform();
        actions().click(hob2).perform();
        actions().click(hob3).perform();

        File file = new File("D:\\2023-07-20 202614.png");
        $("[id=uploadPicture]").uploadFile(file);

        $("[id=currentAddress]").setValue("some adress");

        $("#stateCity-wrapper > div:nth-of-type(2) svg").click();
        $("#react-select-3-option-0").click();
        $("div:nth-of-type(3) div.css-1hwfws3").click();
        $("#react-select-4-option-0").click();

        $("[id=submit]").scrollIntoView(true).click();
        Selenide.sleep(10000);
    }
}
/*$("value=\"Male\"").click();
        $("id=userNumber").setValue("9213824198");

        $("id=subjectsInput").setValue("12345678910");
        $("id=\"hobbies-checkbox-1\"").click();
        $("id=\"hobbies-checkbox-2\"").click();
        $("id=\"hobbies-checkbox-3\"").click();

        $("id=currentAddress").setValue("Kulture ave, 11/1");
        $("class=\" css-1uccc91-singleValue\"").setValue("Rajasthan");
        $("class=\" css-1uccc91-singleValue\"").setValue("Jaipur");
        $("id=submit").click();
        DragAndDropOptions.to("id=\"submit\"").;*/