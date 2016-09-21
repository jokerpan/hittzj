package top.hittzj.service;

import top.hittzj.dao.AddCS2CollectionDao;
import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;

public class AddCS2CollectionService {
	private AddCS2CollectionDao dao;

	public AddCS2CollectionService() {
		this.dao = new AddCS2CollectionDao();
	}

	public boolean add(Commodity_Sell cs, User user) {
		return dao.add2Collection(cs, user);
	}

}
