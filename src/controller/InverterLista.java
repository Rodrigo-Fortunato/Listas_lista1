package controller;

import model.listaint.ListaEncadeada;

public class InverterLista {
    ListaEncadeada lista ;

    public InverterLista(ListaEncadeada lista) {

        this.lista = lista;


    }

    public void inverter(int size, int cont) throws Exception {

        if (cont < size){
            inverter(size,cont+1);
            lista.addLast(lista.get(cont));
            lista.remove(cont);
        }


    }

}
