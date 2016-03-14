/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsmtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bertrand
 */
public class Connexion extends javax.swing.JFrame {
    private Socket skt;
    private BufferedReader in;
    private PrintWriter out;
    private int port;
    
    /**
     * Creates new form Connexion
     */
    public Connexion() {
        initComponents();
        loadConfiguration();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_user = new javax.swing.JTextField();
        lb_id = new javax.swing.JLabel();
        lb_mdp = new javax.swing.JLabel();
        tf_pass = new javax.swing.JPasswordField();
        lb_title = new javax.swing.JLabel();
        btn_apop = new javax.swing.JButton();
        btn_userpass = new javax.swing.JButton();
        lb_ipserv = new javax.swing.JLabel();
        tf_ipserv = new javax.swing.JTextField();
        lb_port = new javax.swing.JLabel();
        tf_port = new javax.swing.JTextField();
        cb_md5 = new javax.swing.JCheckBox();
        cb_save = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lb_id.setText("Identifiant :");

        lb_mdp.setText("Mot de passe :");

        lb_title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("Client mail");

        btn_apop.setText("APOP");
        btn_apop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apopActionPerformed(evt);
            }
        });

        btn_userpass.setText("USER / PASS");
        btn_userpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userpassActionPerformed(evt);
            }
        });

        lb_ipserv.setText("Ip serveur :");

        lb_port.setText("Port :");

        tf_port.setText("587");

        cb_md5.setText("MD5 ?");

        cb_save.setText("Sauvegarder ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_ipserv)
                    .addComponent(lb_mdp)
                    .addComponent(lb_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_title, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(tf_user)
                            .addComponent(tf_pass)
                            .addComponent(tf_ipserv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_port)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_md5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_apop, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btn_userpass, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(cb_save)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ipserv)
                    .addComponent(tf_ipserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_port)
                    .addComponent(tf_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_id))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_mdp)
                    .addComponent(tf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_md5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(cb_save)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_apop)
                    .addComponent(btn_userpass))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_apopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apopActionPerformed
        connexion();
        String pass = new String(tf_pass.getPassword());
        saveConfiguration();
        
        //envoiMessage("ok");
        System.out.println(recoitMessage());
        
        envoiMessage("APOP "+tf_user.getText()+" "+getPassword());
        String result = recoitMessage();
        
        System.out.println(result);
        if(result.contains("OK"))
        {
            new Interface(skt, in, out).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Combinaison identifiant/mot de passe incorrecte");
        }
    }//GEN-LAST:event_btn_apopActionPerformed

    private void btn_userpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userpassActionPerformed
        connexion();
        String pass = new String(tf_pass.getPassword());
        saveConfiguration();
        
        //envoiMessage("ok");
        System.out.println(recoitMessage());
        
        envoiMessage("USER "+tf_user.getText());
        String result = recoitMessage();
        
        System.out.println(result);
        if(result.contains("OK"))
        {
            envoiMessage("PASS "+getPassword());
            result = recoitMessage();
            
            System.out.println(result);
            if(result.contains("OK"))
            {
                new Interface(skt, in, out).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Mot de passe incorrect");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Utilisateur non trouvé");
        }
    }//GEN-LAST:event_btn_userpassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_apop;
    private javax.swing.JButton btn_userpass;
    private javax.swing.JCheckBox cb_md5;
    private javax.swing.JCheckBox cb_save;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_ipserv;
    private javax.swing.JLabel lb_mdp;
    private javax.swing.JLabel lb_port;
    private javax.swing.JLabel lb_title;
    private javax.swing.JTextField tf_ipserv;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_port;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables

    private boolean verfierChamps() {
        String pass = new String(tf_pass.getPassword());
        return(!tf_ipserv.getText().trim().equals("") && !tf_user.getText().trim().equals("") && !pass.equals(""));
    }
    
    private String getPassword()
    {
        String result = "";
        String pass = new String(tf_pass.getPassword());
        if(cb_md5.isSelected())
        {
            String hashtext = "";
            try {
                MessageDigest m = MessageDigest.getInstance("MD5");
                m.reset();
                m.update(pass.getBytes());
                byte[] digest = m.digest();
                BigInteger bigInt = new BigInteger(1,digest);
                hashtext = bigInt.toString(16);
                while(hashtext.length() < 32 ){
                    hashtext = "0"+hashtext;
                }
                result = hashtext;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Le cryptage a retourné une erreur");
            }
        }
        else
        {
            result = pass;
        }
        return result;
    }
    
    private void connexion()
    {       
        if(!verfierChamps())
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs");
            return;
        }
        try {
            port = Integer.parseInt(tf_port.getText());
            skt = new Socket(tf_ipserv.getText(), port);
            in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            out = new PrintWriter(skt.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Connexion impossible");
        } 
    }
    
    private void envoiMessage(String message)
    {
        System.out.println(message+" ->");
        out.write(message+'\n');
    }
    
    private String recoitMessage()
    {
        String result = "";
        try {
            char c = (char) in.read();
            while(c != '\n')
            {
                result += c;
                c = (char)in.read();  
            }
            System.out.println("<- "+result);
        } catch (IOException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private void loadConfiguration()
    {
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(FileSystems.getDefault().getPath(System.getProperty("user.dir")+"/smtpconfig.txt"), charset)) {
            String line = null;
            int i=0;
            while ((line = reader.readLine()) != null) {
                switch(i)
                {
                    case 0:
                        tf_ipserv.setText(line);
                        break;
                    case 1:
                        tf_user.setText(line);
                        break;
                    case 2:
                        tf_port.setText(line);
                        break;
                }                
                i++;
            }
            System.out.println("Configuration chargée !");
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null,"La configuration n'a pas pu être chargée. Le fichier n'existe peut-être pas encore.");
        }
    }
    
    private void saveConfiguration()
    {
        if(cb_save.isSelected())
        {
            try {
                if(!new File(FileSystems.getDefault().getPath(System.getProperty("user.dir")+"/smtpconfig.txt").toString()).exists())
                {
                    Files.createFile(FileSystems.getDefault().getPath(System.getProperty("user.dir")+"/smtpconfig.txt"));
                }
                
                List<String> lines = Arrays.asList(tf_ipserv.getText(), tf_user.getText(), tf_port.getText());
                Path file = FileSystems.getDefault().getPath(System.getProperty("user.dir")+"/smtpconfig.txt");
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Le fichier de sauvegarde n'a pas pu être atteint (problème de droits)");
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
