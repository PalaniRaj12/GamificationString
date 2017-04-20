package com.T14GString.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

 
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name = "SolutionDB")
public class CompilationForm {
	@Column
	private String code=new String();
	@Column
	private String stdout=new String("");
	@Column
	private String stderr=new String("");
	@Id
	private String questionId;
	@Column
	private int percentage;
	@Transient
	private boolean checkbox;
	@Transient
	private CommonsMultipartFile file;
	@Column
	private String tc1Routput=new String("");
	@Column
	private String tc2Routput=new String("");
	@Column
	private String tc3Routput=new String("");
	@Column
	private String tc4Routput=new String("");
	@Column
	private String tc5Routput=new String("");
	@Column
	private String tc1Rerr=new String("");
	@Column
	private String tc2Rerr=new String("");
	@Column
	private String tc3Rerr=new String("");
	@Column
	private String tc4Rerr=new String("");
	@Column
	private String tc5Rerr=new String("");
	
	public String getTc1Rerr() {
		return tc1Rerr;
	}
	public void setTc1Rerr(String tc1Rerr) {
		this.tc1Rerr = tc1Rerr;
	}
	public String getTc2Rerr() {
		return tc2Rerr;
	}
	public void setTc2Rerr(String tc2Rerr) {
		this.tc2Rerr = tc2Rerr;
	}
	public String getTc3Rerr() {
		return tc3Rerr;
	}
	public void setTc3Rerr(String tc3Rerr) {
		this.tc3Rerr = tc3Rerr;
	}
	public String getTc4Rerr() {
		return tc4Rerr;
	}
	public void setTc4Rerr(String tc4Rerr) {
		this.tc4Rerr = tc4Rerr;
	}
	public String getTc5Rerr() {
		return tc5Rerr;
	}
	public void setTc5Rerr(String tc5Rerr) {
		this.tc5Rerr = tc5Rerr;
	}
	public String getTc1Routput() {
		return tc1Routput;
	}
	public void setTc1Routput(String tc1Routput) {
		this.tc1Routput = tc1Routput;
	}
	public String getTc2Routput() {
		return tc2Routput;
	}
	public void setTc2Routput(String tc2Routput) {
		this.tc2Routput = tc2Routput;
	}
	public String getTc3Routput() {
		return tc3Routput;
	}
	public void setTc3Routput(String tc3Routput) {
		this.tc3Routput = tc3Routput;
	}
	public String getTc4Routput() {
		return tc4Routput;
	}
	public void setTc4Routput(String tc4Routput) {
		this.tc4Routput = tc4Routput;
	}
	public String getTc5Routput() {
		return tc5Routput;
	}
	public void setTc5Routput(String tc5Routput) {
		this.tc5Routput = tc5Routput;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public String getStdout() {
		return stdout;
	}
	public void setStdout(String stdout) {
		this.stdout = stdout;
	}
	public String getStderr() {
		return stderr;
	}
	public void setStderr(String stderr) {
		this.stderr = stderr;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	
	
	
	
	
	
}
