import java.io.BufferedWriter;
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
}