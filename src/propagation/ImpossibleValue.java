package propagation;

public class ImpossibleValue extends Throwable{
	
	public ImpossibleValue(String title){
		this.title=title;
	}
	private String title;
	public String getTitle() {
		return title;
	}
}
