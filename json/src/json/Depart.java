package json;

public class Depart {
	private int num;
	private String name;
	private String type;

	public Depart() {

	}

	public Depart(int num, String name, String type) {
		super();
		this.num = num;
		this.name = name;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Depart [num=" + num + ", name=" + name + ", type=" + type + "]";
	}

}
