package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample/getAddrApi")
public class SampleJSONController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청변수 설정
//		String currentPage = req.getParameter("currentPage"); // 요청 변수 설정 (현재 페이지. currentPage : n > 0)
//		String countPerPage = req.getParameter("countPerPage"); // 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
//		String resultType = req.getParameter("resultType"); // 요청 변수 설정 (검색결과형식 설정, json)
//		String confmKey = req.getParameter("confmKey"); // 요청 변수 설정 (승인키)
//		String keyword = req.getParameter("keyword"); // 요청 변수 설정 (키워드)
		
		String currentPage = "1"; // 요청 변수 설정 (현재 페이지. currentPage : n > 0)
		String countPerPage = "20"; // 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
		String resultType = "json"; // 요청 변수 설정 (검색결과형식 설정, json)
		String confmKey = "U01TX0FVVEgyMDIyMDIxNzEyMjMwMDExMjI1Njc="; // 요청 변수 설정 (승인키)
		String keyword = "영등포"; // 요청 변수 설정 (키워드)
		
		// OPEN API 호출 URL 정보 설정
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage + "&countPerPage="
				+ countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8") + "&confmKey=" + confmKey
				+ "&resultType=" + resultType;
		URL url = new URL(apiUrl);
		System.out.println(apiUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer();
		String tempStr = null;

		while (true) {
			tempStr = br.readLine();
			if (tempStr == null)
				break;
			sb.append(tempStr); // 응답결과 JSON 저장
		}
		br.close();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().write(sb.toString());
	}
}
