
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipesilva
 */
public class ChatScreen extends javax.swing.JFrame implements OnReceiveMessageListener {

    private ChatClient chatClient;
    private String userName;
    private ArrayList<String> users;
    private DefaultListModel<String> listModel;

    /**
     * Creates new form ChatScreen
     */
    public ChatScreen() {
        users = new ArrayList<String>();
        chatClient = new ChatClient();
        chatClient.setListener(this);
        chatClient.connect();
        initComponents();
        setupList();
        userName = JOptionPane.showInputDialog(this, "Insira seu nome de usuario!!");
        chatClient.setOwnerName(userName);
        authUser();
        addLogout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usersConnectedsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatInfo = new javax.swing.JTextArea();
        msgTxt = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usersConnectedsLabel.setText("Usuários Conectados");

        usersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(usersList);

        chatInfo.setColumns(20);
        chatInfo.setRows(5);
        jScrollPane2.setViewportView(chatInfo);

        msgTxt.setToolTipText("Mensagem...");
        msgTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgTxtActionPerformed(evt);
            }
        });

        sendBtn.setText("Enviar");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msgTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usersConnectedsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersConnectedsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        chatClient.sendMessage(userName, msgTxt.getText(), MessageType.MESSAGE);
        msgTxt.setText("");
    }//GEN-LAST:event_sendBtnActionPerformed

    private void msgTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgTxtActionPerformed

    }//GEN-LAST:event_msgTxtActionPerformed

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
            java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField msgTxt;
    private javax.swing.JButton sendBtn;
    private javax.swing.JLabel usersConnectedsLabel;
    private javax.swing.JList<String> usersList;
    // End of variables declaration//GEN-END:variables

    private void authUser() {
        chatClient.sendMessage(userName, userName, MessageType.NICKNAME);
    }

    @Override
    public void onReceiveUser(String name) {
        listModel.addElement(name);
    }

    @Override
    public void onReceiveMessage(Message msg) {
        chatInfo.setText(chatInfo.getText() + "\n\n" + getMessage(msg));
    }

    private void setupList() {
        listModel = new DefaultListModel<String>();
        usersList.setModel(listModel);
    }

    private String getMessage(Message msg) {
        DateFormat format = new SimpleDateFormat("HH:mm");
        return "[ " + format.format(msg.getDate()) + " ] ( " + msg.getOwner() + " ) : " + msg.getContent();
    }

    @Override
    public void onMaxClients(Message msg) {
        JOptionPane.showMessageDialog(rootPane, msg.getContent());
        this.dispose();
    }

    private void addLogout() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                chatClient.sendMessage(userName, "LOGOUT" + userName, MessageType.LOGOUT);
                e.getWindow().dispose();
            }
        });
    }

    @Override
    public void onClearUsers() {
        listModel.clear();
    }

}
