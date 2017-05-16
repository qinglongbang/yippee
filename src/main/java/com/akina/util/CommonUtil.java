package com.akina.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.security.MessageDigest;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-16 -  13:19
 * @Describe ： 存放公用方法
 */
public class CommonUtil {

    /**
     * 被允许的文件格式
     */
    public static String[] ALLOWED_IMAGE = {"jpg", "jpge", "png", "JPG", "JPGE", "PNG"};


    /****
     * 删除单个文件
     *
     * @param filePath
     */
    public static void delFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            // 文件路径是文件且不为空执行删除
            file.delete();
        }
    }


    /***
     * 保存图片
     *
     * @param inputStream
     *            图片流
     * @param fileName
     *            文件名
     * @param path
     *            保存路径
     */
    public static void savePic(InputStream inputStream, String fileName, String path) {

        OutputStream os = null;
        try {
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTimeToFileName() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }

    /**
     * 获取当前时间-30天
     *
     * @return
     */
    public static String getCurrentTimeLostOneMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        // cl.add(Calendar.DAY_OF_YEAR, -1); //一天
        // cl.add(Calendar.WEEK_OF_YEAR, -1); //一周
        cl.add(Calendar.MONTH, -1); // 一个月
        Date dateFrom = cl.getTime();
        return formatter.format(dateFrom);
    }

    /**
     * 截取 时间字符串的： 【0】年 【1】月 【2】日 【3】时 【4】分 【5】秒 【6】该月多少天
     *
     * @return String[]
     */
    public static String[] getYearToSecondDays(String string) {
        if (string == null || string.equals("")) {
            string = getCurrentTime();
        } else if (string.length() == 7) {
            string += "-00 00:00:00";
        } else if (string.length() != 19) {
            string = getCurrentTime();
        }
        String year = string.substring(0, 4);
        String month = string.substring(5, 7);
        String day = string.substring(8, 10);
        String hour = string.substring(11, 13);
        String minute = string.substring(14, 16);
        String second = string.substring(17);
        int days = getDaysByYM(Integer.parseInt(year), Integer.parseInt(month));
        String[] arrayList = {year, month, day, hour, minute, second, String.valueOf(days)};
        // System.out.println("Parameter Time StringReturn :" + string);
        return arrayList;
    }

    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getFirstDayOfOneMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = format.format(cale.getTime());
        return firstday;
    }

    /**
     * 获取当天是星期几
     *
     * @return
     * @throws ParseException
     */
    public static String getWeekOfDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        Date d;
        try {
            d = format.parse(date);

            if (d != null) {
                calendar.setTime(d);
            }
            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;

            if (w < 0) {

                w = 0;

            }
            return weekOfDays[w];
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将long类型的毫秒是转换成时间类型
     *
     * @param date
     * @return
     */
    public static String getDateFromLong(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 将long类型的毫秒转换成日期类型
     *
     * @param date
     * @return
     */
    public static String getDateFromLong2(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 将String 的时间类型 转换成long类型的毫秒
     *
     * @param date
     * @return
     */
    public static long getLongFromDateStr(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long rtn = 0;
        try {
            if ("".equals(date) || "0".equals(date)) {

            } else {
                rtn = sdf.parse(date).getTime() / 1000;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        return rtn;
    }

    /**
     * 获取时间字符串
     *
     * @param date
     * @return
     */
    public static String getStringFromDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    /**
     * 获取登录的ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        System.out.println("本次登录的用户IP地址：" + ip);
        return ip;
    }

    /**
     * 根据输入的str 返回一个带时间戳的字符串
     *
     * @param str
     * @return
     */
    public static String getNameFromStr(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = formatter.format(new Date());
        String rtn = str + "_" + time;
        return rtn;
    }


    /**
     * 将图片缩放 返回流
     *
     * @param img    图片流
     * @param format 输出格式
     * @param ww     缩放的宽
     * @return
     */

    public static InputStream suofangImg(InputStream img, String format, int ww) {
        try {
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            int newH = (int) ((ww * 1.0 / width) * height);
            BufferedImage tag = new BufferedImage(ww, newH, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src.getScaledInstance(ww, newH, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

			/*
             * 将小图定向生成到文件 FileOutputStream out = new
			 * FileOutputStream("D:/71.jpg"); JPEGImageEncoder encoder =
			 * JPEGCodec.createJPEGEncoder(out); //近JPEG编码 encoder.encode(tag);
			 * out.close();
			 */

			/*
             * 将图放到字节数组 ImageIO.write(BufferedImage image,String
			 * format,OutputStream out);方法可以很好的解决问题； 参数image表示获得的BufferedImage；
			 * 参数format表示图片的格式，比如“gif”等；
			 * 参数out表示输出流，如果要转成Byte数组，则输出流为ByteArrayOutputStream即可；
			 * 执行完后，只需要toByteArray()就能得到byte[];
			 */
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(tag, format, out);
            byte[] b = out.toByteArray();
            ByteArrayInputStream in = new ByteArrayInputStream(b, 0, b.length);
            return in;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据url 下载图片流
     *
     * @param image
     * @return
     */
    public static InputStream download(String image) {
        InputStream is = null;
        try {
            // 构造URL
            URL url = new URL(image);
            // 打开连接
            URLConnection con = url.openConnection();
            // 设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            is = con.getInputStream();
            // rtnStr = IOUtils.toString(is);
            // rtnStr = IOUtils.toString(is, con.getContentEncoding());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;
    }

    public static int getDaysByYM(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// 月份小1
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        // System.out.println(maxDate);
        return maxDate;
    }


    public static String getUrlEncode(String origin) {
        try {
            return URLEncoder.encode(origin, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    /***
     * 判断文件格式是否合法
     *
     * @param
     * @return
     */
    public static boolean getImageDate(String fileName) {
        for (String imge_date : ALLOWED_IMAGE) {
            if (fileName.endsWith(imge_date)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将一个用特定字符（如 ，） 拼接的字符串 转成list
     *
     * @param ids
     * @return
     */
    public static List<String> fromStrToList(String ids, String regex) {
        String[] arr = ids.split(regex);
        /*
         * 2种方式都可以 List<String> list = new ArrayList<String>();
		 * Collections.addAll(list,arr);
		 */
        List<String> list = Arrays.asList(arr);
        return list;
    }

    /**
     * 根据给定的内容，写入txt文档
     */
    public static void writeToFile(List<String> content, boolean append, String fileName) {
        // fileName="D:\\App\\people"+itemId+markId+datetime; //文件命名规则
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(fileName, append), "utf-8");
            for (String s : content) {
                osw.write(s + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }


    /**
     * 按规则 +MD5 加密 if (j == 0) { result += "upload"; result = GetMD5(result);}
     * if (j == 1) { result = "upload" + result; result = GetMD5(result); if (j
     * == 2) { result = GetMD5(result); }
     *
     * @param inStr
     * @return
     */
    public static String getFinalStr(String inStr) {
        String result = "";
        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                inStr += "upload";
                result = GetMD5(inStr);
            }
            if (j == 1) {
                result = "upload" + result;
                result = GetMD5(result);
            }
            if (j == 2) {
                result = GetMD5(result);
            }
        }
        return result;
    }

    /**
     * MD5 加密
     *
     * @param inStr
     * @return
     */
    public static String GetMD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

}
