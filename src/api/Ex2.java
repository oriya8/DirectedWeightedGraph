package api;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class is the main class for api.Ex2 - your implementation will be tested using this class.
 */


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
           // this.j=kkk;
           // DirectedWeightedGraphAlgorithms an = new DirectedWeightedGraphAlgorithms_(kkk);



            return kkk;
        }
        /**
         * This static function will be used to test your implementation
         * @param json_file - a json file (e.g., G1.json - G3.gson)
         * @return
         */
        public static DirectedWeightedGraphAlgorithms getGrapgAlgo (String json_file){
            DirectedWeightedGraph_ kkk = null;
            try {
                kkk = new DirectedWeightedGraph_(json_file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            DirectedWeightedGraphAlgorithms ans = new DirectedWeightedGraphAlgorithms_(kkk);
          //  DirectedWeightedGraphAlgorithms ans = null;
         //   ans.save("try");
            //   System.out.print(an.shortestPath(1,3));
            // System.out.print(an.isConnected());


//            List<NodeData> l = new LinkedList<>();
//            Iterator<NodeData> n = an.getGraph().nodeIter();
//            while (n.hasNext()) {
//                NodeData e = n.next();
//                l.add(e);
//            }
            //           NodeData one = an.getGraph().getNode(20);//NodeData two = an.getGraph().getNode(21);
            // NodeData three = an.getGraph().getNode(3);
//                l.add(one);
//                l.add(two);
            //     l.add(three);
//            System.out.print(l);
//            System.out.print("siiizze"+"\n");
            //    System.out.print(an.tsp(l));
            //    System.out.print(an.tsp(l).size());
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