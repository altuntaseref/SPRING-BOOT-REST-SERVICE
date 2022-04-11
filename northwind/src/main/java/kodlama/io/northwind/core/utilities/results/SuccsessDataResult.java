package kodlama.io.northwind.core.utilities.results;

public class SuccsessDataResult<T> extends DataResult<T> {
	
	public SuccsessDataResult(T data, String message) {
		super(data, true, message);
		
	}
	
	public SuccsessDataResult (T data) {
		super (data,true);
	}
	
	public SuccsessDataResult (String message) {
		super (null,true,message);
	}
	
	public SuccsessDataResult () {
		super (null,true);
	}

}
