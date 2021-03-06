package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.CusQDTO;
import poly.dto.QuizDTO;
import poly.persistance.mapper.ICusQMapper;
import poly.service.ICusQService;

@Service("CusQService")
public class CusQService implements ICusQService {
	
	@Resource(name = "CusQMapper")
	ICusQMapper cusQMapper;
	
	@Override
	public int insertCusQ(CusQDTO cDTO) {
		return cusQMapper.insertCusQ(cDTO);
	}

	@Override
	public List<CusQDTO> getCusQList(QuizDTO qrDTO) {
		return cusQMapper.getCusQList(qrDTO);
	}

}
