import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogostop2 {
    static Scanner ler = new Scanner(System.in);
    static Random sorteador = new Random();

    public static void main(String[] args) {
      
            Jogar();
    }

    public static void Jogar(){
            System.out.println("Digite a quantidade de jogadores: ");
            int qtdJogadores = ler.nextInt();
            
            List<Jogador> jogadores = new ArrayList<>();
            int[] pontos = new int[qtdJogadores];

    
            for (int i = 0; i < jogadores.size(); i++) {
                System.out.println("Informe os nomes dos jogadores: ");
                String jogador = ler.nextLine();
                jogadores.add(new Jogador(jogador)); 
            }
    
            System.out.println("Informe quantas categorias você deseja: ");
            int qtdCategorias = ler.nextInt();
            
            String[] categorias = new String[qtdCategorias];
            for (int i = 0; i < qtdCategorias; i++) {
                System.out.println("Informe quais categorias você deseja: ");
                categorias[i] = ler.next();
                ler.nextLine();
             }
        
            char letra = (char) (sorteador.nextInt(26) + 'A');
            System.out.println("A letra sorteada é: " + letra);

         
            List<List<String>> respostas = new ArrayList<>();
            for (int i = 0; i < jogadores.size(); i++) {
                respostas.add(new ArrayList<>());
            }

            for (int i = 0; i < jogadores.size(); i++) {
                String jogador = jogadores.get(new Jogador(nome));
                String[] respJog = new String[categorias.length];

                for (int c = 0; c < categorias.length; c++) {
                    String categoria = categorias[c];

                    System.out.println("É a vez de " + jogador + "\nInforme um(a) " + categoria + " que comece com a letra " + letra);
                    String resp = ler.nextLine();
                    respJog[c] = resp;
                }

                respostas.add(respJog);
            }
    
            for (int categoriaIndex = 0; categoriaIndex < categorias.length; categoriaIndex++) {
            List<String> todasRespostas = new ArrayList<>();

            // Recolhe todas as respostas para a categoria atual
            for (List<String> respostaJogador : respostas) {
                todasRespostas.add(respostaJogador.get(categoriaIndex));
            }

            // Conta as respostas por categoria
            List<String> respostasUnicas = new ArrayList<>();
            List<String> respostasDuplicadas = new ArrayList<>();

            for (String resposta : todasRespostas) {
                if (Collections.frequency(todasRespostas, resposta) == 1) {
                    respostasUnicas.add(resposta);
                } else {
                    if (!respostasDuplicadas.contains(resposta)) {
                        respostasDuplicadas.add(resposta);
                    }
                }
            }
            int[] pontuacoes = new int[qtdJogadores];
            // Calcula os pontos para cada jogador
            for (int i = 0; i < respostas.size(); i++) {
                String resposta = respostas.get(i).get(categoriaIndex);
                if (resposta != null && resposta.startsWith(String.valueOf(letra))) {
                    if (respostasUnicas.contains(resposta)) {
                        // Resposta única
                        pontuacoes[i] += 10;
                    } else if (respostasDuplicadas.contains(resposta)) {
                        // Resposta duplicada
                        pontuacoes[i] += 5;
                    }
                }
            }
            List<Integer> ranking = new ArrayList<>();
            for (int i = 0; i < pontuacoes.length; i++) {
                ranking.add(i);
            }
            ranking.sort((i1, i2) -> Integer.compare(pontuacoes[i2], pontuacoes[i1]));
    
            // Exibe o ranking
            System.out.println("\nRanking Final:");
            for (int i = 0; i < ranking.size(); i++) {
                int idx = ranking.get(i);
                System.out.println((i + 1) + ". " + jogadores.get(idx).getNome() + ": " + pontuacoes[idx] + " ponto(s)");
            }
        }
    }
                   
        }
    }
}