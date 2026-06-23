package dicionario_simples;
import dicionario_simples.Primo;

public class Dicionario implements IDicionario {
    private Item a[];
    private int tamanho;

    public Dicionario(int tamanho){
        this.tamanho = tamanho;
        a = new Item[tamanho];
    }

    // falta a função secundária pro hash duplo
    private int funcaoPrimaria(int k){
        if (Primo.ehPrimo(this.tamanho)){
            return k % this.tamanho;
        }
        else{
            int ptrTamanho = this.tamanho;
            while (!Primo.ehPrimo(ptrTamanho)){
                ptrTamanho++;
                Primo.ehPrimo(ptrTamanho);
            }
            this.tamanho = ptrTamanho;
            return k % this.tamanho;
        }
    }

    /* iterador pra chaves improvisado */
    public int[] keys(){
        int[] k = new int[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            k[i] = a[i].key();
        }
        return k;
    }

    /* iterador pra elementos improvisado */
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

        while (p != this.tamanho) {
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

    


}