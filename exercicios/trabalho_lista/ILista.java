package exercicios.trabalho_lista;

public interface ILista {
    public abstract boolean isFirst(No n);
    public abstract boolean isLast(No n);
    public abstract Object first();
    public abstract Object last();
    public abstract Object before(No p);
    public abstract Object after(No p);
    public abstract Object replaceElement(No n, Object o);
    public abstract void swapElements(No n, No q)
    public abstract void insertBefore(No n, Object o);
    public abstract void insertAfter(No n, Object o);
    public abstract void insertFirst(Object o);
    public abstract void insertLast(Object o);
    public abstract No remove(No n);
    public abstract int size();
    public abstract boolean isEmpty();
}