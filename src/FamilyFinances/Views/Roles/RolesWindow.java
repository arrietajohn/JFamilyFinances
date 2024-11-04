package FamilyFinances.Views.Roles;

import FamilyFinances.Controllers.Roles.CreateRoleController;
import FamilyFinances.Controllers.Roles.DeleteRoleController;
import FamilyFinances.Controllers.Roles.GetRoleController;
import FamilyFinances.Controllers.Roles.ListAllRoleController;
import FamilyFinances.Controllers.Roles.UpdateRoleController;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Infrastructure.Configurations.DependencyContainer;
import FamilyFinances.Infrastructure.Configurations.DependencyInjectionConfiguration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnarrieta
 */
public class RolesWindow extends javax.swing.JDialog {

    private final DependencyContainer dependencyContainer;
    private final GetRoleController getRoleController;

    /**
     * Creates new form RolesWindow
     *
     * @param parent
     * @param modal
     * @param container
     */
    public RolesWindow(java.awt.Frame parent, boolean modal, DependencyContainer container) {
        super(parent, modal);
        initComponents();
        this.dependencyContainer = container;
        getRoleController = dependencyContainer.resolve(GetRoleController.class);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        listButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        roleTableScroll = new javax.swing.JScrollPane();
        rolesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("..:: Family Finances ::.. [Gestion de Roles]");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTION DE ROLES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Datos del Rol:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Codigo:");

        codeField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        descriptionField.setColumns(20);
        descriptionField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        descriptionField.setRows(5);
        descriptionField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        jScrollPane1.setViewportView(descriptionField);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nombre:");

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameField))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(codeField)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        listButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        listButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/list48px.png"))); // NOI18N
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/delete48px.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/edit48px.png"))); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/search48px.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/add48px.png"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/roles256px.png"))); // NOI18N

        rolesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "ID", "NOMBRE", "DESCRIPCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roleTableScroll.setViewportView(rolesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGap(18, 18, 18)
                                .addComponent(editButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(listButton))))
                    .addComponent(roleTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deleteButton)
                                    .addComponent(listButton)
                                    .addComponent(editButton)
                                    .addComponent(searchButton))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(roleTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        var codeString = codeField.getText();

        var codeInteger = Integer.parseInt(codeString);
        try {
            var role = getRoleController.executeAction(codeInteger);
            codeField.setText(role.getId().toString());
            nameField.setText(role.getName());
            descriptionField.setText(role.getDescripcion());
            enableButtons(false, true, true, true, true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:

        var option = JOptionPane.showConfirmDialog(this,
                "Confirme si desea registrar este Rol", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            var id = Integer.parseInt(codeField.getText());
            var name = nameField.getText();
            var description = descriptionField.getText();
            var controller = dependencyContainer.resolve(CreateRoleController.class);
            controller.executeAction(id, name, description);
            JOptionPane.showMessageDialog(this, "Rol registrado con exito");
            clearFilds();
            listButtonActionPerformed(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El Id debes numerico");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
        enableButtons(true, true, false, false, true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        Role currentRole = getRoleController.getCurrentRole();
        if (currentRole == null) {
            JOptionPane.showMessageDialog(this, "Primero debe consultar un Rol");
            clearFilds();
            enableButtons(false, true, false, false, true);
            return;
        }

        Integer rolId = null;
        try {
            rolId = Integer.parseInt(codeField.getText());
            if (currentRole.getId().intValue() != rolId) {
                JOptionPane.showMessageDialog(this, "El Id del Rol no puede ser modificado");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El codigo debe ser numerico");
            return;
        }

        var option = JOptionPane.showConfirmDialog(this,
                "Confirme si desea actualizar este Rol", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            var controller = dependencyContainer.resolve(UpdateRoleController.class);
            controller.executeAction(rolId, nameField.getText(), descriptionField.getText());
            currentRole.setName(nameField.getText());
            currentRole.setDescripcion(descriptionField.getText());
            JOptionPane.showMessageDialog(this, "Rol Actualizado con exito");
            clearFilds();
            listButtonActionPerformed(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        enableButtons(true, true, false, false, true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        Role currentRole = getRoleController.getCurrentRole();
        if (currentRole == null) {
            JOptionPane.showMessageDialog(this, "Primero debe consultar un Rol");
            clearFilds();
            enableButtons(false, true, false, false, true);
            return;
        }

        Integer rolId = null;
        try {
            rolId = Integer.valueOf(codeField.getText());
            if (currentRole.getId().intValue() != rolId) {
                JOptionPane.showMessageDialog(this, "El Id del Rol no coincide con el Id del Rol actual");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El codigo debe ser numerico");
            return;
        }

        var option = JOptionPane.showConfirmDialog(this,
                "Confirme si desea elimimar este Rol", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            var controller = dependencyContainer.resolve(DeleteRoleController.class);
            controller.executeAction(rolId);
            getRoleController.clearCurrentRole();
            JOptionPane.showMessageDialog(this, "Rol eliminado con exito");
            clearFilds();
            listButtonActionPerformed(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        enableButtons(true, true, false, false, true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        try {
            // TODO add your handling code here:
            var controller = dependencyContainer.resolve(ListAllRoleController.class);
            var rolesList = controller.executeAction();
            if (rolesList == null || rolesList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No existen roles en el sistema");
                return;
            }
            loadRolesIntoTable(rolesList);
        } catch (Exception ex) {
            Logger.getLogger(RolesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listButtonActionPerformed

    private void loadRolesIntoTable(List<Role> rolesList) {
        String columns[] = {"ITEM", "ID", "NOMBRE", "DESCRIPCION"};
        String rowsWithRoles[][] = new String[rolesList.size()][4];
        for (var role : rolesList) {
            var rolePosition = rolesList.indexOf(role);
            rowsWithRoles[rolePosition][0] = (rolePosition + 1) + "";
            rowsWithRoles[rolePosition][1] = role.getId().toString();
            rowsWithRoles[rolePosition][2] = role.getName();
            rowsWithRoles[rolePosition][3] = role.getDescripcion();
        }
        DefaultTableModel tableModel = new DefaultTableModel(rowsWithRoles, columns);
        rolesTable.setModel(tableModel);
    }

    private void clearFilds() {
        codeField.setText("");
        nameField.setText("");
        descriptionField.setText("");
    }

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
            java.util.logging.Logger.getLogger(RolesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RolesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RolesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RolesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var container = DependencyContainer.getInstance();
                DependencyInjectionConfiguration.registerDependencies(container);
                RolesWindow dialog = new RolesWindow(new javax.swing.JFrame(), true, container);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void enableButtons(boolean add, boolean search, boolean edit,
            boolean delete, boolean list) {
        addButton.setEnabled(add);
        searchButton.setEnabled(search);
        editButton.setEnabled(edit);
        deleteButton.setEnabled(delete);
        listButton.setEnabled(list);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JScrollPane roleTableScroll;
    private javax.swing.JTable rolesTable;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
