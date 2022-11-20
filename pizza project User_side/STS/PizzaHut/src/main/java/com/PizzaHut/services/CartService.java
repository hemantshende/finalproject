package com.PizzaHut.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.CartDao;
import com.PizzaHut.dto.CartDto;
import com.PizzaHut.dto.CartDtoWithoutTopping;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.entities.Cart;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.entities.Users;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private DtoEntityConvertor convertor;

	// add in cart with topping
	public Cart addTocart(CartDto cartDto) {
		Cart cartAdd = convertor.tocartEntity(cartDto);
		System.out.println("===>>>>===>>>>" + cartAdd);
		cartDao.save(cartAdd);
		return cartAdd;
	}

	// add in cart without topping
	public Cart addTocart(CartDtoWithoutTopping cartWithoutTopping) {
		Cart cartAddNoTopping = convertor.tocartEntityNoTopping(cartWithoutTopping);
		System.out.println(cartAddNoTopping);
		cartDao.save(cartAddNoTopping);
		return cartAddNoTopping;
	}

	// show all cart of a particular user
	public List<Cart> getAllCartOfUser(int userid, int status) {
		Users getCart = new Users();
		getCart.setUserId(userid);
		List<Cart> cartsOfUser = cartDao.findByUserStatus(getCart, status);
		return cartsOfUser;
	}

	// get by cart id
	public List<Cart> fetchByid(int cartid) {
		Cart byId = cartDao.getById(cartid);
		List<Cart> cartById = new ArrayList<Cart>();
		if (byId != null) {
			cartById.add(byId);
			return cartById;
		}
		return null;
	}
	
	// get by delivery id
	public List<Cart> fetchByDeliveryid(int deliveryId) {
		DeliveryStatus delivery = new DeliveryStatus();
		delivery.setDeliveryId(deliveryId);
		List<Cart> cartById = cartDao.findBydeliveryId(delivery);
		if (cartById != null) {
			return cartById;
		}
		return null;
	}

	// delete from cart
	public int deleteByCartId(int cartId) {
		cartDao.deleteById(cartId);
		return 1;
	}

	// update cartStatus
	public String changeCartStatus(int userid) {
		cartDao.changeStatus(userid);
		return "cart Status updated";
	}

	// add foreignKey
	public void addForeignKey(int delId, int userid) {
		System.out.println("this is payment id" + delId);
		int returned = cartDao.addForeign(delId, userid);
		System.out.println("WE are here===" + returned);
	}
}
