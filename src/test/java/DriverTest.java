
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.TAF.mydriver.DriverFactory;
import com.TAF.mydriver.DriverType;

public class DriverTest {

	@Test
	public void test() {
		WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);
		driver.get("https://www.whatismybrowser.com/");
		DriverFactory.disposeDriver();

		driver = DriverFactory.getDriver(DriverType.CHROME_IPAD);
		driver.get("https://www.whatismybrowser.com/");
		DriverFactory.disposeDriver();

		driver = DriverFactory.getDriver(DriverType.CHROME_NEXUS5);
		driver.get("https://www.whatismybrowser.com/");
		DriverFactory.disposeDriver();

		driver = DriverFactory.getDriver(DriverType.FIREFOX);
		driver.get("https://www.whatismybrowser.com/");
		DriverFactory.disposeDriver();
	}
}
