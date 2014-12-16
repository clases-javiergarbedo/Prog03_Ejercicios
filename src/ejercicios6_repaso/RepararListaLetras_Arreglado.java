package ejercicios6_repaso;

public class RepararListaLetras_Arreglado extends javax.swing.JFrame {

    public RepararListaLetras_Arreglado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaCantidad = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMensajes = new javax.swing.JTextArea();
        botónAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pocas", "Muchas", "Todas" }));

        areaMensajes.setColumns(20);
        areaMensajes.setRows(5);
        jScrollPane1.setViewportView(areaMensajes);

        botónAceptar.setText("Aceptar");
        botónAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botónAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botónAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botónAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botónAceptarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botónAceptarActionPerformed
    {//GEN-HEADEREND:event_botónAceptarActionPerformed
        //Arreglado: Borrado inicial del JTextArea
        areaMensajes.setText("");
        int selec = listaCantidad.getSelectedIndex();
        //Arreglado: Asignar valor inicial para corregir error de compilación
        int maxLetras = 0;
        char letraActual;
        switch(selec) {
            case 0:
                maxLetras = 5;
                //Arreglado: Añadidos los break para que no siga tomando los siguientes valores
                break;
            case 1:
                maxLetras = 15;
                break;
            case 2:
                maxLetras = 26;
                break;
        }
        letraActual = 'A';
//        for(int i=maxLetras; i>0; i++);
        //Arreglado: Borrado punto y coma mal colocado al final del for
        //Arreglado: Se cambia incremento por decremento
        for(int i=maxLetras; i>0; i--)
        {
//            letraActual++;
//            if(letraActual!='A' || letraActual!='E' || letraActual!='I' ||
//                    letraActual!='O' || letraActual!='U')
            //Arreglado: cambiado || por &&
            if(letraActual!='A' && letraActual!='E' && letraActual!='I' &&
                    letraActual!='O' && letraActual!='U') {
               areaMensajes.append(""+letraActual);
               //Arreglado: Metido dentro del if para que no se añada el salto 
               //   de línea en el lugar de las vocales
               areaMensajes.append("\n");
            }
//          areaMensajes.append("\n");
            //Arreglado: Movido al final del bucle para que no genere una letra de más
            letraActual++;
        }
    }//GEN-LAST:event_botónAceptarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepararListaLetras_Arreglado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMensajes;
    private javax.swing.JButton botónAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listaCantidad;
    // End of variables declaration//GEN-END:variables

}
