package com.hhhh.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hhhh.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANDOM = new Random();

    /**
     * 处理详情图，并返回新生成图片的相对值路径
     * 
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径（带文件名）
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails
                    .of(thumbnail.getImage()).size(337, 640).watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(new File(basePath + "/watermark.jpeg")), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名，如png、jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径（带文件名）
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is : " + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is : " + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpeg")), 0.5f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回图片相对路径
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录，即/home/work/hr/XXX.jpg,那么home work hr 这三个文件都得自动创建
     * 
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * 
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日时分秒+五位随机数
     * 
     * @return
     */
    public static String getRandomFileName() {
        // 获取随机五位数
        int rannum = RANDOM.nextInt(89999) + 10000;
        String nowTimeStr = DATE_FORMAT.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("/tmp/xiaohuangren.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpeg")), 0.5f)
                .outputQuality(0.8f).toFile("/tmp/xiaohuangren_new.jpg");
    }

    /**
     * storePath是文件路径还是目录的路径，如果是文件路径则删除该文件，如果是目录路径则删除该目录下的所有文件
     * 
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
