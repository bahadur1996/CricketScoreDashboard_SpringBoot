package com.backendcode.assignment;

import com.backendcode.assignment.scheduler.LiveScoreUpdatingScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	LiveScoreUpdatingScheduler liveScoreUpdatingScheduler;
	@Test
	void testLiveApiCallAndDataPersistence() {
		liveScoreUpdatingScheduler.updateLiveScore();
	}

}
