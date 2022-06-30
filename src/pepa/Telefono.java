/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

/**
 *
 * @author gabriel
 */
public class Telefono{
    int ID;
    String Tipo;
    int Copas;
    int[] mazo = new int[8];
    
    
    public Telefono(int id,int copas,String tipo,int[] mazo){
        this.ID=id;
        this.Tipo=tipo;
        this.Copas=copas;
        this.mazo=mazo;
    }
        
}
