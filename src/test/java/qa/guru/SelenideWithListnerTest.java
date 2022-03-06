package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideWithListnerTest {

    @Test
    public void testIssuesShouldBe() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Ckogann/allure_report_HW6");
        $(".header-search-input").submit();

        $(linkText("Ckogann/allure_report_HW6")).click();
        $("#issues-tab").shouldBe(Condition.visible);
    }
}
