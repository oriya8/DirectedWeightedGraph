package api;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class is the main class for api.Ex2 - your implementation will be tested using this class.
 */
//public class Ex2 {


public class Ex2 {
   // private DirectedWeightedGraph j;
        /**
         * This static function will be used to test your implementation
         * @param json_file - a json file (e.g., G1.json - G3
         *                  .gson)
         * @return
         */
        public static DirectedWeightedGraph getGrapg (String json_file) throws FileNotFoundException {
            DirectedWeightedGraph ans = null;
           // json_file = "data\\G1.json";
            DirectedWeightedGraph_ kkk = new DirectedWeightedGraph_(json_file);
            DirectedWeightedGraphAlgorithms an = new DirectedWeightedGraphAlgorithms_(kkk);
            List<NodeData> l = new LinkedList<>();
            Iterator<NodeData> n = an.getGraph().nodeIter();
            while (n.hasNext()) {
                NodeData e = n.next();
                l.add(e);
            }
            an.tsp(l);

            return kkk;
        }
        /**
         * This static function will be used to test your implementation
         * @param json_file - a json file (e.g., G1.json - G3.gson)
         * @return
         */
        public static DirectedWeightedGraphAlgorithms getGrapgAlgo (String json_file){
            DirectedWeightedGraphAlgorithms ans = null;
            // ****** Add your code here ******
            //
            // ********************************
            return ans;
        }
        /**
         * This static function will run your GUI using the json fime.
         * @param json_file - a json file (e.g., G1.json - G3.gson)
         *
         */
        public static void runGUI (String json_file){
            DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
            // ****** Add your code here ******
            //
            // ********************************
        }

}