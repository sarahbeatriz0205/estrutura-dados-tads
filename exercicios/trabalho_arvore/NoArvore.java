package exercicios.trabalho_arvore;

public class NoArvore{
    private NoArvore filhoEsquerdo;
    private NoArvore filhoDireito;
    private NoArvore pai;
    private Object elemento;

    public NoArvore(NoArvore filhoEsquerdo, NoArvore filhoDireito, NoArvore pai, Object o){
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
        this.pai = pai;
        this.elemento = o;
    }

    public NoArvore getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }

    public NoArvore getFilhoDireito(){
        return this.filhoDireito;
    }

    public NoArvore getPai(){
        return this.pai;
    }

    public Object getElemento(){
        return this.elemento;
    }
}
