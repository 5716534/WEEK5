package summary;

public class Student {
    private String stuNo;
    private String stuName;
    private int age;

    public Student() {
    }

    public Student(String stuNo, String stuName, int age) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.age = age;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }

}
