import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class SimulacoesJuros {

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Simulador de Juros");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout(20, 20));

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        40,
                        25,
                        40
                )
        );

        JLabel titulo = new JLabel(
                "Simulador de Juros",
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
                "Veja como o dinheiro evolui ao longo do tempo",
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
                        "Dados da simulação"
                )
        );

        JLabel labelTipo = new JLabel(
                "Tipo de juros:"
        );

        JComboBox<String> campoTipo = new JComboBox<>(
                new String[]{
                        "Juros Compostos",
                        "Juros Simples"
                }
        );

        JLabel labelValor = new JLabel(
                "Valor inicial (R$):"
        );

        JTextField campoValor = new JTextField();

        JLabel labelTaxa = new JLabel(
                "Taxa de juros (% ao mês):"
        );

        JTextField campoTaxa = new JTextField();

        JLabel labelPeriodo = new JLabel(
                "Período (meses):"
        );

        JTextField campoPeriodo = new JTextField();

        painelFormulario.add(labelTipo);
        painelFormulario.add(campoTipo);

        painelFormulario.add(labelValor);
        painelFormulario.add(campoValor);

        painelFormulario.add(labelTaxa);
        painelFormulario.add(campoTaxa);

        painelFormulario.add(labelPeriodo);
        painelFormulario.add(campoPeriodo);

        JButton botaoCalcular = new JButton(
                "Calcular"
        );

        JButton botaoLimpar = new JButton(
                "Limpar"
        );

        JPanel painelAcoes = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        5
                )
        );

        painelAcoes.add(
                botaoCalcular
        );

        painelAcoes.add(
                botaoLimpar
        );

        JLabel resultadoMontante = new JLabel(
                "Montante final: -"
        );

        resultadoMontante.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        17
                )
        );

        JLabel resultadoJuros = new JLabel(
                "Juros acumulados: -"
        );

        resultadoJuros.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        JPanel painelResultados = new JPanel();

        painelResultados.setLayout(
                new BoxLayout(
                        painelResultados,
                        BoxLayout.Y_AXIS
                )
        );

        painelResultados.setBorder(
                BorderFactory.createTitledBorder(
                        "Resultado"
                )
        );

        resultadoMontante.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        resultadoJuros.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        painelResultados.add(
                Box.createVerticalStrut(8)
        );

        painelResultados.add(
                resultadoMontante
        );

        painelResultados.add(
                Box.createVerticalStrut(8)
        );

        painelResultados.add(
                resultadoJuros
        );

        painelResultados.add(
                Box.createVerticalStrut(8)
        );

        GraficoJuros grafico = new GraficoJuros();

        grafico.setPreferredSize(
                new Dimension(
                        650,
                        190
                )
        );

        grafico.setBorder(
                BorderFactory.createTitledBorder(
                        "Evolução do valor"
                )
        );

        JPanel painelCentro = new JPanel();

        painelCentro.setLayout(
                new BoxLayout(
                        painelCentro,
                        BoxLayout.Y_AXIS
                )
        );

        painelFormulario.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        150
                )
        );

        painelAcoes.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        painelResultados.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        90
                )
        );

        painelCentro.add(
                painelFormulario
        );

        painelCentro.add(
                Box.createVerticalStrut(10)
        );

        painelCentro.add(
                painelAcoes
        );

        painelCentro.add(
                Box.createVerticalStrut(10)
        );

        painelCentro.add(
                painelResultados
        );

        painelCentro.add(
                Box.createVerticalStrut(10)
        );

        painelCentro.add(
                grafico
        );

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

        NumberFormat formatoDinheiro =
                NumberFormat.getCurrencyInstance(
                        new Locale(
                                "pt",
                                "BR"
                        )
                );

        botaoCalcular.addActionListener(e -> {

            try {

                String valorTexto =
                        campoValor
                                .getText()
                                .trim()
                                .replace(",", ".");

                String taxaTexto =
                        campoTaxa
                                .getText()
                                .trim()
                                .replace(",", ".");

                String periodoTexto =
                        campoPeriodo
                                .getText()
                                .trim();

                double valorInicial =
                        Double.parseDouble(
                                valorTexto
                        );

                double taxa =
                        Double.parseDouble(
                                taxaTexto
                        );

                int periodo =
                        Integer.parseInt(
                                periodoTexto
                        );

                if (valorInicial <= 0) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "O valor inicial deve ser maior que zero.",
                            "Valor inválido",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                if (taxa < 0) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "A taxa não pode ser negativa.",
                            "Taxa inválida",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                if (periodo <= 0 || periodo > 360) {

                    JOptionPane.showMessageDialog(
                            janela,
                            "Informe um período entre 1 e 360 meses.",
                            "Período inválido",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                double taxaDecimal =
                        taxa / 100.0;

                double[] evolucao =
                        new double[periodo + 1];

                evolucao[0] =
                        valorInicial;

                String tipoSelecionado =
                        (String) campoTipo
                                .getSelectedItem();

                double montante;

                if ("Juros Simples".equals(
                        tipoSelecionado
                )) {

                    montante =
                            valorInicial
                                    * (1
                                    + taxaDecimal
                                    * periodo);

                    for (int i = 1;
                         i <= periodo;
                         i++) {

                        evolucao[i] =
                                valorInicial
                                        * (1
                                        + taxaDecimal
                                        * i);
                    }

                } else {

                    montante =
                            valorInicial
                                    * Math.pow(
                                    1 + taxaDecimal,
                                    periodo
                            );

                    for (int i = 1;
                         i <= periodo;
                         i++) {

                        evolucao[i] =
                                valorInicial
                                        * Math.pow(
                                        1 + taxaDecimal,
                                        i
                                );
                    }
                }

                double juros =
                        montante
                                - valorInicial;

                resultadoMontante.setText(
                        "Montante final: "
                                + formatoDinheiro
                                .format(
                                        montante
                                )
                );

                resultadoJuros.setText(
                        "Juros acumulados: "
                                + formatoDinheiro
                                .format(
                                        juros
                                )
                );

                grafico.atualizarDados(
                        evolucao
                );

            } catch (NumberFormatException erro) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Preencha todos os campos com valores numéricos válidos.",
                        "Dados inválidos",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        botaoLimpar.addActionListener(e -> {

            campoValor.setText("");
            campoTaxa.setText("");
            campoPeriodo.setText("");

            campoTipo.setSelectedIndex(0);

            resultadoMontante.setText(
                    "Montante final: -"
            );

            resultadoJuros.setText(
                    "Juros acumulados: -"
            );

            grafico.limpar();

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

    private static class GraficoJuros extends JPanel {

        private double[] valores;

        public void atualizarDados(
                double[] valores) {

            this.valores = valores;

            repaint();
        }

        public void limpar() {

            valores = null;

            repaint();
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            if (valores == null
                    || valores.length < 2) {

                g.setColor(
                        Color.GRAY
                );

                g.drawString(
                        "Realize uma simulação para visualizar o gráfico.",
                        30,
                        getHeight() / 2
                );

                return;
            }

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int largura =
                    getWidth();

            int altura =
                    getHeight();

            int margemEsquerda =
                    55;

            int margemDireita =
                    25;

            int margemSuperior =
                    30;

            int margemInferior =
                    35;

            int larguraGrafico =
                    largura
                            - margemEsquerda
                            - margemDireita;

            int alturaGrafico =
                    altura
                            - margemSuperior
                            - margemInferior;

            double valorMaximo =
                    valores[0];

            for (double valor : valores) {

                if (valor > valorMaximo) {

                    valorMaximo = valor;
                }
            }

            g2.setColor(
                    Color.GRAY
            );

            g2.drawLine(
                    margemEsquerda,
                    margemSuperior,
                    margemEsquerda,
                    margemSuperior
                            + alturaGrafico
            );

            g2.drawLine(
                    margemEsquerda,
                    margemSuperior
                            + alturaGrafico,
                    margemEsquerda
                            + larguraGrafico,
                    margemSuperior
                            + alturaGrafico
            );

            g2.setColor(
                    new Color(
                            45,
                            140,
                            75
                    )
            );

            g2.setStroke(
                    new BasicStroke(
                            3
                    )
            );

            for (int i = 0;
                 i < valores.length - 1;
                 i++) {

                int x1 =
                        margemEsquerda
                                + (int) (
                                (
                                        (double) i
                                                / (valores.length - 1)
                                )
                                        * larguraGrafico
                        );

                int x2 =
                        margemEsquerda
                                + (int) (
                                (
                                        (double) (i + 1)
                                                / (valores.length - 1)
                                )
                                        * larguraGrafico
                        );

                int y1 =
                        margemSuperior
                                + alturaGrafico
                                - (int) (
                                (
                                        valores[i]
                                                / valorMaximo
                                )
                                        * alturaGrafico
                        );

                int y2 =
                        margemSuperior
                                + alturaGrafico
                                - (int) (
                                (
                                        valores[i + 1]
                                                / valorMaximo
                                )
                                        * alturaGrafico
                        );

                g2.drawLine(
                        x1,
                        y1,
                        x2,
                        y2
                );
            }

            g2.setColor(
                    Color.DARK_GRAY
            );

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            10
                    )
            );

            g2.drawString(
                    "0",
                    margemEsquerda - 5,
                    margemSuperior
                            + alturaGrafico
                            + 18
            );

            g2.drawString(
                    String.valueOf(
                            valores.length - 1
                    ),
                    margemEsquerda
                            + larguraGrafico
                            - 10,
                    margemSuperior
                            + alturaGrafico
                            + 18
            );

            g2.drawString(
                    "Meses",
                    margemEsquerda
                            + larguraGrafico / 2
                            - 15,
                    altura - 5
            );

            g2.dispose();
        }
    }
}