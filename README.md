# Payment Service

Payment Service is a microservice responsible for **processing payments** in an e-commerce microservices architecture.

---

## Tech Stack

* Java 21+ / Spring Boot
* Spring Web
* Lombok

---

## Features

* Process payment requests
* Simulate payment success and failure
* Integrates with Order Service
* Simple and extensible architecture for future real payment providers

---

## Getting Started

### Prerequisites

* Java 21+
* Gradle

---

## Running the Service

```bash
./gradlew bootRun
```

The service will start on:

```text
http://localhost:8083
```

---

## API Endpoints

### Process Payment

```http
POST /payments
```

#### Request

```json
{
  "orderId": 1,
  "amount": 100,
  "paymentMethod": "CARD"
}
```

#### Response (Success)

```json
{
  "orderId": 1,
  "status": "SUCCESS"
}
```

#### Response (Failed)

```json
{
  "orderId": 1,
  "status": "FAILED"
}
```

---

## Integration

This service is used by:

* **Order Service** → sends payment requests
* Returns payment status → used to update order status

---

## Future Improvements

* Integration with real payment providers (PayPal, Stripe)
* Payment status persistence (database)
* Asynchronous processing (Kafka / events)
* Security with JWT (service-to-service authentication)

---

## License

This project is for learning purposes.
