package vo;

public class TicketInfo {
	private Integer tmnum;
	private String tmname; 
	private Integer tmprice; 
	private String tmstartdat; 
	private String tmenddat; 
	private String tmcredat; 
	private String tmdesc; 
	private Integer tmcnt; 
	private String tmimg;
	private PageInfo pi;
	
	public PageInfo getPi() {
		return pi;
	}
	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	public TicketInfo() {
		
	}
	/**
	 * @param tmnum
	 * @param tmname
	 * @param tmprice
	 * @param tmstartdat
	 * @param tmenddat
	 * @param tmcredat
	 * @param tmdesc
	 * @param tmcnt
	 * @param tmimg
	 */
	public TicketInfo(Integer tmnum, String tmname, Integer tmprice, String tmstartdat, String tmenddat,
			String tmcredat, String tmdesc, Integer tmcnt, String tmimg) {
		super();
		this.tmnum = tmnum;
		this.tmname = tmname;
		this.tmprice = tmprice;
		this.tmstartdat = tmstartdat;
		this.tmenddat = tmenddat;
		this.tmcredat = tmcredat;
		this.tmdesc = tmdesc;
		this.tmcnt = tmcnt;
		this.tmimg = tmimg;
	}
	public Integer getTmnum() {
		return tmnum;
	}
	public void setTmnum(Integer tmnum) {
		this.tmnum = tmnum;
	}
	public String getTmname() {
		return tmname;
	}
	public void setTmname(String tmname) {
		this.tmname = tmname;
	}
	public Integer getTmprice() {
		return tmprice;
	}
	public void setTmprice(Integer tmprice) {
		this.tmprice = tmprice;
	}
	public String getTmstartdat() {
		return tmstartdat;
	}
	public void setTmstartdat(String tmstartdat) {
		this.tmstartdat = tmstartdat;
	}
	public String getTmenddat() {
		return tmenddat;
	}
	public void setTmenddat(String tmenddat) {
		this.tmenddat = tmenddat;
	}
	public String getTmcredat() {
		return tmcredat;
	}
	public void setTmcredat(String tmcredat) {
		this.tmcredat = tmcredat;
	}
	public String getTmdesc() {
		return tmdesc;
	}
	public void setTmdesc(String tmdesc) {
		this.tmdesc = tmdesc;
	}
	public Integer getTmcnt() {
		return tmcnt;
	}
	public void setTmcnt(Integer tmcnt) {
		this.tmcnt = tmcnt;
	}
	public String getTmimg() {
		return tmimg;
	}
	public void setTmimg(String tmimg) {
		this.tmimg = tmimg;
	}
	@Override
	public String toString() {
		return "TicketInfo [tmnum=" + tmnum + ", tmname=" + tmname + ", tmprice=" + tmprice + ", tmstartdat="
				+ tmstartdat + ", tmenddat=" + tmenddat + ", tmcredat=" + tmcredat + ", tmdesc=" + tmdesc + ", tmcnt="
				+ tmcnt + ", tmimg=" + tmimg + "]";
	}
	
	
}
