package com.spring.web.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.web.entity.User;
import com.spring.web.service.FaceService;
import com.spring.web.util.GetTon;

@Controller
public class UserControll {

	private static String accessToken;

	@Resource
	private FaceService faceService;

	@ResponseBody
	@RequestMapping("/facelogin.action")
	public String onListStudent(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String base = request.getParameter("base");
		System.out.println(base);
		try {

			List<User> users = this.faceService.selectAllUsers();
			String base64 = "";
			PrintWriter writer = response.getWriter();
			response.reset();

			for (User user : users) {
				base64 = new String(user.getBase64());
				/*base64 = new String("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");*/
				boolean result = getResult(base, base64);
				if (result) {
					request.getSession().setAttribute("user", user);
				
					System.out.println(result);
					
					writer.print(result);
					writer.close();
					return null;
				} else {

					System.out.println(result);
					writer.print(result);
					writer.close();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/page/404.jsp";
		}

		return null;
	}


	public boolean getResult(String imStr1, String imgStr2) {

		accessToken = GetTon.getToken();
		boolean flag = false;
		BufferedReader br = null;
		String result = "";

		// 锟斤拷锟斤拷锟斤拷锟斤拷锟街�
		String mathUrl = "https://aip.baidubce.com/rest/2.0/face/v2/match";
		try {
			// 拼锟接诧拷锟斤拷
			String params = URLEncoder.encode("images", "UTF-8") + "="

			+ URLEncoder.encode(imStr1 + imgStr2, "UTF-8");
			String genrearlURL = mathUrl + "?access_token=" + accessToken;
			URL url = new URL(genrearlURL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setDoInput(true);
			connection.setDoOutput(true);

			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.writeBytes(params);
			out.flush();
			out.close();
			br = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);

		/* result ="{"log_id":3142639513,"error_msg":"not enough images","error_code":216614}";*/

		JSONObject fromObject = JSONObject.fromObject(result);

		JSONArray jsonArray = fromObject.getJSONArray("result");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = (JSONObject) jsonArray.get(i);
			double resultList = object.getDouble("score");
			if (resultList >= 90) {
				flag = true;

			}
		}
		return flag;
	}

	@Test
	public void test() {
		getResult(null, null);
		System.out.println();

	}

}
