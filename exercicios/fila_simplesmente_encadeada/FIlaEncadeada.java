package exercicios.fila_simplesmente_encadeada;

public class FilaEncadeada{
    public FilaEncadeada(){
        private No i;
        private No f;
    }

    public void enqueue(Object o){
        if (i == null){
            this.i = o;
            this.f = o;
        }
        else{
            if (f != null){
                No novo = new No(o);
                f.setProximo(novo);
                f = novo;
            }
        }
    }

    public Object dequeue() throws FilaEncadeadaVaziaExececao{
        if (isEmpty()){
            throw new FilaEncadeadaVaziaExcecao("A fila está vazia");
        }
        else{
            Object antigo = this.i;
            this.i = i.setProximo();
            this.f = f.setProximo();
            return antigo;
        }
    }

    public int size(){
        
    }

    public isEmpty(){
        return this.i == null && this.f == null;
    }

    public int first(){
        return this.i;
    }
}