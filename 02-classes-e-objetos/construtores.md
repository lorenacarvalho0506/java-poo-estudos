# POO — Construtores em Java

## 1. O que é um construtor?

O construtor é executado automaticamente no momento em que criamos um objeto usando `new`.

Características:

- Tem exatamente o mesmo nome da classe.
- Não possui tipo de retorno, nem mesmo `void`.
- Pode receber parâmetros para inicializar os atributos do objeto.

## 2. Construtor padrão

Quando não criamos nenhum construtor na classe, o Java fornece um construtor padrão sem parâmetros.

Exemplo:

```java
class Aluno {

    String nome;
    double nota1;
    double nota2;
}

public class Main {

    public static void main(String[] args) {

        Aluno a1 = new Aluno();

        System.out.println(a1.nome);
    }
}
```

**Resultado:**

```text
null
```

Isso acontece porque nenhum valor foi atribuído ao atributo `nome`.

Valores padrão dos atributos:

| Tipo | Valor padrão |
|---|---|
| `String` | `null` |
| `double` | `0.0` |
| `int` | `0` |
| `boolean` | `false` |

**Importante:** quando você declara um construtor próprio, o Java deixa de fornecer automaticamente o construtor padrão sem parâmetros.

## 3. Criando nosso próprio construtor

Podemos criar um construtor para que o objeto já comece com valores definidos.

```java
class Aluno {

    private String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
}
```

Agora podemos criar um objeto assim:

```java
Aluno a1 = new Aluno("Zé", 10, 9);
```

O objeto já começa com os seguintes valores:

- `nome = "Zé"`
- `nota1 = 10`
- `nota2 = 9`

## 4. A palavra-chave `this`

A palavra-chave `this` é usada dentro da classe para diferenciar os atributos do objeto dos parâmetros recebidos.

Exemplo:

```java
this.nome = nome;
```

- `this.nome` → o atributo `nome` do objeto.
- `nome` → o parâmetro recebido pelo construtor.

Portanto, essa instrução significa que o atributo `nome` do objeto recebe o valor do parâmetro `nome`.

## 5. Exemplo completo

```java
class Aluno {

    private String nome;
    private double nota1;
    private double nota2;

    // Construtor
    public Aluno(String nome, double nota1, double nota2) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public String toString() {
        return String.format(
            "Nome: %s | Média: %.2f",
            nome,
            calcularMedia()
        );
    }
}

public class Main {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("Zé", 10, 9);
        Aluno a2 = new Aluno("Maria", 5, 8);

        System.out.println(a1);
        System.out.println(a2);
    }
}
```

**Resultado:**

```text
Nome: Zé | Média: 9,50
Nome: Maria | Média: 6,50
```

Nesse exemplo, os objetos já são criados com os valores definidos nos construtores.

## 6. Resumo

- **Construtor:** inicializa o objeto quando ele é criado.
- **Nome:** deve ser exatamente igual ao nome da classe.
- **Retorno:** não possui tipo de retorno, nem mesmo `void`.
- **Parâmetros:** podem ser usados para receber os valores iniciais dos atributos.
- **`this`:** diferencia os atributos do objeto dos parâmetros recebidos.
- **Construtor padrão:** é fornecido automaticamente pelo Java quando nenhum construtor é declarado.

Exemplo básico:

```java
public Aluno(String nome) {
    this.nome = nome;
}
```

Uso:

```java
Aluno a1 = new Aluno("Maria");
```

O objeto `a1` é criado com o atributo `nome` inicializado como `"Maria"`.
