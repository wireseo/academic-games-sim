/*    */ package smartSchool;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBConnection
/*    */ {
/*    */   public static Connection con;
/*    */   private Statement st;
/*    */   private ResultSet rs;
/*    */   
/* 24 */   Runnable notifier = new Runnable() {
/*    */       public void run() {
/* 26 */         System.out.print(".");
/*    */       }
/*    */     };
/*    */   
/* 30 */   ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
/*    */   
/*    */   public DBConnection() {
/* 33 */     System.out.print("Establishing Database Connection");
/* 34 */     this.scheduler.scheduleAtFixedRate(this.notifier, 1L, 100L, TimeUnit.MILLISECONDS);
/*    */     try {
/* 36 */       Class.forName("com.mysql.cj.jdbc.Driver");
/* 37 */       con = DriverManager.getConnection("jdbc:mysql://mydbtest.c2kbmu0652jo.us-east-2.rds.amazonaws.com:3306/CS_IA", "superuser", "yeryeonseo");
/* 38 */       this.st = con.createStatement();
/* 39 */       this.scheduler.shutdownNow();
/*    */       
/* 41 */       System.out.println(" Database Connection Established.");
/*    */     }
/* 43 */     catch (Exception e) {
/* 44 */       System.out.println("ERROR: " + e.getMessage());
/* 45 */       JOptionPane.showMessageDialog(null, "Connection Failure. Please check internet status and restart.", " ERROR", 0);
/* 46 */       System.exit(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\DBConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */