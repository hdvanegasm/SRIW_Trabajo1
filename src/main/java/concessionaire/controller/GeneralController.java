/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaire.controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.reasoner.ReasonerRegistry;

/**
 *
 * @author Admin
 */
public class GeneralController {

    public ResultSet executeQueryToIntegration(String queryString) {
        Model model = ModelFactory.createDefaultModel();
        model.read("https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/integration_ontology.owl", "RDF/XML");
        InfModel inferenceModel = ModelFactory.createInfModel(ReasonerRegistry.getOWLReasoner(), model);

        RDFWriter writer = model.getWriter();
        String querys;

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, inferenceModel);

        ResultSet results = qexec.execSelect();
        return results;
    }

    public ResultSet executeQueryToEndPoint(String queryString, String endpoint) {
        Query query = QueryFactory.create(queryString);
        QueryExecution queryExec = QueryExecutionFactory.sparqlService(endpoint, query);

        ResultSet resultSet = queryExec.execSelect();
        return resultSet;
    }

    public ArrayList getClasses() {
        String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                + "SELECT DISTINCT ?clase \n"
                + "WHERE {\n"
                + "	?clase rdf:type owl:Class .\n"
                + "	?clase owl:equivalentClass ?otra_clase .\n"
                + "	FILTER(?clase != ?otra_clase)\n"
                + "}";

        ResultSet allClasses = this.executeQueryToIntegration(query);

        ArrayList<String> list = new ArrayList<String>();
        while (allClasses.hasNext()) {
            QuerySolution soln = allClasses.nextSolution();
            list.add(soln.getResource("?clase").toString());
        }
        return list;
    }

    public ResultSet getEquivalentClasses(String uriClass) {
        String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                + "SELECT DISTINCT ?clase_igual \n"
                + "WHERE {\n"
                + "	<" + uriClass + "> owl:equivalentClass ?clase_igual .\n"
                + "}";

        return this.executeQueryToIntegration(query);
    }

    public ArrayList<String> getAttributesFromClass(String entity) {
        ArrayList<String> attributes = new ArrayList<>();
        ResultSet resultQuery = null;
        if (entity.contains("concesionario.owl")) {
            String query = SparqlQuery.getAttributesFromClassQuery(entity, "http://35.224.217.230:8890/ontologies/concesionario");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (entity.contains("resource/vocab")) {
            String query = SparqlQuery.getAttributesFromClassQuery(entity, "DEFAULT");
            try {
                resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (entity.contains("dbpedia")) {
            String query = SparqlQuery.getAttributesFromClassQuery(entity, "DEFAULT");
            resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getAttributesFromClassQuery(entity, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        if (resultQuery != null) {
            while (resultQuery.hasNext()) {
                QuerySolution resultIndividual = resultQuery.nextSolution();
                attributes.add(resultIndividual.getResource("atributo").toString());
            }
        }
        System.out.println(attributes);
        return attributes;
    }

    public ArrayList<String> getInstancesFromClass(String entity) {
        ResultSet sameClases = getEquivalentClasses(entity);
        ArrayList<String> individualsFullResult = new ArrayList<>();

        while (sameClases.hasNext()) {
            System.out.println("--------------------------------------------------");

            QuerySolution solution = sameClases.nextSolution();
            String individualResult = solution.get("clase_igual").toString();
            ResultSet resultQuery = null;
            if (individualResult.contains("concesionario.owl")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
                resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

            } else if (individualResult.contains("resource/vocab")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "DEFAULT");
                try {
                    resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (individualResult.contains("dbpedia")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "DEFAULT");
                resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
            } else {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
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
    
    public ResultSet getEquivalentProperties(String uriProperty) {
        String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                + "SELECT DISTINCT ?propiedad_igual \n"
                + "WHERE {\n"
                + "	<" + uriProperty + "> owl:equivalentProperty ?propiedad_igual .\n"
                + "}";

        return this.executeQueryToIntegration(query);
    }
}
