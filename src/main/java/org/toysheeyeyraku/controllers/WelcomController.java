package org.toysheeyeyraku.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
	@GetMapping("q")
	public String s(Principal p) {
		System.out.println(p.getName());
		return "q";
	}
}
