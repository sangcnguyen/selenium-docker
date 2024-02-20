import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@Slf4j
public class BaseTest {
  protected WebDriver webDriver;
  public final static int TIMEOUT = 5;

  @BeforeMethod
  @Parameters({ "browser" })
  public void setUp() throws MalformedURLException {
    webDriver = getRemoteDriver();
    webDriver.get("https://opensource-demo.orangehrmlive.com/");
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
  }

  private WebDriver getRemoteDriver() throws MalformedURLException {
    ChromeOptions capabilities = new ChromeOptions();
    capabilities.addArguments("--start-maximized");
    String urlFormat = "http://%s:4444/wd/hub";
    String hubHost ="localhost";
    String url = String.format(urlFormat, hubHost);
    log.info(String.format("%s%s","grid url: ",url));
    return new RemoteWebDriver(new URL(url), capabilities);
  }

  private WebDriver getLocalDriver() {
    log.info("Browser Started : Chrome");
    return new ChromeDriver();
  }

  @AfterMethod
  public void closeBrowser() {
    webDriver.quit();
  }
}
