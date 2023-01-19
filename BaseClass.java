package BasePackage;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Pages.DesktopListPage;
import com.Pages.DesktopSelectionPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utilities.CommonFunctions;
import com.Utilities.IntializeDriver;
import com.Utilities.ReadPropertiesFile;

public class BaseClass {

	public static int constructorRunCounter = 0;
	public static String ElementFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\elementSelectors.properties";
	public static String DetailsFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\details.properties";

	public static ReadPropertiesFile prop = new ReadPropertiesFile();
	public static Properties eleconfig = prop.loadElementSelectorFile();
	public static Properties detailsconfig = prop.loadDetails();
	public static CommonFunctions comm = new CommonFunctions();
	
	public static IntializeDriver initdriver = null;
	public static WebDriver driver = null;
	public static LoginPage loginpage = null;
	public static HomePage homepage = null;
	public static DesktopSelectionPage deskpage = null;
	public static DesktopListPage deskListPage = null;
	

	@BeforeSuite(alwaysRun = true)
	public void preSuite() {
		initdriver = IntializeDriver.getInstanceOfIntializeDriverClass();
		driver = initdriver.getDriver();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		deskpage = new DesktopSelectionPage(driver);
		deskListPage = new DesktopListPage(driver);
	}
	
	
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("In After suite");
		driver.quit();
	}

}
