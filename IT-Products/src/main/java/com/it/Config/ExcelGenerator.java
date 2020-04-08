package com.it.Config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.it.Model.TransactionEntity;

public class ExcelGenerator {
	  
	  public static ByteArrayInputStream ToExcel(TransactionEntity transaction) throws IOException {
	    String[] COLUMNs = {"Id", "Cart", "Intent", "State","CreateTime","UpdateTime","Status","Payment-Method","payerId","First-Name","Middle-Name","Last-Name","E-mail","Country-Code"};
	    try(
	        Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ){
	      CreationHelper createHelper = workbook.getCreationHelper();
	   
	      Sheet sheet = workbook.createSheet("transactions");
	   
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLUE.getIndex());
	   
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      headerCellStyle.setFont(headerFont);
	      Row headerRow = sheet.createRow(0);
	      for (int col = 0; col < COLUMNs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(COLUMNs[col]);
	        cell.setCellStyle(headerCellStyle);
	      }
	      CellStyle ageCellStyle = workbook.createCellStyle();
	      ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	   
	        Row row = sheet.createRow(1);
	   
	        row.createCell(0).setCellValue(transaction.getId());
	        row.createCell(1).setCellValue(transaction.getCart());
	        row.createCell(2).setCellValue(transaction.getIntent());
	        row.createCell(3).setCellValue(transaction.getState());
	        row.createCell(4).setCellValue(transaction.getCreateTime());
	        row.createCell(5).setCellValue(transaction.getUpdateTime());
	        row.createCell(6).setCellValue(transaction.getPayer().getStatus());
	        row.createCell(7).setCellValue(transaction.getPayer().getPaymentMethod());
	        row.createCell(8).setCellValue(transaction.getPayer().getPayerInfo().getPayerId());
	        row.createCell(9).setCellValue(transaction.getPayer().getPayerInfo().getFirstName());
	        row.createCell(10).setCellValue(transaction.getPayer().getPayerInfo().getMiddleName());
	        row.createCell(11).setCellValue(transaction.getPayer().getPayerInfo().getLastName());
	        row.createCell(12).setCellValue(transaction.getPayer().getPayerInfo().getEmail());
	        row.createCell(13).setCellValue(transaction.getPayer().getPayerInfo().getCountryCode());
	    /*    row.createCell(15).setCellValue(transaction.getPayer().getPayerInfo().getPhone());	
	        row.createCell(16).setCellValue(transaction.getPayer().getPayerInfo().getPhone());
	        row.createCell(17).setCellValue(transaction.getPayer().getPayerInfo().getPhone());
	      */
	   
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }

	
}
