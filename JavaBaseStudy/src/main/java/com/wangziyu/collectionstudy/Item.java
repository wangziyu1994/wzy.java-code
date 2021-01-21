package com.wangziyu.collectionstudy;

import java.util.Objects;

public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }


    public boolean equals(Object otherObject){
        if(this==otherObject) return true;
        if(otherObject==null) return false;
        if(this.getClass()!=otherObject.getClass()) return  false;
        Item other=(Item)otherObject;
        return Objects.equals(description,((Item) otherObject).description)&&partNumber==((Item) otherObject).partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }


    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff!= 0 ? diff:description.compareTo(other.description);
    }


}
