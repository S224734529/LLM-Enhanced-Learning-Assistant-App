# LLM-Enhanced Learning Assistant App

## Overview
This project is an Android Java application designed to support student learning through personalised tasks and simple AI assistance. The app guides users from account setup to task completion, while providing learning support such as hints, flashcards, and feedback on answers.

The purpose of the application is to demonstrate how Large Language Models can be used to enhance learning activities rather than only provide chat-based responses.

---

## Key Features

### User Flow
- Login and account setup  
- Interest selection to personalise content  
- Home dashboard with generated learning task  
- Task screen with questions and AI assistance  
- Results screen with feedback  

---

### LLM-Powered Learning Utilities
The application includes learning-focused AI features:

- Generate Hint  
  Provides guidance to help students approach a question  

- Create Flashcards  
  Generates three short revision cards from a topic  

- Answer Explanation  
  Explains whether a student’s answer is correct or incorrect  

Each feature displays the prompt sent to the model, the generated response, and handles loading and failure states.

---

## Screens
- Login Screen  
- Account Setup Screen  
- Interest Selection Screen  
- Home Dashboard  
- Task Screen  
- Results Screen  

---

## Tech Stack
- Java  
- Android SDK  
- XML layouts  
- SharedPreferences  
- OkHttp  
- Backend API for LLM integration  

---

## Project Structure

app/
├── java/com/example/learningassistant/
│ ├── MainActivity.java
│ ├── SignupActivity.java
│ ├── InterestsActivity.java
│ ├── HomeActivity.java
│ ├── TaskActivity.java
│ ├── ResultsActivity.java
│ ├── LlmRepository.java
│ └── AppStore.java
│
├── res/
│ ├── layout/
│ ├── drawable/
│ ├── anim/
│ └── values/


## LLM Integration Design
The application follows a secure architecture:

Android App → Backend API → LLM Service  

The Android app sends prompts such as:
- Generate a hint  
- Create flashcards  
- Explain answer correctness

## How to Run
- Clone the repository
- Open the project in Android Studio
- Sync Gradle
- Run on an emulator or physical device
