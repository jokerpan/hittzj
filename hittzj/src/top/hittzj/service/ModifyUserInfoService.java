package top.hittzj.service;

import top.hittzj.dao.ModifyUserInfoDao;
import top.hittzj.entity.User;
import top.hittzj.util.RegexUtil;

public class ModifyUserInfoService {
	private ModifyUserInfoDao dao;

	public ModifyUserInfoService() {
		this.dao = new ModifyUserInfoDao();
	}

	public boolean modify(String count, String psd, String qq, String phone,
			String nickName) {
		if (RegexUtil.checkPsd(psd) & RegexUtil.checkCount(count)
				& RegexUtil.checkNickName(nickName)
				& RegexUtil.checkPhone(phone) & RegexUtil.checkQq(qq)) {
			User user = new User();
			user.setNickName(nickName);
			user.setCount(count);
			user.setPsd(psd);
			user.setQq(qq);
			user.setPhone(phone);
			return dao.change(user);
		}
		return false;
	}
}
