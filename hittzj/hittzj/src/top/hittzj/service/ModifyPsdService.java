package top.hittzj.service;

import top.hittzj.dao.ModifyPsdDao;
import top.hittzj.entity.Question;
import top.hittzj.entity.User;
import top.hittzj.util.RegexUtil;

public class ModifyPsdService {
	private ModifyPsdDao dao;

	public ModifyPsdService() {
		this.dao = new ModifyPsdDao();
	}

	public boolean modify(String count, String newpsd, Question question,
			String answer) {
		if (RegexUtil.checkCount(count) & RegexUtil.checkPsd(newpsd)
				& RegexUtil.checkAnswer(answer)) {
			User user = new User();
			user.setQuestion(question);
			user.setAnswer(answer);
			user.setCount(count);
			user.setPsd(newpsd);
			return dao.modifyPsd(user);
		}
		return false;
	}
}
