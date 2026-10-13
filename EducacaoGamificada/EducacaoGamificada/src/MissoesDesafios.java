import javax.swing.*;
import java.awt.*;

public class MissoesDesafios {

    public static void abrir(JFrame telaAnterior) {

        JFrame janelaDesafios = new JFrame("Missões");
        janelaDesafios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaDesafios.setSize(850, 650);
        janelaDesafios.setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout(20, 20));

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        );

        JLabel titulo = new JLabel(
                "Quadro de Missões",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        JPanel painelMissoes = new JPanel();

        painelMissoes.setLayout(
                new BoxLayout(
                        painelMissoes,
                        BoxLayout.Y_AXIS
                )
        );

        adicionarMissao(
                painelMissoes,
                "Missão 1: Raio-X da Carteira",
                "Anotar 100% dos seus gastos durante 7 dias."
        );

        adicionarMissao(
                painelMissoes,
                "Missão 2: O Desafio 50/30/20",
                "Dividir sua renda ou mesada nas categorias de necessidades, desejos e investimentos."
        );

        adicionarMissao(
                painelMissoes,
                "Missão 3: Permanência",
                "Assista 10 aulas."
        );

        adicionarMissao(
                painelMissoes,
                "Missão 4: Detector de Armadilhas",
                "Analisar uma fatura de cartão de crédito e identificar juros, parcelas e taxas."
        );

        adicionarMissao(
                painelMissoes,
                "Missão 5: Escudo de Emergência",
                "Calcular o valor necessário para cobrir de 3 a 6 meses do seu custo de vida."
        );

        JScrollPane scroll = new JScrollPane(painelMissoes);

        scroll.setBorder(null);

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JButton botaoVoltar = new JButton("Voltar");

        botaoVoltar.addActionListener(e -> {

            janelaDesafios.dispose();

            telaAnterior.setVisible(true);

        });

        JPanel painelInferior = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );

        painelInferior.add(botaoVoltar);

        painelPrincipal.add(
                titulo,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                scroll,
                BorderLayout.CENTER
        );

        painelPrincipal.add(
                painelInferior,
                BorderLayout.SOUTH
        );

        janelaDesafios.add(painelPrincipal);

        janelaDesafios.setVisible(true);
    }

    private static void adicionarMissao(
            JPanel painel,
            String titulo,
            String descricao) {

        JPanel quadroMissao = new JPanel();

        quadroMissao.setLayout(
                new BoxLayout(
                        quadroMissao,
                        BoxLayout.Y_AXIS
                )
        );

        quadroMissao.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                        BorderFactory.createEmptyBorder(
                                15,
                                20,
                                15,
                                20
                        )
                )
        );

        quadroMissao.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        110
                )
        );

        JLabel tituloMissao = new JLabel(titulo);

        tituloMissao.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        JLabel descricaoMissao = new JLabel(
                "<html>"
                        + descricao
                        + "</html>"
        );

        descricaoMissao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        quadroMissao.add(tituloMissao);

        quadroMissao.add(
                Box.createVerticalStrut(8)
        );

        quadroMissao.add(descricaoMissao);

        painel.add(quadroMissao);

        painel.add(
                Box.createVerticalStrut(12)
        );
    }
}