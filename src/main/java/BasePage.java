import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  public WebDriver webDriver;

  public BasePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  public void waitForPageLoad(){
    var wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState")));
  }
}
