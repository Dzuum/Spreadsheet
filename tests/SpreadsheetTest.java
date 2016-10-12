import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet sheet = new Spreadsheet();
	
	@Test
	public void test_getSetValue() {
		sheet.set("A1", "1");
		assertEquals("1", sheet.get("A1"));
	}
	
	@Test
	public void test_evaluateSetNegativeValue() {
		sheet.set("A1", "-1");
		assertEquals("-1", sheet.evaluate("A1"));
	}

	@Test
	public void test_wronglyFormattedInteger() {
		sheet.set("A1", "5A");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_evaluateStringCell() {
		sheet.set("A1", "'string'");
		assertEquals("string", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_evaluateUnquotedString() {
		sheet.set("A1", "'string");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
}
