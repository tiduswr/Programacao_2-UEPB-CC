package com.uepb.hospital.ui;

import java.util.concurrent.CountDownLatch;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class frmListarPessoas extends JDialog {
    
    private Object[][] source;
    private String[] headers;
    private String tipo;
    private String titulo;
    private int returnValueFromCol;
    private String retorno;
    
    public frmListarPessoas(Object[][] src, String[] headers, String tipo, String title) {
        //Inicia componentes na EDT
        final CountDownLatch latch = new CountDownLatch(1);        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                initComponents();
                latch.countDown();
            }
        });
        try{
            latch.await();
        }catch(InterruptedException e){}
        
        //Inicia restante dos componentes
        this.source = src;
        this.headers = headers;
        this.tipo = tipo;
        this.titulo = title;
        this.btOk.setVisible(false);
    }
    public frmListarPessoas(Object[][] src, String[] headers, String tipo, String title, int returnValueFromCol) {
        //Inicia componentes na EDT
        final CountDownLatch latch = new CountDownLatch(1);        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                initComponents();
                latch.countDown();
            }
        });
        try{
            latch.await();
        }catch(InterruptedException e){}
        
        //Inicia restante dos componentes
        this.source = src;
        this.headers = headers;
        this.tipo = tipo;
        this.titulo = title;
        this.returnValueFromCol = returnValueFromCol;
        this.retorno = null;
        this.btOk.setVisible(true); 
    }
    
    //Getters and Setters
    public String getRetorno(){
        return retorno;
    }
    public Object[][] getSource() {
        return source;
    }
    public void setSource(Object[][] source) {
        this.source = source;
    }
    public String[] getHeaders() {
        return headers;
    }
    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String title) {
        this.titulo = title;
    }
    
    //Inicialização do Formulário
    
    public void showForm(){
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                showFormInterno();
                latch.countDown();
            }
        });
        try{
            latch.await();
        }catch(InterruptedException e){}
    }
    
    private void showFormInterno(){
        this.tblPessoas.setModel(new DefaultTableModel(this.source, this.headers));
        this.lblFilter.setText(this.getTipo());
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setTitle(this.getTitulo());
        this.setVisible(true);
    }
    
    //Mensageiro
    private void showMsg(String message){
        JOptionPane.showMessageDialog(null, message, "Formulario de Listagem", JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoas = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblTitleLine = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPessoas);

        lblTitle.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setText("LISTAGEM DE PESSOAS");

        lblTitleLine.setBackground(new java.awt.Color(0, 0, 0));
        lblTitleLine.setForeground(new java.awt.Color(0, 0, 0));
        lblTitleLine.setOpaque(true);

        lblSubTitle.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblSubTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblSubTitle.setText("Filtrando por:");

        lblFilter.setForeground(new java.awt.Color(0, 0, 0));

        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addComponent(lblTitleLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(409, 409, 409))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitleLine, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOk, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        int selected = this.tblPessoas.getSelectedRow();
        
        if(selected != -1){
            try{
                this.retorno = String.valueOf(this.tblPessoas.getValueAt(selected, this.returnValueFromCol));
                final CountDownLatch latch = new CountDownLatch(1);
                this.dispose();                
            }catch(Exception e){
                this.showMsg("Argumento de retorno da Coluna esta fora do Range da tabela!");
            }
        }else{
            this.showMsg("Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleLine;
    private javax.swing.JTable tblPessoas;
    // End of variables declaration//GEN-END:variables
}
