package heap_nos;

public class HeapNos {
    private NoHeap raiz;
    private int size;

    public HeapNos(Object o){
        this.raiz = new NoHeap(null, null, null, o);
        this.size = 1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return false;
    }

    public NoHeap min(){
        return this.raiz;
    }

    public static NoHeap leftChild(NoHeap v){
        return v.getFilhoEsquerdo();
    }

    public static NoHeap rightChild(NoHeap v){
        return v.getFilhoDireito();
    }

    public boolean hasLeft(NoHeap v){
        if (HeapNos.leftChild(v) != null){
            return true;
        }
        return false;
    }

    public boolean hasRight(NoHeap v){
        if (HeapNos.rightChild(v) != null){
            return true;
        }
        return false;
    }

    public void upheap(){
        //
    }

    public void insert(int k, Object o){
        //
    }

    public void downheap(){
        //
    }

    public Object removeMin(){
        //
    }
}
