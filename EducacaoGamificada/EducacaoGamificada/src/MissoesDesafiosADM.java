import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MissoesDesafiosADM {

    private static final ArrayList<Missao> missoes = new ArrayList<>();

    static {

        missoes.add(
                new Missao(
                        "Missão 1: Raio-X da Carteira",
                        "Anotar 100% dos seus gastos durante 7 dias."
                )
        );

        missoes.add(
                new Missao(
                        "Missão 2: O Desafio 50/30/20",
                        "Dividir sua renda ou mesada nas categorias de necessidades, desejos e investimentos."
                )
        );

        missoes.add(
                new Missao(
                        "Missão 3: Permanência",
                        "Assista 10 aulas."
                )
        );

        missoes.add(
                new Missao(
                        "Missão 4: Detector de Armadilhas",
                        "Analisar uma fatura de cartão de crédito e identificar juros, parcelas e taxas."
                )
        );

        missoes.add(
                new Missao(
                        "Missão 5: Escudo de Emergência",
                        "Calcular o valor necessário para cobrir de 3 a 6 meses do seu custo de vida."
                )
        );
    }

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Gerenciamento de Missões");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(900, 650);
        janela.setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(
                new BorderLayout(20, 20)
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        35,
                        25,
                        35
                )
        );

        JPanel painelSuperior = new JPanel(
                new BorderLayout()
        );

        JLabel titulo = new JLabel(
                "Quadro de Missões"
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        JButton botaoAdicionar = new JButton("+");

        botaoAdicionar.setToolTipText(
                "Adicionar missão"
        );

        botaoAdicionar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        botaoAdicionar.setPreferredSize(
                new Dimension(
                        50,
                        45
                )
        );

        painelSuperior.add(
                titulo,
                BorderLayout.WEST
        );

        painelSuperior.add(
                botaoAdicionar,
                BorderLayout.EAST
        );

        JPanel painelMissoes = new JPanel();

        painelMissoes.setLayout(
                new BoxLayout(
                        painelMissoes,
                        BoxLayout.Y_AXIS
                )
        );

        JScrollPane scroll = new JScrollPane(
                painelMissoes
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

        botaoAdicionar.addActionListener(e -> {

            adicionarMissao(
                    painelMissoes,
                    janela
            );

        });

        atualizarLista(
                painelMissoes,
                janela
        );

        painelPrincipal.add(
                painelSuperior,
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

    private static void atualizarLista(
            JPanel painelMissoes,
            JFrame janela) {

        painelMissoes.removeAll();

        for (int i = 0; i < missoes.size(); i++) {

            int indice = i;

            Missao missao =
                    missoes.get(i);

            JPanel quadro = new JPanel(
                    new BorderLayout(
                            10,
                            0
                    )
            );

            quadro.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    Color.LIGHT_GRAY
                            ),
                            BorderFactory.createEmptyBorder(
                                    15,
                                    20,
                                    15,
                                    20
                            )
                    )
            );

            quadro.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            120
                    )
            );

            JPanel painelTexto = new JPanel();

            painelTexto.setLayout(
                    new BoxLayout(
                            painelTexto,
                            BoxLayout.Y_AXIS
                    )
            );

            JLabel tituloMissao =
                    new JLabel(
                            missao.getTitulo()
                    );

            tituloMissao.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            16
                    )
            );

            JLabel descricaoMissao =
                    new JLabel(
                            "<html>"
                                    + missao.getDescricao()
                                    + "</html>"
                    );

            descricaoMissao.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            painelTexto.add(
                    tituloMissao
            );

            painelTexto.add(
                    Box.createVerticalStrut(8)
            );

            painelTexto.add(
                    descricaoMissao
            );

            JButton botaoEditar =
                    new JButton("✎");

            botaoEditar.setToolTipText(
                    "Editar missão"
            );

            JButton botaoDeletar =
                    new JButton("X");

            botaoDeletar.setToolTipText(
                    "Deletar missão"
            );

            botaoEditar.setPreferredSize(
                    new Dimension(
                            50,
                            45
                    )
            );

            botaoDeletar.setPreferredSize(
                    new Dimension(
                            50,
                            45
                    )
            );

            botaoEditar.addActionListener(e -> {

                editarMissao(
                        indice,
                        painelMissoes,
                        janela
                );

            });

            botaoDeletar.addActionListener(e -> {

                deletarMissao(
                        indice,
                        painelMissoes,
                        janela
                );

            });

            JPanel painelAcoes =
                    new JPanel(
                            new FlowLayout(
                                    FlowLayout.RIGHT,
                                    5,
                                    0
                            )
                    );

            painelAcoes.add(
                    botaoEditar
            );

            painelAcoes.add(
                    botaoDeletar
            );

            quadro.add(
                    painelTexto,
                    BorderLayout.CENTER
            );

            quadro.add(
                    painelAcoes,
                    BorderLayout.EAST
            );

            painelMissoes.add(
                    quadro
            );

            painelMissoes.add(
                    Box.createVerticalStrut(12)
            );
        }

        painelMissoes.revalidate();

        painelMissoes.repaint();
    }

    private static void adicionarMissao(
            JPanel painelMissoes,
            JFrame janela) {

        JTextField campoTitulo =
                new JTextField();

        JTextArea campoDescricao =
                new JTextArea(
                        5,
                        25
                );

        campoDescricao.setLineWrap(true);
        campoDescricao.setWrapStyleWord(true);

        JScrollPane scrollDescricao =
                new JScrollPane(
                        campoDescricao
                );

        JPanel painel = new JPanel();

        painel.setLayout(
                new BoxLayout(
                        painel,
                        BoxLayout.Y_AXIS
                )
        );

        painel.add(
                new JLabel(
                        "Título da missão:"
                )
        );

        painel.add(
                Box.createVerticalStrut(5)
        );

        painel.add(
                campoTitulo
        );

        painel.add(
                Box.createVerticalStrut(15)
        );

        painel.add(
                new JLabel(
                        "Descrição:"
                )
        );

        painel.add(
                Box.createVerticalStrut(5)
        );

        painel.add(
                scrollDescricao
        );

        int resposta =
                JOptionPane.showConfirmDialog(
                        janela,
                        painel,
                        "Adicionar missão",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (resposta
                == JOptionPane.OK_OPTION) {

            String titulo =
                    campoTitulo
                            .getText()
                            .trim();

            String descricao =
                    campoDescricao
                            .getText()
                            .trim();

            if (!titulo.isEmpty()
                    && !descricao.isEmpty()) {

                missoes.add(
                        new Missao(
                                titulo,
                                descricao
                        )
                );

                atualizarLista(
                        painelMissoes,
                        janela
                );

            } else {

                JOptionPane.showMessageDialog(
                        janela,
                        "Preencha o título e a descrição da missão."
                );
            }
        }
    }

    private static void editarMissao(
            int indice,
            JPanel painelMissoes,
            JFrame janela) {

        Missao missao =
                missoes.get(indice);

        JTextField campoTitulo =
                new JTextField(
                        missao.getTitulo()
                );

        JTextArea campoDescricao =
                new JTextArea(
                        missao.getDescricao(),
                        5,
                        25
                );

        campoDescricao.setLineWrap(true);
        campoDescricao.setWrapStyleWord(true);

        JScrollPane scrollDescricao =
                new JScrollPane(
                        campoDescricao
                );

        JPanel painel = new JPanel();

        painel.setLayout(
                new BoxLayout(
                        painel,
                        BoxLayout.Y_AXIS
                )
        );

        painel.add(
                new JLabel(
                        "Título da missão:"
                )
        );

        painel.add(
                Box.createVerticalStrut(5)
        );

        painel.add(
                campoTitulo
        );

        painel.add(
                Box.createVerticalStrut(15)
        );

        painel.add(
                new JLabel(
                        "Descrição:"
                )
        );

        painel.add(
                Box.createVerticalStrut(5)
        );

        painel.add(
                scrollDescricao
        );

        int resposta =
                JOptionPane.showConfirmDialog(
                        janela,
                        painel,
                        "Editar missão",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (resposta
                == JOptionPane.OK_OPTION) {

            String novoTitulo =
                    campoTitulo
                            .getText()
                            .trim();

            String novaDescricao =
                    campoDescricao
                            .getText()
                            .trim();

            if (!novoTitulo.isEmpty()
                    && !novaDescricao.isEmpty()) {

                missao.setTitulo(
                        novoTitulo
                );

                missao.setDescricao(
                        novaDescricao
                );

                atualizarLista(
                        painelMissoes,
                        janela
                );

            } else {

                JOptionPane.showMessageDialog(
                        janela,
                        "Preencha o título e a descrição da missão."
                );
            }
        }
    }

    private static void deletarMissao(
            int indice,
            JPanel painelMissoes,
            JFrame janela) {

        Missao missao =
                missoes.get(indice);

        int resposta =
                JOptionPane.showConfirmDialog(
                        janela,
                        "Deseja realmente excluir a missão?\n\n"
                                + missao.getTitulo(),
                        "Excluir missão",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

        if (resposta
                == JOptionPane.YES_OPTION) {

            missoes.remove(
                    indice
            );

            atualizarLista(
                    painelMissoes,
                    janela
            );
        }
    }

    private static class Missao {

        private String titulo;
        private String descricao;

        public Missao(
                String titulo,
                String descricao) {

            this.titulo = titulo;
            this.descricao = descricao;
        }

        public String getTitulo() {

            return titulo;
        }

        public void setTitulo(
                String titulo) {

            this.titulo = titulo;
        }

        public String getDescricao() {

            return descricao;
        }

        public void setDescricao(
                String descricao) {

            this.descricao = descricao;
        }
    }
}