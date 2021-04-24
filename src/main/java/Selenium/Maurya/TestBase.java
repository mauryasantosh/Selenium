package Selenium.Maurya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase {

	public static void setup()
	{
		/*ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);*/
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\exe\\geckodriver.exe");
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.worldometers.info/world-population/");		
		long startTime = System.currentTimeMillis();
		int count=1;
		while((System.currentTimeMillis()-startTime)<20000)
		{ 	System.out.print("PrintCount "+count++);
			System.out.print(" | Current World Population "+driver.findElement(By.xpath("//div[@class='maincounter-number']")).getText());
			System.out.print(" | Births today "+driver.findElement(By.xpath("//span[@rel='births_today']")).getText());
			System.out.print(" | Deaths today "+driver.findElement(By.xpath("//span[@rel='dth1s_today']")).getText());
			System.out.print(" | Births this year "+driver.findElement(By.xpath("//span[@rel='births_this_year']")).getText());
			System.out.print(" | Deaths this year "+driver.findElement(By.xpath("//span[@rel='dth1s_this_year']")).getText());
			System.out.print(" | Population Growth today "+driver.findElement(By.xpath("//span[@rel='absolute_growth']")).getText());
			System.out.println(" | Population Growth this year "+driver.findElement(By.xpath("//span[@rel='absolute_growth_year']")).getText());
						
		}
		driver.close();
	}
}
