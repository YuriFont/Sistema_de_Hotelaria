import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Recepcionista extends Funcionario 
{
    public boolean fazerCheckIn(String nome, int id, String telefone)
    {
        try (FileWriter fileWriter = new FileWriter("InnControl/registros/registros_reserva.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) { 

            // Formato: Nome - ID - Telefone
            String registro = nome + " - " + id + " - " + telefone;

            // Escrever no arquivo
            bufferedWriter.write(registro);
            bufferedWriter.newLine(); // Adicionar uma nova linha para separar registros

            System.out.println("Reserva realizada com sucesso!");

            return true; // Indicar que a reserva foi realizada com sucesso

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false; // Indicar que ocorreu um erro ao escrever no arquivo
        }
    }
}