
import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = {"decision.ftl", "areas"})
@com.gs.dmn.runtime.annotation.DRGElement(
    namespace = "",
    name = "areas",
    label = "",
    elementKind = com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
    expressionKind = com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
    hitPolicy = com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
    rulesCount = -1
)
public class Areas extends com.gs.dmn.runtime.DefaultDMNBaseDecision {
    public static final com.gs.dmn.runtime.listener.DRGElement DRG_ELEMENT_METADATA = new com.gs.dmn.runtime.listener.DRGElement(
        "",
        "areas",
        "",
        com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
        com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
        com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
        -1
    );

    public Areas() {
    }

    public List<java.math.BigDecimal> apply(String heights, String widths, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_) {
        try {
            return apply((heights != null ? asList(com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(heights, java.math.BigDecimal[].class)) : null), (widths != null ? asList(com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(widths, java.math.BigDecimal[].class)) : null), annotationSet_, new com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), new com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor());
        } catch (Exception e) {
            logError("Cannot apply decision 'Areas'", e);
            return null;
        }
    }

    public List<java.math.BigDecimal> apply(String heights, String widths, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        try {
            return apply((heights != null ? asList(com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(heights, java.math.BigDecimal[].class)) : null), (widths != null ? asList(com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(widths, java.math.BigDecimal[].class)) : null), annotationSet_, eventListener_, externalExecutor_);
        } catch (Exception e) {
            logError("Cannot apply decision 'Areas'", e);
            return null;
        }
    }

    public List<java.math.BigDecimal> apply(List<java.math.BigDecimal> heights, List<java.math.BigDecimal> widths, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_) {
        return apply(heights, widths, annotationSet_, new com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), new com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor());
    }

    public List<java.math.BigDecimal> apply(List<java.math.BigDecimal> heights, List<java.math.BigDecimal> widths, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        try {
            // Decision start
            long startTime_ = System.currentTimeMillis();
            com.gs.dmn.runtime.listener.Arguments arguments = new com.gs.dmn.runtime.listener.Arguments();
            arguments.put("heights", heights);
            arguments.put("widths", widths);
            eventListener_.startDRGElement(DRG_ELEMENT_METADATA, arguments);

            // Evaluate expression
            List<java.math.BigDecimal> output_ = evaluate(heights, widths, annotationSet_, eventListener_, externalExecutor_);

            // Decision end
            eventListener_.endDRGElement(DRG_ELEMENT_METADATA, arguments, output_, (System.currentTimeMillis() - startTime_));

            return output_;
        } catch (Exception e) {
            logError("Exception caught in 'areas' evaluation", e);
            return null;
        }
    }

    private List<java.math.BigDecimal> evaluate(List<java.math.BigDecimal> heights, List<java.math.BigDecimal> widths, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        return heights.stream().map(h -> widths.stream().map(w -> numericMultiply(h, w))).flatMap(x -> x).collect(Collectors.toList());
    }
}