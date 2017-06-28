package com.jia.demo.utils;




import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;


//import com.seowang.mystruct.mystruct.net.utils.ToastUtil;

/**
 * Created by jia on 2016/1/12.
 *
 *   这里封装的操作是关于http、https相关的网络访问的具体执行操作、
 *   1、http的（Get、Post、混合的post）
 *   2、https的（Get、Post、混合的post）
 *   3、在该类中定义的方法的返回值是将网络请求后的IO流转化成为的字符串，并将字符串转换成为JavaBean
 *
 *   封装思路：
 *   1、之前使用的控制都是在存在网络的情况下进行的数据请求操作，这种思路的作用在于可以优化同一个接口的网络请求次数
 *      当用户处于移动流量的环境下的时候可以节省一部分流量
 *   2、新的思路：
 *      a、首先根据网络的链接状态划分出两条分支，存在网络的时候，执行相关的网络请求的部分，同时这一部分也包含从本地
 *         缓存中获取数据的操作
 *      b、考虑到用户处于的网络可能不存在，这个时候之前只要进行过网络连接的操作就会出现数据的缓存，这个时候可以将本地
 *         的缓存数据展示到应用中。
 *      c、此时出现一个问题：返回的接口中包含图片资源的网络连接时候，这个时候进行第一次联网展示的时候使用的是二级缓存
 *         的机制将图片进行了缓存，所以就会解决图片没有网络的时候的展示问题
 *      d、之前我的疑问在于：怎么讲Json数据中的所有真实展示信息完全缓存，现在使用二级缓存等类似的机制的时候就能够解决。
 *   3、关于新的思路继续补充：
 *      a、缓存的时间
 *      b、具体的Json是否需要缓存（关于数据展示类型的Json数据需要完全缓存，但是像支付一类的接口Json是不能缓存的）
 *      c、文件的缓存位置（利用工具类完成）考虑到部分手机不存在SD等问题
 *      d、以上这些参数的数据是存在默认值的（用户也可以自己设置）
 *      e、一定要强调健壮性！！！！！
 *
 *   4、换一种思路：
 *      之前看到好多人书写代码的时候，经常把一些需要的公共的变量等数据放在构造方法中
 *      可以模仿一下！！
 *
 *   5、几点要求：
 *      a、一定要健壮性
 *      b、友好性，作为一个网络的操作封装，要将网络相关的状态一定要提示清楚
 *
 */
public class Net {




    private static final String BOUNDARY = UUID.randomUUID().toString(); // 边界标识
    // 随机生成
    private static final String PREFIX = "--";
    private static final String LINE_END = "\r\n";
    private static final String CONTENT_TYPE = "multipart/form-data"; // 内容类型

    private static final String CHARSET = "utf-8"; // 设置编码



    /**
     * 这个方法完成的操作是使用Post进行数据的请求操作，并包含文件的上传操作！
     *
     * @return
     */
    public static InputStream getHttpsIOByPost(String mUrl,HashMap<String,String> param,HashMap<String,File> files) {

        URL url = null;
        try {
            url = new URL(mUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setDoInput(true); // 允许输入流
            conn.setDoOutput(true); // 允许输出流
            conn.setUseCaches(false); // 不允许使用缓存
            conn.setRequestMethod("POST"); // 请求方式
            conn.setRequestProperty("Charset", CHARSET); // 设置编码
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 当文件不为空，把文件包装并且上传
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            StringBuffer sb = null;
            String params = "";

            /***
             * 以下是用于上传参数
             */
            if (param != null && param.size() > 0) {
                Iterator<String> it = param.keySet().iterator();
                while (it.hasNext()) {
                    sb = null;
                    sb = new StringBuffer();
                    String key = it.next();
                    String value = param.get(key);
                    sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
                    sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END)
                            .append(LINE_END);
                    sb.append(value).append(LINE_END);
                    params = sb.toString();
                    dos.write(params.getBytes());
                    // dos.flush();
                }
            }


            sb = null;
            params = null;
            sb = new StringBuffer();
            /**
             * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
             * filename是文件的名字，包含后缀名的 比如:abc.png
             */
            File value=null;
            Set<String> keySet2 = files.keySet();
            for (Iterator<String> it = keySet2.iterator(); it.hasNext();) {
                String name = it.next();
                value = files.get(name);
                sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
                sb.append("Content-Disposition:form-data; name=\"" + name + "\"; filename=\"" + value.getName() + "\""
                        + LINE_END);
//                System.out.println("上传文件的格式："+value.getName());
                sb.append("Content-Type:image/jpg" + LINE_END); // 这里配置的Content-type很重要的
                // ，用于服务器端辨别文件的类型的
                sb.append(LINE_END);
                params = sb.toString();
                dos.write(params.getBytes());

                InputStream is = new FileInputStream(value);
                byte[] bytes = new byte[1024];
                int len = 0;
                int curLen = 0;
                while ((len = is.read(bytes)) != -1) {
                    curLen += len;
                    dos.write(bytes, 0, len);
                }
                is.close();
            }



            dos.write(LINE_END.getBytes());
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
            dos.write(end_data);
            dos.flush();
            int res = conn.getResponseCode();
            if (res == 200) {
                InputStream input = conn.getInputStream();
                return input;
            }else{
//                System.out.println("网络的返回码是：："+res);
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }



    }

}

