package com.ecommerce.tests.menu;

public class ClientHttpRequest {

	@Override
	public String toString() {
		return "ClientHttpRequest [cmd=" + cmd + ", id=" + id + ", cmt=" + cmt + ", tid=" + tid + ", tzo=" + tzo
				+ ", ver=" + ver + "]";
	}
	private String cmd;
	private String id;
	private String cmt;
	private String tid;
	private Integer tzo;
	private Double ver;
	private String pfx;
	private String fid;

	
	public String getPfx() {
		return pfx;
	}
	public void setPfx(String pfx) {
		this.pfx = pfx;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String string) {
		this.fid = string;
	}
	public ClientHttpRequest(String cmd, String id, String cmt, String tid, Integer tzo, Double ver) {
		super();
		this.cmd = cmd;
		this.id = id;
		this.cmt = cmt;
		this.tid = tid;
		this.tzo = tzo;
		this.ver = ver;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
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

}
