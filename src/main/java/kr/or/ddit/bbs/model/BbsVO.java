/**
 * 
 */
package kr.or.ddit.bbs.model;

/**
 * BbsVO.java
 *
 * @author "K.BoYeong"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "K.BoYeong" 최초 생성
 *
 * </pre>
 */
public class BbsVO {
	private int rownum;
	private Integer bbs_seq;
	private String bbs_name;
	private String bbs_mem_id;
	private String bbs_dt;
	private String bbs_yn;
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public Integer getBbs_seq() {
		return bbs_seq;
	}
	public void setBbs_seq(Integer bbs_seq) {
		this.bbs_seq = bbs_seq;
	}
	public String getBbs_name() {
		return bbs_name;
	}
	public void setBbs_name(String bbs_name) {
		this.bbs_name = bbs_name;
	}
	public String getBbs_mem_id() {
		return bbs_mem_id;
	}
	public void setBbs_mem_id(String bbs_mem_id) {
		this.bbs_mem_id = bbs_mem_id;
	}
	public String getBbs_dt() {
		return bbs_dt;
	}
	public void setBbs_dt(String bbs_dt) {
		this.bbs_dt = bbs_dt;
	}
	public String getBbs_yn() {
		return bbs_yn;
	}
	public void setBbs_yn(String bbs_yn) {
		this.bbs_yn = bbs_yn;
	}
	
	
	
	
}
