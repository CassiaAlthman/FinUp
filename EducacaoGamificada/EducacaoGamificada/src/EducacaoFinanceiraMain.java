import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EducacaoFinanceiraMain {

    private static final String LOGIN_ADMIN = "ADM123";
    private static final String LOGIN_ALUNO = "Aluno 123";
    private static final String SENHA_PADRAO = "Exemplo123";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EducacaoFinanceiraMain::criarTelaLogin);
    }

    public static void criarTelaLogin() {

        JFrame janela = new JFrame("Sistema de Educação Financeira Gamificada");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 500);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

        JLabel titulo = new JLabel("Sistema de Educação Financeira Gamificada");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelPrincipal.add(titulo);
        painelPrincipal.add(Box.createVerticalStrut(45));

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new BoxLayout(painelLogin, BoxLayout.Y_AXIS));

        painelLogin.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                        BorderFactory.createEmptyBorder(25, 30, 25, 30)
                )
        );

        JLabel textoLogin = new JLabel("LOGIN");
        textoLogin.setFont(new Font("Arial", Font.BOLD, 20));
        textoLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelUsuario = new JLabel("Login");

        JTextField campoUsuario = new JTextField();
        campoUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        JLabel labelSenha = new JLabel("Senha");

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel mensagemErro = new JLabel(" ");
        mensagemErro.setForeground(Color.RED);
        mensagemErro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textoCadastro = new JLabel(
                "<html>Ainda não tem uma conta? <u>Clique aqui.</u></html>"
        );

        textoCadastro.setForeground(new Color(0, 102, 204));
        textoCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        textoCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelLogin.add(textoLogin);
        painelLogin.add(Box.createVerticalStrut(25));

        painelLogin.add(labelUsuario);
        painelLogin.add(Box.createVerticalStrut(5));
        painelLogin.add(campoUsuario);

        painelLogin.add(Box.createVerticalStrut(15));

        painelLogin.add(labelSenha);
        painelLogin.add(Box.createVerticalStrut(5));
        painelLogin.add(campoSenha);

        painelLogin.add(Box.createVerticalStrut(20));

        painelLogin.add(botaoEntrar);
        painelLogin.add(Box.createVerticalStrut(10));

        painelLogin.add(mensagemErro);
        painelLogin.add(Box.createVerticalStrut(10));

        painelLogin.add(textoCadastro);

        painelPrincipal.add(painelLogin);

        botaoEntrar.addActionListener(e -> {

            String login = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            if (login.equals(LOGIN_ADMIN) && senha.equals(SENHA_PADRAO)) {

                janela.dispose();
                criarTelaAdministrador();

            } else if (login.equals(LOGIN_ALUNO) && senha.equals(SENHA_PADRAO)) {

                janela.dispose();
                criarTelaAluno();

            } else {

                mensagemErro.setText("Login ou senha inválidos.");

            }
        });

        textoCadastro.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                janela.dispose();
                criarTelaCadastro();

            }
        });

        janela.add(painelPrincipal);
        janela.setVisible(true);
    }

    public static void criarTelaAdministrador() {

        JFrame janela = new JFrame("Área do Administrador");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));

        JLabel titulo = new JLabel("Área do Administrador");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel mensagem = new JLabel("Login realizado com sucesso.");
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoTrilhas = new JButton("Trilhas");
        botaoTrilhas.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoMissoes = new JButton("Missões");
        botaoMissoes.setAlignmentX(Component.CENTER_ALIGNMENT);

        //LógicadosBotões

        botaoTrilhas.addActionListener(e -> {

            janela.setVisible(false);

            TrilhasAdmin.abrir(janela);

        });

        botaoMissoes.addActionListener(e -> {
           janela.setVisible(false);

           MissoesDesafiosADM.abrir(janela);
        });

        JButton voltar = new JButton("Sair");
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        voltar.addActionListener(e -> {

            janela.dispose();

            criarTelaLogin();

        });

        painel.add(titulo);

        painel.add(
                Box.createVerticalStrut(25)
        );

        painel.add(mensagem);

        painel.add(
                Box.createVerticalStrut(30)
        );

        painel.add(botaoTrilhas);
        painel.add(botaoMissoes);

        painel.add(
                Box.createVerticalStrut(20)
        );

        painel.add(voltar);

        janela.add(painel);

        janela.setVisible(true);
    }

    public static void criarTelaAluno() {

        JFrame janela = new JFrame("Área do Aluno");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(850, 650);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JLayeredPane painelCamadas = new JLayeredPane();

        JPanel painelPrincipal = new JPanel(new BorderLayout(20, 20));
        painelPrincipal.setBounds(0, 0, 850, 610);

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(20, 30, 30, 30)
        );

        JPanel painelSuperior = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("Área do Aluno");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JButton botaoNotificacoes = new JButton("Notificações");

        painelSuperior.add(titulo, BorderLayout.WEST);
        painelSuperior.add(botaoNotificacoes, BorderLayout.EAST);

        JPanel painelBotoes = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 20, 20)
        );

        JButton botaoTrilhas = new JButton("Trilhas");
        JButton botaoSimulacoes = new JButton("Simulações");
        JButton botaoMissoes = new JButton("Missões");

        Dimension tamanhoBotao = new Dimension(140, 60);

        botaoTrilhas.setPreferredSize(tamanhoBotao);
        botaoSimulacoes.setPreferredSize(tamanhoBotao);
        botaoMissoes.setPreferredSize(tamanhoBotao);

        botaoTrilhas.addActionListener(e -> {

            janela.setVisible(false);

            TrilhasAluno.abrir(janela);

        });

        botaoSimulacoes.addActionListener(e -> {

            janela.setVisible(false);

            TelaSimulacoesAluno.abrir(janela);

        });

        botaoMissoes.addActionListener(e -> {

            janela.setVisible(false);

            MissoesDesafios.abrir(janela);

        });

        painelBotoes.add(botaoTrilhas);
        painelBotoes.add(botaoSimulacoes);
        painelBotoes.add(botaoMissoes);

        JPanel painelInferior = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );

        JButton voltar = new JButton("Sair");

        voltar.addActionListener(e -> {

            janela.dispose();

            criarTelaLogin();

        });

        painelInferior.add(voltar);

        painelPrincipal.add(
                painelSuperior,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                painelBotoes,
                BorderLayout.CENTER
        );

        painelPrincipal.add(
                painelInferior,
                BorderLayout.SOUTH
        );

        JPanel painelNotificacoes = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();

                g2.setComposite(
                        AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER,
                                0.88f
                        )
                );

                g2.setColor(
                        new Color(45, 45, 45)
                );

                g2.fillRect(
                        0,
                        0,
                        getWidth(),
                        getHeight()
                );

                g2.dispose();

                super.paintComponent(g);
            }
        };

        painelNotificacoes.setOpaque(false);

        painelNotificacoes.setBounds(
                550,
                0,
                280,
                610
        );

        painelNotificacoes.setLayout(
                new BoxLayout(
                        painelNotificacoes,
                        BoxLayout.Y_AXIS
                )
        );

        painelNotificacoes.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        15,
                        20,
                        15
                )
        );

        JLabel tituloNotificacoes = new JLabel(
                "Notificações"
        );

        tituloNotificacoes.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        tituloNotificacoes.setForeground(
                Color.WHITE
        );

        tituloNotificacoes.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JButton fecharNotificacoes =
                new JButton("X");

        fecharNotificacoes.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JPanel notificacao1 = criarNotificacao(
                "Parabéns! Você concluiu 10 missões."
        );

        JPanel notificacao2 = criarNotificacao(
                "Nova trilha disponível."
        );

        JPanel notificacao3 = criarNotificacao(
                "Você ganhou uma nova conquista."
        );

        painelNotificacoes.add(
                tituloNotificacoes
        );

        painelNotificacoes.add(
                Box.createVerticalStrut(10)
        );

        painelNotificacoes.add(
                fecharNotificacoes
        );

        painelNotificacoes.add(
                Box.createVerticalStrut(20)
        );

        painelNotificacoes.add(
                notificacao1
        );

        painelNotificacoes.add(
                Box.createVerticalStrut(12)
        );

        painelNotificacoes.add(
                notificacao2
        );

        painelNotificacoes.add(
                Box.createVerticalStrut(12)
        );

        painelNotificacoes.add(
                notificacao3
        );

        painelNotificacoes.setVisible(false);

        botaoNotificacoes.addActionListener(e -> {

            painelNotificacoes.setVisible(
                    !painelNotificacoes.isVisible()
            );

        });

        fecharNotificacoes.addActionListener(e -> {

            painelNotificacoes.setVisible(false);

        });

        painelCamadas.add(
                painelPrincipal,
                Integer.valueOf(0)
        );

        painelCamadas.add(
                painelNotificacoes,
                Integer.valueOf(1)
        );

        janela.add(painelCamadas);

        janela.setVisible(true);
    }

    private static JPanel criarNotificacao(String texto) {

        JPanel painelNotificacao = new JPanel(
                new BorderLayout(10, 0)
        );

        painelNotificacao.setOpaque(false);

        painelNotificacao.setMaximumSize(
                new Dimension(
                        240,
                        65
                )
        );

        painelNotificacao.setPreferredSize(
                new Dimension(
                        240,
                        65
                )
        );

        painelNotificacao.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(60, 200, 90),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                7,
                                7,
                                7,
                                7
                        )
                )
        );

        JLabel iconeTrofeu = new JLabel(
                "🏆",
                SwingConstants.CENTER
        );

        iconeTrofeu.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        17
                )
        );

        iconeTrofeu.setPreferredSize(
                new Dimension(
                        40,
                        40
                )
        );

        iconeTrofeu.setBorder(
                BorderFactory.createLineBorder(
                        new Color(60, 200, 90),
                        2
                )
        );

        JLabel textoNotificacao = new JLabel(
                "<html>"
                        + "<div style='width:160px;'>"
                        + texto
                        + "</div>"
                        + "</html>"
        );

        textoNotificacao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        10
                )
        );

        textoNotificacao.setForeground(
                Color.WHITE
        );

        painelNotificacao.add(
                iconeTrofeu,
                BorderLayout.WEST
        );

        painelNotificacao.add(
                textoNotificacao,
                BorderLayout.CENTER
        );

        return painelNotificacao;
    }

    public static void criarTelaCadastro() {

        JFrame janela = new JFrame("Cadastro");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 400);
        janela.setLocationRelativeTo(null);


        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));

        JLabel titulo = new JLabel("Cadastro");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelCriarUsuario = new JLabel("Digite Seu Usuário");

        JTextField campoCriacaoUsuario = new JTextField();
        campoCriacaoUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        JLabel labelCriarSenha = new JLabel("Digite sua Senha");
        JTextField campoCriacaoSenha = new JTextField();
        campoCriacaoSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        labelCriarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoCriacaoUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelCriarSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoCriacaoSenha.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton criar = new JButton("Criar Conta");
        criar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton voltar = new JButton("Voltar para o login");
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        criar.addActionListener(e ->
                System.out.println("TBD"));

        voltar.addActionListener(e -> {
            janela.dispose();
            criarTelaLogin();
        });

        painel.add(titulo);
        painel.add(Box.createVerticalStrut(25));
        painel.add(labelCriarUsuario);
        painel.add(campoCriacaoUsuario);
        painel.add(labelCriarSenha);
        painel.add(campoCriacaoSenha);
        painel.add(Box.createVerticalStrut(30));
        painel.add(voltar);
        painel.add(criar);

        janela.add(painel);
        janela.setVisible(true);
    }
}