# POO — Encapsulamento, Getters, Setters e Construtores

## 1. Encapsulamento

**Encapsulamento:** protege os atributos do objeto e controla como eles podem ser acessados ou alterados.

A ideia é validar as operações para evitar que o objeto fique em um estado inconsistente.

**Exemplo:**

```java
a1.nota1 = -5;
a1.nota2 = 12;
```

Isso é um problema porque uma nota deveria estar entre 0 e 10.

Com encapsulamento, podemos impedir esse tipo de alteração diretamente.

---

## 2. Visibilidade

Os principais modificadores de acesso são:

- `public` → pode ser acessado de qualquer lugar.
- `private` → só pode ser acessado diretamente dentro da própria classe.
- `protected` → possui regras específicas relacionadas à herança.
- Sem modificador → acesso dentro do mesmo pacote.

### Atributos

**Boa prática:**

```java
private String nome;
private double nota1;
private double nota2;
```

Quando um atributo é `private`, outras classes não conseguem acessá-lo diretamente.

### Métodos

Os métodos podem ser públicos ou privados, dependendo do que queremos permitir.

**Exemplo:**

```java
public double getNota1()
```

Pode ser chamado de fora da classe.

Já:

```java
private void validarNota()
```

Só pode ser usado diretamente dentro da própria classe.

---

## 3. Problema de deixar os atributos públicos

```java
class Aluno {

    String nome;
    double nota1;
    double nota2;
}

public class Main {

    public static void main(String[] args) {

        Aluno a1 = new Aluno(); // construtor padrão

        a1.nome = "Maria";
        a1.nota1 = -5;
        a1.nota2 = 12;

        System.out.println(a1.nome);
        System.out.println(a1.nota1);
        System.out.println(a1.nota2);
    }
}
```

O problema está nestas linhas:

```java
a1.nota1 = -5;
a1.nota2 = 12;
```

O programa aceita esses valores, mesmo que sejam inválidos.

Isso pode deixar o objeto em um estado inconsistente.

---

## 4. Usando `private`

```java
class Aluno {

    private String nome;
    private double nota1;
    private double nota2;
}
```

Agora, estas instruções:

```java
a1.nome = "Maria";
a1.nota1 = -5;
```

Vão gerar erro se estiverem fora da classe `Aluno`.

**Por quê?**

Porque os atributos são `private`.

Então usamos métodos para controlar o acesso:

- `get` → pegar ou obter um valor.
- `set` → alterar ou definir um valor.

---

## 5. Getter — `get`

**Get → obter.**

### Estrutura

```java
public tipoDeRetorno getAtributo() {
    return atributo;
}
```

### Características

- Normalmente é `public`.
- Não possui parâmetros.
- Serve para obter ou consultar um atributo.
- Precisa retornar um valor.
- Por isso, normalmente não é `void`.

### Exemplos

```java
public String getNome() {
    return nome;
}

public double getNota1() {
    return nota1;
}
```

### Uso

```java
System.out.println(a1.getNome());
System.out.println(a1.getNota1());
```

---

## 6. Setter — `set`

**Set → definir ou alterar.**

### Estrutura

```java
public void setAtributo(tipo valor) {
    atributo = valor;
}
```

### Características

- Normalmente é `public`.
- É `void`.
- Pode receber parâmetros.
- Serve para alterar um atributo.
- Pode conter condições para validar o valor.

### Exemplo com validação

```java
public void setNota1(double valor) {

    if (valor >= 0 && valor <= 10) {
        nota1 = valor;
    }
}
```

Agora:

```java
a1.setNota1(-1);
```

Não altera a nota, porque `-1` não passa pela condição.

---

## 7. `void` e `else if`

Um método `void` pode ter `if`, `else` e `else if` normalmente.

O que não pode é colocar a declaração de um método dentro de um `if`, `else` ou `else if`.

**Errado:**

```java
if (condicao) {

} else if (outraCondicao) {

    public void fazerAlgo() {

    }
}
```

Métodos devem ser declarados dentro da classe, mas não dentro de `if`, `else` ou `else if`.

**`void` significa apenas que o método não retorna um valor.**

---

## 8. Construtor

O construtor é executado quando criamos um objeto.

```java
Aluno a1 = new Aluno();
```

Quando não criamos nenhum construtor, o Java fornece um construtor padrão sem parâmetros.

Por isso, a instrução abaixo é possível:

```java
Aluno a1 = new Aluno();
```

### Valores padrão dos atributos

Os atributos recebem seus valores padrão quando nenhum outro valor é atribuído.

| Tipo | Valor padrão |
|---|---|
| `String` | `null` |
| `double` | `0.0` |
| `int` | `0` |
| `boolean` | `false` |

### Exemplo

```java
class Aluno {

    String nome;
    double nota1;
    double nota2;
}

Aluno a1 = new Aluno();

System.out.println(a1.nome);
```

**Resultado:**

```text
null
```

Isso acontece porque nenhum valor foi atribuído a `nome`.

---

## 9. Criando nosso próprio construtor

Podemos criar um construtor para que o objeto já seja criado com valores.

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

Agora podemos criar o objeto assim:

```java
Aluno a1 = new Aluno("Zé", 10, 9);
```

O objeto já começa com:

- `nome = "Zé"`
- `nota1 = 10`
- `nota2 = 9`

### `this`

Observe:

```java
this.nome = nome;
```

- `this.nome` → é o atributo da classe.
- `nome` → é o parâmetro recebido pelo construtor.

O `this` permite diferenciar o atributo do objeto do parâmetro que possui o mesmo nome.

---

## 10. Exemplo completo — Aluno

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

    // Setter com validação
    public void setNota1(double valor) {

        if (valor >= 0 && valor <= 10) {
            nota1 = valor;
        }
    }

    // Getter
    public String getNome() {
        return nome;
    }

    // Getter
    public double getNota1() {
        return nota1;
    }

    // toString
    public String toString() {
        return "Nome: " + nome +
               " | Nota 1: " + nota1 +
               " | Nota 2: " + nota2;
    }
}

public class Main {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("Zé", 10, 9);

        // Teste: -1 não será atribuído
        // porque não passa pela validação.
        a1.setNota1(-1);

        System.out.println("Nome do aluno: " + a1.getNome());
        System.out.println("Nota do aluno: " + a1.getNota1());
    }
}
```

### O que acontece?

1. O objeto `a1` é criado com o nome `"Zé"` e as notas `10` e `9`.
2. O método `setNota1(-1)` é chamado.
3. A condição verifica se `-1` está entre `0` e `10`.
4. Como a condição é falsa, a nota não é alterada.
5. O getter retorna o valor atual da nota.

---

## 11. Boa prática

Uma boa prática é colocar condições de validação antes de alterar atributos.

**Exemplo:**

```java
public void setNota1(double valor) {

    if (valor >= 0 && valor <= 10) {
        nota1 = valor;
    }
}
```

Assim, o objeto não aceita qualquer valor.

### Fluxo do encapsulamento

```text
Atributo privado
       ↓
Método controla o acesso
       ↓
Validação
       ↓
Atributo recebe o valor
```

---

## 12. Exemplo — Conta bancária

```java
class Conta {

    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {

        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {

    public static void main(String[] args) {

        Conta c = new Conta(3000);

        c.depositar(1000);
        c.depositar(2000);

        System.out.println("Saldo atual: " + c.getSaldo());

        c.sacar(500);

        System.out.println("Saldo atual: " + c.getSaldo());
    }
}
```

### O que está acontecendo?

**Saldo inicial:**

```text
3000
```

**Depois do primeiro depósito:**

```java
c.depositar(1000);
```

Saldo: `4000`.

**Depois do segundo depósito:**

```java
c.depositar(2000);
```

Saldo: `6000`.

**Depois do saque:**

```java
c.sacar(500);
```

Saldo: `5500`.

O saldo não pode ser alterado diretamente:

```java
c.saldo = -5000; // ERRO
```

Isso acontece porque `saldo` é `private`.

A alteração precisa passar pelos métodos da classe.

---

## 13. Método `calcularMedia()`

Os métodos também podem realizar operações usando os atributos privados.

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

### Resultado

```text
Nome: Zé | Média: 9,50
Nome: Maria | Média: 6,50
```

O método `calcularMedia()` calcula a média das duas notas e retorna o resultado.

O `toString()` utiliza esse método para incluir a média na representação textual do objeto.

---

## 14. `toString()`

O método `toString()` define como o objeto será representado quando for convertido em texto.

### Exemplo

```java
public String toString() {
    return "Nome: " + nome;
}
```

Então, ao executar:

```java
System.out.println(a1);
```

O Java chama automaticamente o método `toString()` do objeto, nesse caso, `a1`.

Isso permite definir quais informações serão exibidas ao imprimir um objeto.

---

## 15. Resumo

### Encapsulamento

```text
Encapsulamento
      ↓
Proteger os dados do objeto
      ↓
Usar private nos atributos
      ↓
Controlar o acesso através de métodos
      ↓
Validar os valores
      ↓
Evitar estado inconsistente
```

### `private`

```java
private double nota;
```

Somente a própria classe pode acessar diretamente esse atributo.

### Getter — `get`

```java
public double getNota() {
    return nota;
}
```

Obtém ou consulta o valor.

### Setter — `set`

```java
public void setNota(double valor) {
    nota = valor;
}
```

Altera ou define o valor.

### Construtor

```java
public Aluno(String nome) {
    this.nome = nome;
}
```

Inicializa o objeto quando ele é criado.

### `toString()`

```java
public String toString() {
    return nome;
}
```

Define como o objeto será representado quando for usado, por exemplo:

```java
System.out.println(a1);
```

### `void`

```java
public void sacar(double valor)
```

Indica que o método não retorna um valor.

**Importante:** `void` não significa que o método não pode ter parâmetros ou usar `if`, `else` e `else if`.

Significa apenas que o método não retorna um valor.
