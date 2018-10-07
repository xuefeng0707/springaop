package test.xuefeng.springaop.service.impl;

import org.springframework.stereotype.Service;

import test.xuefeng.springaop.annotation.LogTime;
import test.xuefeng.springaop.service.MyService;

@Service
@LogTime
public class MyServiceImpl implements MyService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}

}
