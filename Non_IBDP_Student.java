/*    */ package smartSchool;
/*    */ 
/*    */ import java.util.Stack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Non_IBDP_Student
/*    */   extends Student
/*    */ {
/*    */   private Course[] electiveList;
/*    */   
/*    */   public Non_IBDP_Student(String studentName, int grade, String studentType, Stack desiredList, Course[] electiveList) {
/* 13 */     super(studentName, grade, studentType, desiredList);
/* 14 */     this.electiveList = electiveList;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Course[] getElectiveList() {
/* 20 */     return this.electiveList;
/*    */   }
/*    */   public void setElectiveList(Course[] electiveList) {
/* 23 */     this.electiveList = electiveList;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Non_IBDP_Student.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */