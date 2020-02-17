package concessionaire.gui;
import concessionaire.controller.RelationsController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class RelationsGUI extends javax.swing.JFrame {
    RelationsController controller = new RelationsController();
    
    public RelationsGUI() {
        initComponents();
 
        ArrayList<String> clases = controller.getClasses();

        DefaultListModel listModel = new DefaultListModel();

        clases.forEach((clase) -> {
            listModel.addElement(clase);
        });

        classesList1.setModel(listModel);
        classesList2.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        classesList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        findInstances1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        classesList2 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        instancesList2 = new javax.swing.JList<>();
        findInstances2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        findRelation = new javax.swing.JButton();
        isdirectRelation = new javax.swing.JCheckBox();
        result = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        instancesList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Relations Query");

        jScrollPane1.setViewportView(classesList1);

        jLabel2.setText("Select Class:");

        jLabel3.setText("Instances");

        findInstances1.setText("Find instances");
        findInstances1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findInstances1ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(classesList2);

        jScrollPane4.setViewportView(instancesList2);

        findInstances2.setText("Find instances");
        findInstances2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findInstances2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Select Class");

        jLabel5.setText("Intances");

        findRelation.setText("Find Relation");
        findRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findRelationActionPerformed(evt);
            }
        });

        isdirectRelation.setText("Indirect relation");

        result.setEditable(false);
        result.setText("Result");

        jLabel6.setText("Result");

        jScrollPane5.setViewportView(instancesList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2)
                            .addComponent(findInstances2)
                            .addComponent(findInstances1)
                            .addComponent(isdirectRelation)
                            .addComponent(findRelation))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane4))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62)
                        .addComponent(result)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(454, 454, 454))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findInstances1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findInstances2)
                .addGap(13, 13, 13)
                .addComponent(isdirectRelation)
                .addGap(14, 14, 14)
                .addComponent(findRelation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findInstances1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findInstances1ActionPerformed
        String selectedClass = classesList1.getSelectedValue();
        
        if ( selectedClass != null ) {
            ArrayList<String> individuals = controller.getInstancesFromClass(selectedClass);

            DefaultListModel modelList = new DefaultListModel();
            individuals.forEach((individual) -> {
                modelList.addElement(individual);
            });

            instancesList1.setModel(modelList);
        }
    }//GEN-LAST:event_findInstances1ActionPerformed

    private void findInstances2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findInstances2ActionPerformed
       String selectedClass = classesList2.getSelectedValue();
        
        if ( selectedClass != null ) {
            ArrayList<String> individuals = controller.getInstancesFromClass(selectedClass);

            DefaultListModel modelList = new DefaultListModel();
            individuals.forEach((individual) -> {
                modelList.addElement(individual);
            });

            instancesList2.setModel(modelList);
        }
    }//GEN-LAST:event_findInstances2ActionPerformed

    private void findRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findRelationActionPerformed
        String selectedIndividual1 = instancesList1.getSelectedValue();
        String selectedIndividual2 = instancesList2.getSelectedValue();
        
        if (selectedIndividual1 == null || selectedIndividual2 == null) {
            return;
        }
        
        String uri1 = selectedIndividual1.substring(0, selectedIndividual1.lastIndexOf("/"));
        String uri2 = selectedIndividual2.substring(0, selectedIndividual2.lastIndexOf("/"));
        
        if (!uri1.equals(uri2)) {
            result.setText("No existe Relación");
            return;
        }
        
        Boolean isDirectRelationChecked = isdirectRelation.isSelected();
        if (isDirectRelationChecked) {
            Boolean answer = controller.checkIfExistAIndirectRelationship(selectedIndividual1, selectedIndividual2);
            
            if (answer) {
                result.setText("Existe Relación");
            } else {
                result.setText("No existe Relación");
            }
        } else {
            Boolean answer = controller.checkIfExistARelationship(selectedIndividual1, selectedIndividual2);
            
            if (answer) {
                result.setText("Existe Relación");
            } else {
                result.setText("No existe Relación");
            }
        }
    }//GEN-LAST:event_findRelationActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelationsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> classesList1;
    private javax.swing.JList<String> classesList2;
    private javax.swing.JButton findInstances1;
    private javax.swing.JButton findInstances2;
    private javax.swing.JButton findRelation;
    private javax.swing.JList<String> instancesList1;
    private javax.swing.JList<String> instancesList2;
    private javax.swing.JCheckBox isdirectRelation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField result;
    // End of variables declaration//GEN-END:variables
}
