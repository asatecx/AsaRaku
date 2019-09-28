package com.apitore.api.shopping.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apitore.api.shopping.bean.item.insert.InventoryBean;
import com.apitore.api.shopping.bean.item.insert.ItemBean;
import com.apitore.api.shopping.bean.item.insert.ItemInventoryBean;
import com.apitore.api.shopping.service.ItemService;
import com.apitore.api.shopping.service.NavigationService;
import com.apitore.api.shopping.service.RakutenPayOrderService;
import com.apitore.api.shopping.service.ShopManagementService;
import com.apitore.api.shopping.utils.Bean2XmlUtil;
import com.google.common.collect.Lists;

/**
 * @author ASATECX
 */
@Controller
@RequestMapping(value = "/")
public class TransController {

	@Autowired
	ShopManagementService shopManagementService;

	@Autowired
	NavigationService navigationService;

	@Autowired
	ItemService itemService;

	@Autowired
	RakutenPayOrderService rakutenPayOrderService;

    @RequestMapping("/index")
    public String toIndex(ModelAndView mv, HttpSession session) {
        return "Search";
    }


//    @RequestMapping("/Search")
//    public ModelAndView  toAdmin(ModelAndView mv, HttpSession session) {
//        mv.setViewName("XXXX");
//        return mv;
//    }

	@RequestMapping("/testget")
	public String toAdmin(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("categoryMapId", "30469"));

		String res = shopManagementService.dsgn_category_list_get(params);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}

	@RequestMapping("/testget2")
	public String testget2(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("genreId", "564040"));

		String res = navigationService.genre_get(params);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}

	@RequestMapping("/ItemService/search")
	public String testget3(ModelAndView mv, HttpSession session) {
		List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("itemName", "着後レビューで選べる特典"));

		String res = itemService.search(params);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}

	@RequestMapping("/RakutenPayOrderService/getOrder")
	public String testget4(ModelAndView mv, HttpSession session) {
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> orderNumberList = new ArrayList<String>();
		orderNumberList.add("502763-20171027-00006701");
		orderNumberList.add("502763-20171027-00006702");
		param.put("orderNumberList", orderNumberList);

		String res = rakutenPayOrderService.getOrder(param);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}

	@RequestMapping("/ItemService/insert")
	public String testget5(ModelAndView mv, HttpSession session) {
		Map<String, Object> param = new HashMap<String, Object>();
		ItemBean item = new ItemBean();

		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setInventoryCount(1);

		List<InventoryBean> inventories = new ArrayList<InventoryBean>();
		inventories.add(inventoryBean);

		ItemInventoryBean itemInventoryBean = new ItemInventoryBean();
		itemInventoryBean.setInventoryType(1);
		itemInventoryBean.setInventories(inventories);
		item.setItemName("テスト商品");
		item.setItemPrice(50000);
		item.setGenreId(564040);
		item.setCatalogId("4901810674091");
		item.setCatalogIdExemptionReason(1);
		item.setItemLayout(1);
		item.setItemInventory(itemInventoryBean);
		item.setItemWeight(999999999);


		String xmlRequest = Bean2XmlUtil.parseBeanToXml(ItemBean.class,item);

		String res = itemService.insert(xmlRequest);
		session.setAttribute("apiResult", res);
		return "ResResult";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        String name = "jiangbei";
        model.addAttribute("name", name);
        String strJson ="{\"name\":\"tangxiaoxiao\",\"age\":\"25\",\"tel\":{\"tel1\":\"123\",\"tel2\":\"456\"}}";
        //        String strJson ="[{'name':'tangxiaoxiao','age':'25'}]";
        model.addAttribute("strJson", strJson);
        return "Search";
    }

}
