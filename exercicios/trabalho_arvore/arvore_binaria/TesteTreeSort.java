package arvore_binaria;

public class TesteTreeSort {

    public static void main(String[] args) {

        Integer[] numeros = {12,76,46,98,38,23,45,239,74,13,97};

        TreeSort treeSort = new TreeSort(numeros);
        try {
            treeSort.insert();
            treeSort.ordenar();
            Integer[] ordenado = treeSort.mostrarOrdenada();

            System.out.println("Vetor original:");
            for (Integer n : numeros) {
                System.out.print(n + " ");
            }

            System.out.println("\n");

            System.out.println("Vetor ordenado:");
            for (Integer n : ordenado) {
                System.out.print(n + " ");
            }

        } catch (ArvoreExcecao e) {
            e.printStackTrace();
        }
    }    
}
