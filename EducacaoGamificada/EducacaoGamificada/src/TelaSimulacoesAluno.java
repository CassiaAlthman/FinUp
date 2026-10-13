import javax.swing.*;
import java.awt.*;

public class TelaSimulacoesAluno {

    public static void abrir(JFrame telaAnterior) {

        JFrame janelaSimulacoes = new JFrame("Simulações Financeiras");
        janelaSimulacoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaSimulacoes.setSize(850, 650);
        janelaSimulacoes.setLocationRelativeTo(null);
        janelaSimulacoes.setResizable(false);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(
                new BoxLayout(
                        painelPrincipal,
                        BoxLayout.Y_AXIS
                )
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        70,
                        100,
                        70,
                        100
                )
        );

        JLabel titulo = new JLabel(
                "Simulações Financeiras"
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitulo = new JLabel(
                "Escolha uma ferramenta para começar"
        );

        subtitulo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JButton botaoCenarios = new JButton(
                "Cenários Financeiros"
        );

        JButton botaoJuros = new JButton(
                "Simulador de Juros"
        );

        JButton botaoFatura = new JButton(
                "Simulador de Fatura"
        );

        Dimension tamanhoBotao = new Dimension(
                300,
                60
        );

        botaoCenarios.setMaximumSize(
                tamanhoBotao
        );

        botaoJuros.setMaximumSize(
                tamanhoBotao
        );

        botaoFatura.setMaximumSize(
                tamanhoBotao
        );

        botaoCenarios.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoJuros.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoFatura.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoCenarios.addActionListener(e -> {

            janelaSimulacoes.setVisible(false);

            CenariosFinanceiros.abrir(
                    janelaSimulacoes
            );

        });

        botaoJuros.addActionListener(e -> {

            janelaSimulacoes.setVisible(false);

            SimulacoesJuros.abrir(
                    janelaSimulacoes
            );

        });

        botaoFatura.addActionListener(e -> {

            janelaSimulacoes.setVisible(false);

            SimulacoesFatura.abrir(
                    janelaSimulacoes
            );

        });

        JButton botaoVoltar = new JButton(
                "Voltar"
        );

        botaoVoltar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoVoltar.addActionListener(e -> {

            janelaSimulacoes.dispose();

            telaAnterior.setVisible(true);

        });

        painelPrincipal.add(
                titulo
        );

        painelPrincipal.add(
                Box.createVerticalStrut(10)
        );

        painelPrincipal.add(
                subtitulo
        );

        painelPrincipal.add(
                Box.createVerticalStrut(60)
        );

        painelPrincipal.add(
                botaoCenarios
        );

        painelPrincipal.add(
                Box.createVerticalStrut(20)
        );

        painelPrincipal.add(
                botaoJuros
        );

        painelPrincipal.add(
                Box.createVerticalStrut(20)
        );

        painelPrincipal.add(
                botaoFatura
        );

        painelPrincipal.add(
                Box.createVerticalGlue()
        );

        painelPrincipal.add(
                botaoVoltar
        );

        janelaSimulacoes.add(
                painelPrincipal
        );

        janelaSimulacoes.setVisible(true);
    }
}