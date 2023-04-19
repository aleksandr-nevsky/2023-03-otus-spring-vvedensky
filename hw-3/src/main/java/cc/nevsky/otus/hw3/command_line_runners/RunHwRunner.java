package cc.nevsky.otus.hw3.command_line_runners;

import cc.nevsky.otus.hw3.runner.HwRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunHwRunner implements CommandLineRunner {

    private final HwRunner hwRunner;

    public RunHwRunner(HwRunner hwRunner) {
        this.hwRunner = hwRunner;
    }

    @Override
    public void run(String... args) throws Exception {
        hwRunner.run();
    }
}
