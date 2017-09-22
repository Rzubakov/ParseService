/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2b.entytis;

/**
 *
 * @author rzubakov
 */
public class User {
    public User(){
    }
    
    private long id;
    private String email;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return this.id + " "+ this.email;
    }
}
