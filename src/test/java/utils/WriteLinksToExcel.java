package utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebElement;

public class WriteLinksToExcel {

	public static void writeLink(List<WebElement> links) throws Exception {


		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestOutputSheet");

		XSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Link Text");
		header.createCell(1).setCellValue("Link URL");

		int rowNum = 1;

		for (WebElement e : links) {

			XSSFRow row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(e.getText());
			row.createCell(1).setCellValue(e.getAttribute("href"));

		}

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		
		
		String filePath = System.getProperty("user.dir") + "\\Exceloutput\\TestOutput.xlsx";
		FileOutputStream file = new FileOutputStream(filePath);

		workbook.write(file);

		workbook.close();
		file.close();

		System.out.println(" Excel file created at: " + filePath);
	}
}
