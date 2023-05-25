package br.com.buritiscript.generante.generator.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    public Integer getIndexColunas(String collumnName) throws IOException {
       
            FileInputStream arquivo = new FileInputStream("upload-dir/guarda.xlsx");
            XSSFWorkbook planilha = new XSSFWorkbook(arquivo);
            XSSFSheet folha = planilha.getSheetAt(0);
            Iterator<Row> linhaIterator = folha.iterator();

            while (linhaIterator.hasNext()){
                Row linha = linhaIterator.next();
                Iterator<Cell> celulIterator = linha.cellIterator();
                Cell celula = celulIterator.next();
                if(celula.getStringCellValue().equals("collumnName")){
                   return celula.getColumnIndex();
                }        
           }
        return null;
        
    }
}
