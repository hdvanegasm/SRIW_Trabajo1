/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaire.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import concessionaire.controller.GeneralController;
import concessionaire.controller.SparqlQuery;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.jena.graph.Node;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;

/**
 *
 * @author santi
 */
public class Main {

    public static void main(String[] args) {
        GeneralController controller = new GeneralController();

        String querys = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX onto: <https://sriw-trabajo1-ontologies.herokuapp.com/ontologies/concesionario.owl/>\n"
                + "SELECT DISTINCT ?clase_igual \n"
                + "WHERE {\n"
                + "	\"clase\" owl:sameAs ?clase_igual .\n"
                + "}";

        ResultSet result = controller.executeQueryToIntegration(querys);
        ResultSetFormatter.out(System.out, result);

        while (result.hasNext()) {
            System.out.println("--------------------------------------------------");

            QuerySolution solution = result.nextSolution();
            String individualResult = solution.get("another_class").toString();
            ResultSet resultQuery = null;
            if (individualResult.contains("concesionario.owl")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario");
                resultQuery = controller.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
                System.out.println(query);
            } else if (individualResult.contains("resource/vocab")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "DEFAULT");
                try {
                    resultQuery = controller.executeQueryToEndPoint(query, "http://sriw-trabajo1-d2r.herokuapp.com/sparql");
                    System.out.println(query);
                } catch (Exception ex) {
                    System.out.println("Error de conexion con servidor D2R");
                }
            } else if (individualResult.contains("dbpedia")) {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "DEFAULT");
                resultQuery = controller.executeQueryToEndPoint(query, "http://dbpedia.org/sparql");
                System.out.println(query);
            } else {
                String query = SparqlQuery.getIndividualFromClassQuery(individualResult, "http://35.224.217.230:8890/ontologies/concesionario.rdf");
                resultQuery = controller.executeQueryToEndPoint(query, "http://35.224.217.230:8890/sparql");
                System.out.println(query);
            }

            if (resultQuery != null) {
                ResultSetFormatter.out(System.out, resultQuery);
            }
        }

    }

}
