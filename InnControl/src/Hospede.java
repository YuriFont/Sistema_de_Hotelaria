
public class Hospede 
{
    private String nome;
    private int id;
    private String telefone;

    public Hospede()
    {

    }

    public Hospede(String nome, int id, String telefone) 
    {
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
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
}
