/**
 * 
 */
package kr.or.ddit.attachment.model;

/**
 * AttachmentVO.java
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
public class AttachmentVO {

	private Integer att_num;
	private Integer att_bd_seq;
	private String att_path;
	
	public Integer getAtt_num() {
		return att_num;
	}
	public void setAtt_num(Integer att_num) {
		this.att_num = att_num;
	}
	public Integer getAtt_bd_seq() {
		return att_bd_seq;
	}
	public void setAtt_bd_seq(Integer att_bd_seq) {
		this.att_bd_seq = att_bd_seq;
	}
	public String getAtt_path() {
		return att_path;
	}
	public void setAtt_path(String att_path) {
		this.att_path = att_path;
	}
	
	
	
}
