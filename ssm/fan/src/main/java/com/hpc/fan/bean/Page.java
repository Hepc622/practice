package com.hpc.fan.bean;

public class Page implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// ǰһҳ
	private Boolean hasPrePage;
	// ��һҳ
	private Boolean hasNextPage;
	// ÿҳ��ʾ������:Ĭ��9��
	private Integer everyPage = 9;
	// ��ҳ��
	private Integer totalPage;
	// ��ʾ��ʼҳ��
	private Integer startPage;
	// ��ʾ����ҳ��
	private Integer endPage;
	// ��ǰ�ڶ���ҳ:Ĭ�ϵ�1ҳ
	private Integer currentPage = 1;
	// ��ʼ�±�
	private Integer beginIndex;
	// �����±�
	private Integer endinIndex;
	// �ܹ�������
	private Integer totalCount;
	// ��������
	private String sortName;
	// ����״̬
	private String sortState;
	// ������Ϣ
	private String sortInfo;
	// �Ƿ�����
	private Boolean sort = false;
	private String defaultInfo = "  ";

	public Integer getStartPage() {
		if (currentPage == null || currentPage == 1) {
			startPage = 1;
		} else {
			startPage = currentPage - 2 >= 1 ? currentPage - 2 : 1;
		}
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		Integer tPage = getTotalPage(totalCount);
		if (currentPage != tPage) {
			endPage = currentPage + 2 <= tPage ? currentPage + 2 : tPage;
		} else {
			endPage = tPage;
		}
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public String getDefaultInfo() {
		return defaultInfo;
	}

	public void setDefaultInfo(String defaultInfo) {
		this.defaultInfo = defaultInfo;
	}

	public String getSortInfo() {
		return sortInfo;
	}

	public void setSortInfo(String sortInfo) {
		this.sortInfo = sortInfo;
	}

	public String getSortName() {
		return sortName;
	}

	public String getSortState() {
		return sortState;
	}

	public void setSortState(String sortState) {
		this.sortState = sortState;
	}

	public Page() {
	}

	/**
	 * ����,���ڼ����ҳ
	 */
	public Page(Integer totalRecords) {
		this.totalCount = totalRecords;
		setTotalPage(getTotalPage(totalRecords));
	}

	/**
	 * ����ÿҳ��ʾ������ʱʹ��
	 */
	public Page(Integer everyPage, Integer totalRecords) {
		this.everyPage = everyPage;
		this.totalCount = totalRecords;
		setTotalPage(getTotalPage(totalRecords));
	}

	/**
	 * @param state
	 *            ״̬��
	 * @param value
	 *            ���ڶ���ҳ��������ÿҳ��ʾ����������Ϊ��������
	 */
	public void pageState(int index, String value) {
		sort = false;
		switch (index) {
		case 0:
			setEveryPage(Integer.parseInt(value));
			break;
		case 1:
			first();
			break;
		case 2:
			previous();
			break;
		case 3:
			next();
			break;
		case 4:
			last();
			break;
		// case 5: sort = true;sort(value);break;
		case 6:// ��ָ���ڶ���ҳ
			setCurrentPage(Integer.parseInt(value));
			break;
		}
	}

	/**
	 * ��ǰһҳ
	 */
	public void first() {
		currentPage = 1;
	}

	public void previous() {
		currentPage--;
	}

	public void next() {
		currentPage++;
	}

	public void last() {
		currentPage = totalPage;
	}

	/**
	 * ������ҳ��
	 */
	private Integer getTotalPage(Integer totalRecords) {
		Integer totalPage = 0;
		everyPage = everyPage == null ? 9 : everyPage;
		if (totalRecords % everyPage == 0)
			totalPage = totalRecords / everyPage;
		else {
			totalPage = totalRecords / everyPage + 1;
		}
		return totalPage;
	}

	public Integer getBeginIndex() {
		this.beginIndex = (currentPage - 1) * everyPage;
		return this.beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getCurrentPage() {
		this.currentPage = currentPage == 0 ? 1 : currentPage;
		return this.currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if (currentPage == null || 0 == currentPage) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public Integer getEveryPage() {
		this.everyPage = everyPage == 0 ? 9 : everyPage;
		return this.everyPage;
	}

	public void setEveryPage(Integer everyPage) {
		this.everyPage = everyPage;
	}

	public Boolean getHasNextPage() {
		this.hasNextPage = (currentPage != totalPage) && (totalPage != 0);
		return this.hasNextPage;
	}

	public void setHasNextPage(Boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Boolean getHasPrePage() {
		this.hasPrePage = currentPage != 1;
		return this.hasPrePage;
	}

	public void setHasPrePage(Boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public Integer getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		if (this.currentPage > totalPage) {
			this.currentPage = totalPage;
		}
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		setTotalPage(getTotalPage(totalCount));
		this.totalCount = totalCount;
	}

	public Boolean isSort() {
		return sort;
	}

	public void setSort(Boolean sort) {
		this.sort = sort;
	}

	public Integer getEndinIndex() {
		this.endinIndex = (currentPage) * everyPage;
		return endinIndex;
	}

	public void setEndinIndex(Integer endinIndex) {
		this.endinIndex = endinIndex;
	}
}