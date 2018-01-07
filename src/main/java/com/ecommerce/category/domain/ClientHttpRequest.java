package com.ecommerce.category.domain;

public class ClientHttpRequest {


	private String cmd;
	private String idt;
	private String id;
	private String cmt;
	private String tid;
	private Integer tzo;
	private Double ver;
	public String getCmd() {
		return cmd;
	}
	@Override
	public String toString() {
		return "ClientHttpRequest [cmd=" + cmd + ", idt=" + idt + ", id=" + id + ", cmt=" + cmt + ", tid=" + tid
				+ ", tzo=" + tzo + ", ver=" + ver + ", pfx=" + pfx + ", fid=" + fid + "]";
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public ClientHttpRequest(String cmd, String idt, String id, String cmt, String tid, Integer tzo, Double ver) {
		super();
		this.cmd = cmd;
		this.idt = idt;
		this.id = id;
		this.cmt = cmt;
		this.tid = tid;
		this.tzo = tzo;
		this.ver = ver;
	}
	public String getIdt() {
		return idt;
	}
	public void setIdt(String idt) {
		this.idt = idt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public Integer getTzo() {
		return tzo;
	}
	public void setTzo(Integer tzo) {
		this.tzo = tzo;
	}
	public Double getVer() {
		return ver;
	}
	public void setVer(Double ver) {
		this.ver = ver;
	}
	public String getPfx() {
		return pfx;
	}
	public void setPfx(String pfx) {
		this.pfx = pfx;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	private String pfx;
	private String fid;

	

}
