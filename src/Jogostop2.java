import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogostop2 {
    static Scanner ler = new Scanner(System.in);
    static Random sorteador = new Random();
    static Integer num_Rodadas = 3;
    static Integer pontMax = 10;
    static Integer pontMet = 5;
    static Integer pontMin = 0;

    public static void main(String[] args) {
        for (int rodada = 0; rodada < num_Rodadas; rodada++) {
            Jogar();
        }
    }

    public static void Jogar(){
            System.out.println("Digite a quantidade de jogadores: ");
            int qtdJogadores = ler.nextInt();
            
            String[] jogadores = new String[qtdJogadores];
            int[] pontos = new int[qtdJogadores];

    
            for (int i = 0; i < jogadores.length; i++) {
                System.out.println("Informe os nomes dos jogadores: ");
                jogadores[i] = ler.next();
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

            List<String[]> respostas = new ArrayList<>();
            

            for (int i = 0; i < jogadores.length; i++) {
                String jogador = jogadores[i];
                String[] respJog = new String[categorias.length];

                for (int c = 0; c < categorias.length; c++) {
                    String categoria = categorias[c];

                    System.out.println("É a vez de " + jogador + "\nInforme um(a) " + categoria + " que comece com a letra " + letra);
                    String resp = ler.nextLine();
                    respJog[c] = resp;
                }

                respostas.add(respJog);
            }

            System.out.println(respostas);


            for (int j = 0; j< jogadores.length; j++) {
                String jog = jogadores[j];
                String[] resps = respostas.get(j);

                int pontosJog = 0;
                //
                //
                //

                pontos[j] += pontosJog;

            }
                for (String resposta : respostas) {
                    for (String string : respostas) {
                        if (resposta.charAt(0) == letra) {
                            if (resposta.length() > 2) {
                                if (resposta.equalsIgnoreCase(string)) {
                                    pontos += pontMet;
                                }else{
                                pontos += pontMax;
                                }
                            }else{
                                pontos += pontMin;
                            }
                        }else{
                            pontos += pontMin;
                        }
                    }
                }        
        }
    }
