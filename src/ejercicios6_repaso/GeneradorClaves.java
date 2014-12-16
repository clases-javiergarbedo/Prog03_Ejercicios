
package ejercicios6_repaso;

import java.util.Random;
import javax.swing.JOptionPane;


public class GeneradorClaves extends javax.swing.JFrame {

    public GeneradorClaves() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldTamano = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFieldContrasena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipoContrasena = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxMayusculas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tamaño de la contraseña:");

        jTextFieldTamano.setColumns(4);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldContrasena.setEditable(false);

        jLabel2.setText("Contraseña:");

        jComboBoxTipoContrasena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alfabética", "Alfanumérica", "Numérica", "Completa" }));

        jLabel3.setText("Tipo de contraseña:");

        jCheckBoxMayusculas.setText("Permitir mayúsculas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTamano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldContrasena))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoContrasena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxMayusculas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTipoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxMayusculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int tamano = Integer.valueOf(jTextFieldTamano.getText());
            String contrasena = "";
            Random generadorAleatorio = new Random();
            char caracterAleatorio = ' ';
            if(tamano>0) {
                do { //Generar letras hasta que se alcance el tamaño indicado
                    int tipoContrasena = jComboBoxTipoContrasena.getSelectedIndex();
                    switch(tipoContrasena) {
                        case 0: //Alfabética
                            if(jCheckBoxMayusculas.isSelected() && Math.random()>=0.5)
                                caracterAleatorio = (char)(generadorAleatorio.nextInt('Z'-'A'+1)+'A');
                            else
                                caracterAleatorio = (char)(generadorAleatorio.nextInt('z'-'a'+1)+'a');
                            break;
                        case 1: //Alfanumérica
                            if(Math.random()>=0.5) {
                                if(jCheckBoxMayusculas.isSelected() && Math.random()>=0.5)
                                    caracterAleatorio = (char)(generadorAleatorio.nextInt('Z'-'A'+1)+'A');
                                else
                                    caracterAleatorio = (char)(generadorAleatorio.nextInt('z'-'a'+1)+'a');
                            } else
                                caracterAleatorio = (char)(generadorAleatorio.nextInt('9'-'0'+1)+'0');
                            break;
                        case 2: //Numérica
                            caracterAleatorio = (char)(generadorAleatorio.nextInt('9'-'0'+1)+'0');
                            break;
                        case 3: //Completa
                            caracterAleatorio = (char)(generadorAleatorio.nextInt('~'-'!'+1)+'!');
                            break;
                    }
                    boolean repetido = false;
                    //Recorrer la contraseña generada hasta el momento
                    for(int i=0; i<contrasena.length(); i++) {
                        //Comprobar si el carácter generado ya existe
                        if(caracterAleatorio==contrasena.charAt(i)) {
                            repetido = true;
                        }
                    } //Se añade el carácter generado si no existía
                    if(!repetido) {
                        contrasena += caracterAleatorio;
                    }
                } while(contrasena.length() < tamano);
                //Mostrar la contraseña generada
                jTextFieldContrasena.setText(contrasena);
            } else {
                JOptionPane.showMessageDialog(this, "El tamaño debe ser positivo");
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes indicar un número en el tamaño");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GeneradorClaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneradorClaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneradorClaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneradorClaves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneradorClaves().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxMayusculas;
    private javax.swing.JComboBox jComboBoxTipoContrasena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldContrasena;
    private javax.swing.JTextField jTextFieldTamano;
    // End of variables declaration//GEN-END:variables

}
