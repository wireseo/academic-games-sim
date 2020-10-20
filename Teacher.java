/*    */ package smartSchool;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Teacher
/*    */   implements Serializable
/*    */ {
/*    */   private String teacherName;
/*    */   private int teacherGroup;
/*    */   private Course[] courseList;
/*    */   private ArrayList<Course> tempCourseList;
/*    */   
/*    */   public Teacher(String teacherName, int teacherGroup, ArrayList<Course> tempCourseList) {
/* 20 */     this.teacherName = teacherName;
/* 21 */     this.teacherGroup = teacherGroup;
/* 22 */     this.tempCourseList = tempCourseList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTeacherName() {
/* 31 */     return this.teacherName;
/*    */   }
/*    */   public int getTeacherGroup() {
/* 34 */     return this.teacherGroup;
/*    */   }
/*    */   public Course[] getCourseList() {
/* 37 */     return this.courseList;
/*    */   }
/*    */   public ArrayList<Course> getTempCourseList() {
/* 40 */     return this.tempCourseList;
/*    */   }
/*    */   public void setTeacherName(String teacherName) {
/* 43 */     this.teacherName = teacherName;
/*    */   }
/*    */   public void setTeacherGroup(int teacherGroup) {
/* 46 */     this.teacherGroup = teacherGroup;
/*    */   }
/*    */   public void setCourseList(Course[] courseList) {
/* 49 */     this.courseList = courseList;
/*    */   }
/*    */   public void setTempCourseList(ArrayList<Course> tempCourseList) {
/* 52 */     this.tempCourseList = tempCourseList;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Teacher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */