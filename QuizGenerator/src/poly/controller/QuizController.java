package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.QuizDTO;
import poly.dto.UserDTO;
import poly.service.IQuizService;

@Controller
public class QuizController {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Resource(name = "QuizService")
	private IQuizService quizService;
	
	@RequestMapping(value = "quiz/quiz")
	public String quizlist(HttpServletRequest request, HttpServletResponse response,
			ModelMap model, UserDTO uDTO) throws Exception {
		
		log.info(this.getClass().getName() + ".cquiz start!");
		
		List<QuizDTO> qrList = quizService.getQuizList();
		
		for(QuizDTO qDTO : qrList) {
			log.info("fk_user_no : " + qDTO.getFk_user_no());
			log.info("q_id : " + qDTO.getQ_id());
			log.info("q_pic : " + qDTO.getQ_pic());
		}
		
		log.info(this.getClass().getName() + ".cquiz end!");
		
		return "/quiz/quiz";
		
	}
	
	@RequestMapping(value = "quiz/examload")
	public String examlist(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + ".examload start!");
		
		
		
		
		
		log.info(this.getClass().getName() + ".examload end!");
		
		return "/cquiz/exam";
		
	}
}
