package com.moxx;

import java.io.IOException;

import com.baidu.aip.util.Base64Util;

public class FacebaiduTest {
	
	public static void main(String[] args) {
		
        try {
        	byte[] imgData = FileUtil.readFileByBytes("F:\\s1.jpg");
            String imgStr = Base64Util.encode(imgData);
            FacebaiduMain facedeal = new FacebaiduMain();
			facedeal.Faceinfomain("select", imgStr, "12345667", "NEW PERSON");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
