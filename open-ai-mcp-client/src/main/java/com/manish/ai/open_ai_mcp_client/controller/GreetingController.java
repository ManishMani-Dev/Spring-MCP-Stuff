package com.manish.ai.open_ai_mcp_client.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final ChatClient chatClient;

    public GreetingController(
            ChatClient.Builder chatClientBuilder,
            ToolCallbackProvider toolCallbackProvider
    ) {
        this.chatClient = chatClientBuilder
//                .defaultTools(toolCallbackProvider)  // merges in server tools
                .build();
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        PromptTemplate template = new PromptTemplate(
                """
                You are a helpful assistant.
                Use the tool `greet` to greet the person by name.
                The name is: {name}
                """
        );
        Prompt prompt = template.create(Map.of("name", name));

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
