public class Main 
{
    public static void main(String[] args) 
    {
        Recepcionista recepcionista = new Recepcionista();
        Garcom garcom = new Garcom();
        recepcionista.fazerCheckIn();
        garcom.anotarComanda();
    }
}
