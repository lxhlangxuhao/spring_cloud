package com.lang.xu.hao.eurekaserver.entity;

import java.io.Serializable;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:59 2019/1/19
 */
public class UserMy implements Serializable{

	private String name;

	private String department;

	private Double score;

	public UserMy(String name, String department, Double score) {
		this.name = name;
		this.department = department;
		this.score = score;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "UserMy{" +
				"name='" + name + '\'' +
				", department='" + department + '\'' +
				", score=" + score +
				'}';
	}
}
