import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Course[] course=new Course[4];
		for(int i=0;i<course.length;i++){
		    int courseid=sc.nextInt();
		    sc.nextLine();
		    String coursename=sc.nextLine();
		    String courseadmin=sc.nextLine();
		    int quiz=sc.nextInt();
		    sc.nextLine();
		    int handson=sc.nextInt();
		    sc.nextLine();
		    course[i]=new Course(courseid,coursename,courseadmin,quiz,handson);
		}
		String admin=sc.nextLine();
		int Handson=sc.nextInt();
		    //sc.nextLine();
		    
		int avg=findAvgOfQuizByAdmin(course,admin);
		if(avg!=0){
		   System.out.println(avg); 
		}
		else{
		   System.out.println("No Course found.");
		}
		    
		Course[] hon=sortCourseByHandsOn(course,Handson);
		if(hon!=null){
		   for(int j=0;j<hon.length;j++){
		        System.out.println(hon[j].getcoursename());
		   }
		}
		else{
		  System.out.println("No Course found with mentioned attribute.");
		}
	}
	public static int findAvgOfQuizByAdmin(Course[] course,String admin){
	    int sum=0,count=0;
		for(int i=0;i<course.length;i++){
		    if(course[i].getcourseadmin().equalsIgnoreCase(admin)){
		        sum+=course[i].getquiz();
		        count++;
		    }
		 }
		 if(count>0){
		    int avg=sum/count;
		    return avg;
		 }
		 else{
		     return 0;
		 }
	}
	public static Course[] sortCourseByHandsOn(Course[] course,int Handson){
		    Course[] obj=new Course[0];
		    for(int i=0;i<course.length;i++){
		        if(course[i].gethandson()<Handson){
		            obj=Arrays.copyOf(obj,obj.length+1);
		            obj[obj.length-1]=course[i];
		        }
		    }
		    Course temp;
		    for(int i=0;i<obj.length;i++){
		        for(int j=i+1;j<obj.length;j++){
		            if(obj[i].gethandson()>obj[j].gethandson()){
		                temp=obj[i];
		                obj[i]=obj[j];
		                obj[j]=temp;
		            }
		        }
		    }
		    if(obj.length>0){
		        return obj;
		    }
		    else{
		        return null;
		    }
	}	
}
class Course{
    private int courseid;
    private String coursename;
    private String courseadmin;
    private int quiz;
    private int handson;
    
    public int getcourseid(){
        return courseid;
    }
    public void setcourseis(int courseid){
        this.courseid=courseid;
    }
    public String getcoursename(){
        return coursename;
    }
    public void setcoursename(String coursename){
        this.coursename=coursename;
    }
    public String getcourseadmin(){
        return courseadmin;
    }
    public void setcourseadmin(String courseadmin){
        this.courseadmin=courseadmin;
    }
    public int getquiz(){
        return quiz;
    }
    public void setquiz(int quiz){
        this.quiz=quiz;
    }
    public int gethandson(){
        return handson;
    }
    public void sethandsob(int handson){
        this.handson=handson;
    }
    public Course(int courseid,String coursename,String courseadmin,int quiz,int handson){
        super();
        this.courseid=courseid;
        this.coursename=coursename;
        this.courseadmin=courseadmin;
        this.quiz=quiz;
        this.handson=handson;
    }
}
