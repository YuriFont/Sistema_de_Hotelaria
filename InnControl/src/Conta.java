public class Conta
{
    private int id;
    private double valor;


    public Conta()
    {

    }

    public Conta(int id, double valor)
    {
        this.id = id;
        this.valor = valor;
    }

    public double getValor() 
    {
        return valor;
    }

    public void setValor(double valor) 
    {
        this.valor = valor;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }    
}
