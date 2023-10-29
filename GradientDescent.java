import java.util.ArrayList;
import java.util.List;

public class GradientDescent {

    public static List<Double> calculateThetaDerivative(List<Double> theta, List<Double> yDesired, List<List<Double>> sInputMatrix, double lambda, double myEps) {
        List<Double> thetaDerivative = new ArrayList<>();
        for (int i = 0; i < theta.size(); i++) {
            thetaDerivative.add(0.0);
        }
        int nMinus2 = sInputMatrix.get(0).size();
        for (int t = 0; t < nMinus2; t++) {
            double yPredicted = 0.0;
            double thetaMag = 0.0;
            for (int i = 0; i < theta.size(); i++) {
                yPredicted += theta.get(i) * sInputMatrix.get(i).get(t);
                thetaMag += Math.sqrt(theta.get(i) * theta.get(i) + myEps);
            }
            for (int i = 0; i < theta.size(); i++) {
                double derivativeTerm = -2.0 / nMinus2 * (yDesired.get(t) - yPredicted) * sInputMatrix.get(i).get(t)
                        + lambda * theta.get(i) / (nMinus2 * thetaMag);
                thetaDerivative.set(i, thetaDerivative.get(i) + derivativeTerm);
            }
        }
        return thetaDerivative;
    }

    public static List<Double> doGradientDescent(double lambda, double learningRate, int nIterations, List<Double> trainData, int thetaSize) {
        double myEps = 0.0001;
        int n = trainData.size();
        List<Double> yDesired = new ArrayList<>();
        List<List<Double>> sInputMatrix = new ArrayList<>();
        for (int i = 0; i < thetaSize; i++) {
            sInputMatrix.add(new ArrayList<>());
        }
        for (int t = thetaSize; t < n; t++) {
            yDesired.add(trainData.get(t));
            List<Double> sInputVector = new ArrayList<>();
            for (int i = 1; i <= thetaSize; i++) {
                sInputVector.add(trainData.get(t - i));
            }
            sInputVector.add(1.0);
            for (int i = 0; i < thetaSize; i++) {
                sInputMatrix.get(i).add(sInputVector.get(i));
            }
        }
        List<Double> theta = new ArrayList<>();
        for (int i = 0; i < thetaSize; i++) {
            theta.add(0.0);
        }
        List<Double> error = new ArrayList<>();
        for (int iteration = 0; iteration < nIterations; iteration++) {
            error.add(0.0);
            List<Double> thetaDerivative = calculateThetaDerivative(theta, yDesired, sInputMatrix, lambda, myEps);
            if (true) {
                double maxDerivative = 0.0;
                for (double derivative : thetaDerivative) {
                    maxDerivative = Math.max(maxDerivative, Math.abs(derivative));
                }
                double currentError = calculateError(theta, yDesired, sInputMatrix);
                error.set(iteration, currentError);

                System.out.println("Iteration #" + (iteration + 1) + ": Error = " + String.format("%.5f", currentError) + ", Gradient Norm = " + String.format("%.5f", maxDerivative));
            }
            for (int i = 0; i < thetaSize; i++) {
                theta.set(i, theta.get(i) - learningRate * thetaDerivative.get(i));
            }
        }
        System.out.println("<--------------------------------------------------------->");
        return theta;
    }

    public static double calculateError(List<Double> theta, List<Double> yDesired, List<List<Double>> sInputMatrix) {
        int n = yDesired.size();
        double sumSquaredError = 0.0;
        for (int i = 0; i < n; i++) {
            double yPredicted = 0.0;
            for (int j = 0; j < theta.size(); j++) {
                yPredicted += theta.get(j) * sInputMatrix.get(j).get(i);
            }
            double squaredError = Math.pow(yDesired.get(i) - yPredicted, 2);

            sumSquaredError += squaredError;
        }
        double meanSquaredError = sumSquaredError / n;
        return meanSquaredError;
    }

}
