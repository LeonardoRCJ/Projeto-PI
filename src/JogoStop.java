import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class JogoStop {
    private static final int NUM_RODADAS = 5;

    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Digite o número de jogadores: ");
        int numJogadores = ler.nextInt();

        List<Jogador> jogadores = new ArrayList<>();
        int volta =  0;
        do {
            System.out.print("Nome do jogador: ");
  
            String nome = ler.next();
            jogadores.add(new Jogador(nome));
            volta++;
        }while(volta < numJogadores);

        String[] categorias = {"Nome", "CEP", "Objeto", "Time", "Marca"};

        Jogo jogo = new Jogo(jogadores, categorias);

        jogo.jogar();

    }
}

class Jogo {
    private static final int NUM_RODADAS = 5;
    private List<Jogador> jogadores;
    private String[] categorias;

    public Jogo(List<Jogador> jogadores, String[] categorias) {
        this.jogadores = jogadores;
        this.categorias = categorias;
    }

    public void jogar() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int rodada = 1; rodada <= NUM_RODADAS; rodada++) {
            System.out.printf("\nRodada: %d", rodada);

            char letra = (char) (random.nextInt(26) + 'A');
            System.out.println("A letra sorteada é: " + letra);

            Map<Jogador, Map<String, String>> respostas = new HashMap<>();

 
            for (String categoria : categorias) {
                System.out.println("\nCategoria: " + categoria);

                for (Jogador jogador : jogadores) {
                    System.out.println("Vez de " + jogador.getNome() + " Pressione Enter para iniciar o temporizador.");
                    scanner.next();
                    System.out.println("Temporizador iniciado! Digite um " + categoria + " que comece com a letra '" + letra + "': ");
                    String palavra = scanner.next();

                    jogador.adicionarResposta(categoria, palavra);
                }
            }


            System.out.println("\nRespostas da Rodada " + rodada + ":");
            for (Jogador jogador : jogadores) {
                System.out.println(jogador.getNome() + ": " + jogador.getRespostas());
            }
        }

        scanner.close();
    }
}

class Jogador {
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}