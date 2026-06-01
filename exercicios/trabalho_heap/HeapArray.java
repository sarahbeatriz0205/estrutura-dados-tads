public class HeapArray{
    private Object o[];
    private int tamanho;

    public HeapArray(int tamanho){
        this.tamanho = tamanho;
        o = new Object[tamanho];
    }

    public void upheap(){
        int n = this.tamanho;
        int p = this.tamanho/2;
        
        while (o[n] < o[p]){
            int novo = o[tamanho];
            o[n] = o[p];
            o[p] = novo;
            n = p;
            p = p/2;
        }
    }

    public void insert(Object k){
        this.tamanho++;
        o[tamanho] = k;
        upheap();
    }

    public void downheap(){
        int filhoEsquerdo = this.tamanho*2;
        int filhoDireito = (this.tamanho*2)+1
        int atual = 1;


    }

    public Object removeMin(){
        Object elemento = o[1];
        o[1] = o[this.tamanho--];
        this.tamanho--;
        downheap();
        return elemento;
    }
}