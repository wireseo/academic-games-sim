/*    */ package smartSchool;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Load_Menu
/*    */   extends JFrame
/*    */ {
/*    */   private JPanel contentPane;
/*    */   static int loadedIndex;
/*    */   
/*    */   public Load_Menu() {
/* 33 */     setDefaultCloseOperation(3);
/* 34 */     setBounds(100, 100, 300, 200);
/* 35 */     this.contentPane = new JPanel();
/* 36 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/* 37 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 38 */     setContentPane(this.contentPane);
/* 39 */     this.contentPane.setLayout((LayoutManager)null);
/*    */     
/* 41 */     JLabel lblLoadSchedule = new JLabel("Load Schedule");
/* 42 */     lblLoadSchedule.setFont(new Font("Lucida Grande", 0, 20));
/* 43 */     lblLoadSchedule.setHorizontalAlignment(0);
/* 44 */     lblLoadSchedule.setBounds(6, 15, 288, 16);
/* 45 */     this.contentPane.add(lblLoadSchedule);
/*    */     
/* 47 */     JLabel lblSelectSerial = new JLabel("Select Serial #:");
/* 48 */     lblSelectSerial.setBounds(20, 68, 91, 16);
/* 49 */     this.contentPane.add(lblSelectSerial);
/*    */     
/* 51 */     String[] serialNums = new String[Login.scheduleList.size()];
/*    */     
/* 53 */     for (int i = 0; i < Login.scheduleList.size(); i++) {
/* 54 */       serialNums[i] = ((Main_Schedule)Login.scheduleList.get(i)).getSerialNum();
/*    */     }
/*    */     
/* 57 */     final JComboBox<String> comboBox_serialNum = new JComboBox<>(serialNums);
/* 58 */     comboBox_serialNum.setBounds(115, 64, 173, 27);
/* 59 */     this.contentPane.add(comboBox_serialNum);
/*    */     
/* 61 */     JButton btnConfirm = new JButton("Confirm");
/* 62 */     btnConfirm.setBounds(150, 115, 69, 39);
/* 63 */     this.contentPane.add(btnConfirm);
/* 64 */     btnConfirm.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent e) {
/* 66 */             Load_Menu.this.dispose();
/* 67 */             Load_Menu.loadedIndex = comboBox_serialNum.getSelectedIndex();
/* 68 */             Main.loaded = true;
/* 69 */             Load_Schedule ls = new Load_Schedule();
/* 70 */             ls.setVisible(true);
/*    */           }
/*    */         });
/*    */     
/* 74 */     JButton btnBack = new JButton("← Back");
/* 75 */     btnBack.setBounds(79, 115, 69, 39);
/* 76 */     this.contentPane.add(btnBack);
/* 77 */     btnBack.addActionListener(new ActionListener() {
/*    */           public void actionPerformed(ActionEvent e) {
/* 79 */             Load_Menu.this.dispose();
/* 80 */             Main m = new Main();
/* 81 */             m.setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Load_Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */