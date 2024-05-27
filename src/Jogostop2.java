import java.util.ArrayList;
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

            ler.nextLine();
            for (int i = 0; i < qtdJogadores; i++) {
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
        
            char letra = (char) (sorteador.nextInt(26) + 'a');
            System.out.println("A letra sorteada é: " + letra);

         
            List<List<String>> respostas = new ArrayList<>();
            for (int i = 0; i < jogadores.size(); i++) {
                respostas.add(new ArrayList<>());
            }

            for (int i = 0; i < jogadores.size(); i++) {
                String[] respJog = new String[categorias.length];
                Jogador jogador = jogadores.get(i);
                for (int c = 0; c < categorias.length; c++) {
                    String categoria = categorias[c];

                    System.out.println("É a vez de " + jogador + "\nInforme um(a) " + categoria + " que comece com a letra " + letra);
                    String resp = ler.nextLine();
                    respostas.get(i).add(resp);
                }
            }
    
            for (int categoriaIndex = 0; categoriaIndex < categorias.length; categoriaIndex++) {
            List<String> todasRespostas = new ArrayList<>();

            
            for (List<String> respostaJogador : respostas) {
                todasRespostas.add(respostaJogador.get(categoriaIndex));
            }
            
            int[] pontuacoes = new int[qtdJogadores];
            
            for (int i = 0; i < respostas.size(); i++) {
                String resposta = respostas.get(i).get(categoriaIndex);
                if (resposta.charAt(0) == letra) {
                    if(!resposta.equals(todasRespostas)){
                        pontuacoes[i] += 10;
                    } else if (resposta.equals(respostas)) {   
                        pontuacoes[i] += 5;
                    }
            } 
        }

            List<Integer> ranking = new ArrayList<>();
            for (int i = 0; i < pontuacoes.length; i++) {
                ranking.add(i);
            }
            ranking.sort((i, j) -> Integer.compare(pontuacoes[i], pontuacoes[j]));
    
            
            System.out.println("\nRanking Final:");
            for (int i = 0; i < ranking.size(); i++) {
                int idx = ranking.get(i);
                System.out.println((i + 1) + ". " + jogadores.get(idx).getNome() + ": " + pontuacoes[idx] + " ponto(s)");
            }
        }
    }                   
}
