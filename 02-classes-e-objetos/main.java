public class Main {
    public static void main(String[] args) {
        
        // Criando o Cachorro 1 (Instanciando o objeto Rex)
        Cachorro cachorro1 = new Cachorro();
        cachorro1.nome = "Rex";
        cachorro1.peso = 12;
        cachorro1.corOlhos = "Castanho";
        cachorro1.numPatas = 4;

        // Criando o Cachorro 2 (Instanciando o objeto Mel)
        Cachorro cachorro2 = new Cachorro();
        cachorro2.nome = "Mel";
        cachorro2.peso = 7;
        cachorro2.corOlhos = "Azul";
        cachorro2.numPatas = 3;

        // Testando os comportamentos dos objetos
        System.out.println("--- Testando o primeiro objeto ---");
        System.out.println("Nome do cão: " + cachorro1.nome);
        cachorro1.falar();
        cachorro1.comer();

        System.out.println("\n--- Testando o segundo objeto ---");
        System.out.println("Nome do cão: " + cachorro2.nome);
        cachorro2.andar();
        cachorro2.dormir();
    }
}
