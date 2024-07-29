import Pages.StudentRegistrationForm;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoqaAutoformPOPatternTests extends TestBase {

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    TestData testData = new TestData();

    @Test
    @Tag("full_form")
    void fillFormTest() {
        List<String> expectedData = List.of
                (testData.userName + " " + testData.userLastName,
                        testData.userEmail,
                        testData.userGender,
                        testData.userPhoneNumber,
                        testData.userBirthday.day + " " + testData.userBirthday.month + "," + testData.userBirthday.year,
                        testData.userSubjects,
                        testData.userHobbies,
                        testData.userFile,
                        testData.userAddress,
                        testData.userState + " " + testData.userCity);

        studentRegistrationForm.openStudentRegistrationFormPage()
                .setUserFirstName(testData.userName)
                .setUserLastName(testData.userLastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.userGender)
                .setUserNumber(testData.userPhoneNumber)
                .setUserDateOfBirth(testData.userBirthday.day, testData.userBirthday.month, testData.userBirthday.year)
                .setUserSubjects(testData.userSubjects)
                .setUserHobbies(testData.userHobbies)
                .uploadPicture(testData.userFile)
                .setUserAdress(testData.userAddress)
                .setUserStateAndCity(testData.userState, testData.userCity)
                .pressSubmitButton()
                .checkFillingResult(expectedData);

    }

    @Test
    @Tag("min_form")
    void fillMinimalDataFormTest() {
        List<String> expectedData = List.of
                (
                        testData.userName + " " + testData.userLastName,
                        testData.userGender,
                        testData.userPhoneNumber,
                        testData.userBirthday.day + " " + testData.userBirthday.month + "," + testData.userBirthday.year
                );
        studentRegistrationForm.openStudentRegistrationFormPage()
                .setUserFirstName(testData.userName)
                .setUserLastName(testData.userLastName)
                .setUserGender(testData.userGender)
                .setUserNumber(testData.userPhoneNumber)
                .setUserDateOfBirth(testData.userBirthday.day, testData.userBirthday.month, testData.userBirthday.year)
                .pressSubmitButton();
        assertTrue(studentRegistrationForm.checkFillingResult(expectedData));
    }

    @Test
    @Tag("negative")
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
