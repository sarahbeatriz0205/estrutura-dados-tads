package arvore_generica;
import java.util.Iterator;
import java.util.ArrayList;

public class No{
    private int elemento;
    private ArrayList<No> posicoes = new ArrayList<>();

    public No(int elemento, ArrayList<No> p){
        this.elemento = elemento;
    }

    public int getElemento(){
        return this.elemento;
    }

    
}