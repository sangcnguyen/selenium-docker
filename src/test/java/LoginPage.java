import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
  WebDriver webDriver;

  @FindBy(name = "username")
  public WebElement userInput;

  @FindBy(name = "password")
  public WebElement passInput;

  @FindBy(xpath = "//button")
  public WebElement loginButton;

  @FindBy(xpath = "//*[@class='orangehrm-login-error']//p")
  public WebElement errorMessage;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    this.webDriver = webDriver;
  }

  public void logIn(String username, String password) {
    userInput.sendKeys(username);
    passInput.sendKeys(password);
    loginButton.click();
  }

  public String getCurrentUrl() {
    return webDriver.getCurrentUrl();
  }
}
