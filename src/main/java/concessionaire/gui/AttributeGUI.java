package concessionaire.gui;
import concessionaire.controller.AttributeController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class AttributeGUI extends javax.swing.JFrame {
    AttributeController controller = new AttributeController();

    public AttributeGUI() {
        initComponents();
 
        ArrayList<String> clases = controller.getClasses();

        DefaultListModel listModel = new DefaultListModel();

        clases.forEach((clase) -> {
            listModel.addElement(clase);
        });

        classesList.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        classesList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        individualsList = new javax.swing.JList<>();
        findIndividuals = new javax.swing.JButton();
        findAttributes = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        otherIndividualsList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        findOtherEntities = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        attributesList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Same Attribute Query");

        jScrollPane1.setViewportView(classesList);

        jLabel2.setText("Select Class:");

        jLabel3.setText("Individuals:");

        jScrollPane2.setViewportView(individualsList);

        findIndividuals.setText("Find Individuals");
        findIndividuals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findIndividualsActionPerformed(evt);
            }
        });

        findAttributes.setText("Find Attributes");
        findAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAttributesActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(otherIndividualsList);

        jLabel4.setText("Attributes:");

        findOtherEntities.setText("Find Similar Individuals");
        findOtherEntities.setActionCommand("Find Similar Individuals");
        findOtherEntities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findOtherEntitiesActionPerformed(evt);
            }
        });

        jLabel5.setText("Entities with same value:");

        jScrollPane5.setViewportView(attributesList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(findAttributes)
                                .addGap(368, 368, 368))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(findIndividuals)
                        .addGap(368, 368, 368))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(findOtherEntities)
                        .addGap(360, 360, 360))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findIndividuals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(findAttributes)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findOtherEntities)
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findIndividualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findIndividualsActionPerformed
        String selectedClass = classesList.getSelectedValue();
        if ( selectedClass != null ) {
            ArrayList<String> individuals = controller.getInstancesFromClass(selectedClass);

            DefaultListModel modelList = new DefaultListModel();
            individuals.forEach((individual) -> {
                modelList.addElement(individual);
            });

            individualsList.setModel(modelList);
        }
    }//GEN-LAST:event_findIndividualsActionPerformed

    private void findAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAttributesActionPerformed
        String selectedIndividual = individualsList.getSelectedValue();
        if ( selectedIndividual != null ) {
            ArrayList<String> list = controller.getAttributes(selectedIndividual);

            DefaultListModel modelList = new DefaultListModel();
            list.forEach((atributo) -> {
                modelList.addElement(atributo);
            });

            attributesList.setModel(modelList);
        }
       
    }//GEN-LAST:event_findAttributesActionPerformed

    private void findOtherEntitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findOtherEntitiesActionPerformed
        String selectedAttribute = attributesList.getSelectedValue();
        if ( selectedAttribute != null ) {
            String propertyURI = selectedAttribute.substring(0,selectedAttribute.lastIndexOf(':'));
            String valueURI = selectedAttribute.substring(selectedAttribute.lastIndexOf(':'), selectedAttribute.length());
            String value = valueURI.substring(valueURI.lastIndexOf('[') + 1, valueURI.lastIndexOf(']'));
            String selectedClass = classesList.getSelectedValue();
            
            ArrayList<String> list = controller.getSimilarIndividuals(propertyURI, value, selectedClass);
            
            DefaultListModel modelList = new DefaultListModel();
            list.forEach((individual) -> {
                modelList.addElement(individual);
            });
            
            otherIndividualsList.setModel(modelList);

        }
    }//GEN-LAST:event_findOtherEntitiesActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttributeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> attributesList;
    private javax.swing.JList<String> classesList;
    private javax.swing.JButton findAttributes;
    private javax.swing.JButton findIndividuals;
    private javax.swing.JButton findOtherEntities;
    private javax.swing.JList<String> individualsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> otherIndividualsList;
    // End of variables declaration//GEN-END:variables
}
