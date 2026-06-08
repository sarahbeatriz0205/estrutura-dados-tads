package heap_nos;

public class HeapNos {
    private NoHeap raiz;
    private NoHeap ultimo;
    private int size;

    public HeapNos(Item o){
        this.raiz = new NoHeap(null, null, null, o);
        this.ultimo = this.raiz;
        this.size = 1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return false;
    }

    public Item min(){
        return this.raiz.getElemento();
    }

    public void changeLast(){
        NoHeap temp = this.ultimo;
        while (temp.getPai() != null && temp == temp.getPai().getFilhoDireito()){
            temp = temp.getPai();
        }
        if (temp.getPai() != null) {
            temp = temp.getPai().getFilhoDireito();
        }
        while (temp.getFilhoEsquerdo() != null) {
            temp = temp.getFilhoEsquerdo();
        }
        this.ultimo = temp;
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

    public void insert(Item o){
        //
        
    }

    public void downheap(){
        //
    }

    public Item removeMin(){
        //
    }
}
