package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public AccountVo getAccount(String id);//service에서 1234라는 값을 넘겨받았고 mapper에서 쿼리문을 수행한다
	public void setAccount(@Param("accountVo")AccountVo accounVo);
//	public void setAccount(//파라미터가 여러개이면 @Param을 붙혀줘야 한다.
//			@Param("id")String id,
//			@Param("pw")String pw,
//			@Param("email")String email,
//			@Param("gender")String gender,
//			@Param("authority")String authority
//	);
}//dao의 구현부는 mapper가 대체할거라서 만들지 않는다(dao에서 구현이란 DB에 연결하여 변수값을 전송하거나 데이터를 가져오는 것을 말한다)
