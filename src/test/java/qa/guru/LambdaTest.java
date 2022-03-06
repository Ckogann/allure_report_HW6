package qa.guru;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {

    @Test
    public void lambdaTestIssuesShouldBe() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Поиск нужного репозитория", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("Ckogann/allure_report_HW6");
            $(".header-search-input").submit();
        });
        step("Переход к репозиторию", () -> {
            $(linkText("Ckogann/allure_report_HW6")).click();
        });
        step("Проверка того, что таб Issues активен для репозитория", () -> {
            $("#issues-tab").shouldBe(Condition.visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        AnnotetedStepsTest steps = new AnnotetedStepsTest();
        steps.openMainPage();
        steps.searchRepository();
        steps.openRepository();
        steps.checkTabIssues();
    }

}
