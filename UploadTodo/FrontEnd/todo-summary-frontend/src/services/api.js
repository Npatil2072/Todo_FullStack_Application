import axios from 'axios';

const BASE_URL = 'http://localhost:8082/productapi'; // Replace with deployed backend if needed

export const getTodos = () => axios.get(`${BASE_URL}/todos`).then(res => res.data);
// export const getTodos = () => axios.get(`http://localhost:8082/productapi/todos`).then(res => res.data);


export const addTodo = (todo) =>
  axios.post(`${BASE_URL}/todos`, todo);

export const deleteTodo = (id) =>
  axios.delete(`${BASE_URL}/todos/${id}`);

export const summarizeTodos = () =>
  axios.post(`${BASE_URL}/summarize`);


//http://localhost:8082/productapi/todos

/*import { CohereClientV2 } from "cohere-ai";

const client = new CohereClientV2({ token: "<YOUR_API_KEY>" });        
await client.chatStream(
	{
		model: "command-a-03-2025",
		messages: [],
		temperature: 0.3
	}
)*/