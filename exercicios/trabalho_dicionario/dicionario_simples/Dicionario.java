package dicionario_simples;

public class Dicionario implements IDicionario {
    private Item a[];
    private int tamanho;
    private Item AVAILABLE = new Item(-1, "AVAILABLE");

    public Dicionario(int tamanho){
        this.tamanho = Primo.menorPrimoMaiorOuIgualA(tamanho);
        a = new Item[tamanho];
    }

    private int funcaoPrimaria(int k){
        return k % this.tamanho;
    }

    private int funcaoSecundaria(int k){
        int primoEscolhido = Primo.maiorPrimoMenorQue(this.tamanho);
        return (primoEscolhido - k) % this.tamanho;
    }

    private double fatorDeCarga(){
        double alfa = (double) size() / a.length; 
        return alfa;
    }

    private double probes(){
        double p = 1.0 / (1.0 - fatorDeCarga());
        return p;
    }

    private void rehash(){
        int tamanhoNovo = Primo.menorPrimoMaiorOuIgualA(this.tamanho*2);
        Item[] ptrAntiga = this.a;
        a = new Item[tamanhoNovo]; 
        this.tamanho = 0;

        for (Item item : ptrAntiga){
            if (item != null){
                insertElement(item);
            }
        }
        this.tamanho = tamanhoNovo;
    }

    public int[] keys(){
        int[] k = new int[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            if (a[i] != null){
                k[i] = a[i].key();
            }
        }
        return k;
    }

    public Object[] elements(){
        Object[] k = new Object[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            k[i] = a[i].value();
        }
        return k;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }

    public int size(){
        return this.tamanho;
    }

    public Object findElement(Item k) throws NoSuchKeyException{
        int i = funcaoPrimaria(k.key());
        int p = 0;

        while (p != size()) {
            Item c = a[i];
            if (c == null){
                throw new NoSuchKeyException("NO_SUCH_KEY");
            }
            else if (c.key() == k.key()){
                return c.value();
            }
            else{
                i = (i+1) % this.tamanho;
                p++;
            }   
        }
        throw new NoSuchKeyException("NO_SUCH_KEY");
    }

    public Object removeElement(Item k) throws NoSuchKeyException{
        try{
            Object item = findElement(k);
            Object elemento = item;
            int i = funcaoPrimaria(k.key());
            int p = 0;
            while (p != size()){
                if (i == k.key()){
                    a[i] = AVAILABLE;
                    return elemento;
                }
                else {
                    i = (i + 1) % this.tamanho;
                    p++;
                }
            }
            return elemento;
            
        } 
        catch (NoSuchKeyException e){
            throw new NoSuchKeyException("NO_SUCH_KEY");
        }
    }

    public void insertElement(Item k){
        double fatorDeCarga = fatorDeCarga() * 100;

        if (fatorDeCarga > 50){
            rehash();
        }

        int resultadoPrimario = funcaoPrimaria(k.key());
        int resultadoSecundario = funcaoSecundaria(k.key());

        for (int i = 0; i < a.length; i++){
            int posicao = resultadoPrimario + (i*resultadoSecundario) % this.a.length;

            if (this.a[posicao] == null || this.a[posicao] == this.AVAILABLE){
                this.a[posicao] = k;
            }
        }
    }

}