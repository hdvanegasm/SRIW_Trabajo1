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

    public static String getIndividualAttributesQuery(String individual, String graph, String propertyType) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a " + propertyType + ". \n"
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
                    + "    ?property a " + propertyType + ". \n"
                    + "}";
        }
    }

    public static String getIndividualRelationsQuery(String individual, String graph, String propertyType) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?property ?value \n"
                    + "WHERE {\n"
                    + "<" + individual + "> ?property ?value.\n"
                    + "    ?property a " + propertyType + ". \n"
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
                    + "    ?property a " + propertyType + ". \n"
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

    public static String getIndirectIndividualFromClassQuery(String entity, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?individual\n"
                    + "WHERE {\n"
                    + "	?individual a ?clase_hija .\n"
                    + "	?clase_hija rdfs:subClassOf <" + entity + "> \n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?individual\n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "	?individual a ?clase_hija .\n"
                    + "	?clase_hija rdfs:subClassOf <" + entity + "> \n"
                    + "}";
        }
    }

    public static String getAttributesFromClassQuery(String entity, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?atributo \n"
                    + "WHERE {\n"
                    + "?atributo rdfs:domain <" + entity + "> \n"
                    + "{?atributo rdfs:range xsd:integer} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:double} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:int} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:string} \n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?atributo \n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "?atributo rdfs:domain <" + entity + "> \n"
                    + "{?atributo rdfs:range xsd:integer} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:double} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:int} \n"
                    + "UNION \n"
                    + "{?atributo rdfs:range xsd:string} \n"
                    + "}";
        }
    }

    public static String getTypeAttributeFromClassQuery(String attribute, String graph) {
        if (graph.equals("DEFAULT")) {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?tipo \n"
                    + "WHERE {\n"
                    + "<" + attribute + "> rdfs:range ?tipo . \n"
                    + "}";
        } else {
            return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                    + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                    + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                    + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                    + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                    + "SELECT ?tipo \n"
                    + "FROM <" + graph + ">\n"
                    + "WHERE {\n"
                    + "<" + attribute + "> rdfs:range ?tipo . \n"
                    + "}";
        }
    }

    public static String countInstancesWithValue(String property, String graph, String type) {
        if (graph.equals("DEFAULT")) {
            if (type.equals("numeric")) {
                return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                        + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                        + "SELECT (COUNT(?individual) AS ?cantidad) (MIN(?value) as ?minimo) (MAX(?value) as ?maximo) (AVG(?value) as ?promedio) \n"
                        + "WHERE {\n"
                        + "	?individual <" + property + "> ?value .\n"
                        + "}";
            } else {
                return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                        + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                        + "SELECT (COUNT(?individual) AS ?cantidad)\n"
                        + "WHERE {\n"
                        + "	?individual <" + property + "> ?value .\n"
                        + "}";
            }
        } else {
            if (type.equals("numeric")) {
                return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                        + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                        + "SELECT (COUNT(?individual) AS ?cantidad) (MIN(?value) as ?minimo) (MAX(?value) as ?maximo) (AVG(?value) as ?promedio) \n"
                        + "FROM <" + graph + ">\n"
                        + "WHERE {\n"
                        + "	?individual <" + property + "> ?value .\n"
                        + "}";
            } else {
                return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                        + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                        + "SELECT (COUNT(?individual) AS ?cantidad) \n"
                        + "FROM <" + graph + ">\n"
                        + "WHERE {\n"
                        + "	?individual <" + property + "> ?value .\n"
                        + "}";
            }
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
