package com.callcenter.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.callcenter.back.service.IDispatcher;

/**
 * <h1>Clase DispatcherController</h1>
 * Clase controller que expone los servicios a llamar
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@RestController
@RequestMapping("/dispatcher")
public class DispatcherController {
	private int numberCall = 0;

	@Value("${api.cfg.queuecapacity}")
	private int queueCapacity;

	@Autowired
	private IDispatcher dispatcher;

	public DispatcherController() {
		// Spring
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> dispatcherController(@RequestParam("size") int size) {
		if (size < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else if (size > queueCapacity) {
			return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
		}
		for (int i = 0; i < size; i++) {
			numberCall++;
			dispatcher.dispatchCall("" + numberCall);
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
