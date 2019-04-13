package com.viaflow.manager.api.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class EntryType<T, V> {

	@DBRef
	private T component;
	
	@DBRef
	private V typePermission;
	public T getComponent() {
		return component;
	}
	public void setComponent(T component) {
		this.component = component;
	}
	public V getTypePermission() {
		return typePermission;
	}
	public void setTypePermission(V typePermission) {
		this.typePermission = typePermission;
	}
	@Override
	public String toString() {
		return "EntryType [component=" + component + ", typePermission=" + typePermission + "]";
	}
}
