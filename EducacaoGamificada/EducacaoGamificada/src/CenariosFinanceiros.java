import javax.swing.*;
import java.awt.*;

public class CenariosFinanceiros {

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Cenários Financeiros");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        35,
                        25,
                        35
                )
        );

        JLabel titulo = new JLabel(
                "Cenários Financeiros",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        JLabel subtitulo = new JLabel(
                "Escolha um cenário para começar",
                SwingConstants.CENTER
        );

        subtitulo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        JPanel painelTitulo = new JPanel();

        painelTitulo.setLayout(
                new BoxLayout(
                        painelTitulo,
                        BoxLayout.Y_AXIS
                )
        );

        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        subtitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        painelTitulo.add(titulo);

        painelTitulo.add(
                Box.createVerticalStrut(8)
        );

        painelTitulo.add(subtitulo);

        painelTitulo.add(
                Box.createVerticalStrut(20)
        );

        JPanel painelCenarios = new JPanel();

        painelCenarios.setLayout(
                new BoxLayout(
                        painelCenarios,
                        BoxLayout.Y_AXIS
                )
        );

        JButton botaoNotebook = new JButton(
                "1. Comprar um notebook"
        );

        JButton botaoPrimeiroSalario = new JButton(
                "2. Recebeu o primeiro salário"
        );

        Dimension tamanhoBotao = new Dimension(
                720,
                55
        );

        botaoNotebook.setMaximumSize(
                tamanhoBotao
        );

        botaoPrimeiroSalario.setMaximumSize(
                tamanhoBotao
        );

        botaoNotebook.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        botaoPrimeiroSalario.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        botaoNotebook.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        botaoPrimeiroSalario.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        botaoNotebook.addActionListener(e -> {

            janela.setVisible(false);

            abrirCenarioNotebook(
                    janela
            );

        });

        botaoPrimeiroSalario.addActionListener(e -> {

            janela.setVisible(false);

            abrirCenarioPrimeiroSalario(
                    janela
            );

        });

        painelCenarios.add(
                botaoNotebook
        );

        painelCenarios.add(
                Box.createVerticalStrut(10)
        );

        painelCenarios.add(
                botaoPrimeiroSalario
        );

        JScrollPane scroll = new JScrollPane(
                painelCenarios
        );

        scroll.setBorder(null);

        scroll.getVerticalScrollBar()
                .setUnitIncrement(16);

        JButton botaoVoltar = new JButton(
                "Voltar"
        );

        botaoVoltar.addActionListener(e -> {

            janela.dispose();

            telaAnterior.setVisible(true);

        });

        JPanel painelInferior = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER
                )
        );

        painelInferior.add(
                botaoVoltar
        );

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

        janela.add(
                painelPrincipal
        );

        janela.setVisible(true);
    }

    private static void abrirCenarioNotebook(
            JFrame telaCenarios) {

        JFrame janela = new JFrame(
                "Comprar um notebook"
        );

        janela.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        janela.setSize(
                850,
                650
        );

        janela.setLocationRelativeTo(
                null
        );

        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel(
                new BorderLayout(
                        20,
                        20
                )
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );

        JLabel titulo = new JLabel(
                "Comprar um notebook",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        JPanel painelCenario = new JPanel();

        painelCenario.setLayout(
                new BoxLayout(
                        painelCenario,
                        BoxLayout.Y_AXIS
                )
        );

        painelCenario.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Color.LIGHT_GRAY
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                30,
                                25,
                                30
                        )
                )
        );

        JLabel descricao = new JLabel(
                "<html>"
                        + "<div style='text-align:center; width:600px;'>"
                        + "Você possui R$ 3.000 disponíveis e precisa comprar "
                        + "um notebook que custa R$ 2.500. "
                        + "Qual decisão você tomaria?"
                        + "</div>"
                        + "</html>"
        );

        descricao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        descricao.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JPanel painelDecisoes = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        10
                )
        );

        JButton botaoVista = new JButton(
                "Comprar à vista"
        );

        JButton botaoParcelar = new JButton(
                "Parcelar"
        );

        JButton botaoEsperar = new JButton(
                "Comprar depois"
        );

        Dimension tamanhoBotao = new Dimension(
                180,
                45
        );

        botaoVista.setPreferredSize(
                tamanhoBotao
        );

        botaoParcelar.setPreferredSize(
                tamanhoBotao
        );

        botaoEsperar.setPreferredSize(
                tamanhoBotao
        );

        painelDecisoes.add(
                botaoVista
        );

        painelDecisoes.add(
                botaoParcelar
        );

        painelDecisoes.add(
                botaoEsperar
        );

        JTextArea resultado = new JTextArea();

        resultado.setEditable(false);

        resultado.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);

        resultado.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(
                                "Resultado da sua decisão"
                        ),
                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        resultado.setPreferredSize(
                new Dimension(
                        650,
                        150
                )
        );

        JButton botaoComparar = new JButton(
                "Comparar decisões"
        );

        botaoComparar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoComparar.setEnabled(false);

        botaoVista.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Comprar à vista\n\n"
                            + "Saldo inicial: R$ 3.000,00\n"
                            + "Valor do notebook: R$ 2.500,00\n"
                            + "Saldo restante: R$ 500,00\n"
                            + "Dívida: R$ 0,00\n\n"
                            + "Consequência:\n"
                            + "Você evita juros e não cria uma dívida, "
                            + "mas utiliza grande parte do dinheiro disponível "
                            + "e fica com uma reserva menor para emergências."
            );

            botaoComparar.setEnabled(true);

        });

        botaoParcelar.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Parcelar o notebook\n\n"
                            + "Saldo inicial: R$ 3.000,00\n"
                            + "Valor à vista: R$ 2.500,00\n"
                            + "Parcelamento: 10 parcelas de R$ 290,00\n"
                            + "Valor total pago: R$ 2.900,00\n"
                            + "Custo adicional: R$ 400,00\n\n"
                            + "Consequência:\n"
                            + "Você preserva parte do dinheiro no curto prazo, "
                            + "mas assume uma dívida mensal e paga R$ 400,00 "
                            + "a mais pelo notebook."
            );

            botaoComparar.setEnabled(true);

        });

        botaoEsperar.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Esperar para comprar\n\n"
                            + "Saldo atual: R$ 3.000,00\n"
                            + "Dívida: R$ 0,00\n"
                            + "Valor gasto agora: R$ 0,00\n\n"
                            + "Consequência:\n"
                            + "Você mantém sua reserva financeira e não assume "
                            + "uma dívida. Em contrapartida, precisará esperar "
                            + "mais tempo para adquirir o notebook."
            );

            botaoComparar.setEnabled(true);

        });

        botaoComparar.addActionListener(e -> {

            JTextArea comparacao = new JTextArea();

            comparacao.setEditable(false);

            comparacao.setLineWrap(true);

            comparacao.setWrapStyleWord(true);

            comparacao.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            comparacao.setText(
                    "COMPRAR À VISTA\n"
                            + "Custo total: R$ 2.500,00\n"
                            + "Saldo restante: R$ 500,00\n"
                            + "Dívida: R$ 0,00\n\n"

                            + "PARCELAR\n"
                            + "Custo total: R$ 2.900,00\n"
                            + "Custo adicional: R$ 400,00\n"
                            + "Dívida assumida: R$ 2.900,00\n\n"

                            + "COMPRAR DEPOIS\n"
                            + "Custo imediato: R$ 0,00\n"
                            + "Saldo preservado: R$ 3.000,00\n"
                            + "Dívida: R$ 0,00"
            );

            JScrollPane scrollComparacao = new JScrollPane(
                    comparacao
            );

            scrollComparacao.setPreferredSize(
                    new Dimension(
                            550,
                            350
                    )
            );

            JOptionPane.showMessageDialog(
                    janela,
                    scrollComparacao,
                    "Comparação entre decisões",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        JButton botaoVoltar = new JButton(
                "Voltar para os cenários"
        );

        botaoVoltar.addActionListener(e -> {

            janela.dispose();

            telaCenarios.setVisible(true);

        });

        JPanel painelInferior = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER
                )
        );

        painelInferior.add(
                botaoVoltar
        );

        painelCenario.add(
                descricao
        );

        painelCenario.add(
                Box.createVerticalStrut(25)
        );

        painelCenario.add(
                painelDecisoes
        );

        painelCenario.add(
                Box.createVerticalStrut(20)
        );

        painelCenario.add(
                resultado
        );

        painelCenario.add(
                Box.createVerticalStrut(15)
        );

        painelCenario.add(
                botaoComparar
        );

        painelPrincipal.add(
                titulo,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                painelCenario,
                BorderLayout.CENTER
        );

        painelPrincipal.add(
                painelInferior,
                BorderLayout.SOUTH
        );

        janela.add(
                painelPrincipal
        );

        janela.setVisible(true);
    }

    private static void abrirCenarioPrimeiroSalario(
            JFrame telaCenarios) {

        JFrame janela = new JFrame(
                "Recebeu o primeiro salário"
        );

        janela.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        janela.setSize(
                850,
                650
        );

        janela.setLocationRelativeTo(
                null
        );

        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel(
                new BorderLayout(
                        20,
                        20
                )
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );

        JLabel titulo = new JLabel(
                "Recebeu o primeiro salário",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        JPanel painelCenario = new JPanel();

        painelCenario.setLayout(
                new BoxLayout(
                        painelCenario,
                        BoxLayout.Y_AXIS
                )
        );

        painelCenario.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Color.LIGHT_GRAY
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                30,
                                25,
                                30
                        )
                )
        );

        JLabel descricao = new JLabel(
                "<html>"
                        + "<div style='text-align:center; width:600px;'>"
                        + "Você recebeu seu primeiro salário de R$ 2.000. "
                        + "Depois de pagar suas despesas essenciais, restaram "
                        + "R$ 800. O que você faria com esse dinheiro?"
                        + "</div>"
                        + "</html>"
        );

        descricao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        descricao.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JPanel painelDecisoes = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        10
                )
        );

        JButton botaoGastar = new JButton(
                "Gastar tudo"
        );

        JButton botaoDividir = new JButton(
                "Dividir o dinheiro"
        );

        JButton botaoGuardar = new JButton(
                "Guardar tudo"
        );

        Dimension tamanhoBotao = new Dimension(
                180,
                45
        );

        botaoGastar.setPreferredSize(
                tamanhoBotao
        );

        botaoDividir.setPreferredSize(
                tamanhoBotao
        );

        botaoGuardar.setPreferredSize(
                tamanhoBotao
        );

        painelDecisoes.add(
                botaoGastar
        );

        painelDecisoes.add(
                botaoDividir
        );

        painelDecisoes.add(
                botaoGuardar
        );

        JTextArea resultado = new JTextArea();

        resultado.setEditable(false);

        resultado.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        resultado.setLineWrap(true);

        resultado.setWrapStyleWord(true);

        resultado.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(
                                "Resultado da sua decisão"
                        ),
                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        resultado.setPreferredSize(
                new Dimension(
                        650,
                        150
                )
        );

        JButton botaoComparar = new JButton(
                "Comparar decisões"
        );

        botaoComparar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        botaoComparar.setEnabled(false);

        botaoGastar.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Gastar todo o dinheiro restante\n\n"
                            + "Valor disponível: R$ 800,00\n"
                            + "Valor gasto: R$ 800,00\n"
                            + "Valor guardado: R$ 0,00\n\n"
                            + "Consequência:\n"
                            + "Você aproveita o dinheiro imediatamente, "
                            + "mas termina o mês sem nenhuma reserva para "
                            + "emergências ou objetivos futuros."
            );

            botaoComparar.setEnabled(true);

        });

        botaoDividir.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Dividir o dinheiro\n\n"
                            + "Valor disponível: R$ 800,00\n"
                            + "R$ 400,00 para lazer e desejos\n"
                            + "R$ 400,00 para reserva ou investimento\n\n"
                            + "Consequência:\n"
                            + "Você consegue aproveitar parte do salário "
                            + "e ao mesmo tempo começa a construir uma reserva."
            );

            botaoComparar.setEnabled(true);

        });

        botaoGuardar.addActionListener(e -> {

            resultado.setText(
                    "Decisão: Guardar todo o dinheiro restante\n\n"
                            + "Valor disponível: R$ 800,00\n"
                            + "Valor guardado: R$ 800,00\n"
                            + "Valor gasto com desejos: R$ 0,00\n\n"
                            + "Consequência:\n"
                            + "Sua reserva cresce mais rapidamente, "
                            + "mas você abre mão de utilizar parte do salário "
                            + "para lazer ou consumo pessoal."
            );

            botaoComparar.setEnabled(true);

        });

        botaoComparar.addActionListener(e -> {

            JTextArea comparacao = new JTextArea();

            comparacao.setEditable(false);

            comparacao.setLineWrap(true);

            comparacao.setWrapStyleWord(true);

            comparacao.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            comparacao.setText(
                    "GASTAR TUDO\n"
                            + "Valor gasto: R$ 800,00\n"
                            + "Valor guardado: R$ 0,00\n\n"

                            + "DIVIDIR O DINHEIRO\n"
                            + "Valor gasto: R$ 400,00\n"
                            + "Valor guardado: R$ 400,00\n\n"

                            + "GUARDAR TUDO\n"
                            + "Valor gasto: R$ 0,00\n"
                            + "Valor guardado: R$ 800,00\n\n"

                            + "Comparação:\n"
                            + "Gastar tudo oferece satisfação imediata, "
                            + "mas não cria reserva. Guardar tudo maximiza "
                            + "a economia, enquanto dividir o dinheiro permite "
                            + "equilibrar consumo atual e planejamento futuro."
            );

            JScrollPane scrollComparacao = new JScrollPane(
                    comparacao
            );

            scrollComparacao.setPreferredSize(
                    new Dimension(
                            550,
                            350
                    )
            );

            JOptionPane.showMessageDialog(
                    janela,
                    scrollComparacao,
                    "Comparação entre decisões",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        JButton botaoVoltar = new JButton(
                "Voltar para os cenários"
        );

        botaoVoltar.addActionListener(e -> {

            janela.dispose();

            telaCenarios.setVisible(true);

        });

        JPanel painelInferior = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER
                )
        );

        painelInferior.add(
                botaoVoltar
        );

        painelCenario.add(
                descricao
        );

        painelCenario.add(
                Box.createVerticalStrut(25)
        );

        painelCenario.add(
                painelDecisoes
        );

        painelCenario.add(
                Box.createVerticalStrut(20)
        );

        painelCenario.add(
                resultado
        );

        painelCenario.add(
                Box.createVerticalStrut(15)
        );

        painelCenario.add(
                botaoComparar
        );

        painelPrincipal.add(
                titulo,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                painelCenario,
                BorderLayout.CENTER
        );

        painelPrincipal.add(
                painelInferior,
                BorderLayout.SOUTH
        );

        janela.add(
                painelPrincipal
        );

        janela.setVisible(true);
    }
}