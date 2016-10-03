package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by barabasm on 03/10/2016.
 */
@Controller
public class HomeController {

	@RequestMapping({
			"/view1",
			"/view2",
			"/view3",
			"/tracks/{id:\\w+}",
			"/location",
			"/about"
	})
	public String index() {
		return "forward:/index.html";
	}
}
