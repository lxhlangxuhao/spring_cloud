package com.lang.xu.hao.eurekaserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:59 2019/1/19
 */
@ApiModel(value = "我的USER2222")
public class UserMyResponse implements Serializable{

	@ApiModelProperty(value = "姓名",required = true,notes = "sdasdasdasdasdasdasd")
	private String name;

	@ApiModelProperty(value = "部门",required = true)
	private String department;

	@ApiModelProperty(value = "分数", dataType = "Double")
	private Double score;

	public UserMyResponse(String name, String department, Double score) {
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
