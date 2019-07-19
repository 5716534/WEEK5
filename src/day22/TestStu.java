package day22;

import org.junit.Test;

public class TestStu {
    @Test
    public void testFindByStuNo() {
        StudentDb stuDb = new StudentDb();
        Student stu = stuDb.findByStuNo(1);
        Student stu1 = stuDb.findByStuNo(2);
        Student stu2 = stuDb.findByStuNo(3);

        System.out.println(stu + "\r\n" + stu1 + "\r\n" + stu2);
    }
}
