package exercicios.fila_simplesmente_encadeada;

public class FilaArrayReverse{
    private int i;
    private int f;
    private int tamanho;
    private int incremento; // crescimento
    private Object o[];

    public FilaArrayReverse(int tamanho, int incremento){
        o = new Object[tamanho];
        this.tamanho = tamanho;
        this.incremento = incremento;
    }

    public void enqueue(Object elemento){
        if (size() == N-1){ // se já estiver cheio
            int novoTamanho; // nova capacidade pro array
            if (incremento == 0){ novoTamanho = N*2; } // duplicação
            else{ novoTamanho = N+incremento; }
            Object[] b = new Object[novoTamanho]; // array novo com a incrementação
            int inicio_dois = i;
            for (int final_dois = 0; final_dois < size(); final_dois++){ // cópia pro novo array
                b[final_dois] = o[inicio_dois];
                inicio_dois = (inicio_dois+1)%N; // recalcula a rota pra o início voltar a ser o índice 0 no novo array
            }
            f  = size(); // novo final
            i = 0; // novo início
            N = novoTamanho; // atualizando o tamanho
            o = b; // lista original agora aponta pra a cópia; aqui a lista original ANTIGA é levada pelo garbage collector
        }
        o[f] = elemento; // insere o novo elemento
        f = (f+1)%N; // recalcula só o final depois de inserir o elemento
    }

    public Object dequeue(){
        if(isEmpty()){ throw new FilaVaziaExcecao("A Fila está vazia");}
        Object temp = o[i]; // cria uma cópia do elemento do início
        i = (i+1)%N; // avança o início pra remover o elemento que antes era o início
        return temp; // retorna o elemento removido
    }

    public int size(){
        return (N-i+f)%N;
    }

    public boolean isEmpty(){
        return f==i;
    }

    public Object first(){
        return o[i];
    }


}