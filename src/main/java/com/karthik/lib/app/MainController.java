package com.karthik.lib.app;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/")
  public String index() {
    return "Proudly handcrafted by " +
        "<a href='http://netgloo.com/en'>Netgloo</a> :)";
  }
  
  @RequestMapping("/error2")
  public Map<String, Object> error() {
	  Map<String, Object>  resultMap = new HashMap<>();
	  resultMap.put("error", "Something went wrong");
    return resultMap;
  }

}