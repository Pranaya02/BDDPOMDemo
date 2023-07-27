package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;

public class TestBase {
	
	public static WebDriver driver; 
	public static Properties prop;

	public TestBase(){
		prop = new Properties ();

		String path = System.getProperty("user.dir")+"//src//test//resources//configfiles//config-properties";
		FileInputStream fin;

		try {

		        fin = new FileInputStream(path);
				prop. load(fin);

	    } catch (FileNotFoundException e) {
         e.printStackTrace () ;

	} catch (IOException e) {

	e.printStackTrace () ;
	}
	}
	
	

	public static void initialize() {
		String strBrowser = prop.getProperty("browser");
			if (strBrowser.equalsIgnoreCase("chrome")) {
				driver = (WebDriver) new ChromeDriver();
			}
			else if (strBrowser.equalsIgnoreCase("edge")) {
				driver = (WebDriver) new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       driver.manage().deleteAllCookies();
	       driver.manage().window().maximize();
	       driver.get(prop.getProperty("url"));
	
	
}
}



