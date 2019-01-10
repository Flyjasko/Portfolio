package lt.baltictalents.pirkiniai.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lt.baltictalents.pirkiniai.entities.Product;
import lt.baltictalents.pirkiniai.services.productService;
import lt.baltictalents.pirkiniai.services.shopService;

@Controller
@SessionAttributes({"shop_id","shopHistory_id","searchName","shopListForAdd"})
public class ProductController {
	
	@Autowired
	shopService sSERV;
	@Autowired
	productService pSERV;
	
	@GetMapping("/productControl")
	public String getShopList(Model model) {
		model.addAttribute("shopListForAdd", sSERV.getShopList());
		model.addAttribute("product", new Product());
		return "productControl";
	}
	
	@PostMapping("/productControl")
	public String addProductByShop(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "productControl";
		} else {
			pSERV.addProductByShop(product);
			return "redirect:productControl";
		}
	}
	
	@GetMapping("/index")
	public String getShopListIndex(Model model) {
		model.addAttribute("shopList", sSERV.getShopList());
		return "index";
	}
	
	@GetMapping("/history")
	public String getShopListHistory(Model model) {
		model.addAttribute("shopList", sSERV.getShopList());
		return "history";
	}
	
	@GetMapping("/productListByShop")
	public String getShopListIndex1(@RequestParam int shop_id, Model model) {
		model.addAttribute("shop_id", shop_id);
		model.addAttribute("productList", pSERV.getProductsByShop(shop_id));
		return "productListByShop";	
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id) {
		pSERV.deleteProduct(id);
		return "redirect:productListByShop";
	}
	
	@GetMapping("/purchaseProduct")
	public String purchaseProduct(@RequestParam int id) {
		pSERV.purchaseProduct(id);
		return "redirect:productListByShop";
	}
	
	@GetMapping("/allProductList")
	public String getShopListIndex2(Model model) {
		model.addAttribute("productList", pSERV.getAllProducts());
		return "allProductList";	
	}
	
	@GetMapping("/deleteProduct2")
	public String deleteProduct2(@RequestParam int id) {
		pSERV.deleteProduct(id);
		return "redirect:allProductList";
	}
	
	@GetMapping("/purchaseProduct2")
	public String purchaseProduct2(@RequestParam int id) {
		pSERV.purchaseProduct(id);
		return "redirect:allProductList";
	}
	
	@GetMapping("/historyListByShop")
	public String getShopListByProductHistory(@RequestParam int shopHistory_id, Model model) {
		model.addAttribute("shopHistory_id", shopHistory_id);
		model.addAttribute("productList", pSERV.getProductsByShopForHistory(shopHistory_id));
		return "productListByShopForHistory";	
	}
	
	@GetMapping("/allProductHistoryList")
	public String getallProductHistoryList(Model model) {
		model.addAttribute("productList", pSERV.getAllProductsForHistory());
		return "allProductListForHistory";
	}
	
	@GetMapping("/searchForProduct")
	public String searchForAProduct(@RequestParam String searchName, Model model) {
		model.addAttribute("searchName", searchName);
		model.addAttribute("searchProductList", pSERV.searchForAProductByName(searchName));
		return "searchList";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
	StringTrimmerEditor stEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stEditor);
	}
	
}
