import javax.swing.*;
import java.awt.*;

public class TrilhasAluno {

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Trilhas de Aprendizagem");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(25, 35, 25, 35)
        );

        JLabel titulo = new JLabel(
                "Trilhas de Educação Financeira",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 25)
        );

        JLabel subtitulo = new JLabel(
                "Escolha uma trilha para começar",
                SwingConstants.CENTER
        );

        subtitulo.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        JPanel painelTitulo = new JPanel();

        painelTitulo.setLayout(
                new BoxLayout(painelTitulo, BoxLayout.Y_AXIS)
        );

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelTitulo.add(titulo);

        painelTitulo.add(
                Box.createVerticalStrut(8)
        );

        painelTitulo.add(subtitulo);

        painelTitulo.add(
                Box.createVerticalStrut(20)
        );

        JPanel painelTrilhas = new JPanel();

        painelTrilhas.setLayout(
                new BoxLayout(painelTrilhas, BoxLayout.Y_AXIS)
        );

        String[] trilhas = {

                "1. A importância da independência e responsabilidade financeira na juventude",

                "2. Como fazer o primeiro orçamento pessoal e organizar a mesada ou salário",

                "3. Distinção clara entre necessidades, desejos e consumo consciente",

                "4. Como evitar armadilhas comuns: cartão de crédito, compras por impulso e parcelamentos",

                "5. Estratégias práticas para renegociar dívidas e sair do vermelho",

                "6. Como montar a primeira reserva de emergência",

                "7. Entendendo o poder dos juros compostos a seu favor ao começar cedo",

                "8. Introdução simples aos investimentos básicos (Tesouro Direto, CDBs e Caixinhas)",

                "9. Definição e planejamento de metas financeiras (viagens, estudos, primeiro carro)",

                "10. Cuidados com golpes na internet, apostas/bets e promessas de dinheiro fácil",

                "11. Noções essenciais sobre trabalho, fontes de renda extra e empreendedorismo jovem",

                "12. Transição para a vida adulta: custos de morar sozinho e planejamento de longo prazo"
        };

        for (int i = 0; i < trilhas.length; i++) {

            String nomeTrilha = trilhas[i];

            JButton botaoTrilha = new JButton(nomeTrilha);

            botaoTrilha.setFont(
                    new Font("Arial", Font.PLAIN, 14)
            );

            botaoTrilha.setHorizontalAlignment(
                    SwingConstants.LEFT
            );

            botaoTrilha.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            55
                    )
            );

            botaoTrilha.setPreferredSize(
                    new Dimension(
                            720,
                            55
                    )
            );

            int numeroTrilha = i + 1;

            botaoTrilha.addActionListener(e -> {

                abrirTrilha(
                        numeroTrilha,
                        nomeTrilha,
                        janela
                );

            });

            painelTrilhas.add(botaoTrilha);

            painelTrilhas.add(
                    Box.createVerticalStrut(10)
            );
        }

        JScrollPane scroll = new JScrollPane(painelTrilhas);

        scroll.setBorder(null);

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JButton botaoVoltar = new JButton("Voltar");

        botaoVoltar.addActionListener(e -> {

            janela.dispose();

            telaAnterior.setVisible(true);

        });

        JPanel painelInferior = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );

        painelInferior.add(botaoVoltar);

        painelPrincipal.add(
                painelTitulo,
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

        janela.add(painelPrincipal);

        janela.setVisible(true);
    }

    private static void abrirTrilha(
            int numero,
            String nome,
            JFrame telaTrilhas) {

        JFrame janela = new JFrame(
                "Trilha " + numero
        );

        janela.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        janela.setSize(700, 500);

        janela.setLocationRelativeTo(null);

        telaTrilhas.setVisible(false);

        JPanel painel = new JPanel();

        painel.setLayout(
                new BoxLayout(
                        painel,
                        BoxLayout.Y_AXIS
                )
        );

        painel.setBorder(
                BorderFactory.createEmptyBorder(
                        50,
                        50,
                        50,
                        50
                )
        );

        JLabel numeroTrilha = new JLabel(
                "Trilha " + numero
        );

        numeroTrilha.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        numeroTrilha.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel titulo = new JLabel(
                "<html><div style='text-align:center;'>"
                        + nome
                        + "</div></html>"
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel conteudo = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "O conteúdo desta trilha será desenvolvido "
                        + "na próxima etapa."
                        + "</div></html>"
        );

        conteudo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        conteudo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JButton voltar = new JButton(
                "Voltar para as trilhas"
        );

        voltar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        voltar.addActionListener(e -> {

            janela.dispose();

            telaTrilhas.setVisible(true);

        });

        painel.add(numeroTrilha);

        painel.add(
                Box.createVerticalStrut(20)
        );

        painel.add(titulo);

        painel.add(
                Box.createVerticalStrut(40)
        );

        painel.add(conteudo);

        painel.add(
                Box.createVerticalGlue()
        );

        painel.add(voltar);

        janela.add(painel);

        janela.setVisible(true);
    }
}