package View;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author luizo
 */
public class Carregamento extends javax.swing.JFrame {

    /**
     * Creates new form Carregamento
     */
    public Carregamento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        porcantagem = new javax.swing.JLabel();
        progresso = new javax.swing.JProgressBar();
        carregar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(porcantagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 50, 20));

        progresso.setBackground(new java.awt.Color(255, 255, 255));
        progresso.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(progresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 190, 30));

        carregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Top.png"))); // NOI18N
        jPanel1.add(carregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 470, 420));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
      Carregamento load = new Carregamento();
      load.setVisible(true);

        try{
            for (int i = 0; i <=100; i+=3)
                
            {
                Thread.sleep(70);
                load.progresso.setValue(i);
                load.porcantagem.setText(Integer.toString(i) + "%");
            }
             load.dispose();
                    
            
    
          Login login = new Login();
          login.setVisible(true);
            }catch(InterruptedException e) {
    JOptionPane.showConfirmDialog(null,"erro");
}
        }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel porcantagem;
    private javax.swing.JProgressBar progresso;
    // End of variables declaration//GEN-END:variables
}
