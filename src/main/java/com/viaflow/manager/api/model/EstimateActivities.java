package com.viaflow.manager.api.model;

public class EstimateActivities {

	private String activity;

	private double value;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "EstimateActivities [activity=" + activity + ", value=" + value + "]";
	}
}
