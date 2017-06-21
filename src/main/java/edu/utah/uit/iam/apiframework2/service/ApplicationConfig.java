/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utah.uit.iam.apiframework2.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author andrewschneider
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(edu.utah.uit.iam.apiframework2.example.Hello.class);
        resources.add(edu.utah.uit.iam.apiframework2.service.ReservesFacadeREST.class);
        resources.add(edu.utah.uit.iam.apiframework2.service.StartersFacadeREST.class);
        resources.add(edu.utah.uit.iam.apiframework2.service.SubsFacadeREST.class);
        resources.add(edu.utah.uit.iam.apiframework2.service.TeamsFacadeREST.class);
    }
    
}
