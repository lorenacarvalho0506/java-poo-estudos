# Atributos e Métodos em Java

## Atributos

Os **atributos** representam as características ou os dados de um objeto. Eles armazenam informações que definem seu estado.

Também podem ser chamados de campos ou variáveis de instância, quando pertencem a cada objeto individualmente.

### Exemplo

```java
public class Pessoa {

    String nome;
    int idade;
    double altura;

}
```

Nesse exemplo:
- `nome`, `idade` e `altura` são atributos.
- `String`, `int` e `double` são os tipos dos atributos.

### Acessando e modificando atributos

Para acessar um atributo por meio de um objeto, utilizamos o operador ponto (`.`).

```java
Pessoa p1 = new Pessoa();

p1.nome = "Maria";
p1.idade = 22;
p1.altura = 1.65;

System.out.println(p1.nome);
```

Saída:

```text
Maria
```

Cada objeto possui seus próprios valores para os atributos de instância.

**Observação:** em Java, atributos de instância sem valores explícitos recebem valores padrão, como `0` para `int`, `false` para `boolean` e `null` para referências. Variáveis locais não recebem esses valores automaticamente.

---

## Métodos

Os **métodos** definem comportamentos ou operações que uma classe pode executar.

Eles permitem agrupar instruções para realizar uma tarefa, podendo receber dados por parâmetros e retornar um resultado.

### Estrutura básica

```java
public tipoRetorno nomeDoMetodo() {
    // Código
}
```

- `public`: define a visibilidade do método.
- `tipoRetorno`: indica o tipo do valor retornado, ou `void` quando não há retorno.
- `nomeDoMetodo`: nome utilizado para chamar o método.
- `()`: local onde são declarados os parâmetros, quando necessários.
- `{ }`: delimitam o corpo do método.

### Método sem retorno

Utilizamos `void` quando o método não devolve um valor.

```java
public void apresentar() {
    System.out.println("Olá!");
}
```

Para executar o método:

```java
p1.apresentar();
```

### Método com retorno

Um método pode calcular ou produzir um resultado e devolvê-lo com `return`.

```java
public int somar(int a, int b) {
    return a + b;
}
```

Utilização:

```java
int resultado = somar(5, 3);
System.out.println(resultado);
```

Saída:

```text
8
```

Nesse exemplo, `a` e `b` são parâmetros, e `int` indica que o método retorna um número inteiro.

---

## Exemplo completo

```java
public class Pessoa {

    String nome;
    int idade;

    public void apresentar() {
        System.out.println("Meu nome é " + nome);
        System.out.println("Tenho " + idade + " anos");
    }

    public int calcularIdadeFutura(int anos) {
        return idade + anos;
    }
}
```

Classe principal:

```java
public class Main {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();

        p1.nome = "Maria";
        p1.idade = 22;

        p1.apresentar();

        int idadeFutura = p1.calcularIdadeFutura(5);

        System.out.println(idadeFutura);
    }
}
```

Saída:

```text
Meu nome é Maria
Tenho 22 anos
27
```

Nesse exemplo:
- `nome` e `idade` são atributos.
- `apresentar()` é um método sem retorno.
- `calcularIdadeFutura()` é um método que recebe um parâmetro e retorna um valor.
- `p1` é uma referência ao objeto criado com `new Pessoa()`.

---

## Resumo

| Conceito | Função |
|---|---|
| Atributos | Armazenam dados e representam características do objeto. |
| Métodos | Definem comportamentos e operações. |
| Parâmetros | Permitem que um método receba dados. |
| `void` | Indica que o método não retorna um valor. |
| `return` | Devolve um resultado ao ponto em que o método foi chamado. |
| Operador `.` | Permite acessar membros de um objeto por meio de sua referência. |
