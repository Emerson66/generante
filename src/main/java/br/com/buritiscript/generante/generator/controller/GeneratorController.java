package br.com.buritiscript.generante.generator.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import java.io.IOException;


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
public class GeneratorController {

    public Integer getIndexColunas(String collumnName) {
        Integer i = null;
        try {
            FileInputStream arquivo = new FileInputStream("upload-dir/guarda.xlsx");
            XSSFWorkbook planilha = new XSSFWorkbook(arquivo);
            XSSFSheet folha = planilha.getSheetAt(0);
            Iterator<Row> linhaIterator = folha.iterator();


            while (linhaIterator.hasNext()){
                Row linha = linhaIterator.next();
                Iterator<Cell> celulIterator = linha.cellIterator();
                    
                   
                       Cell celula = celulIterator.next();

                       if(celula.getStringCellValue().equals("collumnName")){
                            i = celula.getColumnIndex();
                            break;
                       }
                        
           }

        } catch (Exception e) {
            
        }
        
        return i;
    }


    @GetMapping("/leitor")
    public void gerarXml() throws IOException, ParserConfigurationException, TransformerException{

        
        try {
             Integer CPF = null;
             Integer INSCRICAO = null;
             Integer NOME = null;
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

            Element observacao = d.createElement("observacao");
            edital.appendChild(observacao);

            Element tipoEdital = d.createElement("tipoEdital");
            edital.appendChild(tipoEdital);
// -------------------------------------------------------------------------------------------------------------------------------
            Element modalidadeConcurso = d.createElement("modalidadeConcurso");
            concurso.appendChild(modalidadeConcurso);

            Attr idModalidadeConcurso = d.createAttribute("id");
            idModalidadeConcurso.setValue("");
            modalidadeConcurso.setAttributeNode(idModalidadeConcurso);
// -------------------------------------------------------------------------------------------------------------------------------
            Element regimeJuridico = d.createElement("regimeJuridico");
            concurso.appendChild(regimeJuridico);

            Attr idRegimeJuridico = d.createAttribute("id");
            idRegimeJuridico.setValue("");
            regimeJuridico.setAttributeNode(idRegimeJuridico);

// -------------------------------------------------------------------------------------------------------------------------------
            Element texto_ldo = d.createElement("texto_ldo");
            concurso.appendChild(texto_ldo);
// -------------------------------------------------------------------------------------------------------------------------------
            Element texto_lei_especial = d.createElement("texto_lei_especial");
            concurso.appendChild(texto_lei_especial);

// -------------------------------------------------------------------------------------------------------------------------------
            Element texto_loa = d.createElement("texto_loa");
            concurso.appendChild(texto_loa);
// -------------------------------------------------------------------------------------------------------------------------------
            Element texto_ppa = d.createElement("texto_ppa");
            concurso.appendChild(texto_ppa);
// -------------------------------------------------------------------------------------------------------------------------------
            Element cargos = d.createElement("cargos");
            concurso.appendChild(cargos);
// -------------------------------------------------------------------------------------------------------------------------------
            Element cargo_edital = d.createElement("cargo_edital");
            cargos.appendChild(cargo_edital);

            Attr nvagas = d.createAttribute("nvagas");
            nvagas.setValue("");
            cargo_edital.setAttributeNode(nvagas);
// -------------------------------------------------------------------------------------------------------------------------------
            Element cargo = d.createElement("cargo");
            cargo_edital.appendChild(cargo);

            Attr descricaoCargo = d.createAttribute("descricao");
            descricaoCargo.setValue("");
            cargo.setAttributeNode(descricaoCargo);

            Attr codigo = d.createAttribute("codigo");
            codigo.setValue("");
            cargo.setAttributeNode(codigo);
// -------------------------------------------------------------------------------------------------------------------------------
            Element escolaridade = d.createElement("escolaridade");
            cargo_edital.appendChild(escolaridade);
// -------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------
            Element inscritos = d.createElement("inscritos");
            concursos.appendChild(inscritos);
            

            while (linhaIterator.hasNext()){
                Row linha = linhaIterator.next();
                Iterator<Cell> celulIterator = linha.cellIterator();
                Iterator<Cell> celulIterator1 = linha.cellIterator();
                if(numLinha == 0){
                    while(((CPF == null) || (NOME == null) || (INSCRICAO == null)) && (celulIterator1.hasNext())){
                        Cell celula1 = celulIterator1.next();
                        if(celula1.getColumnIndex() ==0) {
                            System.out.println(
                                celula1.getColumnIndex()
                            );
                        }
                        if(celula1.getStringCellValue().equals("Inscrição")){
                            
                            INSCRICAO = celula1.getColumnIndex();
                        }
                        if(celula1.getStringCellValue().equals("Nome")){
                            NOME = celula1.getColumnIndex();
                        }
                        if(celula1.getStringCellValue().equals("CPF")){
                            CPF = celula1.getColumnIndex();
                        }
                        
                    }
                }

                
                    Element inscrito = d.createElement("inscrito");
                    inscritos.appendChild(inscrito);

                    while(celulIterator.hasNext()) {
                        Cell celula = celulIterator.next();
                        
                        if (celula.getColumnIndex() == INSCRICAO){
                            
                            Attr ninscrito = d.createAttribute("ninscrito");
                            ninscrito.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(ninscrito);
                        }
                        if (celula.getColumnIndex() == CPF){
                            Attr cpf = d.createAttribute("cpf");
                            cpf.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(cpf);
                        }
                        if (celula.getColumnIndex() == NOME){
                            Attr nome = d.createAttribute("nome");
                            nome.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(nome);
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
