package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    // locators
    SelenideElement formNameField    =    $(".practice-form-wrapper");
    SelenideElement firstNameInput   =    $("#firstName");
    SelenideElement lastNameInput    =    $("#lastName");
    SelenideElement emailInput       =    $("#userEmail");
    SelenideElement genderInput      =    $("#genterWrapper");
    SelenideElement dateOfBirthClick =    $("#dateOfBirthInput");
    SelenideElement userNumberInput  =    $("#userNumber");
    SelenideElement subjectsInput    =    $("#subjectsInput");
    SelenideElement hobbiesInput     =    $("#hobbiesWrapper");
    SelenideElement pictureInput     =    $("#uploadPicture");
    SelenideElement addressInput     =    $("#currentAddress");
    SelenideElement stateInput       =    $("#stateCity-wrapper");
    SelenideElement stateClick       =    $("#state");
    SelenideElement cityClick        =    $("#city");
    SelenideElement submitClick      =    $("#submit");
    SelenideElement tableCheck       =    $(".table-responsive");

    //
    String formName = "Student Registration Form";


    //actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        formNameField.shouldHave(text(formName));
        Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        dateOfBirthClick.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String path) {
        pictureInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateClick.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityClick.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitClick.click();
    }

    public RegistrationFormPage checkResult(String key, String value){
        tableCheck.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
