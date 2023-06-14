package es.uv.bjtwcam.productores.analyzers;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class BeanCreationAnalyzer extends AbstractFailureAnalyzer<BeanCreationException> {
    @Override
    protected FailureAnalysis analyze(Throwable fail, BeanCreationException cause) {
        return new FailureAnalysis("Some components are missing or cannot be loaded. Running under default profile is forbidden",
                        "Activate a specific profile (local or prod)",
                        cause);
    }
}
