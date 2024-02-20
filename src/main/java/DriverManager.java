import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
  private WebDriver driver;

  public WebDriver getDriver(String type) {
    if (type.equalsIgnoreCase("local")) {
      driver = getLocalDriver();
    } else {
      driver = getRemoteDriver();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
  }

  public WebDriver getLocalDriver() {
    driver = new ChromeDriver();
    return driver;
  }

  public WebDriver getRemoteDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    try {
      driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return driver;
  }
}
