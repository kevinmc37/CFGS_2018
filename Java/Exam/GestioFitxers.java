/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercici1;

import java.awt.Component;
import java.io.File;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Classe que poseeix les utilitats necessàries per llegir i guardar fitxer
 * i mostrar els diàlegs de selecció de fitxer de lectura i escriptura
 * @author malcoba
 */
public class GestioFitxers {

    /**
     * Mostra un diàleg per seleccionar la ruta de l'arxiu a llegir
     * @param c {@link Component} Finestra pare del formulari
     * @return {@link String} Ruta de l'arxiu seleccionat per llegir
     */
    public static String mostrarDialegSeleccio(Component c){
        return mostrarDialegSeleccio(c,"");
    }

    
    /**
     * Mostra un diàleg per seleccionar la ruta de l'arxiu a llegir
     * @param c {@link Component} Finestra pare del formulari
     * @param carpetaDefecte {@link String} Ruta de la carpeta per defecte
     * @return {@link String} Ruta de l'arxiu seleccionat per llegir
     */
    public static String mostrarDialegSeleccio(Component c, String carpetaDefecte){
        String sRet="";
        JFileChooser.setDefaultLocale(new Locale("ES","ES",""));

        JFileChooser fc=new JFileChooser();
       
        fc.setMultiSelectionEnabled(false);//Permet agafar només un fitxer
        fc.setFileFilter( new TxtFilter());
        if (carpetaDefecte==null || carpetaDefecte.length()>0) fc.setCurrentDirectory(new File(carpetaDefecte));
        fc.setAcceptAllFileFilterUsed(true);
        
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      
        int resultat = fc.showOpenDialog(c);
        
        if (resultat==JFileChooser.APPROVE_OPTION){
            sRet=fc.getSelectedFile().getAbsolutePath();
        }
        return sRet;
        
    }
    
    /**
     * Mostra un diàleg per seleccionar la ruta de l'arxiu a guardar
     * @param c {@link Component} Finestra pare del formulari
     * @return {@link String} Ruta de l'arxiu seleccionat per guardar
     */
    public static String mostrarDialegGuardar(Component c){
        return mostrarDialegGuardar(c,"");
    }
    
    /**
     * Mostra un diàleg per seleccionar la ruta de l'arxiu a guardar
     * @param c {@link Component} Finestra pare del formulari
     * @param carpetaDefecte {@link String} Ruta de la carpeta per defecte
     * @return {@link String} Ruta de l'arxiu seleccionat per guardar
     */
    public static String mostrarDialegGuardar(Component c , String carpetaDefecte){
        String sRet="";
      /*  Locale oLoc = Locale.getDefault();
        //System.out.println("lang " +oLoc.getLanguage()+" country "+oLoc.getCountry());
        */
        JFileChooser.setDefaultLocale(new Locale("ES","ES",""));

        JFileChooser fc=new JFileChooser();
       
        fc.setMultiSelectionEnabled(false); //Només permetem guardar un fitxer
        fc.setFileFilter( new TxtFilter());  //Fem que per defecte es guardin .txt

        fc.setAcceptAllFileFilterUsed(true);
        
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY); //Només permetem fitxers
        if (carpetaDefecte!=null || carpetaDefecte.length()>0) fc.setCurrentDirectory(new File(carpetaDefecte));
        //afegim el directori per defecte a mostrar
        
        int resultat = fc.showSaveDialog(c); //mostrem el diàleg
        
        if (resultat==JFileChooser.APPROVE_OPTION){  //Si han acceptat
            sRet=fc.getSelectedFile().getAbsolutePath();  // Agafem la ruta que hem seleccionat
        }
        return sRet;
    }
        
    /**
     * Llegeix el fitxer que es troba a la ruta que es passa per paràmetre - en cas que no
     * existeixi o no fos un fitxer, la funció retornarà null. Bolca totes les dades del fitxer a l'arrayList que es passa
     * per paràmetre. Cada línia del fitxer s'escriu un element a l'arrayList.
     * @param ruta {@link String} Ruta sencera en què es buscarà l'arxiu
     * @return {@link java.util.ArrayList} Llista amb les files que s'han llegit al fitxer.
     * 
     * Es fa servir un ArrayList perquè permet afegir les dades fàcilment, conserva l'ordre d'introducció
     * de les dades i permet recòrrer fàcilment l'estructura a l'hora de bolcar les dades al fitxer.
     */
    public static java.util.ArrayList<String> llegirFitxer(String ruta){
        
        java.util.ArrayList<String> arl =null;

        /*TODO: Introdueix el codi necesssari aquí per llegir el fitxer i carregar 
        l'ArrayList amb les línies del fitxer que hem passat per paràmetre*/
        
        return arl;
    }
    
    /**
     *Genera un fitxer a la ruta que es passa per paràmetre - en cas que existeixi
     * l'elimina i en crea un de nou. Bolca totes les dades de l'arrayList que es passa
     * per paràmetre. Cada element de l'arrayList s'escriu en una línia diferent del fitxer.
     * @param ruta {@link String} Ruta sencera en què es guardarà l'arxiu
     * @param dades {@link java.util.ArrayList} Llista amb les files a carregar en el fitxer.
     * 
     * Es fa servir un ArrayList perquè permet afegir les dades fàcilment, conserva l'ordre d'introducció
     * de les dades i permet recòrrer fàcilment l'estructura a l'hora de bolcar les dades al fitxer.
     */
    public static void bolcarDadesFitxer(String ruta,java.util.ArrayList<String> dades ){

        /*TODO: Introdueix el codi necesssari aquí per bolcar cada línia de l'arraylist al
        fitxer que hem passat per paràmetre*/
        
    }
    
}

class TxtFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        return f.getName().endsWith(".txt")||f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Fitxers de Text (*.txt)";
    }
    
    
}



