# Conceitos iniciais de Java para POO

## 1. Declaração de variáveis e tipos de dados

Diferentemente do JavaScript, em que podemos declarar variáveis com `let` sem especificar previamente o tipo, em Java precisamos declarar o tipo da variável.

```java
int idade = 22;
double altura = 1.65;
String nome = "Lorena";
boolean estudante = true;
char inicial = 'L';
```

- `int`: números inteiros, como `500`.
- `double`: números com casas decimais, como `50.23`.
- `String`: textos, como `"Lorena"`.
- `boolean`: valores `true` ou `false`.
- `char`: um único caractere, como `'L'`.

**Atenção:** em Java, números decimais utilizam ponto, não vírgula. Para representar mil, escrevemos `1000` ou `1_000`, e não `1.000`.

## 2. Entrada de dados com Scanner

A classe `Scanner` permite ler dados digitados pelo usuário ou fornecidos pela entrada padrão, como acontece em plataformas de exercícios de programação.

É necessário importar a classe:

```java
import java.util.Scanner;
```

Exemplo:

```java
Scanner scanner = new Scanner(System.in);

int idade = scanner.nextInt();
double altura = scanner.nextDouble();
String nome = scanner.next();
```

- `new Scanner(System.in)`: cria um leitor da entrada padrão.
- `nextInt()`: lê um número inteiro.
- `nextDouble()`: lê um número decimal.
- `next()`: lê uma palavra, até encontrar um espaço em branco.
- `nextLine()`: lê uma linha inteira de texto.

## 3. Estrutura de um método

Em Java, funções declaradas dentro de uma classe são chamadas de **métodos**.

Exemplo:

```java
public static double calcularConsumo(
    int distancia, double combustivel) {

    return distancia / combustivel;
}
```

- `public`: permite o acesso ao método de outros locais, respeitando as regras de acesso.
- `static`: permite chamar o método pela classe, sem precisar criar um objeto dessa classe.
- `double`: tipo de dado que o método retorna.
- `calcularConsumo`: nome do método.
- `int distancia` e `double combustivel`: parâmetros recebidos pelo método.
- `return`: devolve o resultado para quem chamou o método.

Utilização:

```java
double consumoMedio = calcularConsumo(500, 40);
```

Nesse exemplo, o resultado é `12.5`, ou seja, 12,5 km/l.

**Observação:** esse método usa `static` porque pode ser chamado diretamente a partir de outro método estático, como `main`, quando está na mesma classe.

## 4. Diferença entre void e return

`void` indica que o método não devolve um valor.

```java
public static void apresentar() {
    System.out.println("Olá!");
}
```

Já um método com tipo de retorno, como `int` ou `double`, deve devolver um valor compatível com esse tipo.

```java
public static int somar(int a, int b) {
    return a + b;
}
```

- `void`: executa uma tarefa sem retornar um valor.
- `return`: encerra a execução do método e, quando aplicável, devolve um resultado.

## 5. Exibição de resultados com printf

O método `System.out.printf()` permite exibir textos com formatação.

```java
System.out.printf("%.3f km/l%n", consumoMedio);
```

- `%.3f`: exibe um número decimal com três casas após o separador decimal.
- `%n`: insere uma quebra de linha.
- `consumoMedio`: valor utilizado na formatação.

Exemplo de saída:

```text
12,500 km/l
```

A representação do separador decimal pode depender da configuração regional da aplicação. Em exercícios de programação, normalmente a saída esperada utiliza ponto decimal.

## 6. O que é static?

A palavra-chave `static` indica que um membro pertence à classe, e não a uma instância específica.

### Sem static

Cada objeto possui seu próprio atributo de instância.

```java
class Pessoa {
    String nome;
    int idade;
}
```

```java
Pessoa p1 = new Pessoa();
Pessoa p2 = new Pessoa();

p1.nome = "Lorena";
p2.nome = "Italo";
```

Cada objeto possui seu próprio nome.

### Com static

O atributo pertence à classe e é compartilhado entre suas instâncias.

```java
class Pessoa {
    static String especie = "Humano";
}
```

O atributo pode ser acessado pela própria classe:

```java
System.out.println(Pessoa.especie);
```

**Como decidir?**

Pergunte: essa informação pertence a cada objeto individualmente ou à classe inteira?

- Cada objeto possui um valor próprio: use um atributo de instância, sem `static`.
- O valor é compartilhado pela classe: considere `static`.

Métodos também podem ser `static` ou de instância. Métodos de instância podem acessar diretamente os atributos de instância do objeto atual; métodos estáticos não possuem um objeto atual (`this`).

## 7. Atributos e métodos em POO

Os atributos armazenam os dados de um objeto, enquanto os métodos definem seus comportamentos e operações.

```java
class Cartao {
    double limite;

    void registrarCompra(double valor) {
        limite -= valor;
    }
}
```

Utilização:

```java
Cartao maria = new Cartao();

maria.limite = 1000;
maria.registrarCompra(200);
```

Após a compra, o limite será `800`.

O método `registrarCompra()` acessa o atributo `limite` do próprio objeto. Por isso, não precisamos passar o limite como parâmetro: ele já faz parte do estado do objeto.

Nesse exemplo, `limite` é um atributo de instância. Cada cartão pode ter seu próprio limite.

## 8. Classes e objetos

Uma **classe** é um modelo que define atributos e métodos. Um **objeto** é uma instância criada a partir dessa classe.

```java
class Pessoa {
    String nome;

    void apresentar() {
        System.out.println("Olá, sou " + nome);
    }
}
```

Criando e utilizando um objeto:

```java
Pessoa p1 = new Pessoa();

p1.nome = "Lorena";
p1.apresentar();
```

Saída:

```text
Olá, sou Lorena
```

- `Pessoa`: classe.
- `p1`: variável que guarda uma referência ao objeto.
- `new Pessoa()`: cria uma instância.
- `p1.nome`: acessa um atributo.
- `p1.apresentar()`: chama um método.

## 9. Construtores

Os construtores inicializam objetos durante sua criação. Eles possuem o mesmo nome da classe e não possuem tipo de retorno.

```java
class Pessoa {
    String nome;

    Pessoa(String nome) {
        this.nome = nome;
    }
}
```

Utilização:

```java
Pessoa p1 = new Pessoa("Lorena");
```

`this.nome` representa o atributo do objeto atual, enquanto `nome` representa o parâmetro recebido.

O construtor permite inicializar o objeto sem precisar atribuir o valor ao atributo separadamente depois de criá-lo.

## 10. Operador ponto (.)

O operador `.` permite acessar membros de uma classe ou objeto, conforme as regras de acesso.

```java
p1.nome = "Lorena";
p1.apresentar();
```

Também pode ser utilizado para acessar membros estáticos pela classe:

```java
Pessoa.especie
```

Em Java, o ponto também é usado como separador decimal em números, mas são usos diferentes: em `p1.nome`, acessa-se um membro; em `1.5`, representa-se um número decimal.

## Resumo para memorizar

| Conceito | Significado |
|---|---|
| Tipo de dado | Define quais valores uma variável pode armazenar. |
| `Scanner` | Lê dados da entrada padrão. |
| Método | Executa uma operação ou comportamento. |
| Parâmetro | Dado recebido pelo método. |
| `return` | Devolve um resultado. |
| `void` | Indica que o método não retorna um valor. |
| `static` | Associa um membro à classe, e não a uma instância específica. |
| Atributo | Armazena dados de um objeto ou da classe. |
| Objeto | Instância criada a partir de uma classe. |
| Construtor | Inicializa um objeto durante sua criação. |
| `this` | Referencia o objeto atual. |
| `new` | Cria uma instância de uma classe. |
| `.` | Acessa membros de classes e objetos. |
