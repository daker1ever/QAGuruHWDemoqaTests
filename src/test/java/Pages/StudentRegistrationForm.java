package Pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ResultFormComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationForm {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userDateOfBirthInput = $("#dateOfBirthInput"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            userPictureUpload = $("#uploadPicture"),
            userAdressInput = $("#currentAddress"),
            userStateInput = $("#state"),
            userCityInput = $("#city"),
            submitButton = $("#submit"),
            submitWindow = $("#modal-content");

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultFormComponent resultFormComponent = new ResultFormComponent();

    public StudentRegistrationForm openStudentRegistrationFormPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public StudentRegistrationForm setUserFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public StudentRegistrationForm setUserLastName(String lastname) {
        lastNameInput.setValue(lastname);
        return this;
    }

    public StudentRegistrationForm setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public StudentRegistrationForm setUserGender(String gender) {
        userGenderInput.$(byText(gender)).click();
        return this;
    }

    public StudentRegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public StudentRegistrationForm setUserDateOfBirth(String day, String month, String year) {
        userDateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationForm setUserSubjects(String subject) {
        userSubjectsInput.setValue("a");
        $("#subjectsWrapper").$(byText(subject)).click();
        return this;
    }

    public StudentRegistrationForm setUserHobbies(String hobbie) {
        userHobbiesInput.$(byText(hobbie)).click();
        return this;
    }

    public StudentRegistrationForm uploadPicture(String fileName) {
        userPictureUpload.uploadFromClasspath(fileName);
        return this;
    }

    public StudentRegistrationForm setUserAdress(String adress) {
        userAdressInput.setValue(adress);
        return this;
    }

    public StudentRegistrationForm setUserStateAndCity(String state, String city) {
        userStateInput.click();
        $(byText(state)).click();
        userCityInput.click();
        $(byText(city)).click();
        return this;
    }

    public StudentRegistrationForm pressSubmitButton() {
        submitButton.scrollTo().click();
        return this;
    }

    public boolean checkFillingResult(List<String> expectedData) {
        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        return resultFormComponent.checkResult(expectedData);
    }
    public void checkSubmitWindowShouldBeHidden() {
        submitWindow.shouldNotBe(visible);
    }
}
