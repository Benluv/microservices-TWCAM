package es.uv.bjtwcam.productores.analyzers;

public class MyCustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MyCustomException() {
		super("Running under default profile");
	}

}
