# Classes e Objetos

## O que é Programação Orientada a Objetos?

A **Programação Orientada a Objetos (POO)** é um paradigma de programação que organiza o código utilizando classes e objetos.

A ideia é representar elementos de um sistema por meio de objetos que possuem **características (atributos)** e **comportamentos (métodos)**.

Os principais conceitos estudados nesta parte da POO são:

- Classes
- Objetos
- Atributos
- Métodos
- Construtores
- Estado e comportamento dos objetos
- Referências a objetos

---

# Classes

Uma **classe** é um modelo utilizado para definir como determinados objetos serão criados.

Ela descreve quais características os objetos poderão possuir e quais ações poderão executar.

Para criar uma classe, utilizamos o conceito de **abstração**, identificando as características e ações relevantes para o problema que queremos resolver.

Por exemplo, ao criar uma classe que representa um cachorro, podemos considerar características como nome, peso e cor dos olhos, além de comportamentos como andar, comer e dormir.

Normalmente, o nome de uma classe representa um substantivo, por exemplo:

- `Pessoa`
- `Carro`
- `Cachorro`
- `ContaBancaria`

Uma classe pode conter:

- **Atributos:** representam as características dos objetos.
- **Métodos:** representam os comportamentos ou as operações que os objetos podem executar.
- **Construtores:** permitem inicializar objetos durante sua criação.
- **Modificadores de acesso:** controlam a visibilidade dos membros da classe.

### Estrutura básica

```java
public class Teste {

    // Atributos

    // Construtores

    // Métodos

}
```

### Entendendo a estrutura

- `public`: modificador de acesso que permite que a classe seja acessada de outros lugares, respeitando as regras de acesso do Java.
- `class`: palavra-chave utilizada para declarar uma classe.
- `Teste`: nome da classe.

Em Java, por convenção, os nomes das classes começam com letra maiúscula e utilizam o padrão `PascalCase`, como `ContaBancaria` e `PessoaFisica`.

---

# Exemplo de classe

```java
public class Cachorro {

    public String nome;
    public int peso;
    public String corOlhos;
    public int numPatas;

    public void falar() {
        // Código
    }

    public void andar() {
        // Código
    }

    public void comer() {
        // Código
    }

    public void dormir() {
        // Código
    }
}
```

Nesse exemplo:

- `Cachorro` é o nome da classe.
- `nome`, `peso`, `corOlhos` e `numPatas` são atributos.
- `falar()`, `andar()`, `comer()` e `dormir()` são métodos.

Os métodos estão sem implementação funcional neste exemplo. Eles mostram apenas como os comportamentos podem ser declarados.

---

# Objetos

Um **objeto** é uma instância de uma classe.

Enquanto a classe define a estrutura e os comportamentos disponíveis, o objeto é uma instância criada a partir dessa definição.

Por exemplo, a classe `Cachorro` pode ser utilizada para criar vários objetos:

- Rex
- Bob
- Mel

Todos são objetos da classe `Cachorro`, mas cada um pode possuir seus próprios valores para os atributos.

## Diferença entre classe e objeto

| Classe | Objeto |
|---|---|
| É um modelo ou uma definição. | É uma instância da classe. |
| Define atributos e métodos. | Possui valores próprios para os atributos de instância. |
| Exemplo: `Cachorro`. | Exemplos: Rex, Bob e Mel. |

### Criando um objeto em Java

Utilizamos a palavra-chave `new` para criar uma instância de uma classe.

```java
Cachorro rex = new Cachorro();
```

Essa instrução pode ser dividida em três partes:

- `Cachorro`: tipo da variável, indicando a classe do objeto que ela pode referenciar.
- `rex`: nome da variável que armazenará a referência ao objeto.
- `new Cachorro()`: cria um objeto da classe `Cachorro`, utilizando um construtor.

**Importante:** a variável `rex` não é o próprio objeto. Ela guarda uma referência que permite acessar o objeto criado.

---

# Atributos

Os **atributos** representam as características ou os dados de um objeto.

Também podem ser chamados de **campos** ou, quando pertencem a cada instância, **variáveis de instância**.

Eles armazenam informações sobre o estado do objeto, e seus valores podem mudar durante a execução do programa.

Exemplo:

```java
public class Cachorro {

    public String nome;
    public int peso;
    public String corOlhos;
    public int numPatas;

}
```

Cada objeto criado a partir dessa classe poderá possuir seus próprios valores para esses atributos.

Por exemplo:

**Cachorro 1**

```text
nome = Rex
peso = 12
corOlhos = Castanho
numPatas = 4
```

**Cachorro 2**

```text
nome = Mel
peso = 7
corOlhos = Azul
numPatas = 3
```

Mesmo sendo da mesma classe, os objetos podem apresentar estados diferentes.

## O que é o estado de um objeto?

O **estado** de um objeto corresponde aos valores atuais de seus atributos.

Por exemplo, se um cachorro possui `nome = "Rex"` e `peso = 12`, esses valores fazem parte do estado atual desse objeto.

Se o peso for alterado para `13`, seu estado também será alterado.

### Acessando e modificando atributos

```java
public class Main {

    public static void main(String[] args) {

        Cachorro rex = new Cachorro();

        rex.nome = "Rex";
        rex.peso = 12;
        rex.corOlhos = "Castanho";
        rex.numPatas = 4;

        System.out.println(rex.nome);
        System.out.println(rex.peso);

    }
}
```

Saída:

```text
Rex
12
```

Nesse exemplo, o ponto (`.`) é utilizado para acessar um membro do objeto por meio de sua referência.

Por exemplo:

```java
rex.nome = "Rex";
```

Essa instrução atribui o valor `"Rex"` ao atributo `nome` do objeto referenciado por `rex`.

**Observação:** os atributos foram declarados como `public` para simplificar o exemplo. Em código orientado a objetos, é comum utilizar `private` para proteger os dados e controlar seu acesso.

---

# Métodos

Os **métodos** representam comportamentos, ações ou operações que uma classe disponibiliza.

Eles permitem organizar instruções em blocos que podem ser executados quando necessário.

Exemplos de comportamentos de um cachorro:

- Andar
- Comer
- Dormir
- Latir

### Estrutura de um método

```java
public void latir() {
    System.out.println("Au au!");
}
```

Nesse exemplo:

- `public`: define a visibilidade do método.
- `void`: indica que o método não retorna um valor.
- `latir`: nome do método.
- `()`: local onde podem ser declarados os parâmetros.
- `{ }`: delimitam o corpo do método.

### Executando um método

```java
public class Cachorro {

    public String nome;

    public void latir() {
        System.out.println("Au au!");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        Cachorro rex = new Cachorro();

        rex.nome = "Rex";
        rex.latir();

    }
}
```

Saída:

```text
Au au!
```

A chamada `rex.latir()` executa o método `latir()` do objeto referenciado por `rex`.

## Métodos com retorno

Um método também pode realizar um cálculo e devolver um resultado.

```java
public int somar(int a, int b) {
    return a + b;
}
```

Nesse exemplo:

- `int`: tipo do valor retornado.
- `a` e `b`: parâmetros recebidos pelo método.
- `return`: devolve o resultado da soma.

Um método que retorna um valor pode ser utilizado em uma atribuição ou expressão:

```java
int resultado = somar(5, 3);
```

Nesse caso, `resultado` recebe `8`.

---

# Construtores

Um **construtor** é um recurso utilizado para inicializar um objeto durante sua criação.

Ele é executado quando um objeto é criado com `new`.

### Características dos construtores

- Possuem o mesmo nome da classe.
- Não possuem tipo de retorno, nem mesmo `void`.
- Podem receber parâmetros.
- Podem atribuir valores iniciais aos atributos.

### Exemplo

```java
public class Cachorro {

    public String nome;
    public int peso;

    public Cachorro(String nome, int peso) {
        this.nome = nome;
        this.peso = peso;
    }
}
```

Criando um objeto:

```java
Cachorro rex = new Cachorro("Rex", 12);
```

Nesse caso, o construtor recebe `"Rex"` e `12` e utiliza esses valores para inicializar os atributos do objeto.

## Para que serve `this`?

A palavra-chave `this` referencia o objeto atual.

No construtor:

```java
this.nome = nome;
```

- `this.nome`: atributo `nome` do objeto atual.
- `nome`: parâmetro recebido pelo construtor.

O uso de `this` permite distinguir o atributo do parâmetro quando ambos possuem o mesmo nome.

### Construtor padrão e construtor sem parâmetros

Se uma classe não declarar nenhum construtor, o compilador Java disponibiliza um construtor padrão sem parâmetros.

```java
Cachorro rex = new Cachorro();
```

Porém, quando um construtor é declarado explicitamente, o compilador não fornece automaticamente esse construtor padrão.

Se for necessário criar objetos sem passar parâmetros, pode-se declarar um construtor sem parâmetros:

```java
public Cachorro() {
    nome = "Sem nome";
    peso = 0;
}
```

---

# Referências a objetos

Em Java, variáveis de tipos de classe armazenam referências a objetos, e não os objetos diretamente.

Exemplo:

```java
Cachorro rex = new Cachorro();
Cachorro outro = rex;
```

Na segunda instrução, a referência armazenada em `rex` é copiada para `outro`.

Isso significa que as duas variáveis passam a referenciar o mesmo objeto.

Se o objeto for modificado por meio de uma referência, a alteração poderá ser observada pela outra:

```java
rex.nome = "Rex";

System.out.println(outro.nome);
```

Saída:

```text
Rex
```

Isso acontece porque `rex` e `outro` apontam para o mesmo objeto.

**Atenção:** criar outra variável de referência não significa criar outro objeto. Para criar uma nova instância, é necessário utilizar `new` novamente.

---

# Valores iniciais dos atributos

Quando atributos de instância não recebem valores explícitos, o Java atribui valores iniciais automaticamente.

| Tipo | Valor inicial |
|---|---|
| Tipos inteiros, como `int` e `long` | `0` |
| Tipos de ponto flutuante, como `float` e `double` | `0.0` |
| `boolean` | `false` |
| Tipos de referência, como `String` | `null` |
| `char` | `'\u0000'` |

Exemplo:

```java
public class Cachorro {

    String nome;
    int peso;
    boolean vacinado;

}
```

Se um objeto dessa classe for criado sem inicialização explícita dos atributos, seus valores iniciais serão:

```text
nome = null
peso = 0
vacinado = false
```

`null` indica que uma referência não aponta para um objeto.

**Importante:** essas regras se aplicam aos atributos e a outros campos. Variáveis locais declaradas dentro de métodos não recebem automaticamente esses valores padrão e precisam ser inicializadas antes de serem utilizadas.

---

# Exemplo completo: classes e objetos

```java
public class Cachorro {

    private String nome;
    private int peso;

    public Cachorro(String nome, int peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public void latir() {
        System.out.println(nome + " está latindo: Au au!");
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Peso: " + peso + " kg");
    }
}
```

Classe principal:

```java
public class Main {

    public static void main(String[] args) {

        Cachorro rex = new Cachorro("Rex", 12);
        Cachorro mel = new Cachorro("Mel", 7);

        rex.apresentar();
        rex.latir();

        System.out.println();

        mel.apresentar();
        mel.latir();

    }
}
```

Saída:

```text
Nome: Rex
Peso: 12 kg
Rex está latindo: Au au!

Nome: Mel
Peso: 7 kg
Mel está latindo: Au au!
```

Nesse exemplo, os dois objetos são criados a partir da mesma classe, mas possuem atributos diferentes. Cada um pode executar os métodos definidos em `Cachorro`.

Os atributos foram declarados como `private`, portanto não podem ser acessados diretamente de `Main`. Os métodos públicos permitem executar comportamentos definidos pela classe.

---

# Resumo

| Conceito | Significado |
|---|---|
| POO | Paradigma que organiza o programa em classes e objetos. |
| Classe | Modelo que define atributos e métodos. |
| Objeto | Instância criada a partir de uma classe. |
| Atributo | Dado que representa uma característica do objeto. |
| Método | Bloco de código que define um comportamento ou operação. |
| Estado | Valores atuais dos atributos de um objeto. |
| Construtor | Recurso utilizado para inicializar um objeto durante sua criação. |
| `new` | Palavra-chave utilizada para criar uma instância. |
| `this` | Referência ao objeto atual. |
| Referência | Valor utilizado para acessar um objeto. |

## Ideia principal

Uma classe define como os objetos podem ser estruturados e quais operações podem executar. Cada objeto possui seu próprio estado, representado pelos valores de seus atributos, e pode executar os métodos definidos pela classe.
