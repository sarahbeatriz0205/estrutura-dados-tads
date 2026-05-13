public class FilaEnfileirarArray{
    private int i;
    private int f;
    private int tamanho;
    private int incremento;
    private Object fila[];

    public FilaEnfileirarArray(int tamanho){
        this.i = 0;
        this.f = 0;
        this.tamanho = tamanho;
        this.incremento = incremento;
        fila = new Object[tamanho];
    }

    public int size(){
        return (this.tamanho-this.i+this.f)%this.tamanho; // cálculo do tamanho do array circular (procurar entender depois)
    }

    // de qualquer forma eu devo criar um novo array? sim
    // testar depois esse método
    public void enfileirar(Object obj){
        // incremento correto, mas pode modificar diretamente no atributo da classe?
        if (size() == this.tamanho - 1){
            if (this.incremento == 0){ this.tamanho *= 2; }

            novaFilaTemp = new Object[this.tamanho]; // instanciação correta?
            int tempInicio = this.i;
            for (tempInicio; tempInicio < fila.length; tempInicio++){
                novaFilaTemp[tempInicio] = fila[tempInicio];
            }
            this.f = this.tamanho + 1;
            fila = novaFilaTemp;
        }
        fila[this.tamanho] = obj;
        this.f = (this.f+1)%this.tamanho;
    }
}