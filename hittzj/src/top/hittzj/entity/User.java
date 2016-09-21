package top.hittzj.entity;


import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author zy_q
 * @version 1.0 
 * 用户信息
 */
public class User {
	private int id;
	private String count;
	private String nickName;
	private String psd;
	private String phone;
	private String qq;
	private String answer;
	private Date time;
	private Question question;
	private List<Commodity_Sell> commodity_Sells;
	private List<Commodity_Need> commodity_Needs;
	//收藏多对多
	private Set<Commodity_Need> collectCommodity_Needs;	
	private Set<Commodity_Sell> collectCommodity_Sells;

	public Set<Commodity_Need> getCollectCommodity_Needs() {
		return collectCommodity_Needs;
	}

	public void setCollectCommodity_Needs(Set<Commodity_Need> collectCommodity_Needs) {
		this.collectCommodity_Needs = collectCommodity_Needs;
	}

	public Set<Commodity_Sell> getCollectCommodity_Sells() {
		return collectCommodity_Sells;
	}

	public void setCollectCommodity_Sells(Set<Commodity_Sell> collectCommodity_Sells) {
		this.collectCommodity_Sells = collectCommodity_Sells;
	}

	
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Commodity_Sell> getCommodity_Sells() {
		return commodity_Sells;
	}

	public void setCommodity_Sells(List<Commodity_Sell> commodity_Sells) {
		this.commodity_Sells = commodity_Sells;
	}

	public List<Commodity_Need> getCommodity_Needs() {
		return commodity_Needs;
	}

	public void setCommodity_Needs(List<Commodity_Need> commodity_Needs) {
		this.commodity_Needs = commodity_Needs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return this.getCount()+this.getPhone()+this.getPsd()+this.getQq()+this.getCount();

	}
}
