/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.event;

import java.util.List;

/**
 *
 * @author Thu Phuong
 */
public abstract class HoaDonInteface <EntityType, KeyType> {
    public abstract EntityType selectById(String maHD);
    protected abstract List<EntityType> selectBySql(String sql, Object... args); 
    public abstract List<EntityType> selectAll();
}
