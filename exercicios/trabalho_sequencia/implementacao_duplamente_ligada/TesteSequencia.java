package exercicios.trabalho_sequencia.implementacao_duplamente_ligada;

public class TesteSequencia {
    public static void main(String[] args) {
        try {
            ISequencia seq = new SequenciaDuplamenteLigada();
            System.out.println("--- Iniciando Teste ---");

            // 1. Teste de inserção em leque (Extremidades e Meio)
            seq.insertFirst("Meio");         // [Meio]
            seq.insertFirst("Inicio");       // [Inicio, Meio]
            seq.insertLast("Fim");           // [Inicio, Meio, Fim]
            seq.insertAtRank(1, "Novo_1");   // [Inicio, Novo_1, Meio, Fim]
            seq.insertAtRank(3, "Novo_3");   // [Inicio, Novo_1, Meio, Novo_3, Fim]
            
            System.out.println("Tamanho esperado 5: " + seq.size());
            imprimir(seq); 

            // 2. Teste de busca por Nodo e Rank
            No noMeio = seq.atRank(2); // Deve ser "Meio"
            System.out.println("\nElemento no rank 2: " + noMeio.getElemento());
            System.out.println("Rank detectado do nodo 'Meio': " + seq.rankOf(noMeio));

            // 3. Teste de vizinhança (Before/After)
            System.out.println("Antes do Meio: " + seq.before(noMeio)); // Novo_1
            System.out.println("Depois do Meio: " + seq.after(noMeio));  // Novo_3

            // 4. Teste de Substituição Dupla
            seq.replaceElement(noMeio, "MEIO_ALTERADO");
            seq.replaceAtRank(0, "INICIO_ALTERADO");
            System.out.println("\nApós alterações:");
            imprimir(seq);

            // 5. O Grande Teste: Swap de vizinhos e Swap de distantes
            System.out.println("\nRealizando Swaps...");
            seq.swapElements(seq.atRank(0), seq.atRank(4)); // Troca Inicio com Fim
            seq.swapElements(seq.atRank(1), seq.atRank(2)); // Troca Novo_1 com MEIO_ALTERADO
            imprimir(seq);

            // 6. Esvaziando a lista sistematicamente
            System.out.println("\nLimpando a lista...");
            while (!seq.isEmpty()) {
                Object removido = seq.removeAtRank(0);
                System.out.println("Removido: " + removido + " | Sobrou: " + seq.size());
            }

            System.out.println("\nLista final está vazia? " + seq.isEmpty());

        } catch (Exception e) {
            System.err.println("\n--- FALHA NO TESTE ---");
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void imprimir(ISequencia s) {
        System.out.print("Lista atual: ");
        for (int i = 0; i < s.size(); i++) {
            System.out.print("[" + s.elemAtRank(i) + "] ");
        }
        System.out.println();
    }
}