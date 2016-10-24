package br.com.alterando;

import java.io.File;

import javax.swing.JFileChooser;

public class Pasta {

		
	public static String abrirPasta(String extensao[], String descricao) {
        String path = "";
        JFileChooser fc = new JFileChooser();
        // restringe a amostra a diretorios apenas
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File diretorio = fc.getSelectedFile();
            path = diretorio.getAbsolutePath();
        } else {
            return null;
        }
        
        return path;
        
    }
	
}
