/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dialegs;

import java.awt.Component;
import java.io.File;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author malcoba
 */
public class gestioFitxers {
    
    public static String mostrarDialegSeleccio(Component c){
        String sRet="";
      /*  Locale oLoc = Locale.getDefault();
        //System.out.println("lang " +oLoc.getLanguage()+" country "+oLoc.getCountry());
        */
        JFileChooser.setDefaultLocale(new Locale("ES","ES",""));

        JFileChooser fc=new JFileChooser();
       
        fc.setMultiSelectionEnabled(false);//Permet agafar només un fitxer
        fc.setFileFilter( new TxtFilter());
        fc.setAcceptAllFileFilterUsed(true);
        
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      
//  fc.setApproveButtonText("Acceptar");
      //  fc.setDialogTitle("Seleccionar Fitxer");
        
        int resultat = fc.showOpenDialog(c);
        
        if (resultat==JFileChooser.APPROVE_OPTION){
            sRet=fc.getSelectedFile().getAbsolutePath();
        }
        return sRet;
        
    }
    
    
    public static String mostrarDialegGuardar(Component c){
        String sRet="";
      /*  Locale oLoc = Locale.getDefault();
        //System.out.println("lang " +oLoc.getLanguage()+" country "+oLoc.getCountry());
        */
        JFileChooser.setDefaultLocale(new Locale("ES","ES",""));

        JFileChooser fc=new JFileChooser();
       
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter( new TxtFilter());
        fc.setAcceptAllFileFilterUsed(true);
        
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      
//  fc.setApproveButtonText("Acceptar");
      //  fc.setDialogTitle("Seleccionar Fitxer");
        
        int resultat = fc.showSaveDialog(c);
        if (resultat==JFileChooser.APPROVE_OPTION) {
            sRet=fc.getSelectedFile().getAbsolutePath();
        }
        return sRet;
    }
}

class TxtFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.getName().endsWith(".txt")||f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Fitxers de Text (*.txt)";
    }
}