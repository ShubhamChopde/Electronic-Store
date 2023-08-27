package com.wipro.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.entity.ShoppingCart;
import com.wipro.pojo.Items;

/**
* This is a shopping cart entity related repository
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
*/
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	@Query("FROM ShoppingCart WHERE user_id=:uid")
	ShoppingCart findCartByUserId(int uid);
	
	@Query(value="SELECT Products.* FROM Products INNER JOIN added_products ON added_products.cart_id=:cartid AND Products.product_id=added_products.product_id",nativeQuery = true)
	List<Items> viewCart(int cartid);
}
