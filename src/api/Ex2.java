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
int g = 4;
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
          //  Set entrySet = kkk.getNode(2).getInfo();
            //        conedges.entrySet();

            // System.out.print("kkk.all");
//            Set entrySet = conedges.entrySet();
//            Iterator it = entrySet.iterator();
//
//            while(it.hasNext()){
//                Map.Entry me = (Map.Entry)r.next();
//                System.out.print(me.getKey());
//
//                System.out.print(me.getValue());
//            }
         //   System.out.print(kkk.all.values().);
           // System.out.print(
            //       Iterator r =kkk.edgeIter();
//            while(r.hasNext()){
//                Edge me = (Edge)r.next();
//                 System.out.print(me.getInfo());
//            }
            //);
//            HashMap<Integer,Node> all = new HashMap <Integer, Node>();
          //      Iterator r =kkk.nodeIter();
//
////                       while(r.hasNext()){
////                 System.out.print(r.);
//


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