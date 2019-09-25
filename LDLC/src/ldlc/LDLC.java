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
public class LDLC extends NodoDoble {
    //lista doblemente ligada circular

    private NodoDoble primero;
    private NodoDoble ultimo;

    LDLC() {
        primero = null;
        ultimo = null;

    }

    public boolean esVacia() {
        return primero == null;
    }

    public NodoDoble primerNodo() {
        return primero;
    }

    public NodoDoble ultimoNodo() {
        return ultimo;
    }

    public boolean finDeRecorrido(NodoDoble p) {

        return p == ultimo;
    }

    public void MostrarLista() {//de derecha a izquierda
        NodoDoble p;
        p = primerNodo();
        do {
            System.out.println(p.retornaDato());
            p.retornaLD();
        } while (!finDeRecorrido(p));
    }

    public NodoDoble anterior(NodoDoble p) {
        return p.retornaLI();
    }

    public NodoDoble buscarDondeInsertar(Object d) {
        NodoDoble p;
        NodoDoble y;
        p = primerNodo();
        y = null;
        int b = (int) d;
        int a = (int) p.retornaDato();
        if (b < a) {
            return y;
        }
        y = p;
        p = p.retornaLD();
        while ((!finDeRecorrido(p)) && (a < b)) {
            y = p;
            p = p.retornaLD();
        }
        return y;
    }

    public void insertar(Object d, boolean confirmar) {
        NodoDoble x = new NodoDoble();
        x.asignaDato(d);
        NodoDoble h;
        h = buscarDondeInsertar(d);
        if (confirmar) {
            conectarAntes(x, h);
        } else {
            conectarDespues(x, h);
        }
    }

    /*public void conectar(NodoDoble x, NodoDoble y){
        int sw = 0;
        x.asignaLD(y.retornaLD());
        x.asignaLI(y);
        y.asignaLD(x);
        x.retornaLD().asignaLI(x); 
        if (y == ultimo){//inserta al final de la lista
            sw = 2;
            x= ultimo;
        }
        if (y == null){//incerta al inicio de la lista
            sw = 1;
            y = primero;
        }
    }*/
    // conectar x antes de y
    public void conectarAntes(NodoDoble x, NodoDoble y) {
        if (y == primero) {//inserta al inicio de la lista
            x = primero;
            ultimo.asignaLD(x);
            x.asignaLI(ultimo);
            x.asignaLD(y);
            y.asignaLI(x);
        } else {
            x.asignaLD(y);
            x.asignaLI(y.retornaLI());
            y.retornaLI().asignaLD(x);
            y.asignaLI(x);
        }
    }

    //conectar x depués de y
    public void conectarDespues(NodoDoble x, NodoDoble y) {
        if (y == ultimo) {//inserta al final de la lista
            x = ultimo;
            primero.asignaLI(x);
            x.asignaLD(primero);
            x.asignaLI(y);
            y.asignaLD(x);
        } else {
            x.asignaLI(y);
            x.asignaLD(y.retornaLD());
            y.retornaLD().asignaLI(x);
            y.asignaLD(x);
        }
    }

    public NodoDoble buscarDato(Object d) {
        NodoDoble p;
        p = primerNodo();
        while (!finDeRecorrido(p) && p.retornaDato() != d) {
            p = p.retornaLD();
        }
        if (p.retornaDato() == d) {//si fue encontrado el dato
            return p;//retorna el nodo donde esta el dato
        }
        System.out.println("El dato requerido no está en la lista");
        return null;//no fue encontrado
    }

    public void borrar(NodoDoble x) {//borrar nodo
        if (x == null) {
            System.out.println("El dato no se encuentra en la lista.");
        } else {
            desconectar(x);
        }
    }

    public void desconectar(NodoDoble x) {
        if (x == primero) {//nodo a desconectar es el primero
            primero = x.retornaLD();
            if (primero != null) {
                x.retornaLI().asignaLD(primero);
                primero.asignaLI((x.retornaLI()));
            } else {//no entiendo
                ultimo = null;
            }
        }

        if (x == ultimo) {//nodo a desconectar es el ultimo
            ultimo = x.retornaLI();
            x.retornaLD().asignaLI(ultimo);
            ultimo.asignaLD(x.retornaLD());

        } else {           //nodo a desconectar een el intermedio
            x.retornaLI().asignaLD(x.retornaLD());
            x.retornaLD().asignaLI(x.retornaLI());
        }
    }

    /*esVacia()x,
primerNodo()*,
ultimoNodo()*,
finDeRecorrido(nodoDoble p)*,
mostrarLista()*,
anterior(nodoDoble p)*,
buscaDondeInsertar(char d)*,
insertar(char d, nodoDoble y),*
conctar*
buscarDato(char d, nodoDoble y)*,
borrar(nodoDoble x, nodoDoble y)*
desconectar(nodoDoble x, nodoDoble y)*
    
conectarAntes(nodoDoble x, nodoDoble y),
conectarDespues(nodoDoble x, nodoDoble y),

,
ordenarDescendentemente(),
intercambiarConsecutivos(),
eliminarLista()
actualizarLista()  */
}
