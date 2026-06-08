# AI Customer Reply Assistant

A Spring Boot REST API with a simple web interface that generates professional customer service replies using AI. Type a customer message and get a polished, ready-to-send response powered by Google's Gemini LLM.

## What it does
Support teams get repetitive customer messages. This tool takes any customer message and instantly drafts a professional reply, saving time and keeping responses consistent.

## Tech Stack
- Java 17 + Spring Boot 3.5
- Spring WebFlux (WebClient) for external API calls
- Google Gemini API (gemini-2.5-flash) for AI generation
- MySQL + Spring Data JPA
- HTML/JavaScript frontend

## How it works
1. User types a customer message in the web interface
2. The frontend calls the `/reply` endpoint
3. The service builds a structured prompt and calls the Gemini API
4. The AI-generated reply is parsed and returned as clean text

## Key features
- Live LLM integration with prompt engineering for consistent single-reply output
- Secure API key handling (kept out of source control)
- Clean separation of controller, service, and frontend

## Running locally
1. Add your Gemini API key to `application.properties`
2. Create a MySQL database named `taskmanager`
3. Run `./mvnw spring-boot:run`
4. Open `http://localhost:8080/`
