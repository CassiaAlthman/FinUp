import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrilhasAdmin {

    //As trilhas virão eventualmente do banco de dados? (ideia, lembrar dps)
    private static final ArrayList<String> trilhas = new ArrayList<>();

    static {

        trilhas.add(
                "A importância da independência e responsabilidade financeira na juventude"
        );

        trilhas.add(
                "Como fazer o primeiro orçamento pessoal e organizar a mesada ou salário"
        );

        trilhas.add(
                "Distinção clara entre necessidades, desejos e consumo consciente"
        );

        trilhas.add(
                "Como evitar armadilhas comuns: cartão de crédito, compras por impulso e parcelamentos"
        );

        trilhas.add(
                "Estratégias práticas para renegociar dívidas e sair do vermelho"
        );

        trilhas.add(
                "Como montar a primeira reserva de emergência"
        );

        trilhas.add(
                "Entendendo o poder dos juros compostos a seu favor ao começar cedo"
        );

        trilhas.add(
                "Introdução simples aos investimentos básicos (Tesouro Direto, CDBs e Caixinhas)"
        );

        trilhas.add(
                "Definição e planejamento de metas financeiras (viagens, estudos, primeiro carro)"
        );

        trilhas.add(
                "Cuidados com golpes na internet, apostas/bets e promessas de dinheiro fácil"
        );

        trilhas.add(
                "Noções essenciais sobre trabalho, fontes de renda extra e empreendedorismo jovem"
        );

        trilhas.add(
                "Transição para a vida adulta: custos de morar sozinho e planejamento de longo prazo"
        );
    }

    public static void abrir(JFrame telaAnterior) {

        JFrame janela = new JFrame("Gerenciamento de Trilhas");

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

        JPanel painelTitulo = new JPanel();

        painelTitulo.setLayout(
                new BoxLayout(
                        painelTitulo,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titulo = new JLabel(
                "Trilhas de Educação Financeira"
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        JLabel subtitulo = new JLabel(
                "Gerenciamento de trilhas"
        );

        subtitulo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        painelTitulo.add(titulo);

        painelTitulo.add(
                Box.createVerticalStrut(5)
        );

        painelTitulo.add(subtitulo);

        JButton botaoAdicionar = new JButton("+");

        botaoAdicionar.setToolTipText(
                "Adicionar trilha"
        );

        botaoAdicionar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        botaoAdicionar.setPreferredSize(
                new Dimension(50, 45)
        );

        painelSuperior.add(
                painelTitulo,
                BorderLayout.WEST
        );

        painelSuperior.add(
                botaoAdicionar,
                BorderLayout.EAST
        );

        JPanel painelTrilhas = new JPanel();

        painelTrilhas.setLayout(
                new BoxLayout(
                        painelTrilhas,
                        BoxLayout.Y_AXIS
                )
        );

        JScrollPane scroll = new JScrollPane(
                painelTrilhas
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

        atualizarLista(
                painelTrilhas,
                janela
        );

        botaoAdicionar.addActionListener(e -> {

            String nome = JOptionPane.showInputDialog(
                    janela,
                    "Digite o nome da nova trilha:",
                    "Adicionar trilha",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (nome != null && !nome.trim().isEmpty()) {

                trilhas.add(
                        nome.trim()
                );

                atualizarLista(
                        painelTrilhas,
                        janela
                );

            }

        });

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
            JPanel painelTrilhas,
            JFrame janelaPrincipal) {

        painelTrilhas.removeAll();

        for (int i = 0; i < trilhas.size(); i++) {

            int indice = i;

            String nomeTrilha =
                    trilhas.get(i);

            JPanel linha = new JPanel(
                    new BorderLayout(
                            10,
                            0
                    )
            );

            linha.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            60
                    )
            );

            JButton botaoTrilha =
                    new JButton(
                            (i + 1)
                                    + ". "
                                    + nomeTrilha
                    );

            botaoTrilha.setHorizontalAlignment(
                    SwingConstants.LEFT
            );

            botaoTrilha.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            14
                    )
            );

            botaoTrilha.addActionListener(e -> {

                abrirTrilha(
                        indice,
                        janelaPrincipal
                );

            });

            JButton botaoEditar =
                    new JButton("✎");

            botaoEditar.setToolTipText(
                    "Editar trilha"
            );

            botaoEditar.setPreferredSize(
                    new Dimension(
                            50,
                            45
                    )
            );

            botaoEditar.addActionListener(e -> {

                editarTrilha(
                        indice,
                        painelTrilhas,
                        janelaPrincipal
                );

            });

            JButton botaoDeletar =
                    new JButton("X");

            botaoDeletar.setToolTipText(
                    "Deletar trilha"
            );

            botaoDeletar.setPreferredSize(
                    new Dimension(
                            50,
                            45
                    )
            );

            botaoDeletar.addActionListener(e -> {

                deletarTrilha(
                        indice,
                        painelTrilhas,
                        janelaPrincipal
                );

            });

            JPanel painelAcoes = new JPanel(
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

            linha.add(
                    botaoTrilha,
                    BorderLayout.CENTER
            );

            linha.add(
                    painelAcoes,
                    BorderLayout.EAST
            );

            painelTrilhas.add(
                    linha
            );

            painelTrilhas.add(
                    Box.createVerticalStrut(10)
            );
        }

        painelTrilhas.revalidate();

        painelTrilhas.repaint();
    }

    private static void editarTrilha(
            int indice,
            JPanel painelTrilhas,
            JFrame janela) {

        String nomeAtual =
                trilhas.get(indice);

        String novoNome =
                JOptionPane.showInputDialog(
                        janela,
                        "Editar nome da trilha:",
                        nomeAtual
                );

        if (novoNome != null
                && !novoNome.trim().isEmpty()) {

            trilhas.set(
                    indice,
                    novoNome.trim()
            );

            atualizarLista(
                    painelTrilhas,
                    janela
            );
        }
    }

    private static void deletarTrilha(
            int indice,
            JPanel painelTrilhas,
            JFrame janela) {

        String nome =
                trilhas.get(indice);

        int resposta =
                JOptionPane.showConfirmDialog(
                        janela,

                        "Deseja realmente excluir a trilha?\n\n"
                                + nome,

                        "Excluir trilha",

                        JOptionPane.YES_NO_OPTION,

                        JOptionPane.WARNING_MESSAGE
                );

        if (resposta
                == JOptionPane.YES_OPTION) {

            trilhas.remove(indice);

            atualizarLista(
                    painelTrilhas,
                    janela
            );
        }
    }
    private static void abrirTrilha(
            int indice,
            JFrame telaTrilhas) {

        String nome =
                trilhas.get(indice);

        JFrame janela =
                new JFrame(
                        "Trilha "
                                + (indice + 1)
                );

        janela.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        janela.setSize(
                700,
                500
        );

        janela.setLocationRelativeTo(
                null
        );

        telaTrilhas.setVisible(false);

        JPanel painel =
                new JPanel();

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

        JLabel titulo =
                new JLabel(
                        "<html>"
                                + "<div style='text-align:center;'>"
                                + nome
                                + "</div>"
                                + "</html>"
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

        JLabel conteudo =
                new JLabel(
                        "<html>"
                                + "<div style='text-align:center;'>"
                                + "O conteúdo desta trilha será "
                                + "desenvolvido posteriormente."
                                + "</div>"
                                + "</html>"
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

        JButton voltar =
                new JButton(
                        "Voltar para as trilhas"
                );

        voltar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        voltar.addActionListener(e -> {

            janela.dispose();

            telaTrilhas.setVisible(true);

        });
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