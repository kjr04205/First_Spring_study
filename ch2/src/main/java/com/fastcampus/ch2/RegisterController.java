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
		//binder.setValidator(new UserValidator()); // ���� validator�� ���(��Ʈ�ѷ��ȿ�������밡��)
		binder.addValidators(new UserValidator()); // �۷ι� validator�� ���
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = "+validatorList);
	}
	
	//@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // spring 4.3����
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// ���� ���� - Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
		//UserValidator userValidator = new UserValidator();
		//userValidator.validate(user, result); //BindingResult�� Errors�� �ڼ�
		
		//User��ü�� ������ ��� ������ ������, registerForm�� �̿��ؼ� ������ ������� ��.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		// 1. ��ȿ�� �˻�
		/*if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
			//return "redirect:/register/add?msg="+msg; // URL ���ۼ�(rewriting)
		}*/
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
