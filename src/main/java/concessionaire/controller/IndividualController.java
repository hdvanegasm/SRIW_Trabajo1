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
                if (resultIndividual.get("?value").isLiteral()) {
                    lista.add(resultIndividual.getResource("?property").toString() + ": \t\t " + resultIndividual.get("?value").toString());
                }

            }
        }

        return lista;
    }

    public ArrayList<String> getRelations(String individualResult) {
        ResultSet resultProperties = null;
        if (individualResult.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario", "owl:ObjectProperty");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individualResult.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "DEFAULT", "owl:ObjectProperty");
            try {
                resultProperties = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individualResult.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "DEFAULT", "owl:ObjectProperty");
            resultProperties = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualRelationsQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf", "rdfs:Property");
            resultProperties = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        ArrayList<String> lista = new ArrayList<String>();

        if (resultProperties != null) {
            while (resultProperties.hasNext()) {
                QuerySolution resultIndividual = resultProperties.nextSolution();
                if (resultIndividual.get("?value").isResource()) {
                    lista.add(resultIndividual.getResource("?property").toString() + ": \t\t " + resultIndividual.get("?value").toString());
                }
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

    public ArrayList<String> getIndirectInstancesFromClass(String entity) {

        ResultSet sameClases = getEquivalentClasses(entity);
        ArrayList<String> individualsFullResult = new ArrayList<>();

        while (sameClases.hasNext()) {
            System.out.println("--------------------------------------------------");

            QuerySolution solution = sameClases.nextSolution();
            String individualResult = solution.get("clase_igual").toString();
            ResultSet resultQuery = null;
            if (individualResult.contains("concesionario.owl")) {
                String query = SparqlQuery.getIndirectIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

            } else if (individualResult.contains("resource/vocab")) {
                String query = SparqlQuery.getIndirectIndividualFromClassQuery(individualResult, "DEFAULT");
                try {
                    resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (individualResult.contains("dbpedia")) {
                String query = SparqlQuery.getIndirectIndividualFromClassQuery(individualResult, "DEFAULT");
                resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
            } else {
                String query = SparqlQuery.getIndirectIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
            }

            if (resultQuery != null) {
                while (resultQuery.hasNext()) {
                    QuerySolution resultIndividual = resultQuery.nextSolution();
                    individualsFullResult.add(resultIndividual.getResource("individual").toString());
                }
            }
        }

        return individualsFullResult;
    }
}
