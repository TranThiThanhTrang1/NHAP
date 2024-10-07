package com.koi.koi.controller;

import com.koi.koi.dto.request.orderRequest;
import com.koi.koi.dto.response.orderResponse;
import com.koi.koi.service.IOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("Order/add")
    public ResponseEntity<?> create(@Valid @RequestBody orderRequest request) {
        orderResponse response = orderService.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("Order/update")
    public ResponseEntity<?> updateOrder(orderRequest request) {
        orderResponse response = orderService.updateOrder(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
