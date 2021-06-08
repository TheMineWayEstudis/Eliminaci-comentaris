/*
    Joel Campos Oliva
*/

package eliminaciocomentaris;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EliminacioComentaris {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("Factorial.java");
        BufferedReader br = new BufferedReader(fr);
        String file = "";
        String codi = ""; //Programa sense comentaris
        String comentaris = ""; //Comentaris del programa
        
        do {
            String line = br.readLine();
            if(line == null) break;
            file += "\n" + line;
        } while(true);
        boolean cMulti = false;
        int comptarComentaris = 0;
        int margin = 0;
        for(int i = 0; i < file.length(); i++) {
            int next = i + 1;
            char nChar = ' ';
            if(i + 1 < file.length()) nChar = file.charAt(i + 1);
            
            char current = file.charAt(i);
            if((current == '/' && nChar == '*')) {
                cMulti = true;
                comptarComentaris++;
            }
            if(current == '*' && nChar == '/') {
                cMulti = false;
                comentaris += "\n";
                margin = 2;
            }
            
            if(cMulti || margin > 0) comentaris += current;
            else {
                codi += current;
            }
            margin--;
        }
        String oldCodi = codi;
        codi = "";
        for(String line: oldCodi.split("\n")) {
            if(line.contains("//")) {
                comentaris += "\n" + line;
                comptarComentaris++;
            }
            else codi += "\n" + line;
        }    
        
        fr.close();
        br.close();
        codi = codi.replace("\n", System.getProperty("line.separator"));
        comentaris = comentaris.replace("\n", System.getProperty("line.separator")).replace("\t", "");
        FileWriter fw = new FileWriter("codi.java");
        fw.write(codi);
        fw.close();
        fw = new FileWriter("comentaris.txt");
        fw.write(comentaris);
        fw.close();
        System.out.println("S'han creat els fitxers \"codi.java\" i \"comentaris.txt\"");
        System.out.println("En total hi han " + comptarComentaris + ".");
    }
}

/* Bocata de jamó i quess per merendar Oriol */