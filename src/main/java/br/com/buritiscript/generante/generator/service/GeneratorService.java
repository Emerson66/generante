package br.com.buritiscript.generante.generator.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    public Map<String, Integer> getIndexColunas(String fileName) throws IOException {
        Map<String, Integer> indexColunas = new HashMap<String, Integer>();

        FileInputStream arquivo = new FileInputStream("upload-dir/"+ fileName);
        XSSFWorkbook planilha = new XSSFWorkbook(arquivo);
        XSSFSheet folha = planilha.getSheetAt(0);
        Iterator<Row> linhaIterator = folha.iterator();

        Row linha = linhaIterator.next();
        Iterator<Cell> celulIterator = linha.cellIterator();

        while((indexColunas.size() < 3) && (celulIterator.hasNext())){
            Cell celula1 = celulIterator.next();
            if(celula1.getStringCellValue().equals("INSCRICAO")){
                indexColunas.put("INSCRICAO", celula1.getColumnIndex());
            }
            if(celula1.getStringCellValue().equals("NOME")){
                indexColunas.put("NOME", celula1.getColumnIndex());
            }
            if(celula1.getStringCellValue().equals("CPF")){
                indexColunas.put("CPF", celula1.getColumnIndex());
            }
        }
        return indexColunas;  
    }
}
