/**
 * 
 */
package coffeeReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.File;
import java.io.IOException;
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
		
		//test output
		System.out.println(sheet.getSheetName());
		System.out.println("Sheet first row number: " + sheet.getFirstRowNum());
		System.out.println("Sheet last row number: " + sheet.getLastRowNum());
		
		
		
		//cleanup
		wb.close();
		pkg.close();
	}

}
