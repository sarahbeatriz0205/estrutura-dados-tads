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

    public static boolean isExternal(NoHeap v){
        if (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null){
            return true;
        }
        return false;
    }

    public static boolean isInternal(NoHeap v){
        if (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null){
            return true;
        }
        return false;
    }

    /* suponho que, já que um heap com lado direito preenchido e lado esquerdo não preenchido, 
    a viagem pela esquerda é suficiente */
    public int heapHeigth(){
        NoHeap atual = this.raiz;
        int h = 0;

        while (isInternal(leftChild(atual))){
            atual = atual.getFilhoEsquerdo();
            h += 1;
        }

        return h;
    }

    public NoHeap last(){
        NoHeap atual = this.raiz;
        int h = heapHeigth();
        int n = 0;

        while (n < h){
            if (isInternal(rightChild(atual))){
                atual = atual.getFilhoDireito();
            } else if (leftChild(atual) != null){
                atual = atual.getFilhoEsquerdo();
            } else{
                if (rightChild(atual) != null){
                    atual = atual.getFilhoDireito();
                }
                else{
                    atual = atual.getFilhoEsquerdo();
                }
                break;
            }
            n++;
        }
        return atual;
    }

    public NoHeap nextInsertOrRemove(){
        NoHeap ultimo = last();

        while (ultimo.getPai() != null && ultimo == ultimo.getPai().getFilhoDireito()){
            ultimo = ultimo.getPai(); // quando parar, ultimo vai ser raiz
        }

        if (ultimo.getPai() != null && ultimo.getPai().getFilhoDireito() != null){ // verifica se chegou na raiz ou não e evita NullPointerException
            ultimo = ultimo.getPai().getFilhoDireito();
        } else {
            while (leftChild(ultimo) != null){
                ultimo = ultimo.getFilhoEsquerdo();
            }
        }
        return ultimo;
    }


    public void upheap(){
        //
    }

    public void insert(Item o){
        NoHeap ultimo = nextInsertOrRemove();
        NoHeap novo = new NoHeap(null, null, ultimo, o);

        if (ultimo.getFilhoEsquerdo() != null && ultimo.getFilhoDireito() == null){
            ultimo.setFilhoDireito(novo);
        } else {
            ultimo.setFilhoEsquerdo(novo);
        }
        this.size++;
        upheap();
    }

    public void downheap(){
        //
    }

    public Item removeMin(){
        NoHeap removido = last();
        Item menor = this.raiz.getElemento();
        this.raiz.setElemento(removido.getElemento());
        if (removido == removido.getPai().getFilhoEsquerdo()){
            removido.getPai().setFilhoEsquerdo(null);
        } else {
            removido.getPai().setFilhoDireito(null);
        }
        downheap();
        return menor;
    }
}