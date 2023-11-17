/*
 * FELIPE MACEDO KELNER (1220106097)
 * MIGUEL DE MOURA LOBATO (1220109077)
 * RAFAEL CEZAR COELHO DA MOTA (1220103200)
 * YURI FONTENELE SILVA (1220105046)
 */

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Hospede hospede1 = new Hospede("Joao", 1, "123456789");
        hospede1.realizarReserva();
        Hospede hospede2 = new Hospede("Maria", 2, "987654321");
        hospede2.realizarReserva();

        Conta conta1 = new Conta(1, "Joao", hospede1);
        Conta conta2 = new Conta(2, "Maria", hospede2);

        Arrumadeira arrumadeira = new Arrumadeira();
        conta1.setValor(arrumadeira.registrarConsumo());
        arrumadeira.fecharScanner();

        hospede2.pagarConta(conta2, hospede2);
    }
}
