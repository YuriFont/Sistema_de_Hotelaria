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

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false;
        }
    }
    
    public void fazerCheckOut(Conta conta, Hospede hospede) {
        String nome = hospede.getNome();
        String filePath = "InnControl/registros/registros_reserva.txt";

        try {
            File inputFile = new File(filePath);
            File tempFile = new File("InnControl/registros/temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean found = false;

            // Read each line from the original file and write to the temporary file
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(nome)) {
                    currentLine += " - Checkout";
                    found = true;
                }
                writer.write(currentLine + System.lineSeparator());
            }

            writer.close();
            reader.close();

            // Replace the original file with the temporary file
            if (found) {
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