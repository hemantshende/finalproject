package com.PizzaHut.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.CartDao;
import com.PizzaHut.dao.PaymentDao;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.PaymentDto;
import com.PizzaHut.entities.Payments;

@Service
@Transactional
public class PaymentService {
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private CartDao cartDao;
	
	public Payments addPayments(PaymentDto paymentDto)
	{
		int totalAmount = cartDao.findTotalAmount(paymentDto.getUserId());
		paymentDto.setMode("Card Payment");
		paymentDto.setPayStatus("success");
		System.out.println(totalAmount);
		if(totalAmount != 0) {
			Payments add=convertor.toPaymentEntity(paymentDto,totalAmount);
			paymentDao.save(add);
			return add;
		}
		return null;
	}
	
	public Payments findPayments(int payId)
	{
		Payments togetPayments=paymentDao.getById(payId);
		return togetPayments;
		
	}
}
