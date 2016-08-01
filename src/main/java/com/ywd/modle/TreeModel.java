package com.ywd.modle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ywd.entity.Auth;

public class TreeModel {
	
	private int id;
	private String text;
	private String state;
	private String iconCls;
	private Map<String, String> attributes;
	private List<TreeModel> children;
	
	public TreeModel() {
	}
	
	public TreeModel(int id, String text, String state, String iconCls, Map<String, String> attributes, List<TreeModel> children) {
		this.id = id;
		this.text = text;
		this.state = state;
		this.iconCls = iconCls;
		this.attributes = attributes;
		this.children = children;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public List<TreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}
	
	public void setAuth(Auth auth) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("authPath", auth.getAuthPath());
		setId(auth.getAuthId());
		setText(auth.getAuthName());
		setState(auth.getState());
		setIconCls(auth.getIconCls());
		setAttributes(map);
	}
	
}
