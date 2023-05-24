package br.com.buritiscript.generante.geradorXml.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



@RestController
public class ConverterController {

    @Autowired
    XMLExtratorService xmlExtratorService;

    @GetMapping("/leitor")
    public void lerExcel() throws IOException, ParserConfigurationException, TransformerException{
        try {

            FileInputStream arquivo = new FileInputStream("upload-dir/guarda.xlsx");
            XSSFWorkbook planilha = new XSSFWorkbook(arquivo);
            XSSFSheet folha = planilha.getSheetAt(0);
            Iterator<Row> linhaIterator = folha.iterator();
            int numLinha = 0;


            String arquivoPath = "upload-dir/concurso2023.xml";
 
            DocumentBuilderFactory dbf  =DocumentBuilderFactory.newInstance();
            DocumentBuilder dc = dbf.newDocumentBuilder();
            Document d = dc.newDocument();
            d.setXmlStandalone(true);
// -------------------------------------------------------------------------------------------------------------------------------
            Element concursos = d.createElement("concursos");
            d.appendChild(concursos);

            // descricao="CONCURSO PARA O CARGO DE GUARDA CIVIL MUNICIPAL - EDITAL 01/2"
// -------------------------------------------------------------------------------------------------------------------------------
            Element concurso = d.createElement("concurso");
            concursos.appendChild(concurso);
            
            Attr prorrogacao = d.createAttribute("prorrogacao");
            prorrogacao.setValue("0");
            concurso.setAttributeNode(prorrogacao);

            Attr validade = d.createAttribute("validade");
            validade.setValue("24");
            concurso.setAttributeNode(validade);

            Attr descricao = d.createAttribute("descricao");
            descricao.setValue("CONCURSO PARA O CARGO DE GUARDA CIVIL MUNICIPAL - EDITAL 01/2");
            concurso.setAttributeNode(descricao);


// -------------------------------------------------------------------------------------------------------------------------------
            Element arquivo_lei_especial = d.createElement("arquivo_lei_especial");
            concurso.appendChild(arquivo_lei_especial);
// -------------------------------------------------------------------------------------------------------------------------------
            Element arquivo_lei_ldo = d.createElement("arquivo_lei_ldo");
            concurso.appendChild(arquivo_lei_ldo);
// -------------------------------------------------------------------------------------------------------------------------------
            Element arquivo_lei_loa = d.createElement("arquivo_lei_loa");
            concurso.appendChild(arquivo_lei_loa);
// -------------------------------------------------------------------------------------------------------------------------------
            Element arquivo_lei_ppa = d.createElement("arquivo_lei_ppa");
            concurso.appendChild(arquivo_lei_ppa);
// -------------------------------------------------------------------------------------------------------------------------------
            Element editais = d.createElement("editais");
            concurso.appendChild(editais);
// -------------------------------------------------------------------------------------------------------------------------------
            Element edital = d.createElement("edital");
            editais.appendChild(edital);

            Attr vpublicacao = d.createAttribute("vpublicacao");
            vpublicacao.setValue("0");
            edital.setAttributeNode(vpublicacao);

            Attr numero = d.createAttribute("numero");
            numero.setValue("24");
            edital.setAttributeNode(numero);

            Attr lpublicacao = d.createAttribute("lpublicacao");
            lpublicacao.setValue("DIARIO OFICIAL DO MUNICIPIO DE BOA VISTA");
            edital.setAttributeNode(lpublicacao);

            Attr datapublicacao = d.createAttribute("datapublicacao");
            datapublicacao.setValue("XX/XX/XXXX");
            edital.setAttributeNode(datapublicacao);

            Attr ano = d.createAttribute("ano");
            ano.setValue("XXXX");
            edital.setAttributeNode(ano);

// -------------------------------------------------------------------------------------------------------------------------------
            Element docdigital = d.createElement("docdigital");
            edital.appendChild(docdigital);
// -------------------------------------------------------------------------------------------------------------------------------

// -------------------------------------------------------------------------------------------------------------------------------


// -------------------------------------------------------------------------------------------------------------------------------

// -------------------------------------------------------------------------------------------------------------------------------


// -------------------------------------------------------------------------------------------------------------------------------
            Element inscritos = d.createElement("inscritos");
            concursos.appendChild(inscritos);
            

            while (linhaIterator.hasNext()){
                Row linha = linhaIterator.next();
                Iterator<Cell> celulIterator = linha.cellIterator();
               
               if(numLinha > 0){
                    Element inscrito = d.createElement("inscrito");
                    inscritos.appendChild(inscrito);

                    while(celulIterator.hasNext()) {
                       Cell celula = celulIterator.next();
                       switch (celula.getColumnIndex()) {
                           case 0:
                                Attr ninscrito = d.createAttribute("ninscrito");
                                ninscrito.setValue(celula.getStringCellValue());
                                inscrito.setAttributeNode(ninscrito);
                            break;
                            case 1: 
                                Attr nome = d.createAttribute("nome");
                                nome.setValue(celula.getStringCellValue());
                                inscrito.setAttributeNode(nome);
                            break;
                        }
                        
                        
                    }
                   
               } 
               numLinha++;
           }

           //construção do XML
           TransformerFactory tf = TransformerFactory.newInstance();
           Transformer t = tf.newTransformer();
           DOMSource domSource = new DOMSource(d);
           StreamResult streamResult = new StreamResult(new File(arquivoPath));

           //juntar o conteudo ao arquivo criado
           t.transform(domSource,streamResult);
           arquivo.close();

        } catch (IllegalStateException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        }
        
    }
}
