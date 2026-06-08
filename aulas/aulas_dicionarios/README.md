# TAD Dicionário
**O TAD dicionário modela uma coleção “buscável” de itens chave-elemento**

## Métodos do TAD dicionário:
- **findElement(k)**: se o dicionário tem um item com chave k, retorna o elemento, senão, retorna **NO_SUCH_KEY**
- **insertItem(k, o)**: insere um item no dicionário
- **removeElement(k)**: Se existe um item com chave k, remove e retorna, senão, retorna **NO_SUCH_KEY**
- **size(), isEmpty()**
- **keys(), Elements()**

## Arquivo de LOG
- **É um arquivo de texto onde se isnere novos elementos apenas ao final**
- **Um arquivo de log é um dicionário implementado como um sequência não ordenada**
- **insertItem roda em O(1), mas os outros métodos são O(n)**

## Busca binária
**Busca binária realiza a operação findElement(k) em um dicionário implementado com uma sequencia baseada em array, ordenada pela chave**

> [!TIP]
> O dicionário deve estar ordenado!

~~~
Algoritmo BuscaBinária(A,k,min,max)
    m <- (max+min)/2
    c <- A[m]
    se min>max
        retorne NO_SUCH_KEY
    senão se c.getKey()= k
        retorne c.getElement()
    senão se(k < c.getKey()
        BuscaBinaria(A,k, min, m-1)
    senão se(k>c.getKey())
        BuscaBinaria(A,k, m +1,max)
    retorne NO_SUCH_KEY
~~~

<img width="669" height="219" alt="image" src="https://github.com/user-attachments/assets/c5b32190-304b-48f6-99d6-3256531855f5" />

## Tabela de pesquisa
- **Uma tabela de pesquisa é um dicionário implementado através de uma estrutura ordenada**
- **Ineficiente**

## Tabelas Hash
**Uma tabela de dispersão para um dado tipo de chave consiste de:**
- **função de dispersão h**: ```elemento % N```
- **arranjo (chamado tabela) de tamanho N**

### Problema: Colisão
Uma colisão ocorre quando duas chaves no dicionário têm o mesmo valor de dispersão
**Esquemas de tratamento de colisões:**
- **encadeiamento**: itens que colidem são armazenados numa sequência encadeada (lista duplamente encadeada)
- **endereçamento**: o item que colide é colocado em um lugar diferente na tabela
  - **endereçamento aberto:** verifica se existe vaga ao lado. O find() funciona da mesma maneira, ele percorre e verifica que o número passado é igual a o número encontrado
