/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram.controller;

import com.andersoncarlosfs.tangram.model.Level;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Carlos Ferreira da Silva
 */
public class PersistenceLevel {

    private final List<Level> levels;

    public PersistenceLevel() {
        levels = new ArrayList();
    }

    /**
     * @return the levels
     */
    public List getLevels() {
        return levels;
    }

}
