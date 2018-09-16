package json;

public class DInfo {
	private int dino;
	private String diname;
	private String didesc;
	private int dicnt;
	public DInfo() {
		
	}
	public DInfo(int dino, String diname, String didesc, int dicnt) {
		super();
		this.dino = dino;
		this.diname = diname;
		this.didesc = didesc;
		this.dicnt = dicnt;
	}
	public int getDino() {
		return dino;
	}
	public void setDino(int dino) {
		this.dino = dino;
	}
	public String getDiname() {
		return diname;
	}
	public void setDiname(String diname) {
		this.diname = diname;
	}
	public String getDidesc() {
		return didesc;
	}
	public void setDidesc(String didesc) {
		this.didesc = didesc;
	}
	public int getDicnt() {
		return dicnt;
	}
	public void setDicnt(int dicnt) {
		this.dicnt = dicnt;
	}
	@Override
	public String toString() {
		return "DInfo [dino=" + dino + ", diname=" + diname + ", didesc=" + didesc + ", dicnt=" + dicnt + "]";
	}
	
	
}