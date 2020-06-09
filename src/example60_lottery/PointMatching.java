package example60_lottery;

public class PointMatching {

	private Long id;

	// 獲得點數
	private Long singleAmount;

	// 總份數
	private Integer share;

	// 被抽走的份數
	private Integer share_given;

	// 剩餘份數
	private Integer share_over;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSingleAmount() {
		return singleAmount;
	}

	public void setSingleAmount(Long singleAmount) {
		this.singleAmount = singleAmount;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public Integer getShare_given() {
		return share_given;
	}

	public void setShare_given(Integer share_given) {
		this.share_given = share_given;
	}

	public Integer getShare_over() {
		return share_over;
	}

	public void setShare_over(Integer share_over) {
		this.share_over = share_over;
	}

}
