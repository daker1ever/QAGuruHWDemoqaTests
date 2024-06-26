import Pages.TextBox;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DemoQATextBoxTests {
    TextBox textBox = new TextBox();
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1900x1080";
    }
    @Test
    void fillTextForm() {
        List<String> expectedData = List.of
                (
                        "Ivan Ivanov",
                        "randomMail@email.com",
                        "some adress",
                        "NCR Delhi"
                );
        textBox.openTextBoxPage()
                .setUserName("Ivan Ivanov")
                .setUserEmail("randomMail@email.com")
                .setUserCurrentAdress("some adress")
                .setUserPermanentAddress("NCR Delhi")
                .pressSubmitButton()
                .checkFillingResult(expectedData);
    }
}


