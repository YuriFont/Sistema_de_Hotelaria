import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaGarcom extends JFrame {
    private List<Conta> contas;
    private JTextField idTextField;  // Adicione estas linhas
    private JTextField valorTextField;  // Adicione estas linhas

    public SistemaGarcom() {

        // Configurações do JFrame
        setTitle("Adicionar Valor à Conta");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Componentes
        JLabel idLabel = new JLabel("ID do Hóspede:");
        idTextField = new JTextField();  // Modificado aqui
        JLabel valorLabel = new JLabel("Valor a Adicionar:");
        valorTextField = new JTextField();  // Modificado aqui
        JButton adicionarButton = new JButton("Adicionar Valor");

        // Adicionando componentes ao painel
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(valorLabel);
        panel.add(valorTextField);
        panel.add(adicionarButton);

        // Ação do botão
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarValorConta();
            }
        });

        // Adicionando o painel ao JFrame
        add(panel);

        // Exibindo a janela
        setVisible(true);
        contas = carregarConta();
    }

    private List<Conta> carregarConta() 
    {
        List<Conta>  contas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("InnControl/registros/contas.txt"))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                double valor = Double.parseDouble(parts[1].trim());
                contas.add(new Conta(id, valor));
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return contas;
    }

    private void salvarConta() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("InnControl/registros/contas.txt"))) {
            for (Conta conta : contas) {
                writer.write(conta.getId() + ", " + conta.getValor());
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar no arquivo.");
        }
    }

    private void adicionarValorConta() {
        try {
            int idHospede = Integer.parseInt(idTextField.getText());
            double valor = Double.parseDouble(valorTextField.getText());

            // Verificando se o ID do hóspede existe
            for(Conta conta : contas)
            {
                if (conta.getId() == idHospede)
                {
                    conta.setValor((conta.getValor() + valor));
                    JOptionPane.showMessageDialog(this, "Valor adicionado com sucesso!");
                }
            }
            salvarConta();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos nos campos.");
        }
    }
}
