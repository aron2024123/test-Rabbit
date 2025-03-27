# AI Service - Spring Boot Backend

A Spring Boot application that connects to an AI API (OpenAI) to process user questions and return answers.

## Requirements

- Java 11+
- Maven

## Configuration

Before running the application, configure the OpenAI API key in `src/main/resources/application.properties`:

```properties
openai.api.key=your_api_key_here
```

## Building the Application

```bash
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

The service will be available at http://localhost:8080

## API Usage

### Ask a Question

**Endpoint**: `POST /api/ai/ask`

**Request Body**:
```json
{
  "question": "What is the capital of France?"
}
```

**Response**:
```json
{
  "answer": "The capital of France is Paris."
}
```

## Customization

You can customize the service to use different AI providers by implementing the `AIService` interface.