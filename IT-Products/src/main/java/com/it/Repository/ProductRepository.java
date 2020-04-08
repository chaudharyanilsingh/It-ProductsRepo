package com.it.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
