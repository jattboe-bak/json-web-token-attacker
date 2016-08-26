/**
 * JOSEPH - JavaScript Object Signing and Encryption Pentesting Helper
 * Copyright (C) 2016 Dennis Detering
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package eu.dety.burp.joseph.attacks.BleichenbacherPkcs1.gui;

public class BleichenbacherPkcs1DecryptionAttackPanel extends javax.swing.JPanel {

    /**
     * Creates new form BleichenbacherPkcs1DecryptionAttackPanel
     */
    public BleichenbacherPkcs1DecryptionAttackPanel() {
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

        decryptionAttackButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("JOSEPH"); // NOI18N
        decryptionAttackButton.setText(bundle.getString("ATTACKBUTTON")); // NOI18N
        decryptionAttackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionAttackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(decryptionAttackButton)
                .addGap(0, 329, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(decryptionAttackButton)
                .addGap(0, 268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void decryptionAttackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionAttackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decryptionAttackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decryptionAttackButton;
    // End of variables declaration//GEN-END:variables
}