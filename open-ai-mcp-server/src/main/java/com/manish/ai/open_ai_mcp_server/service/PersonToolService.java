package com.manish.ai.open_ai_mcp_server.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class PersonToolService {

    @Tool(name = "greet",description = "Greet a person by name")
    public String greet(
            @ToolParam(description = "Name of the person") String name
    ) {
        return "Hello, " + name + "!,\n welcome to MCP Server";
    }

    @Tool(description = "Add two integers")
    public int add(
            @ToolParam(description = "First number") int a,
            @ToolParam(description = "Second number") int b
    ) {
        return a + b;
    }
}
