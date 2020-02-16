/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaire.controller;

/**
 *
 * @author user
 */
public class SparqlQuery {

    public static String getCarsQuery(String entity, String graph) {
        if (graph.equals("DEFAULT")) {
            return "SELECT ?car\n"
                + "WHERE {\n"
                + "	?car a <" + entity + "> .\n"
                + "}";
        } else {
            return "SELECT ?car\n"
                + "FROM <"+ graph +">\n"
                + "WHERE {\n"
                + "	?car a <" + entity + ">.\n"
                + "}";
        }
    }
}
