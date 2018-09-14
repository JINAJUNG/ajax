package json;

public class Person {
	private String name;
	private String id;
	private String pwd;
	private String trans;
	
	public Person() {
		
	}
	public Person(String name, String id, String pwd, String trans) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.trans = trans;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", pwd=" + pwd + ", trans=" + trans + "]";
	}
	
	
}
