package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий")
    public void searchRepository() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Ckogann/allure_report_HW6");
        $(".header-search-input").submit();
    }
    @Step("Переходим в репозиторий")
    public void openRepository() {
        $(linkText("Ckogann/allure_report_HW6")).click();
    }
    @Step("Проверка видимости таба Issues")
            public void checkTabIssues() {
        $("#issues-tab").shouldBe(Condition.visible);
    }

}
