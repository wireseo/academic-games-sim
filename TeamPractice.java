/*    */ package database;
/*    */ 
/*    */ import java.awt.LayoutManager;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamPractice
/*    */   extends JFrame
/*    */ {
/*    */   private JPanel contentPane;
/*    */   
/*    */   public TeamPractice() {
/* 20 */     setDefaultCloseOperation(2);
/* 21 */     setBounds(100, 100, 450, 300);
/* 22 */     this.contentPane = new JPanel();
/* 23 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 24 */     setContentPane(this.contentPane);
/* 25 */     this.contentPane.setLayout((LayoutManager)null);
/*    */     
/* 27 */     JLabel lblNewLabel = new JLabel("team");
/* 28 */     lblNewLabel.setBounds(185, 24, 57, 15);
/* 29 */     this.contentPane.add(lblNewLabel);
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\TeamPractice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */