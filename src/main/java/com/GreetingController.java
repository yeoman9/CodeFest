package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template1 = "Hello, %s!";
    private static final String template2 = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public List<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Greeting> greetingsList = new ArrayList<>();

		Greeting greeting1 = new Greeting(counter.incrementAndGet(), String.format(template1, name));
		Greeting greeting2 = new Greeting(counter.incrementAndGet(), String.format(template2, name));
		greetingsList.add(greeting1);
		greetingsList.add(greeting2);

		counter.set(0);
		return greetingsList;
	}
}