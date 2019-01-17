package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired//는 스프링에서 제공
	//@inject 는 자바에서 제공
	AccountDao accountDao;//Dao를 이용해 쿼리문을 동작시키기 위한 객체
	//id 셀렉트 기능
	@Override
	public AccountVo getAccount(String id) {//AccountVo 타입의 게터메소드 (컨트롤러에서 파라미터로 1234를 넘겼다)
		return accountDao.getAccount(id);//1234라는 값을 Dao.getAccount에 넣어 쿼리를 실행하고 꺼내온 값을 리턴한다
		
		//returndmf =로 대입
		/*AccountVo getAccount(1234) = accountDao.getAccount(1234)로 되어
		  getAccount를 실행, mapper에서 쿼리문을 실행한 후 꺼내온 값을 반환한다.
		  그리고 이 꺼내진 값(지금은 쿼리로 꺼내와진 값,오브젝트형태)이 다이렉트로 리턴시켜버린다
		*/
		/*
		 * AccountVo temp = accountDao.getAccount(id);
		 * return temp; 와 동일하다
		 * */
	}
	
	//회원가입 기능
	@Override
	//public boolean signup(String id, String pw, String email, String gender) {
	public boolean signup(AccountVo accountVo) {//boolean인 이유는 id가 있는지 없는지 판단하기 위해서
		//가입여부 확인
		if(accountDao.getAccount(accountVo.getId())!=null) {
			//accountDao.getAccount를 실행(꺼내오는 쿼리),  accountVo의 getId의 값이 있으면 리턴 펄스
			return false;
		}
		
		accountVo.setAuthority("user");//회원가입 시 authority 항목을 정할 수 없기에 강제로 지정
		//이렇게 하면 서비스에서 관리자나 매니저로 바꿀 수 있게 된다.
		accountDao.setAccount(accountVo);//Dao에 value전송
		
		return true;//일단 실패하든 말든 성공했다고 함		
	}
}
