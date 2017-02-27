package coffeeReader;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

public class SortedLinkedListTest {

	@Before
	public void setUp() throws Exception {
		OPCPackage pkg = OPCPackage.open(new File("SRM - QueueView.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		SortedLinkedList<ArrayList<String>> listTest = new SortedLinkedList();
		
		for (Row row : sheet)
		{
			ArrayList<String> array = new ArrayList();
			int cellNum = 0;
			for (Cell cell : row)
			{
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
				cellNum++;
			}
			listTest.add(array);
		}
	}

	@Test
	public void testSortedLinkedList() {
		SortedLinkedList<ArrayList<String>> test = new SortedLinkedList();
	}

	@Test
	public void testSortedLinkedListT() {
		ArrayList<String> testArray = new ArrayList();
		
		testArray.add("foo");
		testArray.add("bar");
		
		SortedLinkedList<ArrayList<String>> test = new SortedLinkedList(testArray);
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		SortedLinkedList<ArrayList<String>> test = new SortedLinkedList();
		assertEquals(true, test.isEmpty());
		
		test.add(new ArrayList());
		assertEquals(false, test.isEmpty());
	}

	@Test
	public void testFind() {
		listTest.find();
	}

	@Test
	public void testFindPrevious() {
		fail("Not yet implemented");
	}

	@Test
	public void testResetCurrNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrade() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPrint() throws InvalidFormatException, IOException
	{
		OPCPackage pkg = OPCPackage.open(new File("SRM - QueueView.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		SortedLinkedList<ArrayList<String>> listTest = new SortedLinkedList();
		
		for (Row row : sheet)
		{
			ArrayList<String> array = new ArrayList();
			int cellNum = 0;
			for (Cell cell : row)
			{
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
				cellNum++;
			}
			listTest.add(array);
		}
		
		listTest.print();
	}

}
