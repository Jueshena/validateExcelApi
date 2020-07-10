package co.com.bancolombia.validateExcelApi.restservice;

public class TestService {
	
	private String description;
	private String base64;
	
	public TestService(String description, String base64) {
		this.description = description;
		this.base64 = base64;
	}
		
		public String getDescription() {
			return description;
		}
		
		public String getBase64() {
			return base64;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setBase64(String base64) {
			this.base64 = base64;
		}
	
}
