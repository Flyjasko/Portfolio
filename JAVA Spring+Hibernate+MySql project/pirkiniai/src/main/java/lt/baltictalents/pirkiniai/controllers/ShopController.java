package lt.baltictalents.pirkiniai.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lt.baltictalents.pirkiniai.entities.Shop;
import lt.baltictalents.pirkiniai.services.shopService;

@Controller
public class ShopController {
	
	@Autowired
	shopService sSERV;
	
	@GetMapping("/shopList")
	public String getShopList(Model model) {
		model.addAttribute("shopList", sSERV.getShopList());
		return "shopList";
	}
	
	@GetMapping("/deleteShop")
	public String insertStudent(@RequestParam int id) {
		sSERV.deleteShop(id);
		return "redirect:shopList";
	}
	
	@GetMapping("/addShop")
	public String addShop(Model model) {
		model.addAttribute("shop", new Shop());
		return "addShop";
	}
	
	@PostMapping("/addShop")
	public String addShop(@ModelAttribute("shop") Shop shop) {
		sSERV.addShop(shop);
		return "redirect:shopList";
	}
	
	@GetMapping("/editShop")
	public String editShop(@RequestParam int id, Model model) {
		model.addAttribute("shop", sSERV.getShop(id));
		return "editShop";
	}
	
	@PostMapping("/editShop")
	public String editShop(@ModelAttribute("shop") Shop shop, @RequestParam("file") MultipartFile file,
			Model model) throws IOException {
		if (file != null && !file.isEmpty()) {
			byte[] bytes = file.getBytes();
			File dir = new File("C:/Users/Tomas/eclipse-workspace/pirkiniai/src/main/webapp/img");
			File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			shop.setImage(file.getOriginalFilename());
		}
		sSERV.updateShop(shop);
		return "redirect:shopList";
	}
}
