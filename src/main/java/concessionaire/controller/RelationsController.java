package concessionaire.controller;
import org.apache.jena.query.ResultSet;

public class RelationsController extends GeneralController {
    
    public Boolean checkIfExistARelationship(String individual1, String individual2) {
        ResultSet resultQuery = null;
            
        if (individual1.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualsRelationShip(individual1, individual2, "http://35.224.217.230:8890/ontologies/concesionario");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individual1.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualsRelationShip(individual1, individual2, "DEFAULT");
            try {
                resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individual1.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualsRelationShip(individual1, individual2,"DEFAULT");
            resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualsRelationShip(individual1, individual2, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }

        return resultQuery.hasNext();
    }
    
    public Boolean checkIfExistAIndirectRelationship(String individual1, String individual2) {
        ResultSet resultQuery = null;
            
        if (individual1.contains("concesionario.owl")) {
            String query = SparqlQuery.getIndividualsIndirectRelationShip(individual1, individual2, "http://35.224.217.230:8890/ontologies/concesionario");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");

        } else if (individual1.contains("resource/vocab")) {
            String query = SparqlQuery.getIndividualsIndirectRelationShip(individual1, individual2, "DEFAULT");
            try {
                resultQuery = this.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
            } catch (Exception ex) {
                System.out.println("Error de conexion con servidor D2R");
            }
        } else if (individual1.contains("dbpedia")) {
            String query = SparqlQuery.getIndividualsIndirectRelationShip(individual1, individual2,"DEFAULT");
            resultQuery = this.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
        } else {
            String query = SparqlQuery.getIndividualsIndirectRelationShip(individual1, individual2, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
            resultQuery = this.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
        }
        
        
        /* Tests */
        /*while(resultQuery.hasNext()) {
            QuerySolution resultIndividual = resultQuery.nextSolution();
            System.out.println("asdasdasdasd " + resultIndividual.get("?thing").toString()); 
        }*/
        
        
        return resultQuery.hasNext();
    }
}
