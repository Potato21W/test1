/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package antarticagui;
import java.io.*;
import java.util.Map;

/**
 *
 * @author matthew
 */
public class AntarticaGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
    	Main.checkMap();
    	
    	for (Map.Entry<String, Integer> entry : Main.userLookup.entrySet()) {
    	    System.out.println(entry.getKey() + "/" + entry.getValue());
    	}
        new Login();
    }
    
}
