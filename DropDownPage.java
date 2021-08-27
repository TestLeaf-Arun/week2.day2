package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropDownPage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	Drop down using Index		
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select drpDwn1 = new Select(drop1);
		drpDwn1.selectByIndex(1);
		
	//	Drop down using Text		
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select drpDwn2 = new Select(drop2);
		drpDwn2.selectByVisibleText("Appium");
		
	//	Drop down using Value		
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select drpDwn3 = new Select(drop3);
		drpDwn3.selectByValue("4");
		
	//	Get the number of Drop down options
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		Select drpDwn4 = new Select(drop4);
		int size = drpDwn4.getOptions().size();
		System.out.println("Size of the Dropdown is " + size);
		
	//	Using sendKeys to select
		driver.findElement(By.xpath("//div[@id='contentblock']/section/div[5]/select")).sendKeys("UFT/QTP");
	}
}