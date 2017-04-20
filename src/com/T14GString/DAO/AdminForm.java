package com.T14GString.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
@Table(name = "QuestionDB")
public class AdminForm {
	
	@Column
	@NotEmpty
	private String question;
	@NotEmpty
	@Column
	private String resultantString;
	@NotEmpty
	@Column
	private String inputString;
	@Column
	private String condition;
	@Id
	private int questionId;
	@Column
	private String tc1input;
	@Column
	private String tc1output;
	@Column
	private String tc2input;
	@Column
	private String tc2output;
	@Column
	private String tc3input;
	@Column
	private String tc3output;
	@Column
	private String tc4input;
	@Column
	private String tc4output;
	@Column
	private String tc5input;
	@Column
	private String tc5output;
	
	
	public String getTc1input() {
		return tc1input;
	}
	public void setTc1input(String tc1input) {
		this.tc1input = tc1input;
	}
	public String getTc1output() {
		return tc1output;
	}
	public void setTc1output(String tc1output) {
		this.tc1output = tc1output;
	}
	public String getTc2input() {
		return tc2input;
	}
	public void setTc2input(String tc2input) {
		this.tc2input = tc2input;
	}
	public String getTc2output() {
		return tc2output;
	}
	public void setTc2output(String tc2output) {
		this.tc2output = tc2output;
	}
	public String getTc3input() {
		return tc3input;
	}
	public void setTc3input(String tc3input) {
		this.tc3input = tc3input;
	}
	public String getTc3output() {
		return tc3output;
	}
	public void setTc3output(String tc3output) {
		this.tc3output = tc3output;
	}
	public String getTc4input() {
		return tc4input;
	}
	public void setTc4input(String tc4input) {
		this.tc4input = tc4input;
	}
	public String getTc4output() {
		return tc4output;
	}
	public void setTc4output(String tc4output) {
		this.tc4output = tc4output;
	}
	public String getTc5input() {
		return tc5input;
	}
	public void setTc5input(String tc5input) {
		this.tc5input = tc5input;
	}
	public String getTc5output() {
		return tc5output;
	}
	public void setTc5output(String tc5output) {
		this.tc5output = tc5output;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResultantString() {
		return resultantString;
	}
	public void setResultantString(String resultantString) {
		this.resultantString = resultantString;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getQuestionId() {
		return questionId;
	}
	public String getInputString() {
		return inputString;
	}
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	
	
}
