package model.listaint;

public class ListaEncadeada {
    No first;

    public ListaEncadeada() {
        first = null;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int cont = 0;
        if (!isEmpty()) {
            No aux = first;
            while (aux != null) {
                cont++;
                aux = aux.proximo;
            }
        }
        return cont;
    }

    private No getNo(int position) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int size = size();
        if (position < 0 || position > size - 1) {
            throw new Exception("Posição Invalida");
        }
        No aux = first;
        int cont = 0;
        while (cont < position) {
            aux = aux.proximo;
            cont++;
        }
        return aux;
    }

    public void addFirst(int value) {
        No elemento = new No();
        elemento.dado = value;
        elemento.proximo = first;
        first = elemento;
    }

    public void addLast(int value) throws Exception {
        int size = size();
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        No elemento = new No();
        elemento.dado = value;
        elemento.proximo = null;
        No last = getNo(size - 1);
        last.proximo = elemento;

    }

    public void add(int value, int position) throws Exception {
        int size = size();
        if (position < 0 || position > size) {
            throw new Exception("Posição invalida");
        }
        if (position == 0) {
            addFirst(value);
        }else if (position == size) {
            addLast(value);
        } else {
            No elemento = new No();
            elemento.dado = value;
            No previous = getNo(position - 1);
            elemento.proximo = previous.proximo;
            previous.proximo = elemento;
        }

    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        first = first.proximo;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int size = size();
        if (size == 1) {
            removeFirst();
        } else {
            No penultimo = getNo(size - 2);
            penultimo.proximo = null;
        }

    }

    public void remove(int position) throws Exception {
        int size = size();
        if (position < 0 || position > size - 1) {
            throw new Exception("Posição Invalida");
        }
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            No previous = getNo(position - 1);
            No atual = getNo(position);
            previous.proximo = atual.proximo;
        }

    }

    public int get(int position) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int size = size();
        if (position < 0 || position > size - 1) {
            throw new Exception("Posição Invalida");
        }
        int cont = 0;
        No aux = first;

        while (cont < position) {
            aux = aux.proximo;
            cont++;
        }
        return aux.dado;

    }

}
