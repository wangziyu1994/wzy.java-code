package com.wangziyu.mybatis.cache;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    private String hobbitName;

    private Hobbit hobbit;

    public Hobbit getHobbit() {
        return hobbit;
    }

    public void setHobbit(Hobbit hobbit) {
        this.hobbit = hobbit;
    }

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Integer id, String name, Integer age, Hobbit hobbit) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbit = hobbit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getHobbitName() {
        return hobbitName;
    }

    public void setHobbitName(String hobbitName) {
        this.hobbitName = hobbitName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbitName='" + hobbitName + '\'' +
                ", hobbit=" + hobbit +
                '}';
    }
}
