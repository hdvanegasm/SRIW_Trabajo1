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
public class IndividualController extends GeneralController {
    
    public ArrayList<String> getProperties(String individualResult) {
        ResultSet resultProperties = null;
        if (individualResult.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individualResult.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "DEFAULT");
            try {
                resultProperties = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individualResult.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "DEFAULT");
            resultProperties = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualAttributesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        ArrayList<String> lista = new ArrayList<String>();

        if (resultProperties != null) {
            while (resultProperties.hasNext()) {
                QuerySolution resultIndividual = resultProperties.nextSolution();
                lista.add(resultIndividual.getResource("?property").toString() + ": \t\t " + resultIndividual.getLiteral("?value").getString());
               
            }
        }
        
        return lista;
    }
    
    
    
    public ArrayList<String> getRelations(String individualResult) {
        ResultSet resultProperties = null;
        if (individualResult.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individualResult.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "DEFAULT");
            try {
                resultProperties = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individualResult.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "DEFAULT");
            resultProperties = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        ArrayList<String> lista = new ArrayList<String>();

        if (resultProperties != null) {
            while (resultProperties.hasNext()) {
                QuerySolution resultIndividual = resultProperties.nextSolution();
                lista.add(resultIndividual.getResource("?property").toString() + ": \t\t " + resultIndividual.getResource("?value").toString());
               
            }
        }
        
        return lista;
    }
    
    
    public ArrayList<String> getEquivalentIndividuals(String individualResult) {
        ResultSet resultProperties = null;
        if (individualResult.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualEquivalencesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individualResult.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualEquivalencesQuery(individualResult, "DEFAULT");
            try {
                resultProperties = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individualResult.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualEquivalencesQuery(individualResult, "DEFAULT");
            resultProperties = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualEquivalencesQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        ArrayList<String> lista = new ArrayList<>();

        if (resultProperties != null) {
            while (resultProperties.hasNext()) {
                QuerySolution resultIndividual = resultProperties.nextSolution();
                lista.add(resultIndividual.getResource("?otro_individual").toString());
               
            }
        }
        
        return lista;
    }
}
