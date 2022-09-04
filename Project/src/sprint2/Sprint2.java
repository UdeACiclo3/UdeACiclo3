/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sprint2;

import Empresa.Empresa;

/**
 *
 * @author nancy
 */
public class Sprint2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa empresa1 = new Empresa("SIGMI", "CRA 27 14 - 61", "486595", "25252652");
        
        System.out.println("El nombre de la empresa es "+empresa1.getNombreempresa());
        
        empresa1.setNombreempresa("UTEMPO");
        
        System.out.println("El nuevo nombre es :"+empresa1.getNombreempresa());
    }
    
}
