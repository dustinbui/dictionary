/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import AVLTree.Node;
import AVLTree.AVLTree;
import PrefixTree.PrefixTree;
import PrefixTree.TrieNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Anh Bui
 */
public class MainForm extends javax.swing.JFrame {

    private static AVLTree avlTree;
    private static PrefixTree prefixTree;
    private static TrieNode root;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Dictionary");
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
        tfInput = new javax.swing.JTextField();
        cbbSuggest = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();
        lbResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfInputCaretUpdate(evt);
            }
        });
        jPanel1.add(tfInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        cbbSuggest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSuggestActionPerformed(evt);
            }
        });
        jPanel1.add(cbbSuggest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        lbResult.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btSearch)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSearch)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        Node n = avlTree.search(avlTree.getRoot(), tfInput.getText());
        if (n != null) {
            lbResult.setText(n.getVi());
        } else {
            lbResult.setText("Không có kết quả!");
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void tfInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfInputCaretUpdate
        cbbSuggest.removeAllItems();
        String input = tfInput.getText();
        if (prefixTree.find(root, input)) {
            prefixTree.createA();
            ArrayList a = prefixTree.result(prefixTree.getCurNode(), 0, new char[100], input);
            for (int i = 0; i < a.size(); i++) {
                cbbSuggest.addItem((String) a.get(i));
            }
            cbbSuggest.showPopup();
        }
    }//GEN-LAST:event_tfInputCaretUpdate

    private void cbbSuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSuggestActionPerformed
        int i = cbbSuggest.getSelectedIndex();
        try {
            tfInput.setText(cbbSuggest.getItemAt(i));
        } catch (IllegalStateException e) {
        }
    }//GEN-LAST:event_cbbSuggestActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
        avlTree = new AVLTree();
        prefixTree = new PrefixTree();
        root = new TrieNode('\0');
        // Đọc file
        try {
            FileReader fr = new FileReader(new File("anhviet.txt"));
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String regex[] = line.split("[@/]");
                String line2 = br.readLine();
                prefixTree.insertWord(root, regex[1].toLowerCase());
                avlTree.setRoot(avlTree.insertNode(avlTree.getRoot(), regex[1].toLowerCase(), line2.toLowerCase()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbbSuggest;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField tfInput;
    // End of variables declaration//GEN-END:variables
}
