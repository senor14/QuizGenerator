package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.CusQDTO;
import poly.dto.QuizDTO;
import poly.persistance.mapper.ICusQMapper;
import poly.persistance.mapper.IQuizMapper;
import poly.service.IQuizService;

@Service("QuizService")
public class QuizService implements IQuizService {
	
	@Resource(name = "QuizMapper")
	IQuizMapper quizMapper;
	
	@Resource(name = "CusQMapper")
	ICusQMapper cusQMapper;
	
	@Override
	public int insertQuiz(QuizDTO qDTO) {
		return quizMapper.insertQuiz(qDTO);
	}

	@Override
	public List<QuizDTO> getQuizList(QuizDTO qrDTO) {
		return quizMapper.getQuizList(qrDTO);
	}

	@Override
	public List<QuizDTO> getExamList(QuizDTO qDTO) {
		return quizMapper.getExamList(qDTO);
	}

	@Override
	public List<CusQDTO> getCusQList(QuizDTO qrDTO) {
		return cusQMapper.getCusQList(qrDTO);
	}

}
