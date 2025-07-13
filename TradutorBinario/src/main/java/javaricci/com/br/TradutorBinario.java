package javaricci.com.br;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

public class TradutorBinario extends JFrame {
    
    private JTextArea txtTexto;
    private JTextArea txtBinario;
    private JButton btnTextoParaBinario;
    private JButton btnBinarioParaTexto;
    private JButton btnLimpar;
    private JButton btnCopiarTexto;
    private JButton btnCopiarBinario;
    private JLabel lblStatus;
    private JPanel mainPanel;
    private JToggleButton btnTema;
    
    public TradutorBinario() {
        initializeComponents();
        setupLayout();
        setupEventListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tradutor Binário v1.0");
        setMinimumSize(new Dimension(600, 500));
        setSize(800, 600);
        setLocationRelativeTo(null);
        updateStatus("Pronto para usar!");
    }
    
    private void initializeComponents() {
        // Áreas de texto
        txtTexto = new JTextArea();
        txtTexto.setLineWrap(true);
        txtTexto.setWrapStyleWord(true);
        txtTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        txtTexto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        txtBinario = new JTextArea();
        txtBinario.setLineWrap(true);
        txtBinario.setWrapStyleWord(true);
        txtBinario.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        txtBinario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Botões principais
        btnTextoParaBinario = new JButton("Texto → Binário");
        btnTextoParaBinario.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        btnTextoParaBinario.setPreferredSize(new Dimension(150, 40));
        
        btnBinarioParaTexto = new JButton("Binário → Texto");
        btnBinarioParaTexto.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        btnBinarioParaTexto.setPreferredSize(new Dimension(150, 40));
        
        btnLimpar = new JButton("Limpar Tudo");
        btnLimpar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        btnLimpar.setPreferredSize(new Dimension(120, 40));
        
        // Botões de copiar
        btnCopiarTexto = new JButton("Copiar");
        btnCopiarTexto.setPreferredSize(new Dimension(80, 30));
        
        btnCopiarBinario = new JButton("Copiar");
        btnCopiarBinario.setPreferredSize(new Dimension(80, 30));
        
        // Botão de tema
        btnTema = new JToggleButton("🌙");
        btnTema.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        btnTema.setPreferredSize(new Dimension(40, 40));
        btnTema.setToolTipText("Alternar tema");
        
        // Label de status
        lblStatus = new JLabel("Pronto para usar!");
        lblStatus.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 11));
        lblStatus.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        // Panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private void setupLayout() {
        // Panel superior com botão de tema
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnTema, BorderLayout.EAST);
        
        // Panel central com as áreas de texto
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Seção de texto
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 1.0; gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JPanel textoHeaderPanel = new JPanel(new BorderLayout());
        JLabel lblTexto = new JLabel("Texto:");
        lblTexto.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        textoHeaderPanel.add(lblTexto, BorderLayout.WEST);
        textoHeaderPanel.add(btnCopiarTexto, BorderLayout.EAST);
        centerPanel.add(textoHeaderPanel, gbc);
        
        gbc.gridy = 1;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollTexto = new JScrollPane(txtTexto);
        scrollTexto.setBorder(BorderFactory.createLoweredBevelBorder());
        centerPanel.add(scrollTexto, gbc);
        
        // Seção de botões
        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(btnTextoParaBinario);
        buttonPanel.add(btnBinarioParaTexto);
        buttonPanel.add(btnLimpar);
        centerPanel.add(buttonPanel, gbc);
        
        // Seção de binário
        gbc.gridy = 3;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JPanel binarioHeaderPanel = new JPanel(new BorderLayout());
        JLabel lblBinario = new JLabel("Binário:");
        lblBinario.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        binarioHeaderPanel.add(lblBinario, BorderLayout.WEST);
        binarioHeaderPanel.add(btnCopiarBinario, BorderLayout.EAST);
        centerPanel.add(binarioHeaderPanel, gbc);
        
        gbc.gridy = 4;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollBinario = new JScrollPane(txtBinario);
        scrollBinario.setBorder(BorderFactory.createLoweredBevelBorder());
        centerPanel.add(scrollBinario, gbc);
        
        // Montagem final
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(lblStatus, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnTextoParaBinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTextoParaBinario();
            }
        });
        
        btnBinarioParaTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterBinarioParaTexto();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        
        btnCopiarTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copiarParaClipboard(txtTexto.getText(), "Texto copiado!");
            }
        });
        
        btnCopiarBinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copiarParaClipboard(txtBinario.getText(), "Binário copiado!");
            }
        });
        
        btnTema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternarTema();
            }
        });
        
        // Listener para redimensionamento responsivo
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarLayout();
            }
        });
    }
    
    private void converterTextoParaBinario() {
        String texto = txtTexto.getText().trim();
        if (texto.isEmpty()) {
            updateStatus("Digite algum texto para converter!");
            return;
        }
        
        try {
            StringBuilder binario = new StringBuilder();
            for (char c : texto.toCharArray()) {
                String bin = Integer.toBinaryString(c);
                // Preenche com zeros à esquerda para 8 bits
                while (bin.length() < 8) {
                    bin = "0" + bin;
                }
                binario.append(bin).append(" ");
            }
            
            txtBinario.setText(binario.toString().trim());
            updateStatus("Texto convertido para binário com sucesso!");
        } catch (Exception ex) {
            updateStatus("Erro ao converter texto: " + ex.getMessage());
        }
    }
    
    private void converterBinarioParaTexto() {
        String binario = txtBinario.getText().trim();
        if (binario.isEmpty()) {
            updateStatus("Digite código binário para converter!");
            return;
        }
        
        try {
            StringBuilder texto = new StringBuilder();
            String[] grupos = binario.split("\\s+");
            
            for (String grupo : grupos) {
                if (grupo.matches("[01]+")) {
                    int valor = Integer.parseInt(grupo, 2);
                    if (valor >= 0 && valor <= 1114111) { // Range Unicode válido
                        texto.append((char) valor);
                    } else {
                        throw new IllegalArgumentException("Valor binário inválido: " + grupo);
                    }
                } else {
                    throw new IllegalArgumentException("Formato binário inválido: " + grupo);
                }
            }
            
            txtTexto.setText(texto.toString());
            updateStatus("Binário convertido para texto com sucesso!");
        } catch (Exception ex) {
            updateStatus("Erro ao converter binário: " + ex.getMessage());
        }
    }
    
    private void limparCampos() {
        txtTexto.setText("");
        txtBinario.setText("");
        updateStatus("Campos limpos!");
    }
    
    private void copiarParaClipboard(String texto, String mensagem) {
        if (texto.isEmpty()) {
            updateStatus("Nada para copiar!");
            return;
        }
        
        try {
            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(new java.awt.datatransfer.StringSelection(texto), null);
            updateStatus(mensagem);
        } catch (Exception ex) {
            updateStatus("Erro ao copiar: " + ex.getMessage());
        }
    }
    
    private void alternarTema() {
        try {
            if (btnTema.isSelected()) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                btnTema.setText("☀️");
                btnTema.setToolTipText("Alternar para tema claro");
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
                btnTema.setText("🌙");
                btnTema.setToolTipText("Alternar para tema escuro");
            }
            SwingUtilities.updateComponentTreeUI(this);
            updateStatus("Tema alterado!");
        } catch (Exception ex) {
            updateStatus("Erro ao alterar tema: " + ex.getMessage());
        }
    }
    
    private void ajustarLayout() {
        // Ajusta o layout baseado no tamanho da janela
        int width = getWidth();
        int height = getHeight();
        
        // Ajusta fonte baseado no tamanho da janela
        if (width < 700) {
            txtTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            txtBinario.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        } else {
            txtTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
            txtBinario.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        }
        
        revalidate();
        repaint();
    }
    
    private void updateStatus(String mensagem) {
        lblStatus.setText(mensagem);
        // Timer para limpar a mensagem após 5 segundos
        Timer timer = new Timer(5000, e -> lblStatus.setText("Pronto para usar!"));
        timer.setRepeats(false);
        timer.start();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Define o tema padrão
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception e) {
                System.err.println("Erro ao definir tema: " + e.getMessage());
            }
            
            new TradutorBinario().setVisible(true);
        });
    }
}