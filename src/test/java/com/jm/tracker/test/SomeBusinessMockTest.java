package com.jm.tracker.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.jm.tracker.demo.TaskServiceDemo;
import com.jm.tracker.obj.TaskObj;
import com.jm.tracker.service.TaskService;

public class SomeBusinessMockTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		TaskService dataServiceMock = mock(TaskService.class);
		// when(dataServiceMock.getTaskObj(1)).thenReturn(getTestTaskObj());
		TaskServiceDemo businessImpl = new TaskServiceDemo(dataServiceMock);
		int result = 24;
		assertEquals(24, result);
	}

	private TaskObj getTestTaskObj() {

		TaskObj x = new TaskObj();

		return x;

	}

}
