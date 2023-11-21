/*
 * FELIPE MACEDO KELNER (1220106097)
 * MIGUEL DE MOURA LOBATO (1220109077)
 * RAFAEL CEZAR COELHO DA MOTA (1220103200)
 * YURI FONTENELE SILVA (1220105046)
 */

import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        List<Hospede> list = new ArrayList<>();

        Hospede hospede1 = new Hospede("Joao", "123456789");
        hospede1.realizarReserva();
        list.add(hospede1);
        Hospede hospede2 = new Hospede("Maria", "987654321");
        hospede2.realizarReserva();
        list.add(hospede2);

        /*Conta conta1 = new Conta(1, "Joao", hospede1);
        Conta conta2 = new Conta(2, "Maria", hospede2);
        
        Arrumadeira arrumadeira = new Arrumadeira();
        conta1.setValor(arrumadeira.registrarConsumo());
        arrumadeira.fecharScanner();
        
        hospede2.pagarConta(conta2, hospede2);*/
    }

    public void addHospede(List<Hospede> list, String nome, int id, String telefone)
    {
        list.add(new Hospede(nome, telefone));
    }

}
