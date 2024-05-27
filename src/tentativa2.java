public class tentativa2 {
    import java.util.*;

    public class JogoStop {
        private static final int NUM_RODADAS = 5;
        private static final String[] CATEGORIAS = {"Nome", "Lugar", "Objeto"};
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Digite o número de jogadores: ");
            int numJogadores = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
    
            List<Jogador> jogadores = new ArrayList<>();
            for (int i = 0; i < numJogadores; i++) {
                System.out.print("Nome do jogador " + (i + 1) + ": ");
                String nome = scanner.nextLine();
                jogadores.add(new Jogador(nome));
            }
    
            // Inicializa o jogo
            Jogo jogo = new Jogo(jogadores, CATEGORIAS);
    
            // Inicia as rodadas
            jogo.jogar();
    
            scanner.close();
        }
    }
    
    class Jogo {
        private List<Jogador> jogadores;
        private String[] categorias;
    
        public Jogo(List<Jogador> jogadores, String[] categorias) {
            this.jogadores = jogadores;
            this.categorias = categorias;
        }
    
        public void jogar() {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
    
            // Inicializa as pontuações
            int[] pontuacoes = new int[jogadores.size()];
    

                char letra = (char) (random.nextInt(26) + 'A');
                System.out.println("A letra sorteada é: " + letra);
    
                List<List<String>> respostas = new ArrayList<>();
                for (int i = 0; i < jogadores.size(); i++) {
                    respostas.add(new ArrayList<>());
                }
    
                // Loop para cada categoria
                for (String categoria : categorias) {
                    System.out.println("\nCategoria: " + categoria);
    
                    for (int i = 0; i < jogadores.size(); i++) {
                        Jogador jogador = jogadores.get(i);
                        System.out.println("Vez de " + jogador.getNome() + ". Pressione Enter para iniciar o temporizador.");
                        scanner.nextLine(); // Aguarda o jogador pressionar Enter
                        System.out.println("Temporizador iniciado! Digite um " + categoria + " que comece com a letra '" + letra + "': ");
                        String palavra = scanner.nextLine();
    
                        // Salva a resposta do jogador
                        respostas.get(i).add(palavra);
                    }
                }
    
                // Calcula e exibe as pontuações da rodada
                System.out.println("\nPontuações da Rodada " + rodada + ":");
                calcularPontuacoes(respostas, letra, pontuacoes);
    
                for (int i = 0; i < jogadores.size(); i++) {
                    System.out.println(jogadores.get(i).getNome() + ": " + pontuacoes[i] + " ponto(s)");
                }
            }
    
            // Exibir pontuações finais
            System.out.println("\nPontuações Finais:");
            for (int i = 0; i < jogadores.size(); i++) {
                System.out.println(jogadores.get(i).getNome() + ": " + pontuacoes[i] + " ponto(s)");
            }
    
            // Exibir ranking final
            exibirRanking(pontuacoes);
    
            scanner.close();
        }
    
        private void calcularPontuacoes(List<List<String>> respostas, char letra, int[] pontuacoes) {
            // Itera sobre cada categoria
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
            }
        }
    
        private void exibirRanking(int[] pontuacoes) {
            // Cria uma lista de índices ordenada pelas pontuações
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
    
    class Jogador {
        private String nome;
    
        public Jogador(String nome) {
            this.nome = nome;
        }
    
        public String getNome() {
            return nome;
        }
    
        @Override
        public String toString() {
            return nome;
        }
    }
}
