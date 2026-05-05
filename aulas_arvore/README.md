# Árvore
## O que é uma árvore?
- Em Computação, é um modelo abstrato de uma estrutura hierárquica
- Uma árvore consiste de nós com uma **relação pai-filho**

## Terminologia de árvore
- Raiz (root): Nó sem pai (A). O nó head de uma lista ligada, por exemplo
- Nó interno: Nó com, pelo menos, um filho (A, B, C, F)
- Nó externo: Também chamado de Nó Folha. Nó sem filhos (E, I, J, K, G, H, D)
- Ancestral de um nó: pai, avô, bisavô, etc.
- Profundidade de um nó: Número de ancestrais. Contagem do que vem antes de um determinado nó
- Altura de um árvore: Profundidade máxima (3). Para definir a altura, pegar a maior altura entre os "galhos". Para isso, não pode contar o nó root 
- Descendente de um nó: filho, neto, bisneto, etc.
- Sub-árvore: árvore formada por um nó e seus descendentes

## Métodos:
#### Métodos genéricos
- integer size()
- integer height()
- boolean isEmpty()
- Iterator elements() -> itera apenas sobre os elementos
- Iterator nos() -> itera a penas sobre os nós
#### Métodos de acesso:
- No root()
- No parent(No)
- Iterator children(No)

#### Métodos de consulta:
- boolean isInternal(No)
- boolean isExternal(No)
- boolean isRoot(No)
- integer depth(No)
#### Métodos de atualização:
- Object replace(No, o)
> Métodos adicionais podem ser definidos pela estrutura que extende/implementa o TAD árvore

## Travessia pré-ordem
- Visita-se primeiro o pai para depois visitar os filhos

~~~
Algoritmo preOrder(v)  -> recebe um nó (sempre o raiz primeiro)
    visite(v) 
    para cada filho w de v
    preorder (w)
~~~

## Travessia pós-ordem
- Visita primeiro os filhos
~~~
Algoritmo postOrder(v)
    para cada filho w de v
        postOrder(w)
    visite(v)
~~~
