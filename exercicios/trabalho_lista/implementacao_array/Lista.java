package exercicios.trabalho_lista.implementacao_array;

public class Lista{
    private int tamanho; 
    private Object a[];

    public Lista(int tamanho){
        this.tamanho = tamanho;
        a = new Object[tamanho];
    } 

    public boolean isFirst(Object o){
        if (a[0] == o){ return true; }
        else{ return false; }
    }

    public boolean isLast(Object o){
        if (a[this.tamanho - 1] == o){ return true; }
        else{ return false; }
    }

    public Object first(){
        return a[0];
    }

    public Object last(){
        return a[this.tamanho-1];
    }

    public Object before(int p) throws ListaExcecaoArray{
        if  (p > this.tamanho || p <= 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return a[p-1];
        }
    }

    public Object after(int p) throws ListaExcecaoArray{
        if  (p > this.tamanho || p < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return [p+1];
        }
    }
}