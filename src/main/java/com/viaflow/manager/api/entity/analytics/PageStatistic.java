package com.viaflow.manager.api.entity.analytics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

public class PageStatistic extends DTOBase {
	
	@Id
	private String pageStatisticId;
	
	private String pageName;
	
	private String pageLink;
	
	private String pageIcon;
	
	@DBRef
	private User user;

	public String getPageStatisticId() {
		return pageStatisticId;
	}

	public void setPageStatisticId(String pageStatisticId) {
		this.pageStatisticId = pageStatisticId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public String getPageIcon() {
		return pageIcon;
	}

	public void setPageIcon(String pageIcon) {
		this.pageIcon = pageIcon;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
