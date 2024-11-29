package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class SomeTest {

    @Test
    public void run() throws Exception {
        ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeoutput));
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));

        GameRunner.main(new String[]{});
        String output = fakeoutput.toString();

        Approvals.verify(output);
    }
}
