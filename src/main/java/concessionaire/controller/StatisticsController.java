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
public class StatisticsController extends GeneralController {

    public int getInstancesWithValueAndType(String property) {
        ResultSet sameProperties = this.getEquivalentProperties(property);
        int conteo = 0;
        while (sameProperties.hasNext()) {
            System.out.println("--------------------------------------------------");

            QuerySolution solution = sameProperties.nextSolution();

            String individualResult = solution.get("propiedad_igual").toString();

            ResultSet resultQuery = null;
            ResultSet resultTypeQuery = null;

            if (individualResult.contains("concesionario.owl")) {

                String typeQuery = SparqlQuery.getTypeAttributeFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
                resultTypeQuery = this.executeQueryToEndPoint(typeQuery, "http://35.224.217.230:8890/sparql");

            } else if (individualResult.contains("resource/vocab")) {
                String typeQuery = SparqlQuery.getTypeAttributeFromClassQuery(individualResult, "DEFAULT");
                try {
                    resultTypeQuery = this.executeQueryToEndPoint(typeQuery, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (individualResult.contains("dbpedia")) {
                String typeQuery = SparqlQuery.getTypeAttributeFromClassQuery(individualResult, "DEFAULT");
                resultTypeQuery = this.executeQueryToEndPoint(typeQuery, "http://dbpedia.org/sparql");
            } else {
                String typeQuery = SparqlQuery.getTypeAttributeFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
                resultTypeQuery = this.executeQueryToEndPoint(typeQuery, "http://35.224.217.230:8890/sparql");
            }
            
            String type = "";
            
            if (resultTypeQuery != null) {
                while (resultTypeQuery.hasNext()) {
                    QuerySolution resultTypeIndividual = resultTypeQuery.nextSolution();
                    System.out.println(resultTypeIndividual.get("?tipo"));
                    
                    if(resultTypeIndividual.get("?tipo").toString().contains("int") || resultTypeIndividual.get("?tipo").toString().contains("double")) {
                        type = "numeric";
                    } else {
                        type = "noNumeric";
                    }
                }
            }

            // --------------------------------------------------------------------
            if (individualResult.contains("concesionario.owl")) {
                String query = SparqlQuery.countInstancesWithValue(individualResult, "http://35.224.217.230:8890/ontologies/concesionario", type);
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

            } else if (individualResult.contains("resource/vocab")) {
                String query = SparqlQuery.countInstancesWithValue(individualResult, "DEFAULT", type);

                try {
                    resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");

                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (individualResult.contains("dbpedia")) {
                String query = SparqlQuery.countInstancesWithValue(individualResult, "DEFAULT", type);
                resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
            } else {
                String query = SparqlQuery.countInstancesWithValue(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf", type);
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

            }

            if (resultQuery != null) {
                while (resultQuery.hasNext()) {
                    QuerySolution resultIndividual = resultQuery.nextSolution();
                    System.out.println(resultIndividual.get("?noExiste"));
                    System.out.println(resultIndividual.get("?cantidad").asLiteral().getInt());
                    conteo += resultIndividual.get("?cantidad").asLiteral().getInt();
                }
            }

        }

        return conteo;
    }

    public void getStatisticsFromClassAttribute(String entity, String attribute) {

    }

    public void getStatisticsNumericFilter(String entity, String attribute, int lowValue, int highValue) {

    }

    public void getStatisticsStringFilter(String entity, String attribute, String pattern) {

    }

}
