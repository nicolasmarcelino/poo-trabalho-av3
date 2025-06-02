import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegistroDeProduto {
    // Frame
    private JFrame frame;
    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField precoField;

    // App
    private ArrayList<Produto> produtos;

    public RegistroDeProduto() {
        // Inicializa lista
        produtos = new ArrayList<Produto>();

        // Create the frame
        JFrame frame = new JFrame("Registro de produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Main panel with vertical stacking
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create label + input pairs
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Nome:");
        JTextField input1 = new JTextField(15);
        panel1.add(label1);
        panel1.add(input1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Descrição:");
        JTextField input2 = new JTextField(15);
        panel2.add(label2);
        panel2.add(input2);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Preço:");
        JTextField input3 = new JTextField(15);
        panel3.add(label3);
        panel3.add(input3);

        // Add sub-panels to main panel with spacing
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        JButton adcNaLista = new JButton("Adicionar produto na lista");
        JButton adcNoArquivo = new JButton("Adicionar o produto no arquivo");
        buttonPanel.add(adcNaLista);
        buttonPanel.add(adcNoArquivo);

        // Add buttons panel to main panel
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        frame.add(mainPanel);


        /*
            input1 ---> nome
            input2 ---> descricao
            input3 ---> preco
        */

        adcNaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resgata valores
                String nome = input1.getText();
                String descricao = input2.getText();
                String preco = input3.getText();
                // Cria produto
                Produto produto_obj = new Produto(nome, descricao, preco);
                // Adiciona na lista
                produtos.add(produto_obj);

                for (Produto produto : produtos) {
                    System.out.print(produto.getNome() + " | " + produto.getDescricao() + " | " + produto.getPreco());
                    System.out.print("\n");
                }

                System.out.println("O produto foi registrado na lista.\n");
            }
        });

        adcNoArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("O produto foi registrado no arquivo.");
            }
        });

        frame.setVisible(true);
    } 
}