package br.com.alterando;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Pasta janela = new Pasta();
		File arquivo = new File(janela.abrirPasta(null, "ESCOLHE A PASTA"));	
		String tagDoXML = JOptionPane.showInputDialog(null, "INSERIR QUAL TAG PARA PROCURA TAG");
		String valorDeSubstitui��oL = JOptionPane.showInputDialog(null, "INSERIR O VALOR DE SUBSTITUI��O");
		
		File[] file = arquivo.listFiles();
		
		Xml trocar = new Xml();
		for(int i = 0; i < file.length; i++){
			File fileAntigo = file[i];
			String valorNovo;
			if(tagDoXML.equals("nNF"))
				valorNovo = valorDeSubstitui��oL + i;
			else
				valorNovo = valorDeSubstitui��oL;	
			trocar.alterarXml(tagDoXML, valorNovo, fileAntigo);
		}
		
	}
	
	public static void copiarArquivos(Path origem, Path destino) throws IOException {
		  // se � um diret�rio, tentamos criar. se j� existir, n�o tem problema.
		  if(Files.isDirectory(origem)){
		    Files.createDirectories(destino);
		 
		    // listamos todas as entradas do diret�rio
		    DirectoryStream<Path> entradas = Files.newDirectoryStream(origem);
		 
		    for (Path entrada : entradas) {
		      // para cada entrada, achamos o arquivo equivalente dentro de cada arvore
		      Path novaOrigem = origem.resolve(entrada.getFileName());
		      Path novoDestino = destino.resolve(entrada.getFileName());
		 
		      // invoca o metodo de maneira recursiva
		      copiarArquivos(novaOrigem, novoDestino);
		    }
		  } else {
		    // copiamos o arquivo
		    Files.copy(origem, destino);
		  }
		}
	

}
