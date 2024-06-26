package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement year = $(".react-datepicker__year-select");
    private final SelenideElement month = $(".react-datepicker__month-select");

    public void setDate(String dayS, String monthS, String yearS) {
        year.selectOption(yearS);
        month.selectOption(monthS);
        if (dayS.length() < 2) {
            dayS ="0" + dayS;
        }
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayS)).click();

    }
}
