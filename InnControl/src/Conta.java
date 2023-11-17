public class Conta
{
    private int numeroDaConta;
    private String nomeDoHospede;
    private double valor;
    private Hospede hospede;


    public Conta()
    {

    }

    public Conta(int numeroDaConta, String nomeDoHospede, Hospede hospede)
    {
        this.numeroDaConta = numeroDaConta;
        this.nomeDoHospede = nomeDoHospede;
        this.hospede = hospede;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public double getValor() 
    {
        return valor;
    }

    public void setValor(double valor) 
    {
        this.valor = valor;
    }

    public int getNumeroDaConta()
    {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta)
    {
        this.numeroDaConta = numeroDaConta;
    }

    public String getNomeDoHospede()
    {
        return nomeDoHospede;
    }

    public void setNomeDoHospede(String nomeDoHospede)
    {
        this.nomeDoHospede = nomeDoHospede;
    }    
}
