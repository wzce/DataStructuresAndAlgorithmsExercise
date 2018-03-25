package alibaba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zuce wei on 2018/3/25.
 */
public class WormUtil {
    int fetch(String uri){
        int res=-1;
        Pattern pattern = Pattern.compile("\\d+");
        try {
            URL url = new URL(uri);
            try {
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is,"utf-8");
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据
                while (data!=null){//循环读取数据
                    data = br.readLine();
                    System.out.println(data);
                    Matcher m = pattern.matcher(data);
                    while (m.find()) {
                        String s=m.group();
                        return Integer.valueOf(s);
                    }
                }
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String args[]){
        WormUtil w=new WormUtil();
        w.fetch("http://www.baidu.com");
    }
}
