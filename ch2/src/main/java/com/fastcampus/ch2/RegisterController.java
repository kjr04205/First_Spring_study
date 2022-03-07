package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) {
		/*ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService = " + conversionService);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));*/
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		//binder.setValidator(new UserValidator()); // 로컬 validator로 등록(컨트롤러안에서만사용가능)
		binder.addValidators(new UserValidator()); // 글로벌 validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = "+validatorList);
	}
	
	//@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // spring 4.3부터
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
		//UserValidator userValidator = new UserValidator();
		//userValidator.validate(user, result); //BindingResult는 Errors의 자손
		
		//User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		// 1. 유효성 검사
		/*if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
			//return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
		}*/
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
