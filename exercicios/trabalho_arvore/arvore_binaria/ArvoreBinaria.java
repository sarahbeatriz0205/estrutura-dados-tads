package arvore_binaria;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/* MÉTODOS QUE FALTAM IMPLEMENTAR OU PRECISAM DE CONSERTO!

    inOrder

    postOrder
    
    heigth (com parâmetros)
    
    remove (bugs)

    height (sem parâmetros)
   
    imprimirArvore (completo)
   
    elementos (ou método para retornar a lista de nós) */


public class ArvoreBinaria{
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

    public boolean hasLeft(NoArvore v){
        if (ArvoreBinaria.leftChild(v) != null){
            return true;
        }
        return false;
    }

    public boolean hasRight(NoArvore v){
        if (ArvoreBinaria.rightChild(v) != null){
            return true;
        }
        return false;
    }

    public NoArvore parent(NoArvore v){
        return v.getPai();
    }

    public void preOrder(NoArvore v){
        if (v == null){
            return;
        }
        visite(v);
        preOrder(leftChild(v));
        preOrder(rightChild(v));
    }

    public void postOrder(NoArvore v){
        if (v == null){
            return;
        }
        postOrder(leftChild(v));
        visite(v);
        postOrder(rightChild(v));
        visite(v);
    }

    public void inOrder(NoArvore v){
        if (isInternal(v)){
            inOrder(leftChild(v));
        } visite(v);
        if (isInternal(v)){
            inOrder(rightChild(v));
        } 
    }

    public void visite(NoArvore v){
        System.out.print(v.getElemento());
    }

    public NoArvore search(int k, NoArvore v){
        if (k == v.getElemento()){
            return v;
        }  
        if (k < v.getElemento() && v.getFilhoEsquerdo() != null){
                return search(k, v.getFilhoEsquerdo());
        }
        if (k > v.getElemento() && v.getFilhoDireito() != null){
            return search(k, v.getFilhoDireito());
        }
        return v;
    }

    public void insert(int k, NoArvore v) throws ArvoreExcecao{
        NoArvore encontrado = search(k, v);
        if (encontrado.getElemento() == k){
            throw new ArvoreExcecao("Erro! Nó já existente");
        }

        NoArvore novo = new NoArvore(null, null, encontrado, k);

        if (novo.getElemento() < encontrado.getElemento()){
            encontrado.setFilhoEsquerdo(novo);
        }
        else {
            encontrado.setFilhoDireito(novo);
        }
        this.size++;
    } 

    public int remove(NoArvore v){
        int element = v.getElemento();

        /* Se um nó for externo, basta ele virar null */
        if (isExternal(v)){
            if (v.getElemento() < v.getPai().getElemento()){
                v.getPai().setFilhoEsquerdo(null);
            } else {
                v.getPai().setFilhoDireito(null);
            }
            return element;
        }

        /* Se o nó tiver apenas UM filho */
        NoArvore aux = v.getPai();
        NoArvore esq = v.getFilhoEsquerdo();
        NoArvore dir = v.getFilhoDireito();

        if ((v.getFilhoEsquerdo() == null && v.getFilhoDireito() != null) || (v.getFilhoEsquerdo() != null && v.getFilhoDireito() == null)){
            if (v.getFilhoEsquerdo() != null){
                v.getFilhoEsquerdo().setPai(aux);
            } else {
                v.getFilhoDireito().setPai(aux);
            }
            if (v.getFilhoEsquerdo().getElemento() < aux.getElemento()){
                    aux.setFilhoEsquerdo(esq);    
            } else{
                aux.setFilhoDireito(dir);
            }
            return element;
        }

        /* Nó com DOIS filhos */
        NoArvore atual = v.getFilhoDireito();
        if (v.getFilhoEsquerdo() != null && v.getFilhoDireito() != null){
             while (isInternal(leftChild(atual))) {
                atual = atual.getFilhoEsquerdo();
             }
             int temp = atual.getElemento();
             remove(atual);
             v.getFilhoDireito().getPai().setElemento(temp);
        }
        return element;
    }

    public void imprimirArvore(int linhas, int colunas){
        int[][] matriz = new int[linhas][colunas];
        int colocacao_raiz = matriz[0].length / 2;
        matriz[0][colocacao_raiz] = this.raiz.getElemento();
        /* ainda preciso desenhar melhor como vou fazer isso */
    }
}