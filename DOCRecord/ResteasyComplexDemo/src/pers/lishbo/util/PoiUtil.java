package pers.lishbo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("deprecation")
public class PoiUtil {

	
	 private Workbook wb ;
	 
	    private Sheet sheet;
	    private Row row;

	    
	    /**
	     * 读取Excel表格表头的内容
	     * @param InputStream
	     * @return String 表头内容的数组
	     */
		public String[] readExcelTitle(InputStream is,boolean isXls) {
	        try {
	            
	            if(isXls){
//	            	fs = new POIFSFileSystem(is);
	            	wb = new HSSFWorkbook(is);
	            }else{
	            	wb = new XSSFWorkbook(is);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        sheet = wb.getSheetAt(0);
	        row = sheet.getRow(0);
	        // 标题总列数
	        int colNum = row.getPhysicalNumberOfCells();
	        System.out.println("colNum:" + colNum);
	        String[] title = new String[colNum];
	        for (int i = 0; i < colNum; i++) {
	            //title[i] = getStringCellValue(row.getCell((short) i));
	            title[i] = getCellFormatValue(row.getCell((short) i));
	        }
	        return title;
	    }

	    /**
	     * 读取Excel数据内容
	     * @param InputStream
	     * @return Map 包含单元格数据内容的Map对象
	     */
	    public Map<Integer, String> readExcelContent(InputStream is,boolean isXls) {
	        Map<Integer, String> content = new HashMap<Integer, String>();
	     
	        String str = "";
	        try {
	            
	            if(isXls){
//	            	fs = new POIFSFileSystem(is);
	            	wb = new HSSFWorkbook(is);
	            }else{
	            	wb = new XSSFWorkbook(is);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        sheet = wb.getSheetAt(0);
	        // 得到总行数
	        int rowNum = sheet.getLastRowNum();
	        row = sheet.getRow(0);
	        int colNum = row.getPhysicalNumberOfCells();
	        content.put(-1, rowNum+"");//记录行数
	        content.put(-2, colNum+"");//记录列数
	        // 正文内容应该从第二行开始,第一行为表头的标题
	        for (int i = 1; i <= rowNum; i++) {
	            row = sheet.getRow(i);
	            int j = 0;
	            while (j < colNum) {
	                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
	                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
	                // str += getStringCellValue(row.getCell((short) j)).trim() +
	                // "-";
	                str += getCellFormatValue(row.getCell((short) j)).trim() + "	";
//	                str += getCellFormatValue(row.getCell((short) j)).trim() + "-|";
	                j++;
	            }
	            content.put(i, str);
	            str = "";
	        }
	        return content;
	    }
	    /**
	     * 读取Excel数据内容
	     * @param InputStream
	     * @return Map 包含单元格数据内容的Map对象
	     */
	    public Map<Integer, String> readExcelContentAll(InputStream is,boolean isXls) {
	    	Map<Integer, String> content = new HashMap<Integer, String>();
	    	
	    	String str = "";
	    	try {
	    		
	    		if(isXls){
//	            	fs = new POIFSFileSystem(is);
	    			wb = new HSSFWorkbook(is);
	    		}else{
	    			wb = new XSSFWorkbook(is);
	    		}
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	sheet = wb.getSheetAt(0);
	    	// 得到总行数
	    	int rowNum = sheet.getLastRowNum();
	    	row = sheet.getRow(0);
	    	int colNum = row.getPhysicalNumberOfCells();
	    	content.put(-1, rowNum+"");//记录行数
	    	content.put(-2, colNum+"");//记录列数
	    	// 正文内容应该从第二行开始,第一行为表头的标题
	    	for (int i = 1; i <= rowNum; i++) {
	    		row = sheet.getRow(i);
	    		int j = 0;
	    		while (j < colNum) {
	    			// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
	    			// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
	    			// str += getStringCellValue(row.getCell((short) j)).trim() +
	    			// "-";
//	                str += getCellFormatValue(row.getCell((short) j)).trim() + "|";
	    			str += getCellFormatValue(row.getCell((short) j)).trim() + "-|";
	    			j++;
	    		}
	    		content.put(i, str);
	    		str = "";
	    	}
	    	return content;
	    }
	    /**
	     * 读取Excel数据内容
	     * @param InputStream
	     * @return Map 包含单元格数据内容的Map对象
	     */
	    public List< List< String> > readExcelAll(InputStream is,boolean isXls) {
	    	List< List< String> > con=new ArrayList<List<String>>();
	        
	        String str = "";
	        try {
	            
	            if(isXls){
//	            	fs = new POIFSFileSystem(is);
	            	wb = new HSSFWorkbook(is);
	            }else{
	            	wb = new XSSFWorkbook(is);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        int numberOfSheets = wb.getNumberOfSheets();
	        System.out.println("一共"+numberOfSheets+"页");
	        List< String> content =null;
	        for (int t = 0; t < numberOfSheets; t++) {
	        	System.out.println("处理第"+t+"页");
	        	sheet = wb.getSheetAt(t);
		        // 得到总行数
		        int isb = 0;
		        int rowNum = sheet.getLastRowNum();
		        for (int i = 0; i < rowNum; i++) {
					row= sheet.getRow(i);
					String string = getCellFormatValue(row.getCell(0)).trim();
					if(null!=string && string.contains("学校")){
						isb=i;
						break;
					}
				}
		        row = sheet.getRow(isb);
		        int colNum = row.getPhysicalNumberOfCells();
		        System.out.print("文件标题：");
		        for (int i = 0; i < colNum; i++) {
		        	
		        	String string = getCellFormatValue(row.getCell(i)).trim();
		        	if(null==string || "".equals(string.trim()) ){
		        		colNum=i;
						break;
					}
		        	System.out.print(string+"	");
				}
		        System.out.println();
		        System.out.println("rowNum:"+rowNum +";colNum:"+colNum);
		        // 正文内容应该从第二行开始,第一行为表头的标题
		        for (int i = isb+1; i <= rowNum; i++) {
		            row = sheet.getRow(i);
		            int j = 0;
		            boolean isC=true;
		           
		            while (j < colNum) {
		                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
		                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
		                // str += getStringCellValue(row.getCell((short) j)).trim() +
		                // "-";
//		            	System.out.println("处理第"+i+"行");
		            	String s = getCellFormatValue(row.getCell((short) j)).trim();
		            	if(j==0 && (null==s || "".equals(s))){
		            		isC=false;
		            	}
		                str += s + ",";
		                j++;
		            }
		            if(isC){
		            	if(null==content){
		            		content=new ArrayList<String>();
		            	}else if(content.size()>3000){
		            		con.add(content);
		            		content=new ArrayList<String>();
		            	}
		            	content.add(str);
		            }
		            str = "";
		        }
		        
			}
	        if(content.size()>0){
	        	con.add(content);
	        }
	        
	        return con;
	    }

	    /**
	     * 获取单元格数据内容为字符串类型的数据
	     * 
	     * @param cell Excel单元格
	     * @return String 单元格数据内容
	     */
	    public String getStringCellValue(Cell cell) {
	    	if (cell == null) {
	            return "";
	        }
	        String strCell = "";
	        switch (cell.getCellType()) {
	        case HSSFCell.CELL_TYPE_STRING:
	            strCell = cell.getStringCellValue();
	            break;
	        case HSSFCell.CELL_TYPE_NUMERIC:
	            strCell = String.valueOf(cell.getNumericCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BOOLEAN:
	            strCell = String.valueOf(cell.getBooleanCellValue());
	            break;
	        case HSSFCell.CELL_TYPE_BLANK:
	            strCell = "";
	            break;
	        default:
	            strCell = "";
	            break;
	        }
	        if (strCell.equals("") || strCell == null) {
	            return "";
	        }
	        
	        return strCell;
	    }

	    /**
	     * 获取单元格数据内容为日期类型的数据
	     * 
	     * @param cell
	     *            Excel单元格
	     * @return String 单元格数据内容
	     */
	    @SuppressWarnings("unused")
		private String getDateCellValue(HSSFCell cell) {
	        String result = "";
	        try {
	            int cellType = cell.getCellType();
	            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
	                Date date = cell.getDateCellValue();
	                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
	                        + "-" + date.getDate();
	            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
	                String date = getStringCellValue(cell);
	                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
	            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
	                result = "";
	            }
	        } catch (Exception e) {
	            System.out.println("日期格式不正确!");
	            e.printStackTrace();
	        }
	        return result;
	    }

	    /**
	     * 根据Cell类型设置数据
	     * @param cell
	     * @return
	     */
	    public String getCellFormatValue(Cell cell) {
	        String cellvalue = "";
	        if (cell != null) {
	            // 判断当前Cell的Type
	            switch (cell.getCellType()) {
	            // 如果当前Cell的Type为NUMERIC
	            case Cell.CELL_TYPE_NUMERIC:
	            case Cell.CELL_TYPE_FORMULA: {
	                
	               
	                // 如果是纯数字
	                
	                cellvalue = new DecimalFormat("#").format(cell.getNumericCellValue());
	                
	                break;
	            }
	            // 如果当前Cell的Type为STRIN
	            case Cell.CELL_TYPE_STRING:
	                // 取得当前的Cell字符串
	                cellvalue = cell.getRichStringCellValue().getString();
	                break;
	            // 默认的Cell值
	            default:
	                cellvalue = " ";
	            }
	        } else {
	            cellvalue = "";
	        }
	        return cellvalue;

	    }
	    /**
	     * 取excel内容 去标题
	     * @param url
	     * @return
	     * @throws Exception
	     */
	    public static Map<Integer, String> getExcelContent(String url) throws Exception{
	    	PoiUtil excelReader = new PoiUtil();
	    	InputStream is2 = new FileInputStream(url);
	    	String fileType = url.substring(url.lastIndexOf(".") + 1, url.length());
	    	boolean isXls=true;
	    	if (fileType.equals("xls")) {
	    		isXls=true;
		    } else if (fileType.equals("xlsx")) {
		    	isXls=false;
		    } else {
		    	is2.close();
		    	return null;
		    }
	    	Map<Integer, String> map = excelReader.readExcelContent(is2,isXls);
	    	is2.close();
			return map;
	    }
	    /**
	     * 取excel内容 去标题
	     * @param url
	     * @return:包含空值的集合数组
	     * @throws Exception
	     */
	    public static List<String []> getExcelContentAll(String url) throws Exception{
	    	PoiUtil excelReader = new PoiUtil();
	    	InputStream is2 = new FileInputStream(url);
	    	String fileType = url.substring(url.lastIndexOf(".") + 1, url.length());
	    	boolean isXls=true;
	    	if (fileType.equals("xls")) {
	    		isXls=true;
	    	} else if (fileType.equals("xlsx")) {
	    		isXls=false;
	    	} else {
	    		is2.close();
	    		return null;
	    	}
	    	Map<Integer, String> map = excelReader.readExcelContentAll(is2,isXls);
	    	//转换为List<String []>
	    	List<String []> list =new ArrayList<String []>();
	    	String row=map.get(-1);
			String lie=map.get(-2);
			String  [] s=new String [Integer.parseInt(lie)];
//			String  [] chongzu=new String [Integer.parseInt(lie)];		
			for (int i = 1; i < Integer.parseInt(row); i++) {
				s=map.get(i).split("\\|");
//				System.err.println(s.length);
				for (int j = 0; j <Integer.parseInt(lie); j++) {
					s[j]=s[j].replace("-", "".trim());
				}
				list.add(s);
				}
	    	is2.close();
	    	return list;
	   }

	    /**
	     * 取excel内容 去标题
	     * @param url
	     * @return
	     * @throws Exception
	     */
	    public static List<List<String>> getExcelAll(String url) throws Exception{
	    	PoiUtil excelReader = new PoiUtil();
	    	InputStream is2 = new FileInputStream(url);
	    	String fileType = url.substring(url.lastIndexOf(".") + 1, url.length());
	    	boolean isXls=true;
	    	if (fileType.equals("xls")) {
	    		isXls=true;
		    } else if (fileType.equals("xlsx")) {
		    	isXls=false;
		    } else {
		    	is2.close();
		    	return null;
		    }
	    	List<List<String>> map = excelReader.readExcelAll(is2,isXls);
	    	is2.close();
			return map;
	    }
	    /**
	     * 取excel标题数组
	     * @param url
	     * @return
	     * @throws Exception
	     */
	    public static String[] getExcelTitle(String url) throws Exception{
	    	PoiUtil excelReader = new PoiUtil();
	    	InputStream is = new FileInputStream(url);
	    	String fileType = url.substring(url.lastIndexOf(".") + 1, url.length());
	    	boolean isXls=true;
	    	if (fileType.equals("xls")) {
	    		isXls=true;
		    } else if (fileType.equals("xlsx")) {
		    	isXls=false;
		    } else {
		    	is.close();
		    	return null;
		    }
	    	String[] title = excelReader.readExcelTitle(is,isXls);
	    	is.close();
			return title;
	    }

	    /**
	     * 写出excel文档
	     * @param path	地址
	     * @param fileName	文件名
	     * @param fileType	文件类型
	     * @param list	文件内容
	     * @param titleRow 标题
	     * @throws Exception 
	     */
	    public static void writer(String path, String fileName,String fileType,List<String> list,String titleRow[],String title) throws Exception {  
	        Workbook wb = null; 
	        String excelPath = path+File.separator+fileName+"."+fileType;
	        File file = new File(excelPath);
	        Sheet sheet =null;
	        boolean isuse=true;
	        if(null==title){
            	title="sheet1";
            	isuse=false;
            }
	        //创建工作文档对象   
	        if (!file.exists()) {
	            if (fileType.equals("xls")) {
	                wb = new HSSFWorkbook();
	                
	            } else if(fileType.equals("xlsx")) {
	                
	                    wb = new XSSFWorkbook();
	            } else {
	                throw new Exception("文件格式不正确");
	            }
	            //创建sheet对象   
	            
	            sheet = (Sheet) wb.createSheet(title);  
	            OutputStream outputStream = new FileOutputStream(excelPath);
	            wb.write(outputStream);
	            outputStream.flush();
	            outputStream.close();
	            
	        } else {
	            if (fileType.equals("xls")) {  
	                wb = new HSSFWorkbook();  
	                
	            } else if(fileType.equals("xlsx")) { 
	                wb = new XSSFWorkbook();  
	                
	            } else {  
	                throw new Exception("文件格式不正确");
	            }  
	        }
	        OutputStream stream=null;
	        try {
	        	 //创建sheet对象   
		        if (sheet==null) {
		            sheet = (Sheet) wb.createSheet(title);  
		        }
		        
		        CellStyle style = wb.createCellStyle(); // 样式对象      
		        // 设置单元格的背景颜色为淡蓝色  
		        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index); 
		        
		        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直      
		        style.setAlignment(CellStyle.ALIGN_CENTER);// 水平   
		        style.setWrapText(true);// 指定当单元格内容显示不下时自动换行
		       
		        
		        
		        Font font = wb.createFont();  
		        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  
		        font.setFontName("宋体");  
		        font.setFontHeight((short) 280);  
		        style.setFont(font);  
		        // 单元格合并      
		       
		        sheet.autoSizeColumn(5200);
		        int titleNum = 0;
		        if(isuse){
		        	 //添加表头  
		        	 Row row = sheet.createRow(0);
				     Cell cell = row.createCell(0);
				     row.setHeight((short) 540); 
				     cell.setCellValue(title);    //创建第一行   
				     cell.setCellStyle(style); // 样式，居中
				     // 四个参数分别是：起始行，起始列，结束行，结束列      
				     sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, titleRow.length-1));  
				     titleNum=titleNum+2;
//		        	setYangShi();
		        }
		       
		        
		        Row row = sheet.createRow(titleNum);    //创建第二行    
		        for(int i = 0;i < titleRow.length;i++){  
		        	Cell cell = row.createCell(i);  
		            cell.setCellValue(titleRow[i]);  
		            cell.setCellStyle(style); // 样式，居中
		            sheet.setColumnWidth(i, (20 * 256)); 
		        }  
		        row.setHeight((short) 540); 

		        //循环写入行数据    
		        for (int i = 0; i < list.size(); i++) {  
		            row = (Row) sheet.createRow(++titleNum);  
		            row.setHeight((short) 500); 
		            int lengths=titleRow.length;
		            String[] split = list.get(i).split("	",-1);
		            if( titleRow.length>split.length){
		            	lengths=split.length;
		            }
		            for (int j = 0; j < lengths; j++) {
		            	Cell cell =row.createCell(j);
		            	cell.setCellValue(split[j]);
		            	cell.setCellStyle(style);
					}

		        }  
		        //创建文件流   
		         stream = new FileOutputStream(excelPath);  
		        //写入数据   
		        wb.write(stream); 
		        
		      //关闭文件流   
		        stream.close();
		       
			} catch (Exception e) {
				PoiUtil.writer(path, fileName, fileType, list, titleRow, title);
			} 
	        System.out.println("xieru-");
	    }  
	    public static void main(String[] args) throws Exception {
	    	/*
	    	String path="C:\\Users\\cjh\\Desktop";
			String fileName = "地市数据统计表1";
			//2003版最大行数是65536行，最大列数是256列。Excel2007及以后的版本最大行数是1048576行，最大列数是16384列。
			String fileType="xls";//有上限，不能填太多数据
			List<String> list=new ArrayList<String>();
				String s1="1	2	3	4	5	6	7	8	9	10	11";
				String s2="1	2	3	4	5	6	7	8	9	10	11";
				String s3="1	2	3	4	5	6	7	8	9	10	11";
				String s4="1	2	3	4	5	6	7	8	9	10	11";
				String s5="1	2	3	4	5	6	7	8	9	10	11";
				String s6="1	2	3	4	5	6	7	8	9	10	11";
				String s7="1	2	3	4	5	6	7	8	9	10	11";
				String s8="1	2	3	4	5	6	7	8	9	10	11";
				String s9="1	2	3	4	5	6	7	8	9	10	11";
				String s0="1	2	3	4	5	6	7	8	9	10	11";
			
				list.add(s1);
				list.add(s2);
				list.add(s3);
				list.add(s4);
				list.add(s5);
				list.add(s6);
				list.add(s7);
				list.add(s8);
				list.add(s9);
				list.add(s0);
//			for (int i = 0; i < 100000; i++) {
//				String s1="1	2	3	4	5	6	7	8	9	10	11";
//				list.add(s1);
//			}
			String[] titleRow={"区县","订购用户","退订用户","PC登录","APP登录","PC发通知","APP发通知","查看通知","PC发作业","PC做作业","APP做作业"} ;
//			String title="地市数据统计表";
			try {
				PoiUtil.writer(path, fileName, fileType, list, titleRow, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    */
	    	
			String url = "C:/Users/cjh/Desktop/allstudents.xlsx";
	/*		Map<Integer, String> excelContent = PoiUtil.getExcelContent(url);
			System.err.println(excelContent);
			String row=excelContent.get(-1);
			String lie=excelContent.get(-2);
			String  [] s=new String [Integer.parseInt(lie)];
			for (int i = 1; i < Integer.parseInt(row); i++) {
				s=excelContent.get(i).split("\\|");
				System.err.println(s.length);
				if(s.length==Integer.parseInt(lie)){
					for (String string : s) {
						System.out.println(i+":-----"+string);
					}
				}else{
					for (int j = s.length; j <=Integer.parseInt(lie); j++) {
						s[j]="-";
					}
					for (String string : s) {
						System.out.println(i+":-----"+string);
					}
				}
				
			}*/
			List<String[]> excelContentAll = PoiUtil.getExcelContentAll(url);
			for (String[] strings : excelContentAll) {
				System.out.println(strings.length+":---");
				for (String string : strings) {
					System.out.print(string+"|");
				}
			}
	    
	    }
	    
	    
}
