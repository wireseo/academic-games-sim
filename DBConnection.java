/*    */ package database;
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
/*    */ public class DBConnection
/*    */ {
/*    */   public static Connection con;
/*    */   private Statement st;
/*    */   private ResultSet rs;
/*    */   
/* 19 */   Runnable notifier = new Runnable() {
/*    */       public void run() {
/* 21 */         System.out.print(".");
/*    */       }
/*    */     };
/*    */   
/* 25 */   ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
/*    */   
/*    */   public DBConnection() {
/* 28 */     System.out.print("Establishing Database Connection");
/* 29 */     this.scheduler.scheduleAtFixedRate(this.notifier, 1L, 100L, TimeUnit.MILLISECONDS);
/*    */     try {
/* 31 */       Class.forName("com.mysql.cj.jdbc.Driver");
/* 32 */       con = DriverManager.getConnection("jdbc:mysql://mydbtest.c2kbmu0652jo.us-east-2.rds.amazonaws.com:3306/Academic_Games", "superuser", "yeryeonseo");
/* 33 */       this.st = con.createStatement();
/* 34 */       this.scheduler.shutdownNow();
/*    */       
/* 36 */       System.out.println(" Database Connection Established.");
/*    */     }
/* 38 */     catch (Exception e) {
/* 39 */       System.out.println("ERROR: " + e.getMessage());
/* 40 */       JOptionPane.showMessageDialog(null, "Connection Failure. Please check internet status and restart.", " ERROR", 0);
/* 41 */       System.exit(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\DBConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */