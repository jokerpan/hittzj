package top.hittzj.service;

import java.util.Date;
import java.util.Map;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import top.hittzj.dao.AddUserDao;
import top.hittzj.entity.Question;
import top.hittzj.entity.User;
import top.hittzj.util.RegexUtil;

public class RegisterService {
	private AddUserDao dao;

	public RegisterService() {
		this.dao = new AddUserDao();
	}

	public boolean register(String count, String nickName, String psd,
			String qq, Question question, String answer, Date time, String phone) {
		// 使用正则判断用户的数据是否符合规范
		// String countRule;
		// String nickNameRule;
		// String psdRule;
		// String qqRule;
		 if (RegexUtil.checkPsd(psd) & RegexUtil.checkCount(count)
		 & RegexUtil.checkNickName(nickName)
		 & RegexUtil.checkPhone(phone) & RegexUtil.checkQq(qq)
		 & RegexUtil.checkAnswer(answer)) {
		User u = new User();
		u.setCount(count);
		u.setNickName(nickName);
		u.setPsd(psd);
		u.setQq(qq);
		u.setQuestion(question);
		u.setAnswer(answer);
		u.setTime(time);
		u.setPhone(phone);
		return dao.saveUser(u);
		 }
		 // 储存用户
		 return false;
	}
}
