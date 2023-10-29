# MarketPredictionAI

In this project, I developed a stock market price prediction system using machine learning techniques. The project involves various accomplishments and highlights:

Machine Learning Model: I implemented a machine learning model in Java, manually coding every algorithm, to predict stock market prices. The model utilizes gradient descent, L1 regularization, and learning rate optimization.

Data Retrieval: I incorporated a data retrieval component using the AlphaVantage Stock Market API. This component fetched historical stock price data for the specified asset symbol, which was used for training and testing the machine learning model.

Feature Engineering: The project involves feature engineering where the input data for the model was constructed based on historical closing prices. This step is crucial for the model to make accurate predictions.

Gradient Descent: I designed and implemented the gradient descent algorithm, which optimizes the model's parameters (theta) for minimizing prediction errors. The model's accuracy is improved through repeated iterations.

Error Calculation: The project calculates and displays the mean squared error during the training phase to assess the model's performance.

Result Presentation: The predicted closing price is displayed with high precision, offering a valuable tool for investors to make informed decisions.

## User Input: 
From the command line, the user can enter any asset symbol they want a predicted price for:

<img width="215" alt="Screenshot 2023-10-29 at 5 49 32 PM" src="https://github.com/Dhanush03-Dhanush/MarketPredictionAI/assets/67134476/51f82961-e0ad-4d13-9946-ad74d1cca3f7">

## AI Output:
The AI runs the gradient descent algorithm with regularization after parsing a set of data from the AlphaVantage API and splitting it into testing and training data and gives a prediction for the next day as an output:

<img width="492" alt="Screenshot 2023-10-29 at 5 51 05 PM" src="https://github.com/Dhanush03-Dhanush/MarketPredictionAI/assets/67134476/cff59bce-e6a8-4546-8d7a-1ad164dbc329">

## Convergence of Loss Display:
The gradient descent algorithm is meant to minimize an emperical loss function. The convergence of loss approaching 0 can be visualized as the program prints the total loss for each iteration of the algorithm: 

<img width="511" alt="Screenshot 2023-10-29 at 5 50 07 PM" src="https://github.com/Dhanush03-Dhanush/MarketPredictionAI/assets/67134476/5a51b4d4-85ba-4e13-878a-d44657394d1c">
<img width="484" alt="Screenshot 2023-10-29 at 5 50 56 PM" src="https://github.com/Dhanush03-Dhanush/MarketPredictionAI/assets/67134476/fc257ab2-8ea6-4b7a-a69b-3880f59a047b">



