package es.uv.bjtwcam.productores.analyzers;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class MyCustomAnalyzer extends AbstractFailureAnalyzer<MyCustomException> {
    @Override
    protected FailureAnalysis analyze(Throwable fail, MyCustomException cause) {
    	return new FailureAnalysis("This application requires a specific profile. Running under default profile is forbidden",
                "Activate a specific profile (local or prod)",
                cause);
    }
}
