package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.CusQDTO;
import poly.dto.QuizDTO;
import poly.dto.UserDTO;
import poly.service.ICusQService;
import poly.service.IQuizService;

@Controller
public class QuizController {

	private Logger log = Logger.getLogger(getClass());

	@Resource(name = "QuizService")
	private IQuizService quizService;
	
	@Resource(name = "CusQService")
	private ICusQService cusQService;

	@RequestMapping(value = "quiz/quiz")
	public String quizlist(HttpServletRequest request, HttpServletResponse response, ModelMap model, UserDTO uDTO)
			throws Exception {
		
		log.info(this.getClass().getName() + ".quizlist start!");

		
		QuizDTO qrDTO = new QuizDTO();
		qrDTO.setFk_user_no(1);
		
		List<QuizDTO> qrList = quizService.getQuizList(qrDTO);

		model.addAttribute("qrList", qrList);
		
		
		/*
		 * for (QuizDTO qDTO : qrList) { log.info("fk_user_no : " +
		 * qDTO.getFk_user_no()); log.info("q_id : " + qDTO.getQ_id());
		 * log.info("q_pic : " + qDTO.getQ_pic()); }
		 */

		log.info(this.getClass().getName() + ".quizlist end!");

		return "/main/myPage";

	}

	@RequestMapping(value = "cquiz/examload" , method=RequestMethod.POST)
	public String examlist(HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session) throws Exception {

		log.info(this.getClass().getName() + ".examload start!");

		List<List<CusQDTO>> rList = new ArrayList<List<CusQDTO>>();

		QuizDTO qDTO = new QuizDTO();
		
		//qDTO.setFk_user_no(session.getAttribute("user_no"));
		//임시로 테스트 번호로 넣어놓음
		qDTO.setFk_user_no(1);
		
		for (int i = 0; i < 5; i++) {
			log.info(this.getClass().getName() + ".examload start!");
			/*String val = request.getParameter("value" + i);
			if (val.equals("") || val.equals(null))
				continue;
			log.info(this.getClass().getName() + ".examload start22222222222!");
			int intVal = Integer.parseInt(val);
			log.info(this.getClass().getName() + ".examload start333333333!");
			qDTO.setQ_id(intVal);*/
			log.info(this.getClass().getName() + ".examload start44444444!");
			qDTO.setFk_user_no(1);
			qDTO.setQ_id(i+1);
			log.info(this.getClass().getName() + ".examload start55555555555!");
			List<CusQDTO> cList = cusQService.getCusQList(qDTO);
			rList.add(i, cList);
		}
		log.info(this.getClass().getName() + ".examload start6666666666!");
		//qDTO.setQ_id_list(rList);
		log.info(this.getClass().getName() + ".examload start77777777777!");
		//List<QuizDTO> qList = quizService.getExamList(qDTO);
		model.addAttribute("rList", rList);
		log.info(this.getClass().getName() + ".examload start888888888!");
		
		
		// 리스트 길이만큼 쪽 수 표시
		// qDTO.getQ_id_list().size()
		
		log.info(this.getClass().getName() + ".examload start999999999999!");
		//List<CusQDTO> cList = cusQService.getCusQList(qrDTO);
		log.info(this.getClass().getName() + ".examload start0000000000000!");
		//model.addAttribute("cList", cList);
		log.info(this.getClass().getName() + ".examload start--------------!");
		//model.addAttribute("rList", rList);
		
		log.info(this.getClass().getName() + ".examload end!");

		return "/cquiz/exam";

	}
}
