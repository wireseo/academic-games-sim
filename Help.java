/*    */ package database;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Help
/*    */   extends JFrame
/*    */ {
/*    */   private JPanel contentPane;
/*    */   
/*    */   public Help() {
/* 18 */     setDefaultCloseOperation(2);
/* 19 */     setBounds(100, 100, 450, 300);
/* 20 */     this.contentPane = new JPanel();
/* 21 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 22 */     this.contentPane.setLayout(new BorderLayout(0, 0));
/* 23 */     setContentPane(this.contentPane);
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\Help.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */