package com.koi.koi.controller;

import com.koi.koi.dto.request.feedbackRequest;
import com.koi.koi.dto.response.feedbackResponse;
import com.koi.koi.service.IFeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private IFeedbackService feedbackService;

    @PostMapping("Feedback/add")
    public ResponseEntity<?> saveFeedback(@Valid @RequestBody feedbackRequest request) {
        feedbackResponse response = feedbackService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Feedback/{invoiceID}")
    public ResponseEntity<?> findAllFeedbacksByInvoiceID(@PathVariable("invoiceID") String invoiceID) {
        List<feedbackResponse> responses = feedbackService.findAllFeedbacksByInvoiceID(invoiceID);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
