package exercicios.trabalho_lista.implementacao_array;

public interface ILista {
    public abstract boolean isFirst(Object o);
    public abstract boolean isLast(Object o);
    public abstract Object first();
    public abstract Object last();
    public abstract Object before(int p);
    public abstract Object after(int p);
    public abstract Object replaceElement(int n, Object o);
    public abstract void swapElements(int n, int q);
    public abstract No insertBefore(int n, Object o);
    public abstract No insertAfter(int n, Object o);
    public abstract No insertFirst(Object o);
    public abstract No insertLast(Object o);
    public abstract Object remove(int n);
    public abstract int size();
    public abstract boolean isEmpty();
}