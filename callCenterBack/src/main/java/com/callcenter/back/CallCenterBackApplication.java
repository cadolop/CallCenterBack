package com.callcenter.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <h1>Clase CallCenterBackApplication</h1>
 * Clase start de spring y start de los proceso asincronos
 *
 * @author  <a href="mailto:cadolop@gmail.com">Carlos Adolfo Lopez</a>
 * @version 1.0
 * @since 20/07/2019
 * @project CallCenterBack
 */
@SpringBootApplication
@EnableAsync
public class CallCenterBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(CallCenterBackApplication.class, args);
	}

}
