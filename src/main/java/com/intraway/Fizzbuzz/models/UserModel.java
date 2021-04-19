package com.intraway.fizzbuzz.models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;
import java.time.*;
import java.time.format.*; 

@Entity
@Table(name = "fizzbuzz")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)

	private long id;
	private long code;
	private LocalDateTime datetime;
	private Integer min;
	private Integer max;
	private String description;
	private String list;

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}

	public void setCode(Long code){
		this.code = code;
	}
	public Long getCode(){
		return code;
	}
    public void setDatetime(LocalDateTime datetime) {
    	this.datetime = datetime;
    }
    
    public LocalDateTime getDatetime() {
    	return this.datetime;
    }
	public void setMin(Integer min){
		this.min = min;
	}
	public Integer getMin(){
		return min;
	}
	public void setMax(Integer max){
		this.max = max;
	}
	public Integer getMax(){
		return max;
	}	
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setList(String list){
		this.list = list;
	}
	public String getList(){
		return list;
	}
}