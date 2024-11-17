package FamilyFinances.Views.Families;

import FamilyFinances.Controllers.Interfaces.Families.ICreateFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IDeleteFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamiliesController;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IUpdateFamilyController;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;
import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Infrastructure.Configurations.DependencyContainer;
import FamilyFinances.Infrastructure.Configurations.DependencyInjectionConfiguration;
import FamilyFinances.Main;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnarrieta
 */
public class FamiliesWindow extends javax.swing.JDialog {

    private final DependencyContainer dependencyContainer;
    private final IGetFamiliesController getFamiliesController;
    private final ILoginUserController loginUserController;
    private final ICreateFamilyController createFamilyController;
    private final IGetFamilyController getFamilyController;
    private final IUpdateFamilyController updateFamilyController;
    private final IDeleteFamilyController deleteFamilyController;
    private Family currentFamily;

    /**
     * Creates new form RolesWindow
     *
     * @param parent
     * @param modal
     * @param container
     */
    public FamiliesWindow(java.awt.Frame parent, boolean modal, DependencyContainer container) {
        super(parent, modal);
        initComponents();
        this.dependencyContainer = container;
        getFamiliesController = dependencyContainer.resolve(IGetFamiliesController.class);
        loginUserController = dependencyContainer.resolve(ILoginUserController.class);
        createFamilyController = dependencyContainer.resolve(ICreateFamilyController.class);
        getFamilyController = dependencyContainer.resolve(IGetFamilyController.class);
        updateFamilyController = dependencyContainer.resolve(IUpdateFamilyController.class);
        deleteFamilyController = dependencyContainer.resolve(IDeleteFamilyController.class);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusRadioGruop = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        disabledRadioField = new javax.swing.JRadioButton();
        enabledRadioField = new javax.swing.JRadioButton();
        phoneNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        roleTableScroll = new javax.swing.JScrollPane();
        familiesTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        listButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("..:: Family Finances ::.. [Gestion de Usuarios]");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTION DE FAMILIAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Datos del Rol:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Direccion:");

        addressField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado:");

        statusRadioGruop.add(disabledRadioField);
        disabledRadioField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        disabledRadioField.setText("Inactivo");

        statusRadioGruop.add(enabledRadioField);
        enabledRadioField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        enabledRadioField.setText("Activo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(enabledRadioField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(disabledRadioField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enabledRadioField)
                    .addComponent(disabledRadioField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phoneNumberField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressField)
                            .addComponent(phoneNumberField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressField)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FamilyFinances/Views/Icons/Family256px.png"))); // NOI18N

        familiesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "ID", "NOMBRE", "DIRECCION", "ESTADO", "CREADO POR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        familiesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        familiesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        familiesTable.setShowHorizontalLines(true);
        familiesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                familiesTableMouseClicked(evt);
            }
        });
        familiesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                familiesTableKeyPressed(evt);
            }
        });
        roleTableScroll.setViewportView(familiesTable);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(listButton)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton)
                    .addComponent(searchButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(listButton))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roleTableScroll)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roleTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            // 1. Confirmar accion
            var option = JOptionPane.showConfirmDialog(this, "Desea agregar esta Familia al sistema",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.NO_OPTION) {
                return;
            }
            // 2). Recuperar los datos ingresados en los campos del formulario
            var name = nameField.getText();
            var address = addressField.getText();
            var phoneNumber = phoneNumberField.getText();
            var currentUser = Main.currentUser;

            if (!this.fieldValidate(name, phoneNumber, address)) {
                return;
            }
            var status = getSelectedStatus();
            createFamilyController.executeAction(name, phoneNumber, address, LocalDateTime.now(), currentUser, status);
            JOptionPane.showMessageDialog(this, "Usuario registrado con exito");
            clearFilds();
            listButtonActionPerformed(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        enableButtons(true, true, false, false, true);
    }//GEN-LAST:event_addButtonActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listButtonActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            // TODO add your handling code here:
            var name = nameField.getText();

            if (name == null || name.isBlank()) {
                JOptionPane.showMessageDialog(this, "El Nombre es requerido");
                enableButtons(true, true, false, false, true);
                return;
            }

            var famlies = getFamiliesController.executeAction(name);
            loadFamiliesIntoTable(famlies);
            enableButtons(true, true, false, false, true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            clearFilds();
            currentFamily = null;
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // 1. Confirmar accion
        var option = JOptionPane.showConfirmDialog(this, "Desea modificar esta Familia",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            var id = currentFamily.getId();
            var name = nameField.getText();
            var newPhoneNumber = phoneNumberField.getText();
            var newAddress = addressField.getText();
            var newStatus = getSelectedStatus();

            updateFamilyController.executeAction(id, name, newPhoneNumber,
                    newAddress, LocalDateTime.now(), Main.currentUser, newStatus);
            JOptionPane.showMessageDialog(this, "Familia actualizada con exito");
            clearFilds();
            listButtonActionPerformed(null);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_editButtonActionPerformed


    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        var option = JOptionPane.showConfirmDialog(this, "Desea eliminar esta Familia",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            var familyId = currentFamily.getId();
            deleteFamilyController.exectuteAction(familyId);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
        listButtonActionPerformed(null);
        clearFilds();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        try {
            // TODO add your handling code here:
            var usersList = getFamiliesController.executeAction();
            loadFamiliesIntoTable(usersList);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
             loadFamiliesIntoTable(new ArrayList<Family>());
        }
    }//GEN-LAST:event_listButtonActionPerformed

    private void familiesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_familiesTableMouseClicked
        // TODO add your handling code here:
        var rowPosition = familiesTable.getSelectedRow();
        var family = getSelectedFamily(rowPosition);
        if (family == null) {
            clearFilds();
            return;
        }
        loadFamilyInForm(family);
    }//GEN-LAST:event_familiesTableMouseClicked

    private void familiesTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_familiesTableKeyPressed
        familiesTableMouseClicked(null);
    }//GEN-LAST:event_familiesTableKeyPressed


    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed

        try {
            var families = getFamiliesController.executeAction(nameField.getText());
            loadFamiliesIntoTable(families);
        } catch (Exception e) {
            loadFamiliesIntoTable(new ArrayList<Family>());
        }

    }//GEN-LAST:event_nameFieldKeyPressed

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
            java.util.logging.Logger.getLogger(FamiliesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FamiliesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FamiliesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FamiliesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var container = DependencyContainer.getInstance();
                DependencyInjectionConfiguration.registerDependencies(container);
                FamiliesWindow dialog = new FamiliesWindow(new javax.swing.JFrame(), true, container);
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

    private EntityStatusEnum getSelectedStatus() {
        if (enabledRadioField.isSelected()) {
            return EntityStatusEnum.ENABLED;
        }
        if (disabledRadioField.isSelected()) {
            return EntityStatusEnum.DISABLED;
        }
        return null;
    }

    private String getStatus(EntityStatusEnum status) {
        if (status == EntityStatusEnum.DISABLED) {
            return "INACTIVO";
        }
        return "ACTIVO";
    }

    private void clearFilds() {
        nameField.setText("");
        addressField.setText("");
        phoneNumberField.setText("");
    }

    private void loadFamiliesIntoTable(List<Family> families) {
        String columns[] = {"ID", "NOMBRE", "CREADO POR", "ESTADO",};
        if (families == null) {
            families = new ArrayList<>();
        }
        String[][] rowsWithFamilies = new String[families.size()][4];
        for (var family : families) {
            var userPosition = families.indexOf(family);
            rowsWithFamilies[userPosition][0] = family.getId().toString();
            rowsWithFamilies[userPosition][1] = family.getName();
            rowsWithFamilies[userPosition][2] = family.getCreatedBy().getName();
            rowsWithFamilies[userPosition][3] = getStatus(family.getStatus());
        }
        DefaultTableModel tableModel = new DefaultTableModel(rowsWithFamilies, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        familiesTable.setModel(tableModel);
        currentFamily = null;
        enableButtons(true, true, false, false, true);
        var nameTemp = nameField.getText();
        clearFilds();
        nameField.setText(nameTemp);
    }

    private boolean fieldValidate(String name, String phoneNumber, String address) {
        if (name == null || name.isBlank()) {
            JOptionPane.showMessageDialog(this, "El Nombre es requerido");
            return false;
        }

        if (name.length() < 4) {
            JOptionPane.showMessageDialog(this, "El Nombre debe ser minimo de 3 caracteres");
            return false;
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            JOptionPane.showMessageDialog(this, "El Numero de telefono es requerido");
            return false;
        }

        if (!enabledRadioField.isSelected() && !disabledRadioField.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe escoger un Estado");
            return false;
        }

        return true;
    }

    private Family getSelectedFamily(Integer rowPosition) {
        try {
            if (rowPosition == null || rowPosition < 0) {
                return null;
            }
            var familyId = (String) familiesTable.getModel().getValueAt(rowPosition, 0);
            return getFamilyController.executeAction(Integer.parseInt(familyId));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return null;
        }
    }

    private void loadFamilyInForm(Family family) {
        nameField.setText(family.getName());
        phoneNumberField.setText(family.getPhoneNumber());
        addressField.setText(family.getAddress());
        switch (family.getStatus()) {
            case ENABLED:
                enabledRadioField.setSelected(true);
                break;
            case DISABLED:
                disabledRadioField.setSelected(true);
        }
        currentFamily = family;
        enableButtons(false, true, true, true, true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JRadioButton disabledRadioField;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton enabledRadioField;
    private javax.swing.JTable familiesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton listButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JScrollPane roleTableScroll;
    private javax.swing.JButton searchButton;
    private javax.swing.ButtonGroup statusRadioGruop;
    // End of variables declaration//GEN-END:variables
}