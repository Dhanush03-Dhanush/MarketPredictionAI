import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final double lambda = 0.01;
    public static final double learningRate = 0.0000001;
    public static final int nIterations = 999999;

    public static void main(String[] args) {
        ArrayList<Double> closePrices = new ArrayList<>();
        ProcessAPI apiProcessor = new ProcessAPI();
        try {
            closePrices = apiProcessor.getAPI();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Double> trainData = new ArrayList<>();
        ArrayList<Double> inputData = new ArrayList<>();

        for(int i = 0; i < closePrices.size()/3; i++) {
            inputData.add(closePrices.get(i));
        }
        for (int i = closePrices.size()/3 + 1; i < closePrices.size(); i++) {
            trainData.add(closePrices.get(i));
        }

        List<Double> theta = GradientDescent.doGradientDescent(lambda, learningRate, nIterations, trainData, inputData.size());

        double prediction = PredictMarket.predictMarketValue((ArrayList<Double>) theta, inputData);
        System.out.println("> Predicted Closing Price: " + String.format("%.2f", prediction));
    }
}
