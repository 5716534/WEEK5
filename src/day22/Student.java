package day22;

public class Student {
    private String stuName;
    private int stuNo;
    private int age;

    public Student() {
    }

    public Student(String stuName, int stuNo, int age) {
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.age = age;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuNo=" + stuNo +
                ", age=" + age +
                '}';
    }
}
