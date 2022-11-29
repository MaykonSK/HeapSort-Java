/* Projeto...: Oredenação
 * Autor.....: Professor Dreco
 * Biblioteca: Vetor de até 1.000.000 posições
 * Classe....: Vetor_Geral
 * Objetivo..: Criação do nó (elemento) que será utilizado nos projetos
 */
package vetorgeral;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VetorGeral
{
    int vetor[] = new int[10000000];
    
    private int tamanho = 1000000;
    
    private int limite  = 1000000; 
    
    public void setPosicao (Integer pos, Integer valor)
    {
        vetor[pos] = valor;
    }

    public Integer getPosicao(Integer pos)
    {
        return vetor[pos];
    }
    
    public void setTamanho (Integer tam)
    {
        tamanho = tam;
    }

    public Integer getTamanho()
    {
        return tamanho;
    }
    
    public void setLimite (Integer lim)
    {
        limite = lim;
    }

    public Integer getLimite()
    {
        return limite;
    }

    public void mostra_Vetor (int limite)
    {
        int i = 0;
        String limite_texto = "   1000";
        
        switch (limite)
        {
            case 10000:
                limite_texto = "  10000";
            case 100000:
                limite_texto = " 100000";
            case 1000000:
                limite_texto = "1000000";
        }

        System.out.println("+---------+------------------+");
        System.out.println("| Vetor de "+limite_texto+" posições  |");
        System.out.println("+---------+------------------+");
        System.out.println("| Posicao | Valor            |");
        System.out.println("+---------+------------------+");
        
        for (i = 0; i < limite; i++)
        {
            System.out.format ("| %7d | %16d |\n", i, vetor[i]);
        }
        System.out.println("+---------+------------------+");
    }

    public void inicializarVetor()
    {
        int t = this.getTamanho();
        int i = 0;
        
        for (i = 0; i <= t; i++)
        {
            this.vetor[i] = 0;
        }

        this.setTamanho(0);
    }

    public void ordena_HeapSort()
    {
        MsgVetor.limpatela();
        
        //mostrar vetor desordenado
        System.out.println("Vetor desordenado");
        for (int i = 0; i < this.getTamanho(); i++) {
            System.out.println(" " + this.vetor[i]);
        }
        
        int n = this.getTamanho();

        // Tempo de inicio
        long tempoInicioNano = System.nanoTime();
        long tempoInicioMilli = System.currentTimeMillis();
        
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            aplicarHeap(this.vetor, n, i);
        }

        for (int i=n-1; i>=0; i--)
        {
            int temp = this.vetor[0];
            this.vetor[0] = this.vetor[i];
            this.vetor[i] = temp;
 
            aplicarHeap( this.vetor, i, 0);
        }
        
        // Tempo final
        long tempoFinalNano = System.nanoTime() - tempoInicioNano;
        long tempoFinalMilli = System.currentTimeMillis() - tempoInicioMilli;
        
        //mostrar vetor ordenado com Heap Sort
        System.out.println("\n\nVetor ordenado");
        for (int i = 0; i < this.getTamanho(); i++) {
            System.out.println(this.vetor[i]+" ");
        }
        
        //mostrar tamanho do array e tempo de execução
        System.out.println("\n\nTamanho do array: "+this.getTamanho());
        
        System.out.println("\nTempo de execução total em nanosegundos --> "
            + tempoFinalNano);
        System.out.println("\nTempo de execução total em milisegundos --> "
            + tempoFinalMilli);

    } 
    
    private static void aplicarHeap(int[] vetor, int n, int i) 
    {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        
        if (esquerda < n && vetor[esquerda] > vetor[raiz]) {
            raiz = esquerda;
        }
        
        if (direita < n && vetor[direita] > vetor[raiz]) {
            raiz = direita;
        }
        
        if (raiz != i) {
            int aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = aux;
            
            aplicarHeap(vetor, n, raiz);
        } 
    }
    
    public String xarq_escolhe_nome_arquivo (String texto)
    {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do
        {
            MsgVetor.limpatela();

            try
            {
                MsgVetor.msg_nl ("Digite o nome do arquivo para carga da ["+texto+"] ou x para não dar carga - não pode ser vazio: ");
                dados = s.nextLine();
            }
            catch(Exception e)
            {
                MsgVetor.msg_nl ("Erro de digitação, não deixe a informação vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }
    
    public int xarq_tamanho_arquivo(String nome_arquivo)
    {
        //
        // Esta função lê o arquivo de dados e conta quantos registros ele possui.
        // A quantidade de registros é retornada e poderá ser utilizada como argumento
        // na criação do vetor de trabalho
        //
        int tamanho = 0;
        boolean prossegue = true;

        FileInputStream stream = null;

        try
        {
            stream = new FileInputStream(nome_arquivo);
            
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = null;
            MsgVetor.msg_central ("Arquivo aberto!");
            //
            // Levantamento do tamanho do arquivo em termos de linhas
            //
            try
            {
                while ((line = reader.readLine()) != null)
                {
                    tamanho++;
                }

                try
                {
                    reader.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo de leitura!");
                }

                try
                {
                    streamReader.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo de stream reader!");
                }

                try
                {
                    stream.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo stream!");
                }
            }
            catch (IOException ioe)
            {
                prossegue = false;
                MsgVetor.msg_central ("Arquivo com problemas na leitura!");
            }
        }
        catch (FileNotFoundException fe)
        {
            MsgVetor.msg_central ("Arquivo não encontrado!");
            prossegue = false;
        }

        return tamanho;
    }

    public int xarq_abre_arquivo (String texto)
    {
        //
        // Esta função lê o arquivo de dados e cria um vetor cujo tamanho é a
        // quantidade de registros do arquivo. O vetor, após ser populado, é devolvido
        // como resposta para o processo chamador.
        //
        MsgVetor.msg_central ("Preparação do arquivo de entrada para carga da ["+texto+"]");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        int tv = 0;

        if (nome_arquivo.equals("x"))
        {
            MsgVetor.msg_central ("Não será utilizado arquivo para entrada de dados para a ["+texto+"].");
        }
        else
        {
            tv = this.xarq_tamanho_arquivo(nome_arquivo);

            if (tv != 0)
            {
                int i = 0;

                boolean prossegue = true;

                if (prossegue)
                {
                    MsgVetor.msg_central ("Gravando dados na ["+texto+"]......");

                    try
                    {
                        FileInputStream stream = null;
                        InputStreamReader streamReader;
                        BufferedReader reader;
                        String line = null;
                        stream = new FileInputStream(nome_arquivo);
                        streamReader = new InputStreamReader(stream);
                        reader = new BufferedReader(streamReader);
                        line = null;
                        ArrayList<String> linha = new ArrayList<String>();

                        if (prossegue)
                        {
                            try
                            {
                                while ((line = reader.readLine()) != null)
                                {
                                    String[] elemento = line.split(";");

                                    MsgVetor.msg_carga ("...Carregando Posição: ["+i+"] - Número: ["+elemento[0]+"]");

                                    this.setPosicao(i, Integer.valueOf(elemento[0]));

                                    i++;
                                }
                            }
                            catch (IOException ioe)
                            {
                                prossegue = false;
                                MsgVetor.msg_central ("Arquivo com problemas na leitura!");
                            }

                            try
                            {
                                reader.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamento do arquivo de leitura!");
                            }

                            try
                            {
                                streamReader.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamentdo do arquivo de stream reader!");
                            }

                            try
                            {
                                stream.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamento do arquivo stream!");
                            }
                        }
                        else
                        {
                            tv = 0;
                        }
                    }
                    catch (FileNotFoundException fe)
                    {
                        prossegue = false;
                        MsgVetor.msg_central ("Arquivo não encontrado!");
                    }
                }

                MsgVetor.msg_central ("Tamanho do arquivo utilizado para a ["+texto+"]: ["+(i+1)+"] linhas!");
            }
        }
        MsgVetor.enter();
        
        return tv;
    }

    public void xarq_salvar_arquivo (String texto)
    {
        //
        // Esta função recebe um vetor populado e, para cada posição (coluna), grava
        // um registro no arquivo de resposta, cujo nome é informado na função.
        //
        MsgVetor.msg_central ("Gravando arquivo de saída da ["+texto+"]");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        int t = nome_arquivo.length();
        
        if ((nome_arquivo.contains("x")) && (t == 1))
        {
            MsgVetor.msg_central ("Não será utilizado arquivo para gravação de dados da ["+texto+"].");
        }
        else
        {
            FileWriter fileWriter = null;

            try
            {
                fileWriter = new FileWriter(nome_arquivo);
            }
            catch (IOException ex)
            {
                MsgVetor.msg_central ("Erro na gravação!");
            }

            PrintWriter writer = new PrintWriter(fileWriter);

            int i = 0;

            do
            {
                writer.write(this.getPosicao(i)+"\n");
                i++;
            }
            while (i < this.limite);

            writer.close();

            try
            {
                fileWriter.close();
                MsgVetor.msg_central ("Arquivo gravado da ["+texto+"] com ["+this.limite+"] linhas!");
            }
            catch (IOException ex)
            {
                MsgVetor.msg_central ("Erro no fechamento do arquivo!");
            }
        }
    }

    public VetorGeral()
    {
        int i = 0;
        
        for (i = 0; i < 1000000; i++)
        {
            vetor[i] = 0;
        }
        
        tamanho = 0;
        limite  = 0;        
    }
}