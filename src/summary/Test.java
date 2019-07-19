package summary;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");

        String str=df1.format(date);
        System.out.println(str);
        try {
            Date date1 = df1.parse("2000/5/7 7/8/8");
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

