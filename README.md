# ✅ Todo Summary Assistant

A full-stack project to manage personal to-dos, summarize them using Cohere AI, and send the summary to a Slack channel.

---

## 🛠 Tech Stack

- **Frontend**: React
- **Backend**: Spring Boot (Java)
- **LLM**: Cohere API (`command` model)
- **Slack**: Incoming Webhook
- **DB**: PostgreSQL (Supabase/local)

---

## ⚙️ Setup

### 🔧 Frontend

``bash
cd todo-summary-frontend
npm install
npm start


### Backend
cd todo-summary-backend
./mvnw spring-boot:run

In .env or application.properties:

CoCOHERE_API_KEY=your_cohere_api_key
SLACK_WEBHOOK_URL=https://hooks.slack.com/services/...


🔗 Slack Setup
Create an app at: Slack Webhooks

Enable Incoming Webhooks

Add a new webhook to your channel

Paste URL into SLACK_WEBHOOK_URL

🧠 Cohere Setup
Get a free API key from: cohere.com

Add it as COHERE_API_KEY in your backend


💡 Design Notes
Modular service classes for LLM and Slack

Real LLM (Cohere) used, not mocked

React manages todos; summary sent via Slack

Minimal UI with full functionality

