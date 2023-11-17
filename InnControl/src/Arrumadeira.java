import java.util.Scanner;

public class Arrumadeira extends Funcionario 
{
    private Scanner scanner;

    public Arrumadeira() {
        this.scanner = new Scanner(System.in);
    }

    public double registrarConsumo()
    {
        System.out.println("Digite o valor do consumo: ");
        double valor = scanner.nextDouble();
        return valor;
    }

    public void fecharScanner() {
        scanner.close();
    }
}
