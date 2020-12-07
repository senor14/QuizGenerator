package poly.service;

import java.util.List;

import poly.dto.CusQDTO;
import poly.dto.QuizDTO;

public interface ICusQService {

	int insertCusQ(CusQDTO cDTO);

	List<CusQDTO> getCusQList(QuizDTO qrDTO);

}
