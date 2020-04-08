package com.it.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.it.ModelDto.ProductDto;
import com.it.ModelDto.PromocodeDto;
import com.it.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	private ModelAndView frontpage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("first");
		return mv;
	}

	@PostMapping("/add")
	private ModelAndView PostData(@ModelAttribute ProductDto productDto) {
		ProductDto pd = productService.save(productDto);
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("price", pd.getPrice());
		return mv;
	}

	@PostMapping("/check-promo")
	private Boolean checkpromo(@RequestBody PromocodeDto promoDto) {
		return productService.checkPromocode(promoDto);

	}

}
