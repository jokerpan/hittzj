package top.hittzj.service;

import top.hittzj.dao.GetCNDao;
import top.hittzj.entity.Commodity_Need;

public class GetCNService {
	private GetCNDao dao;
	public GetCNService(){
		this.dao=new GetCNDao();
	}
	public Commodity_Need get(int id){
		Commodity_Need cn=new Commodity_Need();
		cn.setId(id);
		return dao.getCommodity_Need(cn);
	}
}
