public class FilaArray{
    private int i;
    private int f;
    private int tamanho;
    private int incremento; // crescimento
    private Object o[];

    public FilaArray(int tamanho, int incremento){
        o = new Object[tamanho];
        this.tamanho = tamanho;
        this.incremento = incremento;
    }

    public boolean reverse(){
        if (isEmpty()){ 
            return false; 
        }
        else{ 
            this.i = this.f;
            this.f = 0;
            return true;
        }
    }

    public void enqueue(Object elemento){
        if (this.i > this.f && size() == this.tamanho-1){ 
            int novoTamanho; 
            if (incremento == 0){ novoTamanho = this.tamanho*2; }
            else{ novoTamanho = this.tamanho+incremento; }
            Object[] b = new Object[novoTamanho]; 
            int inicio_dois = this.i - 1; 
            for (int final_dois = 0; final_dois < size(); final_dois++){ 
                b[final_dois] = o[inicio_dois]; 
                inicio_dois--; // decrementando o índice do início pra copiar os elementos na ordem reversa
            }
            this.f  = size(); 
            this.i = 0; 
            this.tamanho = novoTamanho; 
            this.o = b;
            o[this.i] = elemento; 
            this.f++; 
        }
        else{
            if (size() == tamanho-1){
                int novoTamanho; 
                if (incremento == 0){ novoTamanho = tamanho*2; }
                else{ novoTamanho = tamanho+incremento; }
                Object[] b = new Object[novoTamanho]; 
                int inicio_dois = i;
                for (int final_dois = 0; final_dois < size(); final_dois++){ 
                    b[final_dois] = o[inicio_dois];
                    inicio_dois = (inicio_dois+1)%tamanho; 
                }
                f  = size(); 
                i = 0; 
                tamanho = novoTamanho; 
                o = b; 
            }
        }
            o[f] = elemento; 
            this.f = (f+1)%tamanho; 
    }

    public Object dequeue(){
        if(isEmpty()){ throw new FilaVaziaExcecao("A Fila está vazia");}
        Object temp = o[i]; 
        i = (i+1)%tamanho; 
        return temp; 
    }

    public int size(){
        return (tamanho-i+f)%tamanho;
    }

    public boolean isEmpty(){
        return f==i;
    }

    public Object first(){
        return o[i];
    }
}