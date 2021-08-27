package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class RadioButtonPage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	Are you enjoying the Classes? Yes or No
		driver.findElement(By.id("yes")).click();
		
	//	Find the default selected Radio Button
		boolean defaultselect = driver.findElement(By.xpath("(//input[@value='1'])[2]")).isSelected();
		if (defaultselect==true)	{
			System.out.println("Default selected Radio button is Checked");
		} else
			System.out.println("Radio button is Unchecked");
		
	//	Select your age group (only if choice was not selected)	
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[3]//input[3]")).click();
	}
}