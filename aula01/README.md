# Pilhas
```
Algoritmo size()
  retorne t + 1 // o último índice + 1

Algoritmo pop()
  Se (estaVazia()) // exceção
    throw EPilhaVazia // lança exceção
  senão
    t ← t - 1 // atribui a variável anterior como atual
  retorne S[t + 1] // retorna o elemento "removido"

Algoritmo push(o)
  Se (t = S.length - 1) // se pilha tiver cheia, exceção. se t for igual ao tamanho do array
    throw EPilhaCheia
  senão
    t ← t + 1 // passa para o índice "vazio"
    S[t] ← o // insere o objeto nesse índice

Algoritmo colocar(o)
  Se (t = S.length-1)
    então
    A ← novo array 
  para i ← 0 até t faça // O(n)
    A[i] ← S[i]
    S ← A
  t ← t + 1
  S[t] ← o
```
