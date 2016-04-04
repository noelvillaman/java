package school;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListObject {
	
	public List<Object> getDataFromExcelFile(String excelFileName) throws IOException {
		List<Object> mp = new ArrayList<>();
		//String excelFilePath = "courses.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFileName));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					//System.out.print(cell.getStringCellValue());
					mp.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					//System.out.print((int) cell.getNumericCellValue());
					mp.add((int)cell.getNumericCellValue());
					break;
				}
			}
			System.out.println();
		}

		workbook.close();
		inputStream.close();
		return mp;
	}

}
