package trabalho_dicionario;
import java.util.Iterator;

public class Dicionario implements IDicionario {
    private Item a[];
    private int tamanho;

    public Dicionario(int tamanho){
        this.tamanho = tamanho;
        a = new Item[tamanho];
    }

    private int keyConvert(Item k){
        //
    }

    public Object findElement(Item k){
        Object i = keyConvert(k);
        int p = 0;

        Object c = a[i];
        if (c == null){
            return NO_SUCH_KEY;
        }
        else if (c.key() == k){
            return c.value();
        }
    }


}