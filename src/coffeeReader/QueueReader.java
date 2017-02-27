/**
 * 
 */
package coffeeReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Sam Rowe
 *
 */
public class QueueReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		/**
		 * Opens queue as OPCPackage and then the OPCPackage is opened as XSSFWorkbook
		 * XSSFWorkbook is the format for working with .xlsx workbooks
		 * XSSFSheet sheet is created and set to the first sheet in the document -
		 * Sheet1 that contains the queue
		 */
		OPCPackage pkg = OPCPackage.open(new File("SRM - QueueView.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		
		 /**Initialization of SortedLinkedList */
		SortedLinkedList<ArrayList<String>> list = new SortedLinkedList<ArrayList<String>>();
		for (Row row : sheet)
		{
			//Create new ArrayList
			ArrayList<String> array = new ArrayList<String>();
			for (Cell cell : row)
			{
				//fill each element in ArrayList with next element in row
				switch(cell.getCellTypeEnum())
				{
				
				case STRING:
					array.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					array.add(Double.toString(cell.getNumericCellValue()));
					break;
				case BLANK:
					array.add("");
					break;
				default:
					array.add("");
					break;
				}
			}
			//at end of row, add ArrayList to SortedLinkedList
			list.add(array);
		}
		//cleanup input
		wb.close();
		
		//test output
		System.out.println(sheet.getSheetName());
		System.out.println("Sheet first row number: " + sheet.getFirstRowNum());
		System.out.println("Sheet last row number: " + sheet.getLastRowNum());
		System.out.println(sheet.getTopRow());
		
		
		
		//cleanup
		wb.close();
		pkg.close();
	}

}
