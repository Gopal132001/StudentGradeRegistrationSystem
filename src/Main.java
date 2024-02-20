

import java.util.*;
class Student {

    int rollno;
    int tamil;
    int english;
    int maths;
    int science;
    int social;
    int total;
    String result;
    int rank;

    public Student(int rollno, int tamil, int english, int maths, int science, int social){
        this.rollno=rollno;
        this.tamil=tamil;
        this.english=english;
        this.maths=maths;
        this.science=science;
        this.social=social;
        this.total=tamil+english+maths+science+social;
        this.result=(tamil>=35 && english >=35 && maths>=35 && science>=35 && social>=35)? "PASS":"FAIL";
        this.rank=0;

    }
}

public class Main{
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,85,99,89,98,91));
        students.add(new Student(2,85,99,89,98,91));
        students.add(new Student(3,65,69,66,68,85));
        students.add(new Student(4,21,94,96,78,54));
        students.add(new Student(5,65,87,65,73,64));
        students.add(new Student(6,45,81,68,32,86));
        students.add(new Student(7,87,63,75,15,68));
        students.add(new Student(8,99,26,45,84,65));
        students.add(new Student(9,54,54,65,61,94));
        students.add(new Student(10,16,24,35,34,99));
        students.add(new Student(11,55,76,46,57,38));
        Collections.sort(students,Comparator.comparingInt((Student s)->s.total).reversed());




        int currentRank=1;
        int pscount=0;
        int flcount=0;
        int i=0;
        for(int j=0;j<students.size();++j){
            Student currentStudent=students.get(j);
            //System.out.println(students.get(j).total);
            if("PASS".equals(currentStudent.result)){
                pscount++;

                if(j>0&&currentStudent.total==students.get(j-1).total){
                    currentStudent.rank=students.get(j-1).rank;
                    i=i+1;
                }else{
                    //currentStudent.rank=currentRank++;
                     currentStudent.rank=i+currentRank++;
                }

            }else{
                flcount++;
            }
        }
        Collections.sort(students,Comparator.comparingInt((Student s)->s.rollno));
        System.out.println("RollNo\tTamil\tEnglish\tMaths\tScience\tSocial\tTotal\tResult\tRank\tPass\tFail");
        for(Student student:students){
            System.out.println(student.rollno+ "\t" +student.tamil+ "\t" +student.english+ "\t" +student.maths+ "\t" +student.science+ "\t" +student.social+ "\t " +student.total+ "\t" +student.result+ "\t" +student.rank);
        }
        System.out.print("PassCount = "+pscount+"\t"+"FailCount = "+flcount);

    }
}