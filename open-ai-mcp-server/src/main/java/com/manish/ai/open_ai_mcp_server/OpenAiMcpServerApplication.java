package com.manish.ai.open_ai_mcp_server;

import com.manish.ai.open_ai_mcp_server.service.PersonToolService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenAiMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenAiMcpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider toolCallbackProvider(PersonToolService personToolService) {
		return MethodToolCallbackProvider.builder()
				.toolObjects(personToolService)
				.build();
	}

}
