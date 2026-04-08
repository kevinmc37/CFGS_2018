/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author guest-5cc28z
 */
public class Nif {
    private int numero;
    private String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    public int getNumeroDni() {
        return numero;
    }
    
    public String getNif() {
        String dni = "";
	   char lletra = calcularLletraNif(numero);
        dni += numero + lletra;
        return dni;
    }
    
    public void setNumeroDni(int numero) {
        if (validarDni(numero)) { this.numero = numero; };
    }
    
    public void setNif(String dni) {
        if (validarNif(dni)) {
            this.numero = extreureNumeroNif(dni);
        }
    }
    
    public boolean validarDni(int numero) {
        if (numero >= 1 && numero <= 99999999) {
            return true;
        }
        return false;
    }
    
    private char calcularLletraNif(int numero) {
        char lletra = '0';
        if (validarDni(numero)) { lletra = this.lletres.charAt(numero%23); }
        return lletra;
    }
    
    private char extreureLletraNif(String dni) {
        char lletra = '0';
        if (Character.isLetter(dni.charAt(dni.length()-1))) {
            lletra = dni.charAt(dni.length()-1);
        }
        return lletra;
    }
    
    private int extreureNumeroNif(String dni) {
        String numeros = dni.substring(dni.charAt(dni.length()-1));
        boolean validar = true;
        int compt = 0;
        while ((compt < numeros.length()) && (validar == true)) {
            if (!(Character.isDigit(numeros.charAt(compt)))) { validar = false; }
            compt++;
        }
        if (validar == true) { return Integer.parseInt(numeros); }
        return 0;
    }
    
    public boolean validarNif(String dni) {
        char lletra = extreureLletraNif(dni);
        int numero = extreureNumeroNif(dni);
        char lletraValida = calcularLletraNif(numero);
        if (lletra == lletraValida) { return true; }
        return false;
    }
    
    Nif() {
        this.numero = 0;
    }
    
    Nif(int numero) {
        this.numero = numero;
    }
    
    Nif(String dni) {
        this.numero = extreureNumeroNif(dni);
    }
    
}