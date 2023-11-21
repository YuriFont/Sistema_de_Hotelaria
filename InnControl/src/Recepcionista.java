import javax.swing.SwingUtilities;

public class Recepcionista extends Funcionario 
{
<<<<<<< HEAD
    
=======
    public void fazerCheckIn()
    {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {    
                new Menu().setVisible(true); 
            }
        });
    }

    public void fazerCheckOut() 
    {
        SwingUtilities.invokeLater(new Runnable() 
            {   
                public void run() {    
                    new Menu().setVisible(true); 
            }
        });
    }

    public double consultarConsumo()
    {
        return 0;
    }
>>>>>>> f9b6c8915fec795670dfb471554ee6e972499856
}