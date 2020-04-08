package com.it.Service;

import com.it.ModelDto.ProductDto;
import com.it.ModelDto.PromocodeDto;

public interface ProductService {
	public ProductDto save(ProductDto productDto);

	public Boolean checkPromocode(PromocodeDto promoDto);

}
