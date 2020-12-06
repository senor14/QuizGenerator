package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.QuizDTO;

@Mapper("QuizMapper")
public interface IQuizMapper {
	
	int insertQuiz(QuizDTO qDTO);

	List<QuizDTO> getQuizList();
}
