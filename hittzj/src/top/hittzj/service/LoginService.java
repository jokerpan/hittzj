package top.hittzj.service;

import top.hittzj.dao.GetUserDao;
import top.hittzj.entity.User;
import top.hittzj.util.RegexUtil;

public class LoginService {
	private GetUserDao dao;

	public LoginService() {
		this.dao = new GetUserDao();
	}

	public User login(String count, String psd) {
		if (RegexUtil.checkPsd(psd) & RegexUtil.checkCount(count)) {
			User user = new User();
			user.setCount(count);
			user.setPsd(psd);
			return dao.findUser(user);
		}
		return null;
	}

}
