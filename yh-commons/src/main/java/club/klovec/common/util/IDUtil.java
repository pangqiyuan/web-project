package club.klovec.common.util;

import java.util.Random;

public class IDUtil {

	/**
	 * 图片名字生成
	 * 
	 * @return
	 */
	public static String genImageName() {

		Long millis = System.currentTimeMillis();

		Random random = new Random();
		int end3 = random.nextInt(999);
		String str = millis + String.format("%03d", end3);
		return str;
	}

	public static long genIteamsName() {

		Long millis = System.currentTimeMillis();

		Random random = new Random();
		int end2 = random.nextInt(99);
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
