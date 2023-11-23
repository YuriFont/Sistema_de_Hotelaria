import javax.swing.SwingUtilities;

public class Recepcionista extends Funcionario 
{
    public void fazerCheckIn()
    {
        SwingUtilities.invokeLater(new Runnable()
        {   
            public void run()
            {    
                new ManterHospede().setVisible(true); 
            }
        });
    }

    public void fazerCheckOut() 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {   
            public void run()
            {    
                new ManterHospede().setVisible(true); 
            }
        });
    }
}