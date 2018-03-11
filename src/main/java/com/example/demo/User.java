package com.example.demo;

import java.io.Serializable;

/**
 * @author 会飞的狼 on 2017/12/16.
 */
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4918499030158628627L;
	
	private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
