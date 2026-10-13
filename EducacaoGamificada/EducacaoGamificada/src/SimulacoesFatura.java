import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class SimulacoesFatura {

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Simulador de Fatura");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel(
                new BorderLayout(20, 20)
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        40,
                        25,
                        40
                )
        );

        JLabel titulo = new JLabel(
                "Simulador de Fatura",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        JLabel subtitulo = new JLabel(
                "Entenda o impacto do pagamento mínimo da fatura",
                SwingConstants.CENTER
        );

        subtitulo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
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
                Box.createVerticalStrut(7)
        );

        painelTitulo.add(subtitulo);

        JPanel painelFormulario = new JPanel(
                new GridLayout(
                        4,
                        2,
                        15,
                        15
                )
        );

        painelFormulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Dados da fatura"
                )
        );

        JLabel labelValorFatura = new JLabel(
                "Valor total da fatura (R$):"
        );

        JTextField campoValorFatura =
                new JTextField();

        JLabel labelPagamento = new JLabel(
                "Forma de pagamento:"
        );

        JComboBox<String> campoPagamento =
                new JComboBox<>(
                        new String[]{
                                "Pagamento Total",
                                "Pagamento Mínimo"
                        }
                );

        JLabel labelPercentualMinimo =
                new JLabel(
                        "Pagamento mínimo (%):"
                );

        JTextField campoPercentualMinimo =
                new JTextField("20");

        JLabel labelTaxa =
                new JLabel(
                        "Juros do rotativo (% ao mês):"
                );

        JTextField campoTaxa =
                new JTextField("12");

        painelFormulario.add(
                labelValorFatura
        );

        painelFormulario.add(
                campoValorFatura
        );

        painelFormulario.add(
                labelPagamento
        );

        painelFormulario.add(
                campoPagamento
        );

        painelFormulario.add(
                labelPercentualMinimo
        );

        painelFormulario.add(
                campoPercentualMinimo
        );

        painelFormulario.add(
                labelTaxa
        );

        painelFormulario.add(
                campoTaxa
        );

        JButton botaoSimular =
                new JButton(
                        "Simular"
                );

        JButton botaoLimpar =
                new JButton(
                        "Limpar"
                );

        JButton botaoComparar =
                new JButton(
                        "Comparar pagamentos"
                );

        botaoComparar.setEnabled(false);

        JPanel painelAcoes = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        5
                )
        );

        painelAcoes.add(
                botaoSimular
        );

        painelAcoes.add(
                botaoLimpar
        );

        painelAcoes.add(
                botaoComparar
        );

        JTextArea resultado =
                new JTextArea();

        resultado.setEditable(false);

        resultado.setLineWrap(true);

        resultado.setWrapStyleWord(true);

        resultado.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        resultado.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        JScrollPane scrollResultado =
                new JScrollPane(
                        resultado
                );

        scrollResultado.setBorder(
                BorderFactory.createTitledBorder(
                        "Resultado da simulação"
                )
        );

        scrollResultado.setPreferredSize(
                new Dimension(
                        650,
                        230
                )
        );

        JPanel painelCentro =
                new JPanel();

        painelCentro.setLayout(
                new BoxLayout(
                        painelCentro,
                        BoxLayout.Y_AXIS
                )
        );

        painelFormulario.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        155
                )
        );

        painelAcoes.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        55
                )
        );

        painelCentro.add(
                painelFormulario
        );

        painelCentro.add(
                Box.createVerticalStrut(15)
        );

        painelCentro.add(
                painelAcoes
        );

        painelCentro.add(
                Box.createVerticalStrut(15)
        );

        painelCentro.add(
                scrollResultado
        );

        JButton botaoVoltar =
                new JButton(
                        "Voltar"
                );

        botaoVoltar.addActionListener(e -> {

            janela.dispose();

            telaAnterior.setVisible(true);

        });

        JPanel painelInferior =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER
                        )
                );

        painelInferior.add(
                botaoVoltar
        );

        NumberFormat formatoDinheiro =
                NumberFormat.getCurrencyInstance(
                        new Locale(
                                "pt",
                                "BR"
                        )
                );

        final double[] dadosComparacao =
                new double[6];

        campoPagamento.addActionListener(e -> {

            String opcao =
                    (String) campoPagamento
                            .getSelectedItem();

            boolean pagamentoMinimo =
                    "Pagamento Mínimo"
                            .equals(opcao);

            campoPercentualMinimo.setEnabled(
                    pagamentoMinimo
            );

            campoTaxa.setEnabled(
                    pagamentoMinimo
            );

        });

        campoPercentualMinimo.setEnabled(false);
        campoTaxa.setEnabled(false);

        botaoSimular.addActionListener(e -> {

            try {

                String valorTexto =
                        campoValorFatura
                                .getText()
                                .trim()
                                .replace(",", ".");

                double valorFatura =
                        Double.parseDouble(
                                valorTexto
                        );

                if (valorFatura <= 0) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "O valor da fatura deve ser maior que zero.",
                            "Valor inválido",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                String formaPagamento =
                        (String) campoPagamento
                                .getSelectedItem();

                double percentualMinimo =
                        Double.parseDouble(
                                campoPercentualMinimo
                                        .getText()
                                        .trim()
                                        .replace(",", ".")
                        );

                double taxa =
                        Double.parseDouble(
                                campoTaxa
                                        .getText()
                                        .trim()
                                        .replace(",", ".")
                        );

                if (percentualMinimo <= 0
                        || percentualMinimo >= 100) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "O pagamento mínimo deve estar entre 1% e 99%.",
                            "Percentual inválido",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                if (taxa < 0) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "A taxa de juros não pode ser negativa.",
                            "Taxa inválida",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                double pagamentoMinimo =
                        valorFatura
                                * percentualMinimo
                                / 100.0;

                double saldoRestante =
                        valorFatura
                                - pagamentoMinimo;

                double juros =
                        saldoRestante
                                * taxa
                                / 100.0;

                double dividaProximoMes =
                        saldoRestante
                                + juros;

                dadosComparacao[0] =
                        valorFatura;

                dadosComparacao[1] =
                        pagamentoMinimo;

                dadosComparacao[2] =
                        saldoRestante;

                dadosComparacao[3] =
                        juros;

                dadosComparacao[4] =
                        dividaProximoMes;

                dadosComparacao[5] =
                        percentualMinimo;

                if ("Pagamento Total".equals(
                        formaPagamento
                )) {

                    resultado.setText(
                            "Forma escolhida: Pagamento Total\n\n"
                                    + "Valor da fatura: "
                                    + formatoDinheiro.format(
                                    valorFatura
                            )
                                    + "\n"
                                    + "Valor pago: "
                                    + formatoDinheiro.format(
                                    valorFatura
                            )
                                    + "\n"
                                    + "Saldo restante: "
                                    + formatoDinheiro.format(
                                    0
                            )
                                    + "\n"
                                    + "Juros: "
                                    + formatoDinheiro.format(
                                    0
                            )
                                    + "\n\n"
                                    + "Consequência:\n"
                                    + "A fatura foi totalmente paga. "
                                    + "Não existe saldo restante sujeito aos juros "
                                    + "do crédito rotativo."
                    );

                } else {

                    resultado.setText(
                            "Forma escolhida: Pagamento Mínimo\n\n"
                                    + "Valor da fatura: "
                                    + formatoDinheiro.format(
                                    valorFatura
                            )
                                    + "\n"
                                    + "Pagamento mínimo: "
                                    + formatoDinheiro.format(
                                    pagamentoMinimo
                            )
                                    + "\n"
                                    + "Saldo não pago: "
                                    + formatoDinheiro.format(
                                    saldoRestante
                            )
                                    + "\n"
                                    + "Juros do próximo período: "
                                    + formatoDinheiro.format(
                                    juros
                            )
                                    + "\n"
                                    + "Dívida projetada para o próximo mês: "
                                    + formatoDinheiro.format(
                                    dividaProximoMes
                            )
                                    + "\n\n"
                                    + "Consequência:\n"
                                    + "Ao pagar somente o mínimo, uma parte da fatura "
                                    + "permanece em aberto e recebe a incidência dos "
                                    + "juros do crédito rotativo."
                    );
                }

                botaoComparar.setEnabled(true);

            } catch (NumberFormatException erro) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Preencha todos os campos com valores numéricos válidos.",
                        "Dados inválidos",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        botaoComparar.addActionListener(e -> {

            double valorFatura =
                    dadosComparacao[0];

            double pagamentoMinimo =
                    dadosComparacao[1];

            double saldoRestante =
                    dadosComparacao[2];

            double juros =
                    dadosComparacao[3];

            double dividaProximoMes =
                    dadosComparacao[4];

            double percentual =
                    dadosComparacao[5];

            JTextArea comparacao =
                    new JTextArea();

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
                    "PAGAMENTO TOTAL\n\n"
                            + "Fatura: "
                            + formatoDinheiro.format(
                            valorFatura
                    )
                            + "\n"
                            + "Valor pago: "
                            + formatoDinheiro.format(
                            valorFatura
                    )
                            + "\n"
                            + "Saldo restante: R$ 0,00\n"
                            + "Juros: R$ 0,00\n\n"

                            + "PAGAMENTO MÍNIMO ("
                            + percentual
                            + "%)\n\n"
                            + "Valor pago: "
                            + formatoDinheiro.format(
                            pagamentoMinimo
                    )
                            + "\n"
                            + "Saldo restante: "
                            + formatoDinheiro.format(
                            saldoRestante
                    )
                            + "\n"
                            + "Juros: "
                            + formatoDinheiro.format(
                            juros
                    )
                            + "\n"
                            + "Dívida projetada: "
                            + formatoDinheiro.format(
                            dividaProximoMes
                    )
                            + "\n\n"
                            + "Comparação:\n"
                            + "O pagamento total encerra a dívida da fatura. "
                            + "O pagamento mínimo reduz o valor desembolsado "
                            + "imediatamente, mas mantém parte da dívida em aberto "
                            + "e gera juros."
            );

            JScrollPane scrollComparacao =
                    new JScrollPane(
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
                    "Comparação das formas de pagamento",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });

        botaoLimpar.addActionListener(e -> {

            campoValorFatura.setText("");

            campoPagamento.setSelectedIndex(0);

            campoPercentualMinimo.setText("20");

            campoTaxa.setText("12");

            resultado.setText("");

            botaoComparar.setEnabled(false);

        });

        painelPrincipal.add(
                painelTitulo,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                painelCentro,
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