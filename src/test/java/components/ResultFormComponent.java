package components;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ResultFormComponent {
    private final ElementsCollection actualData = $$("tbody tr td:last-child");

    public boolean checkResult(List<String> expectedData) {
        List<String> data = actualData
                .texts().stream()
                .filter(e -> e.length() > 2).toList();
        return expectedData.equals(data);
    }
}
