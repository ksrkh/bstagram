package com.kosta.bookstagram.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.bookstagram.controller.listener.Controller;

public class SearchBookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String book_name = request.getParameter("book_search");
		String clientId = "NFpFzUbjcuX6Ce2eN74w";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "_zKcG_tiOV";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(book_name, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=1"; // json 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}
			String inputLine;
			StringBuffer responseBook = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				responseBook.append(inputLine);
			}
			br.close();
			System.out.println(responseBook.toString());
			request.setAttribute("searchBook", responseBook);
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
}
