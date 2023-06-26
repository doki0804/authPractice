package com.noriand.api.v0.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.noriand.api.v0.dto.order.OrderItemDto;
import com.noriand.api.v0.entity.order.OrderItem;
import com.noriand.api.v0.repository.order.OrderItemRepository;
import com.noriand.api.v0.service.OrderItemService;

@Service
public class orderItemServiceImpl implements OrderItemService {

	private final OrderItemRepository orderItemRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public orderItemServiceImpl(OrderItemRepository orderItemRepository, ModelMapper modelMapper) {
		this.orderItemRepository = orderItemRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> selectPLocByONo(Long id) {
		List<OrderItem> orderItemList = orderItemRepository.findOrderItemsByOrdersId(id);
		List<OrderItemDto> orderItemDtoList = orderItemList.stream()
				.map(orderItem -> modelMapper.map(orderItem, OrderItemDto.class))
				.collect(Collectors.toList());
		return null;
	}

}
