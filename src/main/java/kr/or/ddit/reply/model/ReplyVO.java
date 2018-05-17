/**
 * 
 */
package kr.or.ddit.reply.model;

/**
 * ReplyVO.java
 *
 * @author "K.BoYeong"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "K.BoYeong" 최초 생성
 *
 * </pre>
 */
public class ReplyVO {
	private Integer rp_seq;
	private Integer rp_bd_seq;
	private String rp_mem_id;
	private String rp_reg_dt;
	private String rp_del_yn;
	private String rp_content;
	
	public Integer getRp_seq() {
		return rp_seq;
	}
	public void setRp_seq(Integer rp_seq) {
		this.rp_seq = rp_seq;
	}
	public Integer getRp_bd_seq() {
		return rp_bd_seq;
	}
	public void setRp_bd_seq(Integer rp_bd_seq) {
		this.rp_bd_seq = rp_bd_seq;
	}
	public String getRp_mem_id() {
		return rp_mem_id;
	}
	public void setRp_mem_id(String rp_mem_id) {
		this.rp_mem_id = rp_mem_id;
	}
	public String getRp_reg_dt() {
		return rp_reg_dt;
	}
	public void setRp_reg_dt(String rp_reg_dt) {
		this.rp_reg_dt = rp_reg_dt;
	}
	public String getRp_del_yn() {
		return rp_del_yn;
	}
	public void setRp_del_yn(String rp_del_yn) {
		this.rp_del_yn = rp_del_yn;
	}
	public String getRp_content() {
		return rp_content;
	}
	public void setRp_content(String rp_content) {
		this.rp_content = rp_content;
	}
	
}
