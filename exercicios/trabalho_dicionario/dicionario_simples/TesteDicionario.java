package dicionario_simples;

import java.util.Arrays;

public class TesteDicionario {

    public static void main(String[] args) {

        // Instancia o dicionário
        IDicionario dicionario = new Dicionario(13);

        // Cria alguns itens
        Item item1 = new Item(10, "Maçã");
        Item item2 = new Item(20, "Banana");
        Item item3 = new Item(30, "Laranja");

        // Testa isEmpty()
        System.out.println("Dicionário vazio? " + dicionario.isEmpty());

        // Testa insertElement()
        dicionario.insertElement(item1);
        dicionario.insertElement(item2);
        dicionario.insertElement(item3);

        // Testa size()
        System.out.println("Quantidade de elementos: " + dicionario.size());

        // Testa findElement()
        System.out.println("Buscar chave 20: " + dicionario.findElement(new Item(20, null)));

        // Testa keys()
        System.out.println("Chaves: " + Arrays.toString(dicionario.keys()));

        // Testa elements()
        System.out.println("Elementos: " + Arrays.toString(dicionario.elements()));

        // Testa removeElement()
        System.out.println("Removido: " + dicionario.removeElement(new Item(20, null)));

        // Verifica tamanho após remoção
        System.out.println("Quantidade após remoção: " + dicionario.size());

        // Verifica as chaves novamente
        System.out.println("Chaves após remoção: " + Arrays.toString(dicionario.keys()));

        // Testa isEmpty() novamente
        System.out.println("Dicionário vazio? " + dicionario.isEmpty());
    }
}