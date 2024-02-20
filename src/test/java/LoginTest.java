import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
  LoginPage loginPage;

  @Test
  public void invalidCredentials() {
    loginPage = new LoginPage(webDriver);
    loginPage.logIn("Admin", "123");
    Assert.assertEquals(loginPage.errorMessage.getText(), "Invalid credentials");
  }

  @Test()
  public void loginSuccessfully() {
    loginPage = new LoginPage(webDriver);
    loginPage.logIn("Admin", "admin123");
    loginPage.waitForPageLoad();
    Assert.assertEquals(loginPage.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
  }
}
