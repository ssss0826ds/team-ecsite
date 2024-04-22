package jp.co.internous.team2402.model.form;

import java.io.Serializable;

/**
 * 検索フォーム
 * @author インターノウス
 *
 */
public class SearchForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int category;
	private String keywords;
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public String getKeywords() {
		return keywords;
	}
}
