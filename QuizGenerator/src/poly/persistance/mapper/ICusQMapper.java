package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.CusQDTO;
import poly.dto.QuizDTO;

@Mapper("CusQMapper")
public interface ICusQMapper {
	
	int insertCusQ(CusQDTO cDTO);

	List<CusQDTO> getCusQList(QuizDTO qrDTO);
}
