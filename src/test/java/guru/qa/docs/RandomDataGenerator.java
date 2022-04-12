package guru.qa.docs;

import com.github.javafaker.Faker;
import guru.qa.docs.enums.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class RandomDataGenerator {
    Faker faker = new Faker();

    Date from = new Date("1920/01/01");
    Date to = new Date("2013/12/31");
    Date date = faker.date().between(from, to);
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getGender(){
        String gender = faker.dog().gender();
        return gender.substring(0,1).toUpperCase() + gender.substring(1);
    }

    public String getPhoneNumber(){
        return faker.numerify("##########");
    }

    public String getAddress(){
        return faker.address().fullAddress();
    }


    //date
    public String getDay(){
        //return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        return String.valueOf(localDate.getDayOfMonth());
    }

    public String getMonth(){
        //return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        String month = String.valueOf(localDate.getMonth());
        return month.charAt(0) + month.substring(1).toLowerCase();
    }

    public String getYear(){
        //return String.valueOf(calendar.get(Calendar.YEAR));
        return String.valueOf(localDate.getYear());
    }


    //subjects

    public String getSubject(){
        int el = new Random().nextInt(Subjects.values().length);
        return Subjects.values()[el].toString();
    }

    public String getHobby(){
        int el = new Random().nextInt(Hobbies.values().length);
        return Hobbies.values()[el].toString();
    }

    public String getState(){
        int el = new Random().nextInt(States.values().length);
        return States.values()[el].toString();
    }

    public String getCity(String state){
        int el;
        String result = null;
        switch (state){
            case "NCR":
                el = new Random().nextInt(NCR.values().length);
                result = NCR.values()[el].toString();
                break;
            case "Haryana":
                el = new Random().nextInt(Haryana.values().length);
                result = Haryana.values()[el].toString();
                break;
            case "Rajasthan":
                el = new Random().nextInt(Rajasthan.values().length);
                result = Rajasthan.values()[el].toString();
                break;
        }
        return result;
    }

}
