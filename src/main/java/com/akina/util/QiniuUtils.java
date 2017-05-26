package com.akina.util;


import com.akina.bean.User;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * @Creator Akina
 * @packge
 * @Time 2017-5-20 -  23:43
 * @Describe ： 七牛云存储操作工具类
 */
public class QiniuUtils {


    /***
     * 七牛云文件访问url
     */
    public static String IMAGE_URL = "http://oqjvbm6j1.bkt.clouddn.com/";
    //...生成上传凭证，然后准备上传
    public static String ACCESSKEY = "JBB_ngxIu2WrmfZcndLGnGXteVrgl8Qs9kDw7KTR";
    public static String SECRETKEY = "aQxdSxjl8PSuKk1v8ffJpnDcAtHIv-q7MzVXmcby";
    public static String BUCKET = "yippeeimg";

    /**
     * 返回头像命名规范的key
     *
     * @param user 用户
     * @return 返回七牛云指定的key
     */
    public static String getUserHeadKey(User user) {
        return "headImg_" + user.getUserId() + "_" + CommonUtil.getCurrentTimeToFileName();
    }

    /**
     * 返回图片命名规范的key
     *
     * @param user 用户
     * @return 返回七牛云指定的key
     */
    public static String getPicHeadKey(User user) {
        return "pic_" + user.getUserId() + "_" + CommonUtil.getCurrentTimeToFileName();
    }

    /***
     *  根据传入的文件流上传至七牛云
     * @param uploadInputStream 文件流
     * @param key  默认不指定key的情况下，以文件内容的hash值作为文件名
     * @return 返回文件key
     */
    public static String uploadInputStream(InputStream uploadInputStream, String key) {
        //定义返回类型
        String tempStr = null;

        //构造一个带指定Zone对象的配置类  指定华南机房
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);


        Auth auth = Auth.create(QiniuUtils.ACCESSKEY, QiniuUtils.SECRETKEY);
        String upToken = auth.uploadToken(QiniuUtils.BUCKET);
        try {
            Response response = uploadManager.put(uploadInputStream, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //获得对象的hash值
            //putRet.hash
            //给返回类型赋值
            tempStr = putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                //失败
            }
        }
        return QiniuUtils.IMAGE_URL + tempStr;
    }


    /**
     * 根据我们自定义的url删除七牛云上的图片文件
     *
     * @param url 图片访问连接
     * @return 返回是否删除成功
     */
    public static Boolean deleteFileByUrl(String url) {
        Boolean flag = false;
        //构造一个带指定Zone对象的配置类  指定华南机房
        Configuration cfg = new Configuration(Zone.zone2());
        //根据url拆分
        String temp[] = url.split("/");
        //取出最后一位   文件key值
        String key = temp[temp.length - 1];
        Auth auth = Auth.create(QiniuUtils.ACCESSKEY, QiniuUtils.SECRETKEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(QiniuUtils.BUCKET, key);
            flag = true;
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            ex.printStackTrace();
        }
        return flag;
    }

//    public static void main(String[] arg0) throws Exception {
//        File file = new File("E:\\照片\\卖相比较好的\\IMG_0096.JPG");
//        User user = new User();
//        user.setUserId(1);
//        user.setUserHeadPath("http://oqjvbm6j1.bkt.clouddn.com/headImg_1_20170526163800");
//
////        System.out.println("文件名是:  " + QiniuUtils.uploadInputStream(new FileInputStream(file), QiniuUtils.getUserHeadKey(user)));
//
////        System.out.println(QiniuUtils.deleteFileByUrl(user.getUserHeadPath()));
//    }
}
