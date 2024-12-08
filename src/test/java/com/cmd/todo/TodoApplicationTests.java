package com.cmd.todo;

import com.cmd.todo.entity.Task;
import com.cmd.todo.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	void taskListShouldContainOneItem() {
		List<Task> result = taskRepository.getAllByUserId(97259659);
		Assertions.assertEquals(1, result.size());
	}

	@Test
	void taskListShouldNotBeNull() {
		List<Task> result = taskRepository.getAllByUserId(97259659);
		Assertions.assertNotNull(result);
	}

}
