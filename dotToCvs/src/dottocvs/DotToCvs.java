/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dottocvs;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author lukas
 */
public class DotToCvs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File inputFile = new File("uloha.dot");
        DotParser parser = new DotParser(inputFile);
        parser.parse();
        DataHolder dh = parser.getData();
        System.out.println("----------");
        CvsExport cvse = new CvsExport(dh);
        cvse.export();
    }
    
}
