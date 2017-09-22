/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2b.services;

import com.b2b.entytis.Item;
import com.b2b.entytis.User;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rzubakov
 */
public class ParsingService{

    private Client client;

    public ParsingService() {
        client = ClientBuilder.newClient();
        run();
    }


    public void run() {
        System.out.println("Start Parsing Service " + new Date());
        System.out.println(login("robot@bot","x-qlu5ive"));
        getUsers("Y").forEach(user -> {
            getItems(user.getId()).forEach(item -> {
                System.out.println(item.getName());
            });
        });

        System.out.println("End Parsing Service " + new Date());
    }

    
    private List<User> getUsers(String active) {
        System.out.println("Read users");
        return client.target("http://zubakov-studio.ru/api/rs/getusers").queryParam("active", active).request().accept(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<User>>() {
        });
    }

    private List<Item> getItems(Long id) {
        System.out.println("Read items");
        return client.target("http://zubakov-studio.ru/api/rs/getallitem").queryParam("userid", id).request().accept(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<Item>>() {
        });
    }
    private String login(String login, String password){
        Form form = new Form();
        form.param("login", login);
        form.param("password", password);
        return client.target("http://zubakov-studio.ru/api/rs/login").request().post(Entity.form(form), String.class);
    }
}
