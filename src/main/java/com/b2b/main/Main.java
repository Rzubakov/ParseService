/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b2b.main;

import com.b2b.services.ParsingService;

/**
 *
 * @author rzubakov
 */
public class Main {

    public static void main(String... args) throws InterruptedException {
        new ParsingService();
        Thread.sleep(60000);
    }
}
