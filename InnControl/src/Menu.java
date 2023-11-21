import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame {

    private JTextField textFieldId, textFieldNome, textFieldEmail, textFieldTelefone;
    private JButton btnAdicionar, btnAtualizar, btnExcluir, btnBuscar, btnListar;
    private List<Hospede> registros;

    public Menu() {
        // Configurações da janela
        setTitle("Menu");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os componentes
        initUI();

        // Carrega os registros do arquivo
        registros = carregarRegistros();
    }

    private void initUI() {
        // Cria os componentes
        textFieldId = new JTextField(10);
        textFieldNome = new JTextField(20);
        textFieldTelefone = new JTextField(20);
        textFieldEmail = new JTextField(20);

        btnAdicionar = new JButton("Adicionar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");
        btnBuscar = new JButton("Buscar");
        btnListar = new JButton("Listar");

        // Adiciona os ouvintes de eventos
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarRegistro();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarRegistro();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirRegistro();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarRegistro();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarRegistros();
            }
        });

        // Layout
        setLayout(new GridLayout(6, 2));
        add(new JLabel("ID:"));
        add(textFieldId);
        add(new JLabel("Nome:"));
        add(textFieldNome);
        add(new JLabel("Telefone:"));
        add(textFieldTelefone);
        add(new JLabel("Email:"));
        add(textFieldEmail);
        add(btnAdicionar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnBuscar);
        add(btnListar);
    }

    private List<Hospede> carregarRegistros() {
        List<Hospede> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("InnControl/registros/registros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String nome = parts[1].trim();
                String telefone = parts[2].trim();
                String email = parts[3].trim();
                registros.add(new Hospede(id, nome, telefone, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registros;
    }

    private void salvarRegistros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("InnControl/registros/registros.txt"))) {
            for (Hospede registro : registros) {
                bw.write(registro.getId() + ", " + registro.getNome() + ", " + registro.getTelefone() + ", " + registro.getEmail());
                bw.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adicionarRegistro() {
        String nome = textFieldNome.getText();
        String telefone = textFieldTelefone.getText();
        String email = textFieldEmail.getText();

        int id = registros.isEmpty() ? 1 : registros.get(registros.size() - 1).getId() + 1; 
        Hospede novoRegistro = new Hospede(id, nome, telefone, email);
        registros.add(novoRegistro);

        salvarRegistros();
        JOptionPane.showMessageDialog(this, "Registro adicionado com sucesso.");
        limpartextField();
    }

    private void atualizarRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Hospede registro : registros) {
            if (registro.getId() == id) {
                registro.setNome(textFieldNome.getText());
                registro.setTelefone(textFieldTelefone.getText());
                registro.setEmail(textFieldEmail.getText());
                salvarRegistros();
                JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso.");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
        limpartextField();
    }

    private void excluirRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Hospede registro : registros) {
            if (registro.getId() == id) {
                registros.remove(registro);
                salvarRegistros();
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso.");
                limpartextField();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
        limpartextField();
    }

    private void buscarRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Hospede registro : registros) {
            if (registro.getId() == id) {
                textFieldNome.setText(registro.getNome());
                textFieldTelefone.setText(registro.getTelefone());
                textFieldEmail.setText(registro.getEmail());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
    }

    private void listarRegistros() {
        StringBuilder result = new StringBuilder("Lista de Registros:\n"); 
        for (Hospede registro : registros) {
            result.append("ID: ").append(registro.getId()).append(", Nome: ").append(registro.getNome()).append(", Telefone: ").append(registro.getTelefone()).append(", Email: ").append(registro.getEmail()).append("\n"); 
        }
        JOptionPane.showMessageDialog(this, result.toString()); 
    }

    private void limpartextField()
    {
        textFieldId.setText("");
        textFieldNome.setText("");
        textFieldTelefone.setText("");
        textFieldEmail.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true); 
            }
        });
    }
}



