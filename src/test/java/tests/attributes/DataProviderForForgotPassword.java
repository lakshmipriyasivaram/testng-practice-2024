package tests.attributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ResetPasswordPage;
import utils.CommonActions;

import java.time.Duration;
public class  DataProviderForForgotPassword
{
    @DataProvider(parallel = true)
    public Object[][] getresetpassword() {
        Object[][] data =
                {
                        {"stem123"},
                        {"Stem123"},
                        {"STEM123"},
                };
        return data;
    }

    @Test(dataProvider = "getresetpassword")
public void loginpage(String username )
    {
    String resetusername ="Stem";
    CommonActions commonActions = new CommonActions();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickForgotPassword();
    commonActions.waitFor(2);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
    resetPasswordPage.typeResetUsername(resetusername);
    resetPasswordPage.clickResetPasswordButton();
    commonActions.waitFor(5);
    driver.quit();
}
}
