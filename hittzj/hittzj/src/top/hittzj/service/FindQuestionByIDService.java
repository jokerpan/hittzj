package top.hittzj.service;

import top.hittzj.dao.GetQuestionDao;
import top.hittzj.entity.Question;

public class FindQuestionByIDService {
	private GetQuestionDao dao;
	public FindQuestionByIDService(){
		this.dao=new GetQuestionDao();
	}
	public Question getQuestion(int id){
		Question question=new Question();
		question.setId(id);
		return dao.getQuestionById(question);
	}

}
