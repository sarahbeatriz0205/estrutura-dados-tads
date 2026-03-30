package aulas_fila.codigo;

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


}