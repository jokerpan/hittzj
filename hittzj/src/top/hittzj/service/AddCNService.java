package top.hittzj.service;

import java.util.Date;
import top.hittzj.dao.AddCNDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;

public class AddCNService {
	private AddCNDao dao;

	public AddCNService() {
		this.dao = new AddCNDao();
	}

	public boolean add(String name, String money, String img, String location,
			String desc, String number, User user) {
		Commodity_Need cn = new Commodity_Need();
		cn.setName(name);
		cn.setMoney(money);
		cn.setImg(img);
		cn.setLocation(location);
		cn.setNumber(number);
		cn.setUser(user);
		cn.setDesc(desc);
		cn.setTime(new Date());
		System.out.println(cn);
		return dao.save(cn);
	}
}
