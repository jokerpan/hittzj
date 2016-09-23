package top.hittzj.service;

import top.hittzj.dao.ModifyCNDao;
import top.hittzj.entity.Commodity_Need;

public class ModifyCNService {
	private ModifyCNDao dao;
	public ModifyCNService() {
		// TODO Auto-generated constructor stub
		this.dao=new ModifyCNDao();
	}
	public boolean modify(Commodity_Need cn){
		return dao.modify(cn);
	}

}
