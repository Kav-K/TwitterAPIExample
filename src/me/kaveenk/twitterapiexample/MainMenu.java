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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author kaveen
 */
public class MainMenu extends javax.swing.JFrame {
    
    private static Twitter twitter;
    private static ArrayList<String> staticTweetList;
    private static ArrayList<String> staticLinkList;
    private static String name;
    static Point mouseDownCompCoords;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        this.setUndecorated(true);
        initComponents();
        setBackgroundLabel();
        initMouseListener();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        stylizeButtons();
        initialize();
        
    }
    private void stylizeButtons() {
        exitButton.setBackground(new Color(50,204,254));
        minimizeButton.setBackground(new Color(50,204,254));
        searchButton.setBackground(new Color(50,204,254));
        tweetsList.setBackground(new Color(128,223,255));
        
        maxResultsLabel.setBackground(new Color(50,204,254));
        maxResultsLabel.setOpaque(true);
       
      
        
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
    
    private void initialize() {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("71Kw7SX1GwEelZH5Emg474Z6h")
                .setOAuthConsumerSecret("CYTRfqXl75jJdJ1mCplupiExkzsNXpw2LMc7BTwFrSKCSzU98P")
                .setOAuthAccessToken("713033676938981376-DoNznmVksWKbVRPzeEaHNjESbhN6zPz")
                .setOAuthAccessTokenSecret("kyEn7NRXE6Q8U0OHMsqv7pEKkc6iRYF27uVhfelV1Emw2").setTweetModeExtended(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        
    }
    
    public List<String> getTweets(String user) {
        ArrayList timelineList = new ArrayList<String>();
        try {
            twitter.getUserTimeline(user, new Paging(1, (int) resultsAmountSpinner.getValue())).stream().forEach(item -> {
                
                if (item.isRetweet()) {
                    timelineList.add("(" + item.getCreatedAt().toString() + ") " + item.getRetweetedStatus().getText());
                } else {
                    timelineList.add("(" + item.getCreatedAt().toString() + ") " + item.getText());
                }
            });
            staticTweetList = timelineList;
            return timelineList;
            
        } catch (TwitterException ex) {
            ex.printStackTrace();
            return Arrays.asList("Error occurred. Check if the user is valid");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tweetScrollPane = new javax.swing.JScrollPane();
        tweetsList = new javax.swing.JList<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        resultsAmountSpinner = new javax.swing.JSpinner();
        maxResultsLabel = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tweetsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tweetsListMouseClicked(evt);
            }
        });
        tweetScrollPane.setViewportView(tweetsList);

        searchButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        searchButton.setText("Get User Tweets");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        titleLabel.setText("Twitter API Example");

        resultsAmountSpinner.setModel(new javax.swing.SpinnerNumberModel(20, 1, 2000, 1));

        maxResultsLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        maxResultsLabel.setText("Max Results:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tweetScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(maxResultsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultsAmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minimizeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(resultsAmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxResultsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweetScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultListModel model = new DefaultListModel();
        
        for (String s : getTweets(searchField.getText())) {
            model.addElement(s);
        }
        this.name = "@" + searchField.getText();
        
        tweetsList.setModel(model);
        

    }//GEN-LAST:event_searchButtonActionPerformed

    private void tweetsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tweetsListMouseClicked
        if (evt.getClickCount() == 2) {
            JList source = (JList) evt.getSource();
            int index = source.getSelectedIndex();
            
            new SingularDisplayPane(name, staticTweetList.get(index)).setVisible(true);
            
        }

    }//GEN-LAST:event_tweetsListMouseClicked

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel maxResultsLabel;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JSpinner resultsAmountSpinner;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JScrollPane tweetScrollPane;
    private javax.swing.JList<String> tweetsList;
    // End of variables declaration//GEN-END:variables
}
