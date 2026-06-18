package trabalho_dicionario;

public class Item {
    private Object key;
    private Object element;

    public Item(Object key, Object element){
        this.key = key;
        this.element = element;
    }

    public Object key(){
        return this.key;
    }

    public Object value(){
        return this.element;
    }
}
