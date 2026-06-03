package arvore_binaria;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    private NoArvore raiz;
    private int size;

    public ArvoreBinaria(int o){
        this.raiz = new NoArvore(null, null, null, o);
        this.size = 1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0){ 
            return true; 
        } 
        return false;
    }

    public int depht(NoArvore v){
        if (isRoot(v)){
            return 0;
        }
        return 1+depht(parent(v));
    }

    public int heigth(NoArvore r, NoArvore v){
        if (ArvoreBinaria.isExternal(v)){
            return 0;
        }
        else{
            int h = 0;
            Iterator<NoArvore> f = ArvoreBinaria.children(v);
            while (f.hasNext()){
                NoArvore w = f.next();
                h = Math.max(h, heigth(this.raiz, w));
            }
            return 1+h;
        }
    }

    public static Iterator<NoArvore> children(NoArvore v){
        List<NoArvore> filhos = new ArrayList<>();
        if (v.getFilhoEsquerdo() != null){
            filhos.add(v.getFilhoEsquerdo());
        }
        if (v.getFilhoDireito() != null){
            filhos.add(v.getFilhoDireito());
        }
        return filhos.iterator();
    }

    public static boolean isExternal(NoArvore v){
        if (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null){
            return true;
        }
        return false;
    }

    public static boolean isInternal(NoArvore v){
        if (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null){
            return true;
        }
        return false;
    }

    public boolean isRoot(NoArvore v){
        if (v.getPai() == null){
            return true;
        }
        return false;
    }

    public NoArvore root(){
        return this.raiz;
    }

    public static NoArvore leftChild(NoArvore v){
        return v.getFilhoEsquerdo();
    }

    public static NoArvore rightChild(NoArvore v){
        return v.getFilhoDireito();
    }

    public NoArvore parent(NoArvore v){
        return v.getPai();
    }

    public void inOrder(NoArvore v){
        if (isInternal(v)){
            inOrder(leftChild(v));
        } visite(v);
        if (isInternal(v)){
            inOrder(rightChild(v));
        } visite(v);
    }

    public void visite(NoArvore v){
        //
    }

    public NoArvore search(int k, NoArvore v){
        if (ArvoreBinaria.isExternal(v)){
            return v;
        }
        if (k < v.getElemento()){
            return search(k, ArvoreBinaria.leftChild(v));
        }
        else if (k == v.getElemento()){
            return v;
        }
        else{
            return search(k, ArvoreBinaria.rightChild(v));
        }
    }

    public void insert(int k, NoArvore v){
        // tentar usar search de alguma forma
    } 

    public void imprimirArvore(int linhas, int colunas){
        int[][] matriz = new int[linhas][colunas];
        int colocacao_raiz = matriz[0].length / 2;
        matriz[0][colocacao_raiz] = this.raiz.getElemento(); 
    }
}