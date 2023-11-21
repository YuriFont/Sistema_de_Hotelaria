import javax.swing.SwingUtilities;

public class Garcom extends Funcionario
{
    public void anotarComanda()
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaGarcom().setVisible(true);
            }
        });
    }
}
