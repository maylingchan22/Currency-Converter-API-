# Currency Converter API (Java)

## Table of Contents

- [Project Structure](#project-structure)
- [Setup](#setup)
- [Usage](#usage)

## Project Structure

The project is structured into several packages and classes:

- **com.example.springapi.util**: Contains a utility class `CurrencyConversionUtil` for rounding double values to a specified number of decimal places.
- **com.example.springapi.service**: Houses the `CurrencyConversionService`, which is responsible for making API requests to obtain exchange rates and performing currency conversions.
- **com.example.springapi.api.model**: Defines the `CurrencyConversion` class, which represents a currency conversion transaction.
- **com.example.springapi.api.externalapi**: Contains the `ExchangeRateApiResponse` class, which models the response from an external exchange rate API.
- **com.example.springapi.api.controller**: Defines the RESTful API controller `CurrencyConversionController`, which exposes an endpoint for currency conversion.

## Setup

To set up and run the project locally, follow these steps:

1. **Clone the Repository**:
   ```shell
   git clone <repository-url>
   cd currency-converter-api
   ```

Configure External API URL:
Open the application.properties file in the src/main/resources directory and set the exchangerate.api.base-url property to the URL of the external exchange rate API.

Build the Project:
Use Maven to build the project:
mvn clean install

Run the Application:
Run the Spring Boot application:
java -jar target/currency-converter-api-<version>.jar
The application should now be running locally.

## Usage

API Endpoint
The API exposes a single endpoint for currency conversion:

Endpoint: /api/currency/convert
Method: GET
Request Parameters
from (String): The currency code to convert from (e.g., "USD").
to (String): The currency code to convert to (e.g., "EUR").
amount (double): The amount to convert.

**Example Request**
To convert 100 USD to EUR, make a GET request to the following endpoint:
```GET http://localhost:8080/api/currency/convert?from=USD&to=EUR&amount=100```

**Example Response**
```{
"fromCurrency": "USD",
"toCurrency": "EUR",
"amount": 100.0,
"convertedAmount": 85.41
}```
