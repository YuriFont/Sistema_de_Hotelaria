import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Hospede 
{
    private String nome;
    private int id;
    private String telefone;

    private List<Integer> ids;

    public Hospede()
    {

    }

    public Hospede(String nome, String telefone) 
    {
        if (this.ids == null) {
        this.ids = new ArrayList<>();
        }
        sorteiaNumero();
        this.nome = nome;
        this.telefone = telefone;
        this.realizarReserva();
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public void realizarReserva() 
    {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.fazerCheckIn(this.nome, this.id, this.telefone);
    }

    public void pagarConta(Conta conta, Hospede hospede)
    {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.fazerCheckOut(conta, hospede);
    }

    public void sorteiaNumero() 
    {
        if (this.ids.contains(this.id)) {
            System.out.println("ID já existe!");
            return;
        }

        Random random = new Random();
        int numero = random.nextInt(1000);
        this.ids.add(numero);
        this.id = numero;

    }
    
    public String toString()
    {
        return ("Id: " + id + '\n' + "Name: " + nome + '\n' + "Telefone: " + telefone);
    }
}
