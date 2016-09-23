package top.hittzj.service;

import top.hittzj.dao.GetTypeDao;
import top.hittzj.entity.Commodity_Type;

public class FindTypeById {
	private GetTypeDao dao;

	public FindTypeById() {
		this.dao = new GetTypeDao();
	}
	public Commodity_Type find(int id){
		Commodity_Type type=new Commodity_Type();
		type.setId(id);
		return dao.getType(type);
	}

}
