/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaire.controller;

import java.util.ArrayList;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

/**
 *
 * @author user
 */
public class AttributeController extends GeneralController {       
    public ArrayList<String> getAttributes(String individualResult) {
        ResultSet resultProperties = null;
        if (individualResult.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario", "owl:DatatypeProperty");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individualResult.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "DEFAULT", "owl:DatatypeProperty");
            try {
                resultProperties = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individualResult.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "DEFAULT", "owl:DatatypeProperty");
            resultProperties = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf", "rdfs:Property");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        ArrayList<String> lista = new ArrayList<String>();

        if (resultProperties != null) {
            while (resultProperties.hasNext()) {
                QuerySolution resultIndividual = resultProperties.nextSolution();
                lista.add(
                    resultIndividual.get("?property").toString() + ":[" + resultIndividual.get("?value").toString() + "]"
                );
            }
        }

        return lista;
    }
    
    public ArrayList<String> getSimilarIndividuals(String propertyURI, String value, String classType) {
        ResultSet sameClases = getEquivalentClasses(classType);
        ArrayList<String> individuals = new ArrayList<>();
        
        while (sameClases.hasNext()) {
            QuerySolution solution = sameClases.nextSolution();
            String sameclass = solution.get("clase_igual").toString();
            ResultSet resultQuery = null;
            
            if (sameclass.contains("concesionario.owl")) {
                String query = SparqlQuery.getIndividualWithSameValueQuery(propertyURI, value,  sameclass, "http://35.224.217.230:8890/ontologies/concesionario");
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
                
            } else if (sameclass.contains("resource/vocab")) {
                String query = SparqlQuery.getIndividualWithSameValueQuery(propertyURI, value,  sameclass, "DEFAULT");
                try {
                    resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (sameclass.contains("dbpedia")) {
                String query = SparqlQuery.getIndividualWithSameValueQuery(propertyURI, value,  sameclass, "DEFAULT");
                resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
            } else {
                String query = SparqlQuery.getIndividualWithSameValueQuery(propertyURI, value,  sameclass, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
            }

            if (resultQuery != null) {
               while(resultQuery.hasNext()) {
                   QuerySolution resultIndividual = resultQuery.nextSolution();
                   individuals.add(resultIndividual.getResource("?individual").toString());
               }
            }            
        }
        
        return individuals;
    }
}
