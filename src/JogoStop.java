import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class JogoStop {
    private static final int NUM_CATEGORIAS = 3;
    private static final int NUM_RODADAS = 5;
    private static final int TEMPO_LIMITE_SEGUNDOS = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();

        List<Jogador> jogadores = new ArrayList<>();
        for (int i = 0; i < numJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new Jogador(nome));
        }

        String[] categorias = {"Nome", "Lugar", "Objeto"};

        Jogo jogo = new Jogo(jogadores, categorias);

        jogo.jogar();

        scanner.close();
    }
}

class Jogo {
    private static final int NUM_RODADAS = 0;
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
                    System.out.println("Vez de " + jogador.getNome() + ". Pressione Enter para iniciar o temporizador.");
                    scanner.nextLine();
                    System.out.println("Temporizador iniciado! Digite um " + categoria + " que comece com a letra '" + letra + "': ");
                    String palavra = scanner.nextLine();

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
    private Map<String, String> respostas;

    public Jogador(String nome) {
        this.nome = nome;
        this.respostas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarResposta(String categoria, String resposta) {
        respostas.put(categoria, resposta);
    }

    public Map<String, String> getRespostas() {
        return respostas;
    }
}