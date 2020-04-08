package com.it.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.Constant.Constant;
import com.it.Model.Product;
import com.it.ModelDto.ProductDto;
import com.it.ModelDto.PromocodeDto;
import com.it.Repository.ProductRepository;
import com.it.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto save(ProductDto productDto) {

		double totalprice = ((2549.99 * productDto.getMss()) + (1025.50 * productDto.getEi())
				+ (100 * productDto.getTraining()));

		productDto.setPrice(totalprice);
		if (productDto.getPromocode().equalsIgnoreCase(Constant.promo10) && totalprice >= 5000) {
			productDto.setPrice(totalprice * 0.9);
		}

		if (productDto.getPromocode().equalsIgnoreCase(Constant.promo15) && totalprice >= 10000) {

			productDto.setPrice(totalprice * 0.85);
		}

		Product product = modelMapper.map(productDto, Product.class);
		Product pr = productRepository.save(product);
		return modelMapper.map(pr, ProductDto.class);
	}

	@Override
	public Boolean checkPromocode(PromocodeDto promoDto) {
		if ((promoDto.getTotalPrice() >= Constant.promo10_Min)
				&& (promoDto.getName().equalsIgnoreCase(Constant.promo10))) {
			return true;
		} else if ((promoDto.getTotalPrice() >= Constant.promo15_Min)
				&& (promoDto.getName().equalsIgnoreCase(Constant.promo15))) {
			return true;
		} else {
			return false;
		}

	}

}
