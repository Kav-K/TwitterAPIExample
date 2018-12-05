/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kaveenk.twitterapiexample;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static me.kaveenk.twitterapiexample.MainMenu.mouseDownCompCoords;

/**
 *
 * @author kaveen
 */
public class SingularDisplayPane extends javax.swing.JFrame {

    private static String name;
    private static String s_message;
    private String message;
    private static String date;

    /**
     * Creates new form SingularDisplayPane
     */
    public SingularDisplayPane(String name, String message) {
        this.name = name;
        String date = message.substring(0, 30);
        this.date = date;

        message = message.substring(message.lastIndexOf(") ") + 1).trim();
        this.s_message = message;
        this.message = message;

        this.setUndecorated(true);
        this.setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);

        tweetArea.setEnabled(true);
        tweetArea.setLineWrap(true);
        tweetArea.setWrapStyleWord(true);

        tweetArea.setText(message);
        dateLabel.setText(date);
        handleLabel.setText(name);
        initMouseListener();
        setBackgroundLabel();
        stylize();

    }

    private void stylize() {
        dateLabel.setBackground(new Color(50, 204, 254));
        dateLabel.setOpaque(true);
        tweetArea.setBackground(new Color(128, 223, 255));
        minimizeButton.setBackground(new Color(50, 204, 254));
        exitButton.setBackground(new Color(50, 204, 254));

    }

    private void initMouseListener() {
        try {
            this.addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent e) {
                    mouseDownCompCoords = null;
                }

                public void mousePressed(MouseEvent e) {
                    mouseDownCompCoords = e.getPoint();
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                }
            });

            this.addMouseMotionListener(new MouseMotionListener() {
                public void mouseMoved(MouseEvent e) {
                }

                public void mouseDragged(MouseEvent e) {
                    Point currCoords = e.getLocationOnScreen();
                    setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
                }
            });
        } catch (Exception e) {
            //Silence
        }

    }

    private void setBackgroundLabel() {
        BufferedImage background = null;

        try {
            background = ImageIO.read(new File("resources/bg.jpg"));

        } catch (Exception e) {
            //Silence, for now
        }
        JLabel backgroundLabel = new JLabel(new ImageIcon(background));
        backgroundLabel.setBounds(0, 0, backgroundLabel.getPreferredSize().width, backgroundLabel.getPreferredSize().height);

        this.getContentPane().add(backgroundLabel);
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
        tweetArea = new javax.swing.JTextArea();
        handleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tweetArea.setColumns(20);
        tweetArea.setRows(5);
        tweetArea.setDisabledTextColor(new java.awt.Color(38, 38, 38));
        tweetArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tweetAreaFocusGained(evt);
            }
        });
        tweetArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tweetAreaMouseClicked(evt);
            }
        });
        tweetArea.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tweetAreaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tweetAreaCaretPositionChanged(evt);
            }
        });
        tweetArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tweetAreaPropertyChange(evt);
            }
        });
        tweetArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tweetAreaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tweetAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tweetAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tweetArea);

        handleLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        handleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        handleLabel.setLabelFor(tweetArea);
        handleLabel.setText("Tweet From");
        handleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("(Mon Dec 03 07:49:16 EST 2018)");
        dateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        minimizeButton.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        minimizeButton.setText("-");
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("URW Gothic L", 0, 15)); // NOI18N
        exitButton.setText("x");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(dateLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(handleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(handleLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minimizeButton)
                        .addComponent(exitButton)))
                .addGap(18, 18, 18)
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();

    }//GEN-LAST:event_exitButtonActionPerformed

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    private void tweetAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tweetAreaFocusGained
        
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaFocusGained

    private void tweetAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetAreaMouseClicked
        evt.consume();
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaMouseClicked

    private void tweetAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweetAreaKeyPressed
       // evt.consume();
       // tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaKeyPressed

    private void tweetAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweetAreaKeyReleased
        // evt.consume();
        //tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaKeyReleased

    private void tweetAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweetAreaKeyTyped
         evt.consume();
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaKeyTyped

    private void tweetAreaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tweetAreaInputMethodTextChanged
         evt.consume();
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaInputMethodTextChanged

    private void tweetAreaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tweetAreaCaretPositionChanged
      evt.consume();
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaCaretPositionChanged

    private void tweetAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tweetAreaPropertyChange
         
        tweetArea.setText(this.message);
    }//GEN-LAST:event_tweetAreaPropertyChange

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
            java.util.logging.Logger.getLogger(SingularDisplayPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingularDisplayPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingularDisplayPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingularDisplayPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingularDisplayPane(name, s_message).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel handleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JTextArea tweetArea;
    // End of variables declaration//GEN-END:variables
}
