import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TelaAdicionarValor extends JFrame {
    private Map<Integer, Double> contasHospedes;
    private JTextField idTextField;  // Adicione estas linhas
    private JTextField valorTextField;  // Adicione estas linhas

    public TelaAdicionarValor() {
        contasHospedes = new HashMap<>();

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
    }

    private void adicionarValorConta() {
        try {
            int idHospede = Integer.parseInt(idTextField.getText());
            double valor = Double.parseDouble(valorTextField.getText());

            // Verificando se o ID do hóspede existe
            if (contasHospedes.containsKey(idHospede)) {
                // Adicionando o valor à conta do hóspede
                double valorAtual = contasHospedes.get(idHospede);
                contasHospedes.put(idHospede, valorAtual + valor);
                JOptionPane.showMessageDialog(this, "Valor adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Hóspede não encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos nos campos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaAdicionarValor();
            }
        });
    }
}
