import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWorkExcel {

	public static void main(String[] args) throws IOException  {
		File file= new File("C:\\Users\\user\\eclipse-workspace\\MavenFrameWork\\file\\Datas.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Amazon Product");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\MavenFrameWork\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		WebElement txtBox = driver.findElement(By.id("twotabsearchtextbox"));
		txtBox.sendKeys("mi phone", Keys.ENTER);
		
		
		List<WebElement> phones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

	for (int i = 0; i <phones.size(); i++) {
		WebElement txt = phones.get(i);
		String text = txt.getText();
		Row createRow = sheet.createRow(i);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(text);
		System.out.println(text);
		
	}
		
		

}}
