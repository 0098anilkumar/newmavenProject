import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MavenSample {

	private static final String DateFormat = null;
	private static java.text.DateFormat dateFormt;

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\Desktop\\Green Tech Class\\Application\\Datas.xlsx");

		// Convt The Object
		FileInputStream stream = new FileInputStream(file);

		// WorkBook
		Workbook workbook = new XSSFWorkbook(stream);

		// Sheet Name
		Sheet sheet = workbook.getSheet("Sheet1");

		// Row
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			// For Each Row
			Row row = sheet.getRow(i);
			System.out.println(row);

			// For Cell
//			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
//
//				// For Each cell
//				Cell cell = row.getCell(j);
//				
//				if (DateUtil.isCellDateFormatted(cell)) {
//					Date date = cell.getDateCellValue();
//					SimpleDateFormat Dateformat = SimpleDateFormat("dd-MMM-yy");
//					String name=dateFormt.format(DateFormat);
//					
//				} else {
//					
//
//				}
//				
				
			
				
//
//				// To Check Cell Type,   1-text, 0-Number
//           int cellType = cell.getCellType();
//          int type = 0;       // To Be Check
//		if (type==1) {
//        	  String name = cell.getStringCellValue();
//        	  System.out.println(name);
//		}
//          if (type==0) {
//        	  double number = cell.getNumericCellValue();
//        	  // long
//        	  long li=(long)number;
//        	  String name = String.valueOf(li);
//        	  System.out.println(name);
//        	  
//          
//          }  
//      
//          //String
//         
	
				
			}

		}

	

	
}
