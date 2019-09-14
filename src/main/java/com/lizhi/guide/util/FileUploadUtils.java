package com.lizhi.guide.util;

import com.lizhi.guide.common.Const;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Random;

public class FileUploadUtils {

    private static String url = "localhost:8080/uploads/project_docuemnt/";
    private static Random random = new Random();

    public static String urlPre(String uploadLocation) {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path);
            String resourcesPath = confirmResourcesPath(path);
            File upload = new File(resourcesPath, "/"+uploadLocation+"/");

            if (!upload.exists()) upload.mkdirs();
            return upload.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "/";
    }

    //用户未指定文件名生成方式
    public static String saveTeamProjectDocument(MultipartFile file,String uploadLocation,String suffix,String filename) {
        if (file == null) return "";
        String path = urlPre(uploadLocation);
        if (filename == null){
            filename = System.currentTimeMillis() + "_" + random.nextInt(100000) + "."+suffix;
        }

        File filepath = new File(path, filename);
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        try {
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url + filename;
    }




    //项目文档上传路径处理
    public static String UploadFileNameHandler(MultipartFile file,String uploadPath){
        String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));

        String fileName = FileUploadUtils.saveTeamProjectDocument(file, uploadPath,suffix,null);


        return fileName;
    }


    //文件资源基路径处理
    public static String confirmResourcesPath(File path){
        String parentPath = path.getAbsolutePath();
        int lastIndex = path.getParent().lastIndexOf("\\");
        parentPath = parentPath.substring(0,lastIndex);
        String uploadPath =  parentPath+"\\src\\main\\resources\\uploads";
        return uploadPath;
    }

    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString
     *            16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] toByteArray(String hexString) {
        if (StringUtils.isEmpty(hexString))
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }


    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray
     *            需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }



    public static String WriteEditorMd(String title,String editmd,String uploadLocation){
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path);
            String resourcesPath = confirmResourcesPath(path)+ "\\"+uploadLocation+"\\";
            if (title.equals("")){
                resourcesPath = resourcesPath+"error"+"."+Const.FileSuffix.FILE_MD;
            }else {

                resourcesPath = resourcesPath+title+"."+Const.FileSuffix.FILE_MD;
            }

            FileOutputStream fos = new FileOutputStream(resourcesPath);
            fos.write(editmd.getBytes());
            fos.close();

            return resourcesPath;

        } catch (IOException e) {
            e.printStackTrace();
            return "/";
        }


    }

    public static String ReadEditorMd(String title,String uploadLocation){

        String resoourcesPath = urlPre(uploadLocation)+title+Const.FileSuffix.FILE_MD;
        File file = new File(resoourcesPath);
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String str="";
        try {
            FileInputStream in=new FileInputStream(file);
            // size  为字串的长度 ，这里一次性读完
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            str=new String(buffer,"GB2312");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }


}
