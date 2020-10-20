/*    */ package smartSchool;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class User {
/*    */   private String userID;
/*    */   private String userPW;
/*    */   private String userType;
/*    */   private String userName;
/*    */   private Date lastAccessed;
/*    */   
/*    */   public User(String userID, String userPW, String userType, String userName) {
/* 13 */     this.userID = userID;
/* 14 */     this.userPW = userPW;
/* 15 */     this.userType = userType;
/* 16 */     this.userName = userName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUserID() {
/* 26 */     return this.userID;
/*    */   }
/*    */   public String getUserPW() {
/* 29 */     return this.userPW;
/*    */   }
/*    */   public String getUserType() {
/* 32 */     return this.userType;
/*    */   }
/*    */   public String getUserName() {
/* 35 */     return this.userName;
/*    */   }
/*    */   public Date getLastAccessed() {
/* 38 */     return this.lastAccessed;
/*    */   }
/*    */   public void setUserID(String userID) {
/* 41 */     this.userID = userID;
/*    */   }
/*    */   public void setUserPW(String userPW) {
/* 44 */     this.userPW = userPW;
/*    */   }
/*    */   public void setUserType(String userType) {
/* 47 */     this.userType = userType;
/*    */   }
/*    */   public void setUserName(String userName) {
/* 50 */     this.userName = userName;
/*    */   }
/*    */   public void setLastAccessed(Date lastAccessed) {
/* 53 */     this.lastAccessed = lastAccessed;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */