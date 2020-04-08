package com.it.Controller;

import java.io.IOException;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.it.ModelDto.OrderDto;
import com.it.Service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") OrderDto order) {
		try {

			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/pay/cancel",
					"http://localhost:8080/pay/success");
			for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {
					return "redirect:" + link.getHref();
				}
			}

		} catch (PayPalRESTException e) {

			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping(value = "pay/cancel")
	public String cancelPay() {
		return "cancel";
	}

	@GetMapping(value = "pay/success")
	public ModelAndView successPay(@RequestParam("paymentId") String paymentId,
			@RequestParam("PayerID") String payerId) {
		ModelAndView mv = new ModelAndView();
		try {

			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			service.saveDto(payment);

			if (payment.getState().equals("approved")) {
				mv.setViewName("success");
				mv.addObject("id", paymentId);
				return mv;
			} else {
				mv.setViewName("error");
				return mv;
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		mv.setViewName("error");
		return mv;
	}

	@GetMapping(value = "/download/{id}")
	public ResponseEntity<InputStreamResource> excelCustomersReport(@PathVariable("id") String id) throws IOException {

		return service.download(id);

	}

}