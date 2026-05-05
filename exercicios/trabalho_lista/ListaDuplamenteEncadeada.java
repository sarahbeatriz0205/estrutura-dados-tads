package exercicios.trabalho_lista;

public class ListaDuplamenteEncadeada implements ILista{
    private No head;
    private No tail;
    private int size;

    public ListaDuplamenteEncadeada(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isFirst(No n){
        if (n.getAnterior() == null){
            return true;
        }
        return false;
    }

    public boolean isLast(No n){
        if (n.getProximo() == null){
            return true;
        }
        return false;
    }

    public Object first() throws ListaExcecao{
        if (isEmpty()){
            throw new ListaExcecao("Erro! Lista vazia")
        }
        else{
            aux = this.head;
            return aux.getElemento();
        }
    }

    public Object last(){
        if (isEmpty()){
            throw new ListaExcecao("Erro! Lista vazia")
        }
        else{
            aux = this.tail;
            return aux.getElemento();
        }
    }

    public Object before(No p) throws ListaExcecao{
        if (p == null){
            throw new ListaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.head){
            throw new ListaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getAnterior();
            return elemento.getElemento();
        }
    }

    public Object after(No p){
        if (p == null){
            throw new ListaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.tail){
            throw new ListaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getProximo();
            return elemento.getElemento();
        }
    }
}