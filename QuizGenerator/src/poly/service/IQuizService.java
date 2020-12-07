package poly.service;

import java.util.List;

import poly.dto.CusQDTO;
import poly.dto.QuizDTO;

public interface IQuizService {

	int insertQuiz(QuizDTO qDTO);

	List<QuizDTO> getQuizList(QuizDTO qrDTO);

	List<QuizDTO> getExamList(QuizDTO qDTO);

	List<CusQDTO> getCusQList(QuizDTO qrDTO);


}
