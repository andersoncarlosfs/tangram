/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andersoncarlosfs.tangram;

import java.util.List;
import javax.enterprise.event.Observes;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 *
 * @author AndersonCarlos
 */
public class Main {

    /**
     *
     * @param event
     * @param parameters
     */
    public final void main(@Observes ContainerInitialized event, @Parameters List<String> parameters) {
        System.out.println("Hello " + parameters.size());
    }

}
