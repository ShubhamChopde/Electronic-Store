package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * This is a order entity related service
* @author Debarghya Dutta(@github - cap-codeDeb)
* @since 0.0.1
**/

import com.wipro.entity.Order;
import com.wipro.pojo.Items;
import com.wipro.repo.OrderRepository;


/**
* @author XXXXXX XXXXXX(@github - XXXXXX)
* @since 0.0.1
* 
* This is Order related implemented Service Class
**/

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Override
	public String addOrder(Order ordr) {
		repo.save(ordr);
		return ordr.getOid();
	}
	
	@Override
	public Order getOrder(String oid) {
		return repo.findById(oid).get();
	}
	
	@Override
	public List<Order> fetchAllByUserId(int userid){
		return repo.findAllByUser(userid);
	}

	@Override
	public List<Items> viewProducts(String order_id) {
		return repo.viewProducts(order_id);
	}

}
