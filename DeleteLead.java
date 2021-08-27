package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class DeleteLead {
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneAreaCode")).sendKeys("234");
		driver.findElement(By.name("phoneNumber")).sendKeys("5678901");
		
	//  Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		
	//  Capture Lead ID of first resulting lead
		String leadid = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td//div//a)[1]")).getText();
		System.out.println("Lead ID of first resulting lead is " + leadid);
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td//div//a)[1]")).click();		
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
	//  Enter the captured Lead ID
		driver.findElement(By.name("id")).sendKeys(leadid);
		
	//  Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
	//  Verify message "No records to display in the Lead list. This message confirms the successful deletion
		String text1 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		String text2 = "No records to display";
		if (text1.equals(text2)) {
			System.out.println("Data is deleted");
		}	
		else
			System.out.println("Data is not deleted");		
	//	driver.close();	
	}
}