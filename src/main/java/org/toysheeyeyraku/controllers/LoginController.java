package org.toysheeyeyraku.controllers;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.toysheeyeyraku.models.User;
import org.toysheeyeyraku.repositories.UserRepository;
import org.toysheeyeyraku.services.DynamicLoginService;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;
	@GetMapping("/loginSuccess")
	public String getLoginInfo(Model m, OAuth2AuthenticationToken authentication,HttpServletRequest request) throws ServletException {

		OAuth2AuthorizedClient client = authorizedClientService
				.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

		String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

		if (!StringUtils.isEmpty(userInfoEndpointUri)) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());

			HttpEntity<String> entity = new HttpEntity<String>("", headers);

			ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity,
					Map.class);
			Map userAttributes = response.getBody();
			String username ="";
			if (client.getClientRegistration().getClientName().equals("Facebook")) {
				username="Facebook "+userAttributes.get("id");
			}
			if (client.getClientRegistration().getClientName().equals("Google")) {
				username="Google "+userAttributes.get("email");
			}
			User us ;
			String password=username+"4";
			if (userRepository.findByUsername(username)==null) {
				us =User.createDefaultUser(username, password, encoder);
				userRepository.save(us);
			}
			us=userRepository.findByUsername(username);
			loginService.authenticateUserAndSetSession(us.getUsername(), request,password );
		}

		return "redirect:/creation";
	}
	@Autowired
	private DynamicLoginService loginService;
}
