import java.util.ArrayList;

public class PredictMarket {
    public static double predictMarketValue(ArrayList<Double> theta, ArrayList<Double> inputData) {
        double prediction = 0.0;
        for(int i = 0; i < theta.size() && i < inputData.size(); i++) {
            prediction = prediction + theta.get(i)*inputData.get(i);
        }
        return prediction;
    }
}
