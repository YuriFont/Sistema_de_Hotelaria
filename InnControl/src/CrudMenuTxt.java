import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrudMenuTxt extends JFrame {

    private JTextField textFieldId, textFieldNome, textFieldEmail;
    private JButton btnAdicionar, btnAtualizar, btnExcluir, btnBuscar, btnListar;
    private List<Registro> registros;

    public CrudMenuTxt() {
        // Configurações da janela
        setTitle("Menu CRUD");
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
        add(new JLabel("Email:"));
        add(textFieldEmail);
        add(btnAdicionar);
        add(btnAtualizar);
        add(btnExcluir);
        add(btnBuscar);
        add(btnListar);
    }

    private List<Registro> carregarRegistros() {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("registros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String nome = parts[1].trim();
                String email = parts[2].trim();
                registros.add(new Registro(id, nome, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registros;
    }

    private void salvarRegistros() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("registros.txt"))) {
            for (Registro registro : registros) {
                bw.write(registro.getId() + ", " + registro.getNome() + ", " + registro.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adicionarRegistro() {
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();

        int id = registros.isEmpty() ? 1 : registros.get(registros.size() - 1).getId() + 1;
        Registro novoRegistro = new Registro(id, nome, email);
        registros.add(novoRegistro);

        salvarRegistros();
        JOptionPane.showMessageDialog(this, "Registro adicionado com sucesso.");
    }

    private void atualizarRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Registro registro : registros) {
            if (registro.getId() == id) {
                registro.setNome(textFieldNome.getText());
                registro.setEmail(textFieldEmail.getText());
                salvarRegistros();
                JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso.");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
    }

    private void excluirRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Registro registro : registros) {
            if (registro.getId() == id) {
                registros.remove(registro);
                salvarRegistros();
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso.");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
    }

    private void buscarRegistro() {
        String idStr = textFieldId.getText();
        int id = Integer.parseInt(idStr);

        for (Registro registro : registros) {
            if (registro.getId() == id) {
                textFieldNome.setText(registro.getNome());
                textFieldEmail.setText(registro.getEmail());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Registro não encontrado.");
    }

    private void listarRegistros() {
        StringBuilder result = new StringBuilder("Lista de Registros:\n");
        for (Registro registro : registros) {
            result.append("ID: ").append(registro.getId()).append(", Nome: ").append(registro.getNome()).append(", Email: ").append(registro.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(this, result.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CrudMenuTxt().setVisible(true);
            }
        });
    }
}

class Registro {
    private int id;
    private String nome;
    private String email;

    public Registro(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

