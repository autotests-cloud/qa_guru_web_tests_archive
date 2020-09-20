package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {

    @Test
    void loginWithUnverifiedEmailTest() {
        Configuration.baseUrl = "https://github.com";

        open("/login");

        $("#login_field").val("");
        $("#password").val("").pressEnter();

        $(".flash-error").shouldHave(text("Your account has been flagged."));
    }
}
