package top.hittzj.service;

import top.hittzj.dao.GetUserDao;
import top.hittzj.entity.User;

public class FindUserService {
	private GetUserDao dao;
	public FindUserService(){
		this.dao=new GetUserDao();
	}
	
	public User find(String count,String psd){
		User user=new User();
		user.setCount(count);
		user.setPsd(psd);
		return dao.findUser(user);
	}

}
