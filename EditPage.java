package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class EditPage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	Enter an Email Address	
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("seleniumtraining@testleaf.com");
		
	//	Append a Text and press Keyboard Tab
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Online Course", Keys.TAB);		
		
	//	Get default entered Text
		String text = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
		System.out.println("Default Text is " + text);
		
	//  Clear the Text	
		WebElement clearText = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		clearText.clear();
		
	//	Confirm that the edit field is disabled		
		WebElement disablefunc = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean textfield = disablefunc.isEnabled();
		if (textfield==false)	{
			System.out.println("The edit field is disabled");
		}	else
				System.out.println("The edit field is enabled");
		
	}
}