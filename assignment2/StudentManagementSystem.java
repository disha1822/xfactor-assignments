import java.util.*;
import java.io.*;

class Student{
    private String studentName;
    private int studentAge;
    private String studentGender;
    private String studentAddress;
    private static int studentCount;

    static
    {
        studentCount = 0;
    }

    Student() //Default Parameterless Constructor
    {
        Student.studentCount++;
        this.studentName = "";
        this.studentAge = 0;
        this.studentGender = "";
        this.studentAddress = "";
    }

    public void setStudentName(String name) //Setter method for Student Name
    {
        this.studentName = name;
    }

    public String getStudentName() //Getter method for Student Name
    {
        return this.studentName;
    }

    public void setStudentAge(int age) //Setter method for Student Age
    {
        this.studentAge = age;
    }

    public int getStudentAge() //Getter method for Student Age
    {
        return this.studentAge;
    }

    public void setStudentGender(String gender) //Setter method for Student Gender
    {
        this.studentGender = gender;
     }

    public String getStudentGender() //Getter method for Student Gender
    {
        return this.studentGender;
    }

    public void setStudentAddress(String address) //Setter method for Student Address
    {
        this.studentAddress = address;
    }

    public String getStudentAddress() //Getter method for Student Address
    {
        return this.studentAddress;
    }

    public static int getNumberOfStudents() //Returns total number of students
    {
        return Student.studentCount;
    }
}


class Department{

    private String departmentName;
    private String departmentHOD;
    private static int departmentCount;

    static{
        departmentCount = 0;
    }

    Department() //Default Parameterless Constructor
    {
        Department.departmentCount++;
        this.departmentName = "";
        this.departmentHOD = "";
    }

    public void setDepartmentName(String name) //Setter method for Department Name
    {
        this.departmentName = name;
    }

    public String getDepartmentName() //Getter method for Department Name
    {
        return this.departmentName;
    }

    public void setDepartmentHOD(String HOD) //Setter method for Department HOD
    {
        this.departmentHOD= HOD;
    }

    public String getDepartmentHOD() //Getter method for Department HOD
    {
        return this.departmentHOD;
    }

    public static int getDepartmentCount()
    {
        return Department.departmentCount;
    }
}

public class StudentManagementSystem{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
 
        File file = new File("Output.txt");

        PrintStream stream;
        try
        {
            stream = new PrintStream(file);
            System.setOut(stream);
        }
        catch (FileNotFoundException e)
        { 
            e.printStackTrace();
        }
 
        String toContinue = "Y";
        int choice;
        String sName, sGender, sAddress, dName, dHOD;
        int sAge;

        ArrayList<Student> student = new ArrayList<Student>();
        ArrayList<Department> department = new ArrayList<Department>();

        System.out.println("********** Student Management System ***********"+"\n");

        while(toContinue.equalsIgnoreCase("Y")){

            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. List Student");
            System.out.println("3. Add Department");
            System.out.println("4. List Department");
            System.out.println("5. Remove Student");
            System.out.println("6. Remove Department");
            System.out.println("\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("\nEnter student name: ");
                    sName = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter student age: ");
                    sAge = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    System.out.print("Enter student gender: ");
                    sGender = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter student address: ");
                    sAddress = sc.nextLine();

                    Student sObj = new Student();
                    sObj.setStudentName(sName);
                    sObj.setStudentAge(sAge);
                    sObj.setStudentGender(sGender);
                    sObj.setStudentAddress(sAddress);

                    student.add(sObj);

                    System.out.println("\nStudent added successfully\n");

                    break;

                case 2:
                    System.out.println("Student list is: \n");
                    System.out.print("Name"+"\t"+" | "+"\t"+"Age"+"\t"+" | "+"\t"+"Gender"+"\t"+" | "+"\t"+"Address"+"\n");
                    System.out.println();

                    for(Student s : student){
                        System.out.print(s.getStudentName()+"\t\t"+s.getStudentAge()+"\t\t"+s.getStudentGender()+"\t\t"+s.getStudentAddress()+"\n");
                        System.out.println();
                    }

                    System.out.println("\nTotal number of student records created = "+Student.getNumberOfStudents()+"\n");

                    break;

                case 3:
                    System.out.print("\nEnter department name: ");
                    dName = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter department HOD: ");
                    dHOD = sc.nextLine();

                    Department dObj = new Department();
                    dObj.setDepartmentName(dName);
                    dObj.setDepartmentHOD(dHOD);

                    department.add(dObj);

                    System.out.println("\nDepartment added successfully\n");

                    break;

                case 4:
                    System.out.println("Department list is: \n");
                    System.out.print("Department Name"+"\t"+" | "+"\t"+"Department HOD"+"\n");
                    System.out.println();

                    for(Department d : department){
                        System.out.print(d.getDepartmentName()+"\t\t"+d.getDepartmentHOD()+"\n");
                        System.out.println();
                    }

                    System.out.println("\nTotal number of department records created = "+Department.getDepartmentCount()+"\n");

                    break;

                case 5:
                    System.out.print("\nEnter the student name to delete: ");
                    sName = sc.nextLine();
                    System.out.println();
                    boolean flag = false;

                    ArrayList<Student> studentRemove = new ArrayList<Student>();

                    for(Student s1 : student){
                        if(s1.getStudentName().equals(sName)){
                            flag = true;
                            studentRemove.add(s1);
                        }
                    }

                    if(flag == false){
                        System.out.println("\nStudent name does not exist"+"\n");
                    }
                    else{
                        student.removeAll(studentRemove);
                        System.out.println("\nStudent record deleted successfully\n");
                    }

                    break;

                case 6:
                    System.out.print("\nEnter the department name to delete: ");
                    dName = sc.nextLine();
                    System.out.println();
                    boolean flag1 = false;

                    ArrayList<Department> departmentRemove = new ArrayList<Department>();

                    for(Department d1 : department){
                        if(d1.getDepartmentName().equals(dName)){
                            flag = true;
                            departmentRemove.add(d1);
                        }
                    }

                    if(flag1 == false){
                        System.out.println("Department name does not exist"+"\n");
                    }
                    else{
                        department.removeAll(departmentRemove);
                        System.out.println("\nDepartment removed successfully"+"\n");
                    }

                    break;

                default: System.out.println("Wrong choice !"+"\n");
            }
            System.out.println("Enter Y/y to continue, N/n to quit\n");
            toContinue = sc.nextLine();
        }

        sc.close();
    }
}