import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static utils.RandomUtils.getRandomStringArrayIndex;

public class TestData {

    private final Faker faker = new Faker();
    public final String userName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = generateGender(),
            userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            userSubjects = generateSubjects(),
            userHobbies = generateHobbie(),
            userFile = "img.png",
            userAddress = faker.address().streetAddress(),
            userState = generateState(),
            userCity = generateCity(userState);
    public final Birthday userBirthday = generateBirthday();

    private String generateGender() {
        String[] gender = new String[]{"Male", "Female", "Other"};
        return getRandomStringArrayIndex(gender);
    }

    private String generateSubjects() {
        String[] subject = new String[]{"Maths", "Computer Science", "Art"};
        return getRandomStringArrayIndex(subject);
    }

    private String generateHobbie() {
        String[] hobbie = new String[]{"Music", "Sports", "Reading"};
        return getRandomStringArrayIndex(hobbie);
    }

    private String generateState() {
        String[] state = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomStringArrayIndex(state);
    }

    private String generateCity(String state) {
        String[] ncrCity = new String[]{"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCity = new String[]{"Agra", "Lucknow", "Merrut"};
        String[] haryanaCity = new String[]{"Karnal", "Panipat"};
        String[] rajasthanCity = new String[]{"Karnal", "Panipat"};

        switch (state) {
            case "NCR" -> {
                return getRandomStringArrayIndex(ncrCity);
            }
            case "Uttar Pradesh" -> {
                return getRandomStringArrayIndex(uttarPradeshCity);
            }
            case "Haryana" -> {
                return getRandomStringArrayIndex(haryanaCity);
            }
            case "Rajasthan" -> {
                return getRandomStringArrayIndex(rajasthanCity);
            }
            default -> throw new IllegalStateException("Unexpected value: " + state);
        }

    }

    public static class Birthday {

        public final String year;
        public final String month;
        public final String day;

        Birthday(Integer year, String month, Integer day) {
            this.year = Integer.toString(year);
            this.month = month;
            this.day = day < 10 ? String.format("0%d", day) : Integer.toString(day);
        }
    }

    private static Birthday generateBirthday() {
        Date birthday = Faker.instance().date().birthday(0, 100);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        var year = calendar.get(Calendar.YEAR);
        var month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        var day = calendar.get(Calendar.DAY_OF_MONTH);

        return new Birthday(year, month, day);
    }
}

