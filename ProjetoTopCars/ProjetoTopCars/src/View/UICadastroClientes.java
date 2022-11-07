/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Conexoes.MySQL;
import Objects.Clientes;
import java.util.Set;
import javax.swing.JOptionPane;
/**
 *
 * @author alope
 */
public class UICadastroClientes extends javax.swing.JFrame {

    MySQL conectar = new MySQL();
    Clientes novoCliente = new Clientes();
    /**
     * Creates new form UICadastroClientes
     */
    public UICadastroClientes() {
        initComponents();
    }
    private void CadastrarClientes(Clientes novoCliente){
        this.conectar.conectaBanco();
        
        novoCliente.setNome(txtNomeCliente.getText());
        novoCliente.setCPF(txtCPFCliente.getText());
        novoCliente.setSexo((String)txtSexoCliente.getSelectedItem());
        novoCliente.setEndereco(txtEndCliente.getText());
        novoCliente.setEmail(txtEmailCliente.getText());
        novoCliente.setTelefone(txtTelCliente.getText());
        novoCliente.setCNH(txtCNHCliente.getText());
    
    try {
            this.conectar.insertSQL ("INSERT INTO clientes ("
                + "nome,"
                + "cpf,"
                + "sexo,"
                + "endereco,"
                + "email,"
                + "telefone,"
                + "cnh"
            + ") VALUES ("
                + "'" + novoCliente.getNome() + "',"
                + "'" + novoCliente.getCPF() + "',"
                + "'" + novoCliente.getSexo() + "',"
                + "'" + novoCliente.getEndereco() + "',"
                + "'" + novoCliente.getEmail() + "',"
                + "'" + novoCliente.getTelefone() + "',"
                + "'" + novoCliente.getCNH() + "'"
            + ");");
        } catch (Exception e){
            System.out.println("Erro ao cadastrar cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
        } finally {
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        }
    }
    
    private void BuscarClientes (Clientes novoCliente){
        this.conectar.conectaBanco();
        
        String consultaCpf = this.txtConsultaCpf.getText();
        
        try {
            this.conectar.executarSQL(
                    "SELECT "
                    + "nome,"
                    + "sexo,"
                    + "endereco,"
                    + "email,"
                    + "telefone,"
                    + "cnh"
                    + " FROM"
                        + " clientes"
                    + " WHERE"
                        + " cpf = '" + consultaCpf + "'" + ";");
            while (this.conectar.getResultSet().next()){
                novoCliente.setNome(this.conectar.getResultSet().getString(1));
                novoCliente.setSexo(this.conectar.getResultSet().getString(2));
                novoCliente.setEndereco(this.conectar.getResultSet().getString(3));
                novoCliente.setEmail(this.conectar.getResultSet().getString(4));
                novoCliente.setTelefone(this.conectar.getResultSet().getString(5));
                novoCliente.setCNH(this.conectar.getResultSet().getString(6));
            }
            
            if(novoCliente.getNome() == ""){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        } catch (Exception e){
            System.out.println("Erro ao consultar cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        } finally{
            txtConsultaNome.setText(novoCliente.getNome());
            txtConsultaSexo.setText(novoCliente.getSexo());
            txtConsultaEnd.setText(novoCliente.getEndereco());
            txtConsultaEmail.setText(novoCliente.getEmail());
            txtConsultaTel.setText(novoCliente.getTelefone());
            txtConsultaCNH.setText(novoCliente.getCNH());
            this.conectar.fechaBanco();
        }
    }
    
    public void AtualizarClientes(Clientes novoCliente){
        this.conectar.conectaBanco();
        
        String consultarCpf = this.txtConsultaCpf.getText();
        
        novoCliente.setNome(txtConsultaNome.getText());
        novoCliente.setSexo((String) txtConsultaSexo.getText());
        novoCliente.setEndereco(txtConsultaEnd.getText());
        novoCliente.setEmail(txtConsultaEmail.getText());
        novoCliente.setTelefone(txtConsultaTel.getText());
        novoCliente.setCNH(txtConsultaCNH.getText());
        
        try{
            this.conectar.updateSQL(
                    "UPDATE clientes SET " + "nome = " + "'" + novoCliente.getNome() + "',"
                    + "sexo = " + "'" + novoCliente.getSexo() + "',"
                    + "endereco = " + "'" + novoCliente.getEndereco() + "',"
                    + "email = " + "'" + novoCliente.getEmail() + "',"
                    + "telefone = " + "'" + novoCliente.getTelefone() + "',"
                    + "cnh = " + "'" + novoCliente.getCNH() + "'"
                    + " WHERE " + "cpf = '" + consultarCpf + "'" + ";");
                
        }catch (Exception e){
            System.out.println("Erro ao atualizar cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        }
    }
    
    public void DeletarClientes(Clientes novoCliente){
        this.conectar.conectaBanco();
        
        String consultarCpf = this.txtConsultaCpf.getText();
        
        novoCliente.setNome(txtConsultaNome.getText());
        novoCliente.setSexo((String) txtConsultaSexo.getText());
        novoCliente.setEndereco(txtConsultaEnd.getText());
        novoCliente.setEmail(txtConsultaEmail.getText());
        novoCliente.setTelefone(txtConsultaTel.getText());
        novoCliente.setCNH(txtConsultaCNH.getText());
        
        try{
            this.conectar.deleteSQL(
                    "DELETE FROM clientes WHERE " + "cpf = '" + consultarCpf + "'" + ";");
                
        }catch (Exception e){
            System.out.println("Erro ao deletar cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente!");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        txtTelefone = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        rbnMasculino = new javax.swing.JRadioButton();
        rbnFeminino = new javax.swing.JRadioButton();
        btnLimpar2 = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        bntCadastrar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNome1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BtnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtEmailCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEndCliente = new javax.swing.JTextArea();
        txtCPFCliente = new javax.swing.JTextField();
        txtSexoCliente = new javax.swing.JComboBox<>();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCNHCliente = new javax.swing.JTextField();
        txtTelCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtConsultaEmail = new javax.swing.JTextField();
        txtConsultaTel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsultaEnd = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtConsultaSexo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtConsultaNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtConsultaCNH = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtConsultaCpf = new javax.swing.JTextField();
        btnLimparConsulta = new javax.swing.JButton();
        btnConsultaCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 130, -1));

        lblNome.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(102, 102, 255));
        lblNome.setText("Cadastro de clientes");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 140, -1));

        lblSexo.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N
        jPanel1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 240, 80));

        lblCPF.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblCPF.setText("CPF");
        jPanel1.add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 130, -1));
        jPanel1.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 130, -1));

        lblTelefone.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblTelefone.setText("Telefone");
        jPanel1.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        rbnMasculino.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        rbnMasculino.setText("Masculino");
        jPanel1.add(rbnMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        rbnFeminino.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        rbnFeminino.setText("Feminino");
        jPanel1.add(rbnFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        btnLimpar2.setBackground(new java.awt.Color(0, 153, 255));
        btnLimpar2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnLimpar2.setText("Limpar");
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 90, 50));

        lblEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 130, -1));

        bntCadastrar3.setBackground(new java.awt.Color(0, 153, 255));
        bntCadastrar3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        bntCadastrar3.setText("Cadastrar");
        bntCadastrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrar3ActionPerformed(evt);
            }
        });
        jPanel1.add(bntCadastrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 50));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        lblNome1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblNome1.setText("Nome");
        jPanel1.add(lblNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Cadastro de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Nome");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Sexo");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("CPF");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Endereço");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Telefone");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("E-mail");

        BtnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtEndCliente.setColumns(20);
        txtEndCliente.setRows(5);
        jScrollPane2.setViewportView(txtEndCliente);

        txtSexoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "Masculino", "Feminino", "Não definido" }));
        txtSexoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoClienteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("CNH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSexoCliente, 0, 1, Short.MAX_VALUE))))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCNHCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCNHCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 440));

        jPanel4.setBackground(new java.awt.Color(51, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Busca de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(51, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Atualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Deletar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Telefone");

        txtConsultaEnd.setColumns(20);
        txtConsultaEnd.setRows(5);
        jScrollPane1.setViewportView(txtConsultaEnd);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Endereço");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Sexo");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Nome");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("CNH");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConsultaNome)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtConsultaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtConsultaCNH)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConsultaEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtConsultaTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConsultaCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(65, 65, 65))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("CPF");

        btnLimparConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimparConsulta.setText("Limpar");
        btnLimparConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparConsultaActionPerformed(evt);
            }
        });

        btnConsultaCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaCliente.setText("Buscar");
        btnConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtConsultaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparConsulta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtConsultaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCliente)
                    .addComponent(btnLimparConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 388, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 388, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 241, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 242, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void bntCadastrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCadastrar3ActionPerformed

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
        // TODO add your handling code here:
        this.CadastrarClientes(novoCliente);
    }//GEN-LAST:event_BtnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtNomeCliente.setText("");
        txtCPFCliente.setText("");
        txtSexoCliente.setSelectedItem("Escolher");
        txtEndCliente.setText("");
        txtEmailCliente.setText("");
        txtCNHCliente.setText("");

    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtSexoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoClienteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.AtualizarClientes(novoCliente);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.DeletarClientes(novoCliente);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnLimparConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparConsultaActionPerformed
        // TODO add your handling code here:
        txtConsultaCpf.setText("");
    }//GEN-LAST:event_btnLimparConsultaActionPerformed

    private void btnConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaClienteActionPerformed
        // TODO add your handling code here:
        this.BuscarClientes(novoCliente);
    }//GEN-LAST:event_btnConsultaClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UICadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICadastroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton bntCadastrar3;
    private javax.swing.JButton btnConsultaCliente;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnLimparConsulta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JRadioButton rbnFeminino;
    private javax.swing.JRadioButton rbnMasculino;
    private javax.swing.JTextField txtCNHCliente;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPFCliente;
    private javax.swing.JTextField txtConsultaCNH;
    private javax.swing.JTextField txtConsultaCpf;
    private javax.swing.JTextField txtConsultaEmail;
    private javax.swing.JTextArea txtConsultaEnd;
    private javax.swing.JTextField txtConsultaNome;
    private javax.swing.JTextField txtConsultaSexo;
    private javax.swing.JTextField txtConsultaTel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextArea txtEndCliente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JComboBox<String> txtSexoCliente;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
