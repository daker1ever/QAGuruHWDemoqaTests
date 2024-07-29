import Pages.TextBox;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DemoQATextBoxTests extends TestBase{
    TextBox textBox = new TextBox();

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


