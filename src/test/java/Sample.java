import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\MavenFrameWork\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.name("email"));
	login.sendKeys("Sahani");
	
	WebElement pass = driver.findElement(By.name("pass"));
	pass.sendKeys("sahani.com");
	
	WebElement btnlogin = driver.findElement(By.name("login"));
	btnlogin.click();
	
	
	
	
	
	
	
	
	}

}
