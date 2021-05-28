import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

public class BaseMethodClass {
	
	public static WebDriver driver;
	
	
	public void getDriver() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\MavenFrameWork\\Driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	}
	public void launchUrl(String data) {
		driver.get(data);
		}
		public void getTitle() {
		driver.getTitle();
		}
		public void getUrl() {
		driver.getCurrentUrl();
		}
		public void enterText(WebElement element,String data) {
			element.sendKeys(data);
		}
		public void buttonClick(WebElement element) {
			element.click();
		}
		public void getText(WebElement element) {
			element.getText();
		}
		public void getAttribute(WebElement element,String data) {
			element.getAttribute(data);
		}
		public void moveToElement(WebElement element) {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).perform();
		}
		public void dragAndDrop(WebElement Src, WebElement des) {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(Src, des).perform();
		}
		public void doubleClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).perform();
		}
		public void rightClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.contextClick(element).perform();
		}
		public void selectValueByIndex(WebElement element,int number) {
			Select s = new Select(element);
			s.selectByIndex(number);
		}
		public void selectValueByValue(WebElement element,String value) {
			Select s = new Select(element);
			s.selectByValue(value);
		}
		public void selectValueByVisibleText(WebElement element,String data) {
			Select s = new Select(element);
			s.selectByVisibleText(data);
		}
		public void getOptionsBySelect(WebElement element) {
			Select s = new Select(element);
			List options = (List) s.getOptions();
		}
		public void getAllOptionsBySelect(WebElement element) {
			Select s = new Select(element);
			s.getAllSelectedOptions();
		}
		public void checkMultiple(WebElement element) {
			Select s = new Select(element);
			s.isMultiple();
		}
		public void getFirstOption(WebElement element) {
			Select s = new Select(element);
			s.getFirstSelectedOption();
		}
		public void deSelectByIndex(WebElement element,int number) {
			Select s = new Select(element);
			s.deselectByIndex(number);
		}
		public void deSelectByValue(String Value, WebElement element) {
			Select s = new Select(element);
			s.deselectByValue(Value);
		}
		public void deSelectByVisibleText(String data, WebElement element) {
			Select s = new Select(element);
			s.deselectByVisibleText(data);
		}
		public void deSelectAll(WebElement element) {
			Select s = new Select(element);
			s.deselectAll();
		}
		public void enterTextByJs(String data, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" +data+ "')", element);
		}
		public void btnClickByJs(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].Click()", element);
		}
		public void scrollDown(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		public void scrollUp(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		public void switchFrame1(String data) {
			driver.switchTo().frame(data);
		}
		public void switchFrame(String data) {
			driver.switchTo().frame(data);
		}
		public void switchFrame(WebElement element) {
			driver.switchTo().frame(element);
		}
		public void switchFrame(Integer number) {
			driver.switchTo().frame(number);
		}
		public void frameCount(WebElement element) {
			element.getSize();
		}
		public void takeScreenShot(WebElement element) {
			element.getScreenshotAs(OutputType.FILE);
		}
		public void windowHandle(WebDriver driver) {
			driver.getWindowHandle();
		}
		public void windowHandles(WebDriver driver) {
			driver.getWindowHandles();
		}
		public void switchToWindow(String data) {
			driver.switchTo().window(data);
		}
		public void naviagteUrl(String data) {
			driver.navigate().to(data);
		}
		public void navigateBack() {
			driver.navigate().back();
		}
		public void navigateForward() {
			driver.navigate().forward();
		}
		public void navigateRefresh() {
			driver.navigate().refresh();
		}
		public void keyDown(WebElement element) {
			Actions ac = new Actions(driver);
			ac.keyDown(element,Keys.SHIFT).perform();
		}
		public void keyUp(WebElement element) {
			Actions ac = new Actions(driver);
			ac.keyUp(element, Keys.SHIFT).perform();
		}
		public void simpleAlert() {
			Alert al = driver.switchTo().alert();
			al.accept();
		}
		public WebElement findElementById(String data) {
			WebElement findElement = driver.findElement(By.id(data));
			return findElement;
		}
		public WebElement findElementByName(String data) {
			WebElement findElement = driver.findElement(By.id(data));
			return findElement;
		}
		public WebElement findElementByClassName(String data) {
			WebElement findElement = driver.findElement(By.id(data));
			return findElement;
		}
		public String excelRead(String path,String sheetName,int rowNo,int cellNo) throws IOException {
			File file = new File(path);
			FileInputStream str = new FileInputStream(file);
			Workbook w = new XSSFWorkbook(str);
			Sheet sheet = w.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = (Cell) row.getCell(cellNo);
			int cellType = ((org.apache.poi.ss.usermodel.Cell) cell).getCellType();
			String value="";
			if (cellType == 1) {
				value = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
			} if (cellType==0) {
				if (DateUtil.isCellDateFormatted((org.apache.poi.ss.usermodel.Cell) cell)) {
					Date date = (Date) cell.getValue();
					SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
					value = format.format(date);
					
				} else {
					double numericCellValue = ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
				}
			}
			return value;
		}
		public void excelWrite(String pathname,String sheetName,int rowNo,int cellNo,String data) throws IOException {
			File file = new File(pathname);
			Workbook w = new XSSFWorkbook();
			Sheet sheet = w.createSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			Cell cell = (Cell) row.createCell(cellNo);
			((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			w.write(out);
		}
		public void excelReadWrite(String pathName,String SheetName,int rowNo,int cellNo, String data) throws IOException {
			File file = new File(pathName);
			FileInputStream str = new FileInputStream(file);
			Workbook w = new XSSFWorkbook(str);
			Sheet sheet = w.getSheet(SheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = (Cell) row.createCell(cellNo);
			((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			w.write(out);
	
		}}
