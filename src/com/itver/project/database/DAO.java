/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itver.project.database;

/**
 *
 * @author PONKCHO
 */
import java.util.List;

public interface DAO <T, K>{
    
    boolean insert(T u);
    void update(T u);
    void delete(T u);
    T get(String s1, String s2);
    List<T> getAll();
}
