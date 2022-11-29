/*
 * Projeto.: Lista Duplamente Ligada
 * Autor...: Professor Dreco
 * Classe..: ED2Ordenacao
 * Objetivo: Projeto Lista Duplamente Ligada
 */
package vetorgeral;

import java.util.Scanner;
import static vetorgeral.MsgVetor.msg_central;

public class Main
{
    public static VetorGeral copia_Vetor(VetorGeral vx)
    {
        VetorGeral resultado = new VetorGeral();
        
        resultado.inicializarVetor();
        
        int tamx = vx.getTamanho();
        int aux = 0;
        
        for (aux = 0; aux < tamx; aux++)
        {
            resultado.vetor[aux] = vx.vetor[aux];
        }
        
        resultado.setTamanho(tamx);
        resultado.setLimite(tamx);
        return resultado;
    }

    public static void listagem_Simultanea (VetorGeral v1, VetorGeral v2, int nx, int ny)
    {
        MsgVetor.limpatela();

        int p = 0;

        System.out.println();
        System.out.println("+-----------------------------------------------------+");
        System.out.format( "|                 | Vetor %1d         | Vetor %1d         |\n", nx, ny);
        System.out.println("|         Posição | Elementos       | Elementos       |");

        if ((v1.getTamanho() == 0) && (v2.getTamanho() == 0))
        {
            System.out.println("+-----------------+-----------------+-----------------+");
            System.out.format( "|                 | - Vetor Vazio - | - Vetor Vazio - |\n");
        }
        else
        {
            if (v1.getTamanho() == 0)
            {
                System.out.format( "|                 | - Vetor Vazio - | %15d |\n", v2.getTamanho());
                System.out.println("+-----------------+-----------------+-----------------+");
                
                for (p = 0; p != v2.getTamanho(); p++)
                {
                    System.out.format("| %15d | --------------- | %15d |\n", p, v2.getPosicao(p));
                }
            }
            else
            {
                if (v2.getTamanho() == 0)
                {
                    System.out.format( "|                 | %15d | - Vetor Vazio - |\n", v1.getTamanho());
                    System.out.println("+-----------------+-----------------+-----------------+");

                    for (p = 0; p != v1.getTamanho(); p++)
                    {
                        System.out.format("| %15d | %15d | --------------- |\n", p, v1.getPosicao(p));
                    }
                }
                else
                {
                    System.out.format( "|                 | %15d | %15d |\n", v1.getTamanho(), v2.getTamanho());
                    System.out.println("+-----------------+-----------------+-----------------+");

                    for (p = 0; p != v1.getTamanho(); p++)
                    {
                        System.out.format("| %15d | %15d | %15d |\n", p, v1.getPosicao(p), v2.getPosicao(p));

                    }
                }
            }
        }
        
        System.out.println("+-----------------------------------------------------+");
    }

    
    public static void main(String[] args)
    {
        VetorGeral vetorG1 = new VetorGeral();
        VetorGeral vetorG2 = new VetorGeral();
        VetorGeral vetorG3 = new VetorGeral();
        VetorGeral vetorGx = new VetorGeral();        
        
        int posicao = 0;
        int pos1 = 0;
        int pos2 = 0;
        int qtd = 0;
        int qual_vetor = 0;
        int conteudo = 0;
        
        vetorG1.setTamanho(vetorG1.xarq_abre_arquivo("Vetor 1"));

        vetorG2.setTamanho(vetorG2.xarq_abre_arquivo("Vetor 2"));

        vetorG3.setTamanho(vetorG3.xarq_abre_arquivo("Vetor 3"));
        
        vetorG1.setLimite(vetorG1.getTamanho());
        
        vetorG2.setLimite(vetorG2.getTamanho());
        
        vetorG3.setLimite(vetorG3.getTamanho());
        
        int opc = 0;
        
        do {
            qual_vetor = MsgVetor.opcao_vetor ("trabalho");

            switch (qual_vetor)
            {
                case 1:
                {
                    vetorGx = vetorG1;
                    break;
                }   
                case 2:
                {
                    vetorGx = vetorG2;
                    break;
                }   
                case 3:
                {
                    vetorGx = vetorG3;
                    break;
                }   
            }
            
            vetorGx.ordena_HeapSort();
            
            System.out.println("\nDigite 1 para continuar ou 0 para sair.");
            Scanner s = new Scanner(System.in);
            opc = s.nextInt();
     
            
            
        } while (opc != 0);  
    }
    //FIM
    
}
