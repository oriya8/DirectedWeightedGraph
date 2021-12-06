package api;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            Node [] ddd = new Node[16];
            ddd= kkk.bobbuilder();
            System.out.println(ddd[2].getInfo());
            List<EdgeData> connected = new ArrayList<>();
            connected=ddd[2].connectededges;
            System.out.println(ddd[2].connectededges);
            for (EdgeData gg : connected){
                System.out.println(gg.getInfo());

            }
        return ans;
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