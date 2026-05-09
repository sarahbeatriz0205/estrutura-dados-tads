package exercicios.trabalho_sequencia.implementacao_duplamente_ligada;

public class SequenciaDuplamenteLigada implements ISequencia{
    private No head;
    private No tail;
    private int size;

    public SequenciaDuplamenteLigada(){
        this.head = new No(null);
        this.tail = new No(null);
        this.head.setProximo(tail);
        this.tail.setAnterior(head);
        this.size = 0;
    }

    // Métodos "ponte"
    public No atRank(int rank) throws SequenciaExcecao{
        if (rank < 0 || rank >= size()){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        No aux;
        if (rank <= size()/2){
            aux = this.head.getProximo();
            for (int i=0; i < rank; i++){
                aux = aux.getProximo();
            }
        }
        else{
            aux = this.tail.getAnterior();
            for (int i=0; i < size()-rank-1; i++){
                aux = aux.getAnterior();
            }
        }
        return aux;
    }

    public int rankOf(No no) throws SequenciaExcecao{
        if (no == null || no == head || no == tail) {
            throw new SequenciaExcecao("Exceção! Nó inválido ou sentinela");
        }
        No n =  this.head.getProximo();
        int r = 0;
        while (n != no && n != this.tail){
            n = n.getProximo();
            r++;
        }
        return r;
    }

    // Métodos de vetor
    public Object elemAtRank(int r) throws SequenciaExcecao{
        No aux = this.head.getProximo();
        if (r < 0 || r >= size()){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        return aux.getElemento();
    }

    public Object removeAtRank(int r) throws SequenciaExcecao{
        if (r < 0 || r >= size()){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        if (isEmpty()){
            throw new SequenciaExcecao("Erro! Vetor vazio");
        }
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        if (aux.getAnterior() != null){
            aux.getAnterior().setProximo(aux.getProximo());
        }
        else{
            this.head = aux.getProximo();
        }
        if (aux.getProximo() != null){
            aux.getProximo().setAnterior(aux.getAnterior());
        }
        else{
            this.tail = aux.getAnterior();
        } 
        this.size--;
        return element;  
    }

    public Object replaceAtRank(int r, Object o) throws SequenciaExcecao{
        if (r > size()){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        aux.setElemento(o);
        return element;
    }

    public void insertAtRank(int r, Object o) throws SequenciaExcecao{
        if (r > size()){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        else{
            No novo = new No(o);
            if (this.size == 0) {
                this.head = novo;
                this.tail = novo;
            } 
            else if (r == 0) {
                novo.setProximo(this.head);
                this.head.setAnterior(novo);
                this.head = novo;
            }
            else if (r == this.size){
                No ultimo = this.tail; 
                ultimo.setProximo(novo);
                novo.setAnterior(ultimo);
                tail = novo;
            }
            else{
                No aux = this.head;
                No anterior;
                for (int i=0; i < r; ++i){
                    aux = aux.getProximo();
                }
                anterior = aux.getAnterior();
                novo.setProximo(aux);
                novo.setAnterior(anterior);
                aux.setAnterior(novo);
                anterior.setProximo(novo);
            } 
        }
        this.size++;
    }


    // Métodos de lista
    public Object first() throws SequenciaExcecao{
        if (isEmpty()){
            throw new SequenciaExcecao("Erro! Lista vazia");
        }
        else{
            return this.head.getProximo().getElemento();
        }
    }

    public Object last() throws SequenciaExcecao{
        if (isEmpty()){
            throw new SequenciaExcecao("Erro! Lista vazia");
        }
        else{
            return this.tail.getAnterior().getElemento();
        }
    }

    public Object before(No p) throws SequenciaExcecao{
        if (p == null){
            throw new SequenciaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.head){
            throw new SequenciaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getAnterior();
            return elemento.getElemento();
        }
    }

    public Object after(No p){
        if (p == null){
            throw new SequenciaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.tail){
            throw new SequenciaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getProximo();
            return elemento.getElemento();
        }
    }

    public Object replaceElement(No n, Object o) throws SequenciaExcecao{
        Object element = n.getElemento();
        if (n == null){
            throw new SequenciaExcecao("Exceção! Nó não existe");
        }
        else if (n == this.head){
            this.head.setElemento(o);
        }
        else{
            n.setElemento(o);
        }
        return element;
    }

    public void swapElements(No n, No q){
        if (n == null || q == null){
            throw new SequenciaExcecao("Exceção! Nós não existem");
        }
        else{
           Object aux = n.getElemento();
           n.setElemento(q.getElemento());
           q.setElemento(aux);
        }
    }

    public No insertAfter(No n, Object o){
        No q = new No(o);
        q.setAnterior(n);
        q.setProximo(n.getProximo());
        if (n.getProximo() != null) {
            n.getProximo().setAnterior(q);
        }
        this.size++;
        return q;
    } 

    public No insertBefore(No n, Object o){
        No q = new No(o);
        q.setProximo(n);
        q.setAnterior(n.getAnterior());
        if (n.getAnterior() != null) {
            n.getAnterior().setProximo(q);
        }
        this.size++;
        return q;
    }

    public No insertFirst(Object o){
        No novo = new No(o);
        No proximo = this.head.getProximo();
        novo.setAnterior(this.head);
        novo.setProximo(proximo);
        this.head.setProximo(novo);
        if (this.head.getProximo() != null){
            this.head.getProximo().setAnterior(novo);
        }
        this.size++;
        return novo;
    }

    public No insertLast(Object o){
        No novo = new No(o);
        No anterior =  this.tail.getAnterior();
        novo.setProximo(this.tail);
        novo.setAnterior(anterior);
        this.tail.setAnterior(novo);
        if (anterior != null){
            this.tail.getAnterior().setProximo(novo);
        }
        this.size++;
        return novo;
    }

    public Object remove(No n){
        Object removido = n.getElemento();
        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getAnterior());
        this.size--;
        return removido;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }
}