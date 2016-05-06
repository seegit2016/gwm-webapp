package com.zhanyun.gwm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssFFF");
		String pcode = dateFormat.format(date);
		
/*		@SuppressWarnings("unused")
		String str = pcode.substring(0);
		str = pcode.substring(1);*/
		
		System.out.println(pcode);
		
	}

}
