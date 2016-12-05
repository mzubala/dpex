package pl.com.bottega.dpex.document.shared;

public class ErrorRegistry {

	private static final ErrorRegistry SINGLETON = new ErrorRegistry();
	
	public static ErrorRegistry getInstance() {
		return SINGLETON;
	}
	
	public void log(Class<?> klass, String msg) {
		System.out.println(String.format("Error from %s: %s", klass, msg));
	}
	
}
