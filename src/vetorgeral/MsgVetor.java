/*
 * Projeto.: Ordenação em Vetores
 * Autor...: Professor Dreco
 * Classe..: MsgVetor
 * Objetivo: Biblioteca para mensagens de interação com o usuário
 */
package vetorgeral;
import java.util.Scanner;

public class MsgVetor
{
    public static String x_linha = "--------------------------------------------------------------------------------";
    public static int    t_linha = 80;

    // Objetivo: simular a limpeza da tela para despoluir a área
    //           de saída (resultados) dos projetos
    //
    public static void limpatela()
    {
        for (int i=0; i<50; i++)
        {
            msg_pl (" ");
        }
        msg_nl (x_linha);
        msg_nl (">>>>>>>>>>>>>>>>>>>>>>>>  Heap Sort  <<<<<<<<<<<<<<<<<<<<<<<<");
        msg_nl (x_linha);
    }
    
    public static void limpatela2()
    {
        for (int i=0; i<50; i++)
        {
            msg_pl (" ");
        }
    }
    
    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_pl (String mensagem)
    {
        System.out.println("\n"+mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_nl (String mensagem)
    {
        System.out.println(mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com layout central
    //
    public static void msg_central (String mensagem)
    {
        int t = mensagem.length();
        
        if (t < 80)
        {
            int d = (80 - t) / 2;
            int r = t % 2;

            for (int p = 1; p <= d; p++)
            {
                mensagem = " "+mensagem;
            }

            if (r == 1) 
            {
                mensagem = " "+mensagem;
            }
        }
        
        msg_nl(x_linha);
        msg_nl(mensagem);
        msg_nl(x_linha);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com layout esquerda
    //
    public static void msg_carga (String mensagem)
    {
        msg_nl(mensagem);
    }

    // Objetivo: possibilitar uma ação interativa para com o usuário
    //           visando chamar a atenção para algumas mensagens
    //
    public static void enter ()
    {
        Scanner s = new Scanner(System.in);
        msg_central ("Pressione <enter> para prosseguir");

        String tecla = s.nextLine();

        limpatela();
    }

   
    public static void menu_lista()
    {
        MsgVetor.limpatela();
        msg_central ("Menu de Vetores - Escolha sua opcao");
        msg_nl ("1. Vetor 1");
        msg_nl ("2. Vetor 2");
        msg_nl ("3. Vetor 3");
        msg_nl ("0. Retornar");
        msg_nl (x_linha);
    }

    public static int opcao_vetor(String tipo)
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_lista();
        msg_nl ("Digite o vetor desejado para "+tipo+": ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 3) && (erro != 1))
        {
            menu_lista();
            msg_nl ("Vetor inválido, corrija para "+tipo+": ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

}
