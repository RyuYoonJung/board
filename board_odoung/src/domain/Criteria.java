package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO 
@Data @NoArgsConstructor @AllArgsConstructor
public class Criteria {
	private int pageNum = 1;
	private int amount = 10;
	private int category = 1;
	
	// 사과가 123개 바구니에 10개씩들어감 몇개의 바구니가 필요?
	// (총게시글 갯수 + 9) / 어마운트
	
	public String getParams2() {
		return getParams() + "&pageNum=" + pageNum;
	}
	public String getParams() {
		return "?amount=" + amount +
				"&category=" + category;
	}
}
