package json;

public class EmpInfo {
	private Integer empno;
	private String empname;
	private String empjob;
	private String empmgr;
	private String hiredate;
	private Integer sal;
	private String comm;
	private Integer deptno;
	public EmpInfo() {
		
	}
	public EmpInfo(Integer empno, String empname, String empjob, String empmgr, String hiredate, Integer sal,
			String comm, Integer deptno) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empjob = empjob;
		this.empmgr = empmgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpjob() {
		return empjob;
	}
	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}
	public String getEmpmgr() {
		return empmgr;
	}
	public void setEmpmgr(String empmgr) {
		this.empmgr = empmgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpInfo [empno=" + empno + ", empname=" + empname + ", empjob=" + empjob + ", empmgr=" + empmgr
				+ ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
}
