package co.com.bancolombia.validateExcelApi.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	private static final String template = "Hello, %s!";
	private static final String templateB4 = "Base64: %s";
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_XML_VALUE)
	public TestService testService(@RequestParam(value = "desc", defaultValue = "def") String desc, @RequestParam(value = "base64", defaultValue = "def") String base) {
		return new TestService(String.format(template, desc), String.format(templateB4, base));
	}
	
	@PostMapping(value = "/saveTest", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<TestService> createTest(@RequestBody TestService testService){
		TestService _testService = new TestService(testService.getDescription(), testService.getBase64());
		
		testService.setDescription(testService.getDescription());
		testService.setBase64(testService.getBase64());
		
		System.out.println(testService.getDescription() +  "	+	" + testService.getBase64());
		
		return new ResponseEntity<>(_testService, HttpStatus.CREATED);
	}

}
