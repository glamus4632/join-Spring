package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	AccountService accountService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Boolean signup) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		model.addAttribute("signup",signup);//아래에서 true가 담긴 signup을 멤버변수로 받아 사용함
		
		return "home";//home.jsp
	}
	
	@RequestMapping(value ="/signup", method=RequestMethod.GET)//같은 value를 사용할 수 없다(method가 같을 때)
	public String signupGet(Model model, Boolean signup) {
		//rapper클래스 Boolean은 boolean을 클래스화 시킨것으로 null값을 사용하기 위해서 래퍼클래스를 쓴다
		model.addAttribute("signup",signup);
		return "signup";//signup.jsp
	}
	
	@RequestMapping(value ="/signup", method=RequestMethod.POST)
	//public String signupPost(String id, String pw, String email, String gender) {
	public String signupPost(AccountVo accountVo, Model model) {//어차피 vo에 다 있으니까 이렇게 쓰는게 낫다
		//아이디 중복 여부 Vo에 데이터가 있냐 없냐
		if(accountService.signup(accountVo)) {//accountVo에 데이터를 담아서 accountService.signup실행
			//서비스에서 true면 아래 내용 실행 false면 else실행
			System.out.println("회원가입 성공");
			model.addAttribute("signup",true);//${signup}에 true가 담기게 됨 model을 쓰면 jsp나 다른 URI에서 이용 가능하게 된다
			return "redirect:/";
		}
		else {
			System.out.println("회원가입 실패");
			model.addAttribute("signup",false);
			return "redirect:/signup";
		}
		//home의 겟방식으로 가라 (컨트롤러로 이동하기 때문에 value를 적어주면 된다)
		
		//post는 이게 꼭 필요함.(어떤 동작을 하고 다른 겟방식의 동작이 필요할 때 쓴다고 생각하면 된다)
	}
}
