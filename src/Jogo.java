import java.util.Random;
import java.util.Scanner;

public class Jogo {
    static Scanner ler = new Scanner(System.in);
    static Random sorteador = new Random();


    public void Jogar(){
        Jogadores();
        Categorias();
        SortearLetras();

    }

    public static void Jogadores(){
        System.out.println("Digite a quantidade de jogadores: ");
        int qtdJogadores = ler.nextInt();
        String[] jogadores = new String[qtdJogadores];

        for (int i = 0; i < jogadores.length; i++) {
            System.out.println("Informe os nomes dos jogadores: ");
            String nome = ler.next();
        }
    }

    public static void Categorias(){

        System.out.println("Informe quantas categorias você deseja: ");
        int qtdCategorias = ler.nextInt();
        
        String [] categorias = new String[qtdCategorias];
        for (int i = 0; i < qtdCategorias; i++) {
            System.out.println("Informe quais categorias você deseja: ");
            categorias[i] = ler.next();
        }
        for (int j = 0; j < categorias.length; j++) {
            System.out.println();
        }

    }public static void SortearLetras(){
        char letra = (char) (sorteador.nextInt(26) + 'A');
        System.out.println("A letra sorteada é: " + letra);
    }
}
