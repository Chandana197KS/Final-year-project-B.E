package datasecuritycloud;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.util.*; 
import java.io.*; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bala J
 */
public class Main extends javax.swing.JFrame {

    
    NetworkListener nwlisten;
    
    S3Interfacer s3interface;
    
    static Main instance;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        instance=this;
        
        Connection con=null;
        Statement stmt=null;
        ResultSet rst=null;

        String sql="select email from registration";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rst = stmt.executeQuery(sql);
            to.addItem("All");
            while(rst.next()){
                to.addItem(rst.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        userip = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        userport = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        listenport = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filetoupload = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        uploadFiletoCloud = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        to = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logtext = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data owner");

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));

        start.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("User Port");

        userip.setText("127.0.0.1");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("User IP");

        userport.setText("1000");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Listen Port");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userport, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listenport, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userip, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listenport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configuration", jPanel1);

        jPanel2.setForeground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("File to upload");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 42, 160, 38));
        jPanel2.add(filetoupload, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 45, 241, 38));

        browse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        browse.setText("BROWSE");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel2.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 43, -1, 36));

        uploadFiletoCloud.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        uploadFiletoCloud.setText("UPLOAD TO CLOUD");
        uploadFiletoCloud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFiletoCloudActionPerformed(evt);
            }
        });
        jPanel2.add(uploadFiletoCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 302, 414, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Enter Key for  encryption ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 117, -1, -1));

        key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyActionPerformed(evt);
            }
        });
        jPanel2.add(key, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 112, 241, 44));

        to.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toItemStateChanged(evt);
            }
        });
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });
        jPanel2.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 190, 331, 34));

        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("*  15 charecter key");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 126, 168, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Select user");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 196, -1, -1));

        jTabbedPane1.addTab("File Upload", jPanel2);

        jScrollPane1.setViewportView(logtext);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
       try{ 
         Process process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org"); 
        int x = process.waitFor(); 
        if (x == 0) { 
            
            JOptionPane.showMessageDialog(this, "Sucessfull Connection");
            System.out.println("Connection Successful, "
                               + "Output was " + x); 
        } 
        else { 
             JOptionPane.showMessageDialog(this, "Internet Not Connected");
            System.out.println("Internet Not Connected, "
                               + "Output was " + x); 
        } 
        
        
        s3interface = new S3Interfacer();
        
        
        int lp = Integer.parseInt(listenport.getText());
        
        String uip = userip.getText();
        int uport = Integer.parseInt(userport.getText());
        
                
        nwlisten = new NetworkListener(lp,this,uip,uport);
        nwlisten.start();
        
       }catch(Exception e){
          JOptionPane.showMessageDialog(this, "e"); 
       }
    }//GEN-LAST:event_startActionPerformed

    
     private static String readFileAsString(String filePath) {

        try {
            StringBuffer fileData = new StringBuffer(1000);
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
            reader.close();
            return fileData.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

     
    private void uploadFiletoCloudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFiletoCloudActionPerformed
        // TODO add your handling code here:
        File f=new File(filetoupload.getText());
        
        if(to.getSelectedItem().equals("All")){
            SendEmailToAll.send(f, key.getText());
        }else{
            SendEmail.send(f, key.getText(),to.getSelectedItem().toString());
        }
        
        try
        {
            File fx = new File("Keys.txt");
            fx.delete();
        }
        catch(Exception e)
        {
            
        }
        String cont = readFileAsString(filetoupload.getText());
        System.out.println("cont:"+cont);
        String filename = filetoupload.getText();
        System.out.println("filename:"+filename);
        String fnoext = filename.split("\\.")[0];
         System.out.println("fnoext:"+fnoext);
        int partlen= cont.length()/5;
        
        String [] parts  = new String[5];
        parts[0] = cont.substring(0, partlen);
        parts[1] = cont.substring(partlen, 2*partlen);
        parts[2] = cont.substring(2*partlen, 4*partlen);
        parts[3] = cont.substring(4*partlen, 5*partlen);
        parts[4] = cont.substring(5*partlen, cont.length());
        try
        {
            String keybase = key.getText();
            for (int i=0;i<parts.length;i++)
            {
                writetolog("Part " + i + "=" + parts[i]);

                String keytouse = keybase + i;

                String msg = "KEYTOUSE#" + keytouse + "#";

                nwlisten.sendMessage(msg);

                FileAppender.AppendtoFile("Keys.txt",keytouse);

                

                String partfilename = fnoext + "-" + i + ".txt"; 
                try
                {
                     
                    File fx = new File(partfilename);
                    fx.delete();
                    
                    
                }
                catch(Exception e)
                {
                    
                }
                AESUtil.keyValue = keytouse.getBytes();
               String encrcont=AESUtil.encrypt(parts[i]);
                
                FileAppender.AppendtoFileNoLine(partfilename, encrcont);
                
                File fx = new File(partfilename);
                
                
                s3interface.uploadFileToCloud(partfilename, fx.getName());
                
                writetolog("uploaded the file " + partfilename + " to cloud");
                

            }
            
            
            JOptionPane.showMessageDialog(this, "file upload to cloud completed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
       
        
        
        
        
        
        
        
    }//GEN-LAST:event_uploadFiletoCloudActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        
        JFileChooser jc = new JFileChooser(".");


        int ret = jc.showOpenDialog(this);

        if(ret == JFileChooser.APPROVE_OPTION)
        {
            File f  = jc.getSelectedFile();

            String fname = f.getAbsolutePath();

            filetoupload.setText(fname);
            
        }
        
        
    }//GEN-LAST:event_browseActionPerformed

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

    private void toItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toItemStateChanged
        // TODO add your handling code here:
        String toText=to.getSelectedItem().toString();
        if(toText.equals("All")){
            key.setText("globalfileacces");
        }else{
            key.setText("keykeykeykeykey");
        }
    }//GEN-LAST:event_toItemStateChanged

    private void keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyActionPerformed

    
    void writetolog(String content)
    {
       SimpleAttributeSet set = new SimpleAttributeSet();

       StyleConstants.setItalic(set, true);
       StyleConstants.setForeground(set, Color.black);

       Document doc = logtext.getStyledDocument();
        try {

            doc.insertString(doc.getLength(), content + "\n", set);


        } catch (BadLocationException ex) {

            ex.printStackTrace();
        }

    }
    
    
    private void OTPTimer(){
        try{
        int minutes=1;
        int secounds=minutes*60;
        int milisecounds=secounds*1000;
        JOptionPane pane=new JOptionPane("Session Time Out!!!\nDo you want to Continue??",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
        JDialog dialog=pane.createDialog("Warning");
        javax.swing.Timer logout_time=new javax.swing.Timer(milisecounds,new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.Timer display_time=new javax.swing.Timer(1000*30,new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                
                /*
                display_time.setRepeats(false);
                display_time.start();
                java.awt.Toolkit.getDefaultToolkit().beep();
                dialog.setVisible(true);
                if(pane.getValue().equals(JOptionPane.YES_OPTION)){
                    display_time.stop();
                }else{
                    System.exit(0);
                    display_time.stop();
                }
                */
            }
        });
        logout_time.setRepeats(true);
        logout_time.start();
        }catch(Exception e){
            System.exit(0);
        }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JTextField filetoupload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField key;
    private javax.swing.JTextField listenport;
    private javax.swing.JTextPane logtext;
    private javax.swing.JButton start;
    private javax.swing.JComboBox to;
    private javax.swing.JButton uploadFiletoCloud;
    private javax.swing.JTextField userip;
    private javax.swing.JTextField userport;
    // End of variables declaration//GEN-END:variables
}