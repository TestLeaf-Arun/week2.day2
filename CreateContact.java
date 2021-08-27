package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class CreateContact {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Arun");
		driver.findElement(By.id("lastNameField")).sendKeys("Prakash");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Arun");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Prakash");
		driver.findElement(By.name("departmentName")).sendKeys("Training");
		driver.findElement(By.name("description")).sendKeys("Welcome To Java Training");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("javatraining@testleaf.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select drpDwn = new Select(state);
		drpDwn.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement descField = driver.findElement(By.name("description"));
		descField.clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Welcome To Java Training");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String title = driver.getTitle();
		System.out.println("Title of the resulting page is " + title);
	}
}