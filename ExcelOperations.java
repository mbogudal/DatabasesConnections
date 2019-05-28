
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelOperations implements FileOperations {
		private String fileDir;
	
		ExcelOperations(String fileDir){
			this.fileDir = fileDir;
		}
		
		public void write(String fileName, List<String> scheme, List<String> result) {
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(fileName);
			
			int rowNum = 0;
			int colNum= 0;
			int nResultIndex = 0;
			
			HSSFRow rowScheme = sheet.createRow(rowNum++);
			
			
			for(int nSchemeCells = 0; nSchemeCells < scheme.size(); nSchemeCells++ ) {
				
				HSSFCell cell = rowScheme.createCell(colNum++);
				cell.setCellValue((String) scheme.get(nSchemeCells));
				
			}
			
			for(int nResultRows = 0; nResultRows < (result.size()/scheme.size()); nResultRows++) {
				
				colNum = 0;
				HSSFRow row = sheet.createRow(rowNum++);
				for(int nResultCells = 0; nResultCells < scheme.size(); nResultCells++) {
				
					HSSFCell cell = row.createCell(colNum++);
					cell.setCellValue((String) result.get(nResultIndex++));
				
				}
			}
			
			try{
				FileOutputStream outputStream = new FileOutputStream(fileDir+"/"+fileName+".xls");
				workbook.write(outputStream);
				workbook.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void read() {
			// TODO Auto-generated method stub
			
		}
	
}
