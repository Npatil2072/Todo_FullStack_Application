package com.todo.controller;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.repo.TodoRepository;

@RestController
@RequestMapping("/summarize")
@CrossOrigin(origins = "http://localhost:3000")
public class SummaryController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CohereService cohereService;

    @Autowired
    private SlackService slackService;

    @PostMapping
    public String summarizeAndSend() {
        try {
            List<Todo> pendingTodos = todoRepository.findAll().stream()
                    .filter(todo -> !todo.isCompleted())
                    .collect(Collectors.toList());

            if (pendingTodos.isEmpty()) {
                return "No pending todos to summarize.";
            }

            List<String> tasks = pendingTodos.stream()
                    .map(Todo::getTitle)
                    .collect(Collectors.toList());

            String summary = cohereService.summarizeTodos(tasks);
            slackService.sendToSlack(summary);

            return "✅ Summary sent to Slack:\n" + summary;

        } catch (IOException e) {
            return "❌ Failed to send summary: " + e.getMessage();
        }
    }
}
