package kr.co.moocl.restcontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.moocl.service.ReviewService;
import kr.co.moocl.vo.ReviewVo;

@RestController
@RequestMapping("/api")
public class ReviewRestController {
	
	@Autowired
	ReviewService reviewService;

	@RequestMapping("/reviewlist")
	public List<ReviewVo> getReviewList(HttpServletRequest request){
		
		String movieId = request.getParameter("movieId");
		int page = Integer.parseInt(request.getParameter("pageNo"));
		int score = Integer.parseInt(request.getParameter("score"));
		
		List<ReviewVo> reviewList = reviewService.getReviewList(movieId, page, score);
		
		return reviewList;
	}
	
	@RequestMapping("/reviewcount")
	public Object CountingReview(HttpServletRequest request) {
		
		String movieId = request.getParameter("movieId");
		Map<String, Integer> reviewCounts = reviewService.getReviewCount(movieId);
			
		return reviewCounts;
	} 
	
	@RequestMapping("/reviewtest")
	public List<ReviewVo> testReview(){
		return reviewService.testService();
	}
	
//	@RequestMapping("/reviewtest1")
//	public List<String[]> testReview1(){
//		System.out.println("hi");
//		return reviewService.applyKomoran("test","reviewking","슈퍼액션에서 하고있는데 진짜 재밌어요");
//	}
	
	@RequestMapping(value = "/saveReview",method = RequestMethod.POST)
	public String saveReview(@RequestBody Map<String, String> reviewData){

		String userGrade = reviewData.get("score");
		String review = reviewData.get("review");
		String movieId = reviewData.get("movieId");
		String userId = reviewData.get("email");
		
		reviewService.saveReview(movieId, movieId,"gurumi", review, userId, Integer.parseInt(userGrade));
		reviewService.applyKomoran(movieId,userId,review);
		
		return "완료!";
	}
	
	@RequestMapping(value= "/getOneReview", method = RequestMethod.GET)
	public ReviewVo reviewAnalze(@RequestParam Map<String, Object> reviewId) {
		ReviewVo review =reviewService.getReview(reviewId);
		return review;
	}
}
