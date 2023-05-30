package br.com.buritiscript.generante.generator.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.com.buritiscript.generante.generator.service.GeneratorService;

import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



@RestController
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

 

    @GetMapping("/files/{fileName}")
    public void gerarXml(@PathVariable String fileName) throws IOException, ParserConfigurationException, TransformerException{

        
        try {
            FileInputStream arquivo = new FileInputStream("upload-dir/"+fileName);
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
            datapublicacao.setValue("25/05/2023");
            edital.setAttributeNode(datapublicacao);

            Attr ano = d.createAttribute("ano");
            ano.setValue("2023");
            edital.setAttributeNode(ano);

// -------------------------------------------------------------------------------------------------------------------------------
            Element docdigital = d.createElement("docdigital");
            edital.appendChild(docdigital);

            Element observacao = d.createElement("observacao");
            edital.appendChild(observacao);

            Element tipoEdital = d.createElement("tipoEdital");
            edital.appendChild(tipoEdital);

            Attr idTipoEdital = d.createAttribute("id");
            idTipoEdital.setValue("2");
            tipoEdital.setAttributeNode(idTipoEdital);
// -------------------------------------------------------------------------------------------------------------------------------
            Element modalidadeConcurso = d.createElement("modalidadeConcurso");
            concurso.appendChild(modalidadeConcurso);

            Attr idModalidadeConcurso = d.createAttribute("id");
            idModalidadeConcurso.setValue("2");
            modalidadeConcurso.setAttributeNode(idModalidadeConcurso);
// -------------------------------------------------------------------------------------------------------------------------------
            Element regimeJuridico = d.createElement("regimeJuridico");
            concurso.appendChild(regimeJuridico);

            Attr idRegimeJuridico = d.createAttribute("id");
            idRegimeJuridico.setValue("4");
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
            nvagas.setValue("150");
            cargo_edital.setAttributeNode(nvagas);
// -------------------------------------------------------------------------------------------------------------------------------
            Element cargo = d.createElement("cargo");
            cargo_edital.appendChild(cargo);

            Attr descricaoCargo = d.createAttribute("descricao");
            descricaoCargo.setValue("TESTE");
            cargo.setAttributeNode(descricaoCargo);

            Attr codigo = d.createAttribute("codigo");
            codigo.setValue("12345678");
            cargo.setAttributeNode(codigo);
// -------------------------------------------------------------------------------------------------------------------------------
            Element escolaridade = d.createElement("escolaridade");
            cargo_edital.appendChild(escolaridade);
            
            Attr idEscolaridade = d.createAttribute("id");
            idEscolaridade.setValue("5");
            escolaridade.setAttributeNode(idEscolaridade);
// -------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------------------------------------
            Element inscritos = d.createElement("inscritos");
            cargo_edital.appendChild(inscritos);

            Map<String, Integer> indexMap = new HashMap<String, Integer>();
            indexMap = generatorService.getIndexColunas();

            while (linhaIterator.hasNext()){
                Row linha = linhaIterator.next();
                Iterator<Cell> celulIterator = linha.cellIterator();

                
                if(numLinha > 0){
                Element inscrito = d.createElement("inscrito");
                inscritos.appendChild(inscrito);
                    while(celulIterator.hasNext()) {
                        Cell celula = celulIterator.next();
                        
                        if (celula.getColumnIndex() == indexMap.get("Inscrição")){       
                            Attr ninscrito = d.createAttribute("ninscricao");
                            ninscrito.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(ninscrito);
                        }
                        if (celula.getColumnIndex() == indexMap.get("CPF")){
                            Attr cpf = d.createAttribute("cpf");
                            cpf.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(cpf);
                        }
                        if (celula.getColumnIndex() == indexMap.get("Nome")){
                            Attr nome = d.createAttribute("nome");
                            nome.setValue(celula.getStringCellValue());
                            inscrito.setAttributeNode(nome);
                        }
                        Attr homologado = d.createAttribute("homologado");
                        homologado.setValue("N");
                        inscrito.setAttributeNode(homologado);

                        Attr deferido = d.createAttribute("deferido");
                        deferido.setValue("N");
                        inscrito.setAttributeNode(deferido);

                        Attr aprovado = d.createAttribute("aprovado");
                        aprovado.setValue("N");
                        inscrito.setAttributeNode(aprovado);

                        Attr admitido_inscrito = d.createAttribute("admitido_inscrito");
                        admitido_inscrito.setValue("N");
                        inscrito.setAttributeNode(admitido_inscrito);
                        
                        Attr classificacao = d.createAttribute("classificacao");
                        classificacao.setValue(numLinha+"");
                        inscrito.setAttributeNode(classificacao);
                        
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
