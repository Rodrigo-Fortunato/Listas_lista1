package view;

import controller.InverterLista;
import model.listaint.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        try {
            lista.add(3, 0);
            lista.add(5, 1);
            lista.add(18, 2);
            lista.add(12, 3);
            lista.add(9, 4);
            lista.add(7, 5);
            lista.add(6, 6);
            lista.add(2, 7);
            lista.add(13, 8);
            lista.add(4, 9);
            lista.add(16, 10);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        InverterLista inverterLista = new InverterLista(lista);

        try {
            inverterLista.inverter(lista.size()-1,0);
            for (int cont =0;cont < lista.size();cont++ ) {
                System.out.println(lista.get(cont));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
