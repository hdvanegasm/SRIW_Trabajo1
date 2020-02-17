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

    public String getInstancesStatistics(String property, boolean applyFilter, String numericFilter, String stringFilter) {
        ResultSet sameProperties = this.getEquivalentProperties(property);

        int conteo = 0;
        double minimo = Double.POSITIVE_INFINITY;
        double maximo = Double.NEGATIVE_INFINITY;
        double promedio = 0;
        double sumatoria = 0;

        String result = "";

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

                    if (resultTypeIndividual.get("?tipo").toString().contains("int") || resultTypeIndividual.get("?tipo").toString().contains("double")) {
                        type = "numeric";
                    } else {
                        type = "noNumeric";
                    }
                }
            }

            // --------------------------------------------------------------------
            if (applyFilter) {              
                
                if (individualResult.contains("concesionario.owl")) {
                    String query = SparqlQuery.instanceFilterStatisticsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario", type, numericFilter, stringFilter);
                    resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

                } else if (individualResult.contains("resource/vocab")) {
                    String query = SparqlQuery.instanceFilterStatisticsQuery(individualResult, "DEFAULT", type, numericFilter, stringFilter);

                    try {
                        resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");

                    } catch (Exception ex) {
                        System.out.println("Error de conexion con servidor D2R");
                    }
                } else if (individualResult.contains("dbpedia")) {
                    String query = SparqlQuery.instanceFilterStatisticsQuery(individualResult, "DEFAULT", type, numericFilter, stringFilter);
                    resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
                } else {
                    String query = SparqlQuery.instanceFilterStatisticsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf", type, numericFilter, stringFilter);
                    resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
                }
            } else {
                if (individualResult.contains("concesionario.owl")) {

                    String query = SparqlQuery.instanceStatisticsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario", type);
                    resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

                } else if (individualResult.contains("resource/vocab")) {
                    String query = SparqlQuery.instanceStatisticsQuery(individualResult, "DEFAULT", type);
                    try {
                        resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");

                    } catch (Exception ex) {
                        System.out.println("Error de conexion con servidor D2R");
                    }
                } else if (individualResult.contains("dbpedia")) {
                    String query = SparqlQuery.instanceStatisticsQuery(individualResult, "DEFAULT", type);
                    resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
                } else {
                    String query = SparqlQuery.instanceStatisticsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf", type);
                    resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
                }
            }

            if (resultQuery != null) {
                if (type.equals("numeric")) {
                    while (resultQuery.hasNext()) {
                        QuerySolution resultIndividual = resultQuery.nextSolution();
                        conteo += resultIndividual.get("?cantidad").asLiteral().getInt();

                        if (resultIndividual.get("?minimo") != null && resultIndividual.get("?minimo").asLiteral().getDouble() < minimo) {
                            minimo = resultIndividual.get("?minimo").asLiteral().getDouble();
                        }

                        if (resultIndividual.get("?maximo") != null && resultIndividual.get("?maximo").asLiteral().getDouble() > maximo) {
                            maximo = resultIndividual.get("?maximo").asLiteral().getDouble();
                        }

                        if (resultIndividual.get("?promedio") != null) {
                            sumatoria += resultIndividual.get("?promedio").asLiteral().getDouble() * resultIndividual.get("?cantidad").asLiteral().getInt();
                        }

                    }

                    promedio = sumatoria / conteo;

                    result = "MEAN: \t" + promedio + "\n"
                            + "MIN: \t" + minimo + "\n"
                            + "MAX: \t" + maximo + "\n"
                            + "COUNT: \t" + conteo + "\n";
                } else {
                    while (resultQuery.hasNext()) {
                        QuerySolution resultIndividual = resultQuery.nextSolution();
                        conteo += resultIndividual.get("?cantidad").asLiteral().getInt();

                        if (resultIndividual.get("?promedio_longitud") != null) {
                            sumatoria += resultIndividual.get("?promedio_longitud").asLiteral().getDouble() * resultIndividual.get("?cantidad").asLiteral().getInt();
                        }

                    }

                    result = "MEAN STRING LENGTH: \t" + (sumatoria / conteo) + "\n"
                            + "COUNT: \t" + conteo + "\n";;

                }
            }

        }

        return result;
    }

    public void getStatisticsFromClassAttribute(String entity, String attribute) {

    }

    public void getStatisticsNumericFilter(String entity, String attribute, int lowValue, int highValue) {

    }

    public void getStatisticsStringFilter(String entity, String attribute, String pattern) {

    }

}
