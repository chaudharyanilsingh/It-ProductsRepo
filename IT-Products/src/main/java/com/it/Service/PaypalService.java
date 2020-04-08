package com.it.Service;

import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PaypalService {


	Payment executePayment(String paymentId, String payerId)throws PayPalRESTException;

	void saveDto(Payment payment);

	ResponseEntity<InputStreamResource> download(String id)throws IOException;

	Payment createPayment(Double total, String currency, String method, String intent, String description,
			String cancelUrl, String successUrl) throws PayPalRESTException;

}
