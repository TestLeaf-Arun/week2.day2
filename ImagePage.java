package week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class ImagePage {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		
		String brokenLink = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).getAttribute("src");
		System.out.println(brokenLink);
		
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}
}