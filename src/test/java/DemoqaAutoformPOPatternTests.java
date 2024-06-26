import Pages.StudentRegistrationForm;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoqaAutoformPOPatternTests extends TestBase {

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

    @Test
    void fillFormTest() {
        List<String> expectedData = List.of
                (
                        "Ivan Ivanov",
                        "randomMail@email.com",
                        "Male",
                        "1234567890",
                        "11 October,1993",
                        "Maths",
                        "Sports",
                        "img.png",
                        "some adress",
                        "NCR Delhi"
                );

        studentRegistrationForm.openStudentRegistrationFormPage()
                .setUserFirstName("Ivan")
                .setUserLastName("Ivanov")
                .setUserEmail("randomMail@email.com")
                .setUserGender("Male")
                .setUserNumber("1234567890")
                .setUserDateOfBirth("11", "October", "1993")
                .setUserSubjects("Maths")
                .setUserHobbies("Sports")
                .uploadPicture("img.png")
                .setUserAdress("some adress")
                .setUserStateAndCity("NCR", "Delhi")
                .pressSubmitButton()
                .checkFillingResult(expectedData);

    }

    @Test
    void fillMinimalDataFormTest() {
        List<String> expectedData = List.of
                (
                        "Ivan Ivanov",
                        "Male",
                        "1234567890",
                        "11 October,1993"
                );
        studentRegistrationForm.openStudentRegistrationFormPage()
                .setUserFirstName("Ivan")
                .setUserLastName("Ivanov")
                .setUserGender("Male")
                .setUserNumber("1234567890")
                .setUserDateOfBirth("11", "October", "1993")
                .pressSubmitButton();
        assertTrue(studentRegistrationForm.checkFillingResult(expectedData));
    }

    @Test
    void negativeFillDataFormTest() {

        studentRegistrationForm.openStudentRegistrationFormPage()
                .setUserFirstName("Ivan")
                .setUserLastName("Ivanov")
                .setUserGender("Male")
                .setUserNumber("1234567890")
                .setUserDateOfBirth("11", "October", "1993")
                .pressSubmitButton()
                .checkSubmitWindowShouldBeHidden();
    }
}
