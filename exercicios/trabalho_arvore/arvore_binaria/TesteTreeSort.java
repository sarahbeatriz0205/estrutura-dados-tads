package arvore_binaria;

public class TesteTreeSort {

    public static void main(String[] args) {

        // Lista ordenada de forma crescente -> Gera uma BST totalmente desbalanceada para a direita
        Integer[] numeros = {50, 20, 80, 10, 30, 60, 90, 40, 70, 100};

        TreeSort treeSort = new TreeSort(numeros);
        try {
            long tempoInicio = System.nanoTime();

            treeSort.insert();
            treeSort.ordenar();
            Integer[] ordenado = treeSort.mostrarOrdenada();

            long tempoFinal = System.nanoTime();
            double duracaoMilissegundos = (tempoFinal - tempoInicio) / 1_000_000.0;

            System.out.println("Vetor original (Pior cenário para BST):");
            for (Integer n : numeros) {
                System.out.print(n + " ");
            }

            System.out.println("\n");

            System.out.println("Vetor ordenado:");
            for (Integer n : ordenado) {
                System.out.print(n + " ");
            }
            
            System.out.println("\n\n--------------------------------------");
            System.out.printf("Tempo de execução do TreeSort: %.4f ms\n", duracaoMilissegundos);
            System.out.println("--------------------------------------");

        } catch (ArvoreExcecao e) {
            e.printStackTrace();
        }
    }    
}