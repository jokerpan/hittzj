package top.hittzj.entity;

import java.util.List;

/**
 * @author zy_q
 *
 * @param <T>
 */
//所有的东西的列表都用这个来表示 列表页数从1页数开始 商品从1开始
public class  TzjList<T> {
	private int totalPageCount;
	private int totalItemCount;
	private int currentPage;
	private int pageItemCount;
	List<T> list;
	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageItemCount() {
		return pageItemCount;
	}
	public void setPageItemCount(int pageItemCount) {
		this.pageItemCount = pageItemCount;
	}

	

}
