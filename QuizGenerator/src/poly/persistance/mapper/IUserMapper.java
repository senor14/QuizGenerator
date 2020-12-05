package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface IUserMapper {
	
	UserDTO insertUserInfo() throws Exception;
}
