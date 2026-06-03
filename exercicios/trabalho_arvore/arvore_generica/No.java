import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private Object o;
    private No pai;
    private ArrayList<No> filhos = new ArrayList<No>();
    
    public No(No pai, Object o){
        this.pai = pai;
        this.o = o;
    }
    
    public Object element(){
        return this.o;
    }

    public No getPai(){
        return this.pai;
    }
    
    public void setElement(Object o){
        this.o = o;
    }

    public void addChild(No o){
        filhos.add(o);
    }

    public void removeChild(No o){
        filhos.remove(o);
    }

    public int childrenNumber(){
        return filhos.length;
    }

    public Iterator<No> children(){
        return filhos.iterator();
    }
}