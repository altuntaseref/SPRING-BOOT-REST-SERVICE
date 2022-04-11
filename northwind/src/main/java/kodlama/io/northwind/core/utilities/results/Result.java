package kodlama.io.northwind.core.utilities.results;

public class Result {
	
	private boolean succsess;
	private String message;
	
	public Result (boolean succsess) {
		this.succsess= succsess;
		
	}
	
	public Result (boolean succsess, String message) {
		this(succsess);
		this.message=message;
		
		
	}
	
	public boolean isSuccsess ( ){
		return this.succsess;
		
	}
	
	
	public String getMessage() {
		
		return this.message;
	}

}
