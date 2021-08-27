package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class DuplicateLead {
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
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("abcde@testleaf.com");
		
	//	Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
				
	//  Capture name of the first resulting lead
		String text1 = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td)[3]//a")).getText();
		System.out.println("Name of first resulting lead is " + text1);
		
	//	Click First resulting lead
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td)[3]//a")).click();
		
	//  Click Duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
	//  Verify the Title as Duplicate lead
		String title ="Duplicate Lead | opentaps CRM";
		String dupTitle = driver.getTitle();
		if (title.equals(dupTitle)) {
			System.out.println("In the Duplicate Lead page");
		}	
		else
			System.out.println("Not in the Duplicate Lead page");	
				
	//  Click Create Lead
		driver.findElement(By.name("submitButton")).click();		
		
	//  Confirm the duplicated lead name is same as captured name
		String text2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Name of the Duplicated lead is " + text2);
		if (text1.equals(text2)) {
			System.out.println("Duplicated Lead name and the captured name are same");
		}	
		else
			System.out.println("Duplicated Lead name and the captured name are not same"); 
	// driver.close();
	}
}