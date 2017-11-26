/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul_prog1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
/**
 *
 * @author Lucca
 */
public class View extends javax.swing.JFrame implements IGame {

    private Game game;
    
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        game = new Game(this);        
        
        InitPopups();
        UpdateLocation();
        UpdatePlayer();
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        personsList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRoomPictureBoxPlaceholder = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryList = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        northButton = new javax.swing.JButton();
        westButton = new javax.swing.JButton();
        southButton = new javax.swing.JButton();
        eastButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelPlayerPictureBoxPlaceholder = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        playerNameLabel = new javax.swing.JLabel();
        playerCapacityLabel = new javax.swing.JLabel();
        playerDamageLabel = new javax.swing.JLabel();
        playerWeaponLabel = new javax.swing.JLabel();
        playerLifepointsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        infoMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        muteSoundMenuItem = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zuul");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1216, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DefaultListModel personsListModel = new DefaultListModel();
        itemsList.setModel(personsListModel);
        personsList.setPreferredSize(new java.awt.Dimension(200, 100));
        jScrollPane3.setViewportView(personsList);

        itemsList.setModel(new DefaultListModel());
        itemsList.setPreferredSize(new java.awt.Dimension(200, 100));
        itemsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(itemsList);

        jLabel1.setText("Gegenstände:");

        jLabel2.setText("Personen:");

        panelRoomPictureBoxPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelRoomPictureBoxPlaceholder.setPreferredSize(new java.awt.Dimension(320, 200));
        panelRoomPictureBoxPlaceholder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRoomPictureBoxPlaceholderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRoomPictureBoxPlaceholderLayout = new javax.swing.GroupLayout(panelRoomPictureBoxPlaceholder);
        panelRoomPictureBoxPlaceholder.setLayout(panelRoomPictureBoxPlaceholderLayout);
        panelRoomPictureBoxPlaceholderLayout.setHorizontalGroup(
            panelRoomPictureBoxPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRoomPictureBoxPlaceholderLayout.setVerticalGroup(
            panelRoomPictureBoxPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        jLabel6.setText("Raum:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRoomPictureBoxPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoomPictureBoxPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, roomLabel});

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMinimumSize(new java.awt.Dimension(322, 530));

        itemsList.setModel(new DefaultListModel());
        inventoryList.setPreferredSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setViewportView(inventoryList);

        jLabel5.setText("Inventar:");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        northButton.setText("Norden");
        northButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                northButtonActionPerformed(evt);
            }
        });

        westButton.setText("Westen");
        westButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                westButtonActionPerformed(evt);
            }
        });

        southButton.setText("Süden");
        southButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                southButtonActionPerformed(evt);
            }
        });

        eastButton.setText("Osten");
        eastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eastButtonActionPerformed(evt);
            }
        });

        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(westButton)
                                .addGap(95, 95, 95)
                                .addComponent(eastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(southButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(northButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(restartButton)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(northButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(westButton)
                    .addComponent(eastButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(southButton)
                .addGap(18, 18, 18)
                .addComponent(restartButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Tragkraft:");

        jLabel3.setText("Name:");

        panelPlayerPictureBoxPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPlayerPictureBoxPlaceholder.setPreferredSize(new java.awt.Dimension(100, 120));

        javax.swing.GroupLayout panelPlayerPictureBoxPlaceholderLayout = new javax.swing.GroupLayout(panelPlayerPictureBoxPlaceholder);
        panelPlayerPictureBoxPlaceholder.setLayout(panelPlayerPictureBoxPlaceholderLayout);
        panelPlayerPictureBoxPlaceholderLayout.setHorizontalGroup(
            panelPlayerPictureBoxPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        panelPlayerPictureBoxPlaceholderLayout.setVerticalGroup(
            panelPlayerPictureBoxPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setText("Schaden:");

        jLabel8.setText("Waffe:");

        jLabel9.setText("Lebenspunkte:");

        playerNameLabel.setText("jLabel10");

        playerCapacityLabel.setText("jLabel11");

        playerDamageLabel.setText("jLabel12");

        playerWeaponLabel.setText("jLabel13");

        playerLifepointsLabel.setText("jLabel14");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPlayerPictureBoxPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerLifepointsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerWeaponLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerDamageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerCapacityLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(359, 359, 359))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPlayerPictureBoxPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(playerNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(playerCapacityLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(playerDamageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(playerWeaponLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(playerLifepointsLabel))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        outputArea.setEditable(false);
        outputArea.setColumns(20);
        outputArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        outputArea.setLineWrap(true);
        outputArea.setRows(5);
        outputArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        outputArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
        outputArea.setMaximumSize(new java.awt.Dimension(164, 94));
        outputArea.setMinimumSize(new java.awt.Dimension(164, 94));
        outputArea.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                outputAreaMouseWheelMoved(evt);
            }
        });
        jScrollPane2.setViewportView(outputArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4});

        infoMenu.setText("Info");

        helpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        helpMenuItem.setText("Hilfe");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        infoMenu.add(helpMenuItem);

        muteSoundMenuItem.setText("Ton aus");
        muteSoundMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteSoundMenuItemActionPerformed(evt);
            }
        });
        infoMenu.add(muteSoundMenuItem);

        jMenuBar1.add(infoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *      
     */
    private void northButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_northButtonActionPerformed
        game.changeRoom(CardinalPoints.North);        
        UpdateLocation();
    }//GEN-LAST:event_northButtonActionPerformed

    /**
     *      
     */
    private void southButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_southButtonActionPerformed
        game.changeRoom(CardinalPoints.South);        
        UpdateLocation();
    }//GEN-LAST:event_southButtonActionPerformed

    /**
     *      
     */
    private void eastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eastButtonActionPerformed
        game.changeRoom(CardinalPoints.East);
        UpdateLocation();
    }//GEN-LAST:event_eastButtonActionPerformed

    /**
     *      
     */
    private void panelRoomPictureBoxPlaceholderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoomPictureBoxPlaceholderMouseClicked
        if(evt.getButton() == 1){//links
            game.look();
        }
    }//GEN-LAST:event_panelRoomPictureBoxPlaceholderMouseClicked

    /**
     *      
     */
    private void westButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_westButtonActionPerformed
        game.changeRoom(CardinalPoints.West);
        UpdateLocation();
    }//GEN-LAST:event_westButtonActionPerformed

    /**
     *      
     */
    private void itemsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsListMouseClicked

    }//GEN-LAST:event_itemsListMouseClicked

    /**
     *      
     */
    private void outputAreaMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_outputAreaMouseWheelMoved
        if(evt.isControlDown()){
            int wheelRotation = evt.getScrollAmount() * evt.getWheelRotation() * -1;
            Font font = outputArea.getFont();
            float size = font.getSize() + (wheelRotation / 2);
            outputArea.setFont(font.deriveFont(size));
        }        
    }//GEN-LAST:event_outputAreaMouseWheelMoved

    /**
     *      
     */
    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        game = null;
        game = new Game(this);        
        SetEnabledForAllControl(true);
        InitPopups();
        UpdateLocation();
        UpdatePlayer();
    }//GEN-LAST:event_restartButtonActionPerformed

    /**
     *      
     */
    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        HelpView help = new HelpView();
        help.setContentPane(help.getContentPane());
        help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        help.pack();

        help.setVisible(true);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    /**
     *      
     */
    private void muteSoundMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteSoundMenuItemActionPerformed
        if(muteSoundMenuItem.getState()){
            game.musicPlayer.stopPlayback();
        }
        else{
            try {
                game.musicPlayer.startPlayback();
            } catch (Exception ex) {
             
            }
        }
    }//GEN-LAST:event_muteSoundMenuItemActionPerformed

    /**
     *      
     * @param text
     */
    @Override
    public void writeDown(String text) {
        outputArea.setText(text + "\n");
    }
    
    /**
     *      
     */
    @Override
    public void gameOver() {
        SetEnabledForAllControl(false);
    }
    
    /**
     *      
     */
    private void SetEnabledForAllControl(Boolean value){
        inventoryList.setEnabled(value);
        itemsList.setEnabled(value);
        personsList.setEnabled(value);
        eastButton.setEnabled(value);
        northButton.setEnabled(value);
        westButton.setEnabled(value);
        southButton.setEnabled(value);
    }
    
    /**
     *      
     */
    private void UpdateLocation(){
        HashMap<CardinalPoints, Room> k = game.currentLocation.exits;
        northButton.setEnabled(k.keySet().contains(CardinalPoints.North));
        eastButton.setEnabled(k.keySet().contains(CardinalPoints.East));
        westButton.setEnabled(k.keySet().contains(CardinalPoints.West));
        southButton.setEnabled(k.keySet().contains(CardinalPoints.South));
        personsList.removeAll();
        
        
        UpdateItems();
        UpdatePersons();
        
        roomLabel.setText(game.currentLocation.GetDescription());
        
        SetBackgroundPicture(panelRoomPictureBoxPlaceholder, game.currentLocation.GetImagePath(), 330, 200);
    }
    
    /**
     *      
     */
    private void UpdateItems(){
        DefaultListModel dItemListModel = new DefaultListModel();
        int i = 0;
        for(Item p : game.currentLocation.GetItems()){
            dItemListModel.add(i, p.GetName());
            i++;
        }
        itemsList.setModel(dItemListModel);
    }
    
    /**
     *      
     */
    private void UpdatePersons(){
        DefaultListModel dPersonListModel = new DefaultListModel();
        int i = 0;
        for(Person p : game.currentLocation.GetPersons()){
            dPersonListModel.add(i, p.GetName());
            i++;
        }
        personsList.setModel(dPersonListModel);
    }
    
    /**
     *      
     */
    private void UpdatePlayer(){
        if(game != null && game.player != null){
            playerNameLabel.setText(game.player.GetName());
            playerCapacityLabel.setText(game.player.GetCapacity()+ " kg");
            playerLifepointsLabel.setText(game.player.GetLifePoints()+ "");
            playerDamageLabel.setText(game.player.GetDamage()+ "");
            if(game.player.GetWeapon() != null){
                playerWeaponLabel.setText(game.player.GetWeapon().GetName());
            }
            else{
                playerWeaponLabel.setText("");
            }
            SetBackgroundPicture(panelPlayerPictureBoxPlaceholder, game.player.GetImagePath(), 100, 150);
        }
    }
    
    /**
     * 
     * @param panel
     * @param imageUrl 
     */
    private void SetBackgroundPicture(JPanel panel, URL imageUrl, int width, int height){
        panel.removeAll();
            if(imageUrl != null && !"".equals(imageUrl.toString())){
                JLabel backImgPanel = new JLabel(new ImageIcon(imageUrl));
                backImgPanel.setLayout(null);
                backImgPanel.setOpaque(false);

                panel.add(backImgPanel);
                backImgPanel.setBounds(0, 0, width, height);
            }
    }
    
    /**
     *      
     */
    private void UpdateBackpack(){
        DefaultListModel dItemListModel = new DefaultListModel();
        int i = 0;
        for(Item p : game.player.GetBackpack()){
            dItemListModel.add(i, p.GetName());
            i++;
        }
        inventoryList.setModel(dItemListModel);
    }
    
    /**
     *      
     */    
    private void InitPopups(){        
        JPopupMenu popup = new JPopupMenu();
        HashMap<String,AbstractAction> itemsActionsDict = new HashMap<String,AbstractAction>();
        itemsActionsDict.put("Nimm", new AbstractAction("take") {
                public void actionPerformed(ActionEvent e) {
                    JMenuItem a = ((JMenuItem) e.getSource());
                    int i = itemsList.getSelectedIndex();
                    if(i != -1){
                        game.takeItem(i);
                        UpdateBackpack();
                        UpdateItems();
                    }                    
                }
            });
        
        for(String iA : itemsActionsDict.keySet()){
            JMenuItem a = new JMenuItem(itemsActionsDict.get(iA));
            a.setText(iA);            
            popup.add(a);
        }
        itemsList.setComponentPopupMenu(popup);
        itemsList.setInheritsPopupMenu(true);
        
        itemsActionsDict.clear();
        itemsActionsDict.put("Übernimm", new AbstractAction("overtake") {
                public void actionPerformed(ActionEvent e) {
                    JMenuItem a = ((JMenuItem) e.getSource());
                    int i = personsList.getSelectedIndex();
                    if(i != -1){
                        game.controlPerson(i);
                        UpdatePlayer();
                        UpdateBackpack();
                        UpdatePersons();
                    }                    
                }
            });
        itemsActionsDict.put("Töten", new AbstractAction("kill") {
                public void actionPerformed(ActionEvent e) {
                    JMenuItem a = ((JMenuItem) e.getSource());
                    int i = personsList.getSelectedIndex();
                    if(i != -1){
                        game.killPerson(i);
                        UpdatePlayer();
                        UpdateItems();
                        UpdateBackpack();
                        UpdatePersons();
                    }                    
                }
            });
        
        popup = new JPopupMenu();        
        for(String pA : itemsActionsDict.keySet()){
            JMenuItem a = new JMenuItem(itemsActionsDict.get(pA));
            a.setText(pA);
            popup.add(a);
        }
        personsList.setComponentPopupMenu(popup);
        personsList.setInheritsPopupMenu(true);
        
        
        itemsActionsDict.clear();
        itemsActionsDict.put("Ablegen", new AbstractAction("discard") {
                public void actionPerformed(ActionEvent e) {
                    JMenuItem a = ((JMenuItem) e.getSource());
                    int i = inventoryList.getSelectedIndex();
                    if(i != -1){
                        //Item item = game.player.GetWeapon();
                        Item item = game.player.GetBackpack().get(i);
                        game.currentLocation.InsertItem(item);
                        game.player.GetBackpack().remove(i);
                        UpdateBackpack();
                        UpdateItems();
                    }                 
                }
            });
        itemsActionsDict.put("Waffe", new AbstractAction("takeAsWeapon") {
                public void actionPerformed(ActionEvent e) {
                    JMenuItem a = ((JMenuItem) e.getSource());
                    int i = inventoryList.getSelectedIndex();
                    if(i != -1){
                        game.takeAsWeapon(i);
                        UpdateBackpack();
                        UpdatePlayer();
                    }                    
                }
            });
        popup = new JPopupMenu();        
        for(String iA : itemsActionsDict.keySet()){
            JMenuItem a = new JMenuItem(itemsActionsDict.get(iA));
            a.setText(iA);
            popup.add(a);
        }
        inventoryList.setComponentPopupMenu(popup);
        inventoryList.setInheritsPopupMenu(true);
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eastButton;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenu infoMenu;
    private javax.swing.JList inventoryList;
    private javax.swing.JList itemsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JCheckBoxMenuItem muteSoundMenuItem;
    private javax.swing.JButton northButton;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JPanel panelPlayerPictureBoxPlaceholder;
    private javax.swing.JPanel panelRoomPictureBoxPlaceholder;
    private javax.swing.JList personsList;
    private javax.swing.JLabel playerCapacityLabel;
    private javax.swing.JLabel playerDamageLabel;
    private javax.swing.JLabel playerLifepointsLabel;
    private javax.swing.JLabel playerNameLabel;
    private javax.swing.JLabel playerWeaponLabel;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JButton southButton;
    private javax.swing.JButton westButton;
    // End of variables declaration//GEN-END:variables
}
