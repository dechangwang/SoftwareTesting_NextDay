package cn.edu.wang;

import java.io.File;
import java.util.*;

import junit.framework.TestCase;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestNextDay extends TestCase {
	private List<Date> inputDateList;
	private List<Date> expectedDateList;
	private List<Date> realOutputList;
	public TestNextDay(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		inputDateList = new ArrayList<Date>();
		expectedDateList = new ArrayList<Date>();
		realOutputList = new ArrayList<Date>();
		//month 0 2 6 11 13
		//day 0 2 15 29 31
		inputDateList.add(new Date(2016,0,0));
		inputDateList.add(new Date(2016,0,2));
		inputDateList.add(new Date(2016,0,15));
		inputDateList.add(new Date(2016,0,29));
		inputDateList.add(new Date(2016,0,31));
		
		inputDateList.add(new Date(2016,2,0));
		inputDateList.add(new Date(2016,2,2));
		inputDateList.add(new Date(2016,2,15));
		inputDateList.add(new Date(2016,2,29));
		inputDateList.add(new Date(2016,2,31));
		
		inputDateList.add(new Date(2016,6,0));
		inputDateList.add(new Date(2016,6,2));
		inputDateList.add(new Date(2016,6,15));
		inputDateList.add(new Date(2016,6,28));
		inputDateList.add(new Date(2016,6,30));
		
		inputDateList.add(new Date(2016,11,0));
		inputDateList.add(new Date(2016,11,3));
		inputDateList.add(new Date(2016,11,14));
		inputDateList.add(new Date(2016,11,28));
		inputDateList.add(new Date(2016,11,31));
		
		inputDateList.add(new Date(2016,13,0));
		inputDateList.add(new Date(2016,13,3));
		inputDateList.add(new Date(2016,13,14));
		inputDateList.add(new Date(2016,13,28));
		inputDateList.add(new Date(2016,13,31));
		
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);
		
		expectedDateList.add(null);
		expectedDateList.add(new Date(2016,2,3));
		expectedDateList.add(new Date(2016,2,16));
		expectedDateList.add(new Date(2016,3,1));
		expectedDateList.add(null);
		
		expectedDateList.add(null);
		expectedDateList.add(new Date(2016,6,3));
		expectedDateList.add(new Date(2016,6,16));
		expectedDateList.add(new Date(2016,6,29));
		expectedDateList.add(new Date(2016,7,1));
		
		expectedDateList.add(null);
		expectedDateList.add(new Date(2016,11,4));
		expectedDateList.add(new Date(2016,11,15));
		expectedDateList.add(new Date(2016,11,29));
		expectedDateList.add(new Date(2016,12,1));
		
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);
		expectedDateList.add(null);

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		String title[]={"编号","年","月","天","预期输出","实际输出","结果"};
		WritableWorkbook book= Workbook.createWorkbook(new File("textNextDay.xls"));
		WritableSheet sheet = book.createSheet("第一页", 0);
		
		sheet.addCell(new Label(0,0,"NextDay 测试用例"));
		for(int i = 0;i<7;i++)
			sheet.addCell(new Label(i,1,title[i]));
		
		for(int i = 0;i< inputDateList.size();i++){
			Date date = inputDateList.get(i);
			int year = date.getYear();
			int month = date.getMonth();
			int day = date.getDay();
			sheet.addCell(new Label(0,i+2,"00"+i));//sheet.addCell(new Label(j+1,i+1,context[i][j]));
			sheet.addCell(new Label(1,i+2,year+""));
			sheet.addCell(new Label(2,i+2,month+""));
			sheet.addCell(new Label(3,i+2,day+""));
			sheet.addCell(new Label(4,i+2,expectedDateList.get(i)+""));
			sheet.addCell(new Label(5,i+2,realOutputList.get(i)+""));
			sheet.addCell(new Label(6,i+2,NextDay.isSameDay(expectedDateList.get(i), realOutputList.get(i))+""));
		}
		sheet.mergeCells(0,0,6,0);
		//sheet.msheet.mergeCells(0,1,0,2);
		  book.write(); 
          //关闭文件
          book.close(); 
		
	}

	public void testNextDay() {
//		NextDay nextday = new NextDay(new Date(2016, 1, 0));
//		assertNull(nextday.getNextDay());
//		assertNull(new NextDay(new Date(2016, 1, 6)).getNextDay());
		for(int i= 0;i<inputDateList.size();i++){
			realOutputList.add(new NextDay(inputDateList.get(i)).getNextDay());
		}
	}
}
