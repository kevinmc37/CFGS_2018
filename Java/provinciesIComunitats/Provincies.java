package provinciesIComunitats;

import java.util.LinkedHashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest-pnm2m4
 */
public class Provincies {
    private LinkedHashSet<Provincia> provincies;//estem fent un hash de les provincies
    
    /*Crea im mpi LinkedHashSet de provincies i carrega amb
    les dades de la col·lecció que es passa per paràmetre 
    l'objecte provincies
    
    @param col Collecció amb el llistat de totes les
    provincies
    @return El nombre de provincies carregades, 0 si no s0ha pogut carregar*/
    
    public int carregarProvincies(java.util.Collection<Provincia> col){
       int iret = 0;
       if (col != null){
           /*Realment ens han passat alguna cosa, per tant
            Inicialitzem l'objecte provincies*/
           provincies= new LinkedHashSet(col);//inicialitzem i carreguem el linkedhashset
           iret = provincies.size();
       }
        return iret;
    }
    /*
    que rebra per parametre el codi duna Comunitat Autonoma i tornara el linkedhashset amb totes
    les provincies que es corresponguin a aquesta comunitat.
    (er exemple, provinciesComuunitat(1) hauria de retornar les 8 provincies de la comunitat auotonoma d'Andalusia)
    codiCA: codi fe la comunitat autonoma a filtrar
    */
    public LinkedHashSet<Provincia> provinciesPerComunitat(int codiCA){
        LinkedHashSet<Provincia> provinciesFiltre=null;
        //aqui hem demplenar la col·leccio filtrada amb les dades de les nostres provincies
        
        if(provincies!=null){
            provinciesFiltre = new LinkedHashSet();//si es ==null, no m'han fet la carrega
            /*Recorrerem totes les provincies i, quan trobi alguna amb el codi de comunitat autonoma de la qual coincideixi amb la CA que
            estic filtrant, la carregare a l'objecte provinciesFiltre*/
            for(Provincia prov : provincies){
                if(prov.getCodiCA()==codiCA){
                    provinciesFiltre.add(prov);
                }
            }
        }
        
        return provinciesFiltre;
    }
    
    public static LinkedHashSet<Provincia> unioProvincies(LinkedHashSet<Provincia> lhs1, LinkedHashSet<Provincia> lhs2) {
        LinkedHashSet<Provincia> unio = null;
        unio = new LinkedHashSet(lhs1); /* Necessitem dir-ho perquè en cas contrari modificariem les col·leccions que passem per parèmetre ja que són
        objectes i aquests es passen per referència. Qualsevol modificació afectaria a l'objecte inicial i això no ens interessa.
        Si lsh1 són les províncies de Catalunya i lsh2 són les de Madrid, lsh1.addAll(lsh2) anexionaria Madrid a Catalunya i tornarien totes les empreses. */
        unio.addAll(lhs2);
        return unio;
    }
    
    public static LinkedHashSet<Provincia> interseccioProvincies(LinkedHashSet<Provincia> lhs1, LinkedHashSet<Provincia> lhs2) {
        LinkedHashSet<Provincia> interseccio = null;
        interseccio = new LinkedHashSet(lhs1);
        interseccio.retainAll(lhs2);
        return interseccio;
    }
    
    public static LinkedHashSet<Provincia> diferenciaSimetricaProvincies(LinkedHashSet<Provincia> lhs1, LinkedHashSet<Provincia> lhs2) {
        LinkedHashSet<Provincia> diferencia = null;
        diferencia = new LinkedHashSet(lhs1);
        diferencia.addAll(lhs2);
        diferencia.removeAll(Provincies.interseccioProvincies(lhs1, lhs2));
        return diferencia;
    }
    
}
