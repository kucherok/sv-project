package by.kucher.project.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

	@Override
	public String getMessage() {
		return "Message Return service layer";
	}

}
