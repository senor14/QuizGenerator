package poly.service;

import java.util.List;

import poly.dto.CusQDTO;

public interface ICusQService {

	int insertCusQ(CusQDTO cDTO);

	List<CusQDTO> getCusQList();

}
