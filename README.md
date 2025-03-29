# Tax Calculator API Service

A Spring Boot application that calculates tax on bet returns based on trader-specific tax configurations.

## Overview

This service provides a REST API endpoint that calculates potential returns on bets with appropriate tax deductions. Tax calculations vary based on trader-specific configurations, including tax type (applied to the entire amount or just winnings) and tax method (fixed amount or percentage rate).
As this is for demonstration purposes.

## Prerequisites

- Java 17 or higher
- Gradle 7.0+
- IDE of your choice (IntelliJ IDEA, Eclipse, VS Code, etc.)
### 1. Clone the Repository

```bash
git clone https://github.com/pmishko/tax-calculator.git
cd tax-calculator
```

### 2. Build the Application

```bash
./gradlew clean build
```

### 3. Run the Application

```bash
./gradlew bootRun
```

The application will start on port 8080 by default.

## API Documentation

### Calculate Bet Return

**URL**: `/calculate-return`

**Method**: `POST`

**Content-Type**: `application/json`

**Request Body Example**:
```json
{
  "traderId": 1,
  "playedAmount": 100.00,
  "odd": 2.5
}
```

**Request Parameters**:
- `traderId`: ID of the trader (determines which tax configuration to apply)
- `playedAmount`: The bet amount (must be greater than 0)
- `odd`: The bet odds (multiplier for potential winnings)

**Response Example**:
```json
{
  "possibleReturnAmount": 250.00,
  "possibleReturnAmountBefTax": 250.00,
  "possibleReturnAmountAfterTax": 225.00,
  "taxRate": 0.1,
  "taxAmount": 25.00
}
```
**Error Responses**:
- `400 Bad Request`: If played amount is 0 or negative
## Testing the API

### Method 1: Running Unit Tests

Run the unit tests using Gradle:

```bash
./gradlew test
```

This will execute all the test cases and generate a report in the `build/reports/tests/test` directory.

### Method 2: Using Postman

1. **Start the Application**:
   Ensure the application is running (using `./gradlew bootRun`).

2. **Create a POST Request in Postman**:
    - Set the HTTP method to `POST`
    - Enter the URL: `http://localhost:8080/calculate-return`
    - Go to the Headers tab and add `Content-Type: application/json`

3. **Add Request Body**:
    - Go to the Body tab
    - Select `raw` and then `JSON` format
    - Enter a JSON payload like:
      ```json
      {
        "traderId": 1,
        "playedAmount": 100.00,
        "odd": 2.5
      }
      ```

4. **Send the Request**:
    - Click the Send button
    - You should receive a response with tax calculations

5. **Try Different Trader IDs**:
    - The application has predefined configurations for trader IDs 1-4:
        - ID 1: General tax, Rate method (10%)
        - ID 2: General tax, Fixed amount method (2.00)
        - ID 3: Winnings-only tax, Rate method (10%)
        - ID 4: Winnings-only tax, Fixed amount method (2.00)
    - Any other trader ID defaults to General tax, Rate method (10%)


## License

This project is licensed under the MIT License - see the LICENSE file for details.