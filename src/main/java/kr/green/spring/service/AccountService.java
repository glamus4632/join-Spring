package kr.green.spring.service;

import  kr.green.spring.vo.AccountVo;
//인터페이스를 만드는 이유는 기능이 많아 질 때 한눈에 알아보기 쉽게 하기 위해서다
public interface AccountService {
	public AccountVo getAccount(String id);
	//public boolean signup(String id, String pw, String email, String gender);
	public boolean signup(AccountVo accountVo);//어차피 vo에 다 있으니까 이렇게 쓰는게 낫다
}
