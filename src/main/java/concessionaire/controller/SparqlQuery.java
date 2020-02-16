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

    public static String getIndividualFromClassQuery(String entity, String graph) {
        if (graph.equals("DEFAULT")) {
            return "SELECT ?individual\n"
                    + "WHERE {\n"
                    + "	?individual a <" + entity + "> .\n"
                    + "}";
        } else {
            return "SELECT ?individual\n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "	?individual a <" + entity + ">.\n"
                    + "}";
        }
    }

    public static String getIndividualAttributesQuery(String individual, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a owl:DatatypeProperty. \n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a owl:DatatypeProperty. \n"
                    + "}";
        }
    }
    
    
    public static String getIndividualRelationsQuery(String individual, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a owl:ObjectProperty. \n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a owl:ObjectProperty. \n"
                    + "}";
        }
    }
    
    
    public static String getIndividualEquivalencesQuery(String individual, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?otro_individual \n"
                    + "WHERE {\n"
                    + "<" + individual + "> owl:sameAs ?otro_individual.\n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?otro_individual \n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "{ <" + individual + "> owl:sameAs ?otro_individual. }\n"
                    + "UNION { ?otro_individual owl:sameAs " + "<" + individual + ">. }\n"
                    + "}";
        }
    }
    
     public static String getIndividualWithSameValueQuery(String propertyURI, String value, String entity, String graph) {
         if (graph.equals("DEFAULT")) {
            return "SELECT ?individual\n"
                    + "WHERE {\n"
                    + "	?individual a <" + entity + "> .\n"
                    + "	?individual <" + propertyURI + "> ?value.\n"
                    + "	FILTER REGEX( str(?value), '" + value + "') .\n"
                    + "}";
        } else {
            return "SELECT ?individual\n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "	?individual a <" + entity + "> .\n"
                    + "	?individual <" + propertyURI + "> ?value.\n"
                    + "	FILTER REGEX( str(?value), '" + value + "') .\n"
                    + "}";
        }
    }
}
