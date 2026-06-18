package trabalho_dicionario;
import java.util.Iterator;

public class IDicionario{
    public abstract Object findElement(Item k);
    public abstract void insertElement(Item k);
    public abstract Object removeElement(Item k);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Iterator<Object> keys();
    public abstract Iterator<Object> elements();
}