package poly.service;

import java.util.List;

import poly.dto.QuizDTO;

public interface IQuizService {

	int insertQuiz(QuizDTO qDTO);

	List<QuizDTO> getQuizList();

}
