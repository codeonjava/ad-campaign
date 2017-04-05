package com.simple.web.model;

import java.util.Calendar;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Domain model to hold the ad campaign
 * 
 * @author puru
 *
 */

public class AdCampaign {

	private String partnerId;
	private int duration;
	private String adDisplayContents;

	private Calendar time;

	private boolean isExpired;

	public AdCampaign() {
		this.time = Calendar.getInstance();
	}

	public AdCampaign(String partnerId, int duration, String adDisplayContents) {
		this.partnerId = partnerId;
		this.duration = duration;
		this.adDisplayContents = adDisplayContents;

		this.time = Calendar.getInstance();
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAdDisplayContents() {
		return adDisplayContents;
	}

	public void setAdDisplayContents(String adDisplayContents) {
		this.adDisplayContents = adDisplayContents;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.partnerId).append(this.duration).append(this.adDisplayContents)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AdCampaign == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final AdCampaign otherObject = (AdCampaign) obj;

		return new EqualsBuilder().append(this.partnerId, otherObject.partnerId)
				.append(this.duration, otherObject.duration)
				.append(this.adDisplayContents, otherObject.adDisplayContents).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Partner ID", this.partnerId).append("Duration", this.duration)
				.append("Ad Content", this.adDisplayContents).toString();
	}

}
