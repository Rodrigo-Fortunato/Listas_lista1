package model.listagenerica;

public class ListaEncadeadaGenerica<T> {

    NoGeneric<T> first;
    public ListaEncadeadaGenerica() {
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
            NoGeneric<T> aux = first;
            while (aux != null) {
                cont++;
                aux = aux.proximo;
            }
        }
        return cont;
    }

    private NoGeneric<T> getNo(int position) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int size = size();
        if (position < 0 || position > size - 1) {
            throw new Exception("Posição Invalida");
        }
        NoGeneric<T> aux = first;
        int cont = 0;
        while (cont < position) {
            aux = aux.proximo;
            cont++;
        }
        return aux;
    }

    public void addFirst(T value) {
        NoGeneric<T> elemento = new NoGeneric<T>();
        elemento.dado = value;
        elemento.proximo = first;
        first = elemento;
    }

    public void addLast(T value) throws Exception {
        int size = size();
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        NoGeneric<T> elemento = new NoGeneric<T>();
        elemento.dado = value;
        elemento.proximo = null;
        NoGeneric<T> last = getNo(size - 1);
        last.proximo = elemento;

    }

    public void add(T value, int position) throws Exception {
        int size = size();
        if (position < 0 || position > size) {
            throw new Exception("Posição invalida");
        }
        if (position == 0) {
            addFirst(value);
        }
        if (position == size) {
            addLast(value);
        } else {
            NoGeneric<T> elemento = new NoGeneric<T>();
            elemento.dado = value;
            NoGeneric<T> previous = getNo(position - 1);
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
            NoGeneric<T> penultimo = getNo(size-2);
            penultimo.proximo = null;
        }

    }

    public void remove(int position) throws Exception {
        int size = size();
        if (position < 0 || position > size-1){
            throw new Exception("Posição Invalida");
        }
        if (isEmpty()){
            throw new Exception("Lista Vazia");
        }
        if (position == 0){
            removeFirst();
        }
        if (position == size -1){
            removeLast();
        }else {
            NoGeneric<T> previous = getNo(position-1);
            NoGeneric<T> atual = getNo(position);
            previous.proximo = atual.proximo;
        }

    }

    public T get(int position) throws Exception {
        if (isEmpty()){
            throw new Exception("Lista Vazia");
        }
        int size = size();
        if (position< 0 || position >size-1){
            throw new Exception("Posição Invalida");
        }
        int cont =0;
        NoGeneric<T> aux = first;

        while (cont < position){
            aux = aux.proximo;
            cont++;
        }
        return aux.dado;

    }

}
