package com.hhhh.o2o.util;

public class PathUtil {

	private static String separator = System.getProperty("file.separator"); // 这里间隔符不要写错，是separator，不是seperator

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image";
		} else {
			basePath = "/home/hr/图片";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop" + shopId + "/";
		return imagePath.replace("/", separator);
	}

}
