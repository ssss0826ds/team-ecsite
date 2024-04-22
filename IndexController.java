package jp.co.internous.team2402.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2402.model.domain.MstCategory;
import jp.co.internous.team2402.model.domain.MstProduct;
import jp.co.internous.team2402.model.form.SearchForm;
import jp.co.internous.team2402.model.mapper.MstCategoryMapper;
import jp.co.internous.team2402.model.mapper.MstProductMapper;
import jp.co.internous.team2402.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2402")
public class IndexController {
	
	/*
	 * フィールド定義
	 */
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	private Random random = new Random();
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		if (loginSession.getUserId() == 0 && loginSession.getTmpUserId() == 0) {
			loginSession.setTmpUserId((100000000 + random.nextInt(899999999)) * -1);
		}
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		
		return "index";
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = null;
		
		String keywords = f.getKeywords().replaceAll("[　]+", " ").replaceAll("\\s{2,}", " ").trim();
		
		if (f.getKeywords() == "" && f.getCategory() == 0) {
			products = productMapper.find();
		} else if (f.getCategory() == 0) {
			products = productMapper.findByProductName(keywords.split(" "));
		} else { 
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywords.split(" "));
		}
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("categories", categories);
		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory());
		m.addAttribute("products", products);
		
		return "index";
		
	}
}
