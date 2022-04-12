package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.docs.RandomDataGenerator;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RandomDataGenerator generator = new RandomDataGenerator();

    String firstName = generator.getFirstName();
    String lastName = generator.getLastName();
    String email = generator.getEmail();
    String gender = generator.getGender();
    String mobile = generator.getPhoneNumber();
    String day = generator.getDay();
    String month = generator.getMonth();
    String year = generator.getYear();
    String subjects = generator.getSubject();
    String hobby = generator.getHobby();
    String currentAddress = generator.getAddress();
    String state = generator.getState();
    String city = generator.getCity(state);
    String image = "catImage.jpeg";

    //table
    String tableFirstColumnName = "Label";
    String tableSecondColumnName = "Values";
    String tableStudentName = "Student Name";
    String tableEmail = "Student Email";
    String tableGender = "Gender";
    String tableMobile = "Mobile";
    String tableDateOfBirth = "Date of Birth";
    String tableSubjects = "Subjects";
    String tableHobbies = "Hobbies";
    String tablePicture = "Picture";
    String tableAddress = "Address";
    String tableStateAndCity = "State and City";

    @BeforeAll
    static void setUp(){
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setSubjects(subjects)
                .setHobby(hobby)
                .uploadPicture(image)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setBirthDate(day, month, year)
                .clickSubmit();

        registrationFormPage
                .checkResult(tableFirstColumnName, tableSecondColumnName)
                .checkResult(tableStudentName, firstName + " " + lastName)
                .checkResult(tableEmail, email)
                .checkResult(tableGender, gender)
                .checkResult(tableMobile, mobile)
                .checkResult(tableDateOfBirth, day + " " + month + "," + year)
                .checkResult(tableSubjects, subjects)
                .checkResult(tableHobbies, hobby)
                .checkResult(tablePicture, image)
                .checkResult(tableAddress, currentAddress)
                .checkResult(tableStateAndCity, state + " " + city);

    }
}


