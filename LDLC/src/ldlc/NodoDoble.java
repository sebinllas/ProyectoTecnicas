/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldlc;

/**
 *
 * @author Sebastián
 */
public class NodoDoble {
    private Object dato;
    private NodoDoble ligaIzquierda;
    private NodoDoble ligaDerecha;
    
    NodoDoble(){
    }
    
    NodoDoble(Object dato){
        this.dato=dato;
        ligaIzquierda = null;
        ligaDerecha = null;
    }
    
    public Object retornaDato(){
        return dato;
    }
    
    public NodoDoble retornaLI(){
        return ligaIzquierda;
    }
    
    public NodoDoble retornaLD(){
        return ligaDerecha;
    }
    
    public void asignaDato(Object d){
        dato = d;
    }
    
    public void asignaLI(NodoDoble x){
        ligaIzquierda = x;
    }
    
    public void asignaLD(NodoDoble x){
        ligaDerecha = x;
    }
    
}