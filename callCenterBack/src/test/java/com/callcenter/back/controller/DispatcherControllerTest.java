package com.callcenter.back.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.callcenter.back.service.IDispatcher;

/**
 * <h1>Clase DispatcherControllerTest</h1>
 * Clase test de DispatcherControllerTest que testeala logica de negicio del callcenter y su despacho
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DispatcherController.class)
public class DispatcherControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private IDispatcher dispatcher;

	@Test
	public void dispatcherControllerTen() throws Exception {
		mvc.perform(post("/dispatcher?size=10").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
