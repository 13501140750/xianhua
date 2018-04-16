package com.jifenbao.common;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtil {
	/**
	 * CELL_TYPE_BLANK 空值 
	 * CELL_TYPE_BOOLEAN 布尔型 
	 * CELL_TYPE_ERROR 错误 
	 * CELL_TYPE_FORMULA 公式型 
	 * CELL_TYPE_STRING 字符串型 
	 * CELL_TYPE_NUMERIC 数值型 
	 * @return
	 */
	public static String getCellValue(Cell cell) {
		String value="";
		if (cell != null) {
			switch (cell.getCellType()) { 
			
             case Cell.CELL_TYPE_FORMULA:  
                value=cell.getCellFormula();  
                break;  

             case Cell.CELL_TYPE_NUMERIC:  
                 if(HSSFDateUtil.isCellDateFormatted(cell)){  
                     value=cell.getDateCellValue()+"";  
                 }else{  
                     value=(int)cell.getNumericCellValue()+"";  
                 }  
                 break; 
                 
             case Cell.CELL_TYPE_STRING:  
                 value=cell.getStringCellValue();  
                 break;  
                   
             case Cell.CELL_TYPE_BOOLEAN:  
                 value=cell.getBooleanCellValue()+"";  
                 break;  

             default: ; 
             }  
		}
		return value.trim();
	}
}
