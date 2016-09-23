package top.hittzj.service;

import top.hittzj.dao.AddCN2CollectionDao;
import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;

public class AddCN2CollectionService {
	private AddCN2CollectionDao dao;
	public AddCN2CollectionService(){
		this.dao=new AddCN2CollectionDao();
	}
	public boolean add(Commodity_Need cn,User user){
		return dao.add2Collection(cn, user);
	}

}
