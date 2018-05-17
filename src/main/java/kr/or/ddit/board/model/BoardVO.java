/**
 * 
 */
package kr.or.ddit.board.model;

/**
 * BoardVO.java
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
public class BoardVO {
	private int rn;
	private int bd_bbs_seq;
	private int bd_seq;
	private int level;
	private Integer pbd_seq;
	private String bd_title;
	private String bd_content;
	private String bd_reg_id;
	private String bd_reg_dt;
	private String bd_del_yn;
	private String att_path;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setBd_seq(int bd_seq) {
		this.bd_seq = bd_seq;
	}
	public String getAtt_path() {
		return att_path;
	}
	public void setAtt_path(String att_path) {
		this.att_path = att_path;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getBd_bbs_seq() {
		return bd_bbs_seq;
	}
	public void setBd_bbs_seq(int bd_bbs_seq) {
		this.bd_bbs_seq = bd_bbs_seq;
	}
	public Integer getBd_seq() {
		return bd_seq;
	}
	public void setBd_seq(Integer bd_seq) {
		this.bd_seq = bd_seq;
	}
	public Integer getPbd_seq() {
		return pbd_seq;
	}
	public void setPbd_seq(Integer pbd_seq) {
		this.pbd_seq = pbd_seq;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_content() {
		return bd_content;
	}
	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}
	public String getBd_reg_id() {
		return bd_reg_id;
	}
	public void setBd_reg_id(String bd_reg_id) {
		this.bd_reg_id = bd_reg_id;
	}
	public String getBd_reg_dt() {
		return bd_reg_dt;
	}
	public void setBd_reg_dt(String bd_reg_dt) {
		this.bd_reg_dt = bd_reg_dt;
	}
	public String getBd_del_yn() {
		return bd_del_yn;
	}
	public void setBd_del_yn(String bd_del_yn) {
		this.bd_del_yn = bd_del_yn;
	}
	
	
	
	
}
