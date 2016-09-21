package top.hittzj.service;

import java.util.Date;

import top.hittzj.dao.AddCSDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.User;

public class AddCSService {
	private AddCSDao dao;

	public AddCSService() {
		this.dao = new AddCSDao();
	}

	public boolean add(String name, String money, String useTime,
			String number, String flaw, String desc, String location,
			String img, User user, Commodity_Type type) {
		Commodity_Sell cs = new Commodity_Sell();
		cs.setName(name);
		cs.setDesc(desc);
		cs.setFlaw(flaw);
		cs.setLocation(location);
		cs.setType(type);
		cs.setImg(img);
		cs.setUseTime(useTime);
		cs.setNumber(number);
		cs.setUser(user);
		cs.setMoney(money);
		cs.setTime(new Date());
		System.out.println(cs);
		return dao.save(cs);
	}
}
