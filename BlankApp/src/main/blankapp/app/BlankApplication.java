package blankapp.app;

import blankapp.service.BlankService;
import blankapp.service.BlankServiceImpl;

import java.util.List;

public class BlankApplication {

	/**
       Blank Service.
	*/
	public static void main(String[] args) {
		BlankService blankService = new BlankServiceImpl();

		List<String> messages = blankService.read();
		blankService.write(messages);
	}

}
