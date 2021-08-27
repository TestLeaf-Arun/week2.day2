package week2.day2;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CheckBoxPage {
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	Select the languages you know
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[3]")).click();
		
	//	Confirm Selenium is checked
		boolean defaultcheck = driver.findElement(By.xpath("//div[@class='example'][2]//input[1]")).isSelected();
		if (defaultcheck == true)	{
			System.out.println("Yes, Selenium Checkbox is Checked");
		}
		
	//	Deselect only the checked box
		boolean deselect = driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]/div[2]/input")).isSelected();
		if (deselect == true) {
			driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]/div[2]/input")).click();
			System.out.println("Selected checkbox is deselected");
		}
		
	//	Select all the Check boxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following::input"));
		for (WebElement eachElement : checkBoxes) {
			eachElement.click();
			Thread.sleep(4000);			
		}	
	}
}	