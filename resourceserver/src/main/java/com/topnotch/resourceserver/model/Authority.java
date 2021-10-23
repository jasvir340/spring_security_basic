package com.topnotch.resourceserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    private String name;

    public Authority(Long id, Customer customer, String name) {
        this.id = id;
        this.customer = customer;
        this.name = name;
    }

    public Authority() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority)) return false;
        Authority authority = (Authority) o;
        return Objects.equals(getId(), authority.getId()) && Objects.equals(getCustomer(), authority.getCustomer()) && Objects.equals(getName(), authority.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getName());
    }
}
