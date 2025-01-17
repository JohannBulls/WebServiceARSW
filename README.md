# Stock Market Data Application

This application retrieves historical stock market data for a given stock symbol from Alpha Vantage using their API. It supports different time intervals such as intraday, daily, weekly, and monthly.

## Features

- **Data Retrieval**: Fetches historical stock data based on user-specified intervals (intraday, daily, etc.).
- **API Integration**: Utilizes Alpha Vantage API for data retrieval.
- **Concurrency**: Supports concurrent data fetching using multiple threads.
- **Simple Client**: A Java-based client application that makes HTTP GET requests to the backend.

## Project Structure

### Backend (Spring Boot)

The backend server is built using Spring Boot and provides RESTful APIs for fetching stock data.

#### Main Components

1. **StockService.java**:
   - Service class responsible for constructing the API URL and making HTTP GET requests to Alpha Vantage.

2. **StockController.java**:
   - REST controller that handles incoming requests for fetching stock data based on different intervals.

3. **WebServiceArswApplication.java**:
   - The main class for bootstrapping the Spring Boot application.

### Client (Java)

The Java client application interacts with the backend to fetch and display stock data.

#### Main Classes

1. **StockClient.java**:
   - A simple Java client that makes HTTP GET requests to the Spring Boot backend.
   - Retrieves stock data for predefined intervals and prints the response to the console.

2. **StockClientTest.java**:
   - A test class that executes the StockClient concurrently using multiple threads.
   - Demonstrates how to fetch stock data in parallel to improve performance.

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

### Installation Steps

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/JohannBulls/WebServiceARSW
   cd WebServiceARSW
   ```

2. **Compile and Run the Backend**:

   ```bash
   mvn clean package
   mvn spring-boot:run
   ```

3. **Run the Client**:

   ```bash
   mvn clean package
   mvn exec:java -Dexec.mainClass="edu.escuelaing.arsw.ASE.app.WebServiceARSW.StockClient"
   ```

4. **Access the Application**:
   - The client application will fetch data from the backend based on predefined intervals and display it in the console.

### AWS Deployment

You can access the application deployed on AWS at:
http://ec2-54-158-119-56.compute-1.amazonaws.com:8080/

![alt text](images/image.png)

### Architectural Design
![alt text](<images/Diagrama en blanco.png>)
## Technologies Used

- **Backend**: Spring Boot, Java
- **Client**: Java, HttpURLConnection
- **API**: Alpha Vantage

## Author

- Johann Amaya Lopez - [GitHub](https://github.com/JohannBulls)

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.txt) file for details.