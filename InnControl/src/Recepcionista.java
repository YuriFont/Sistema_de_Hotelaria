import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Recepcionista extends Funcionario 
{
    public boolean fazerCheckIn(String nome, int id, String telefone)
    {
        try (FileWriter fileWriter = new FileWriter("InnControl/registros/registros_reserva.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String registro = nome + " - " + id + " - " + telefone;

            // Escreve no arquivo
            bufferedWriter.write(registro);
            bufferedWriter.newLine(); // Adiciona uma nova linha para separar registros

            System.out.println("Reserva realizada com sucesso!");

            return true;

        } catch (IOException e) 
        {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false;
        }
    }
    
    public void fazerCheckOut(Conta conta, Hospede hospede) 
    {
        String nome = hospede.getNome();
        String filePath = "InnControl/registros/registros_reserva.txt";

        try {
            File inputFile = new File(filePath);
            File tempFile = new File("InnControl/registros/temp.txt");

            BufferedReader ler = new BufferedReader(new FileReader(inputFile));
            BufferedWriter escrever = new BufferedWriter(new FileWriter(tempFile));

            String linhaAtual;
            boolean achou = false;

            
            while ((linhaAtual = ler.readLine()) != null) {
                if (linhaAtual.contains(nome)) {
                    linhaAtual += " - Checkout";
                    achou = true;
                }
                escrever.write(linhaAtual + System.lineSeparator());
            }

            escrever.close();
            ler.close();

            // Se o hóspede foi encontrado, exclui o arquivo original e renomeia o arquivo temporário
            if (achou) {
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.err.println("Erro ao renomear o arquivo temporário para o original.");
                    }
                } else {
                    System.err.println("Erro ao excluir o arquivo original.");
                }

                System.out.println("Check-out realizado com sucesso!");
            } else {
                System.out.println("Hóspede não encontrado para check-out.");
            }

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    public double consultarConsumo()
    {
        return 0;
    }
}