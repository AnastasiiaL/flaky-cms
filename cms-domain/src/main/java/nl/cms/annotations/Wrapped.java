package nl.cms.annotations;

import org.immutables.value.Value;

/**
 * Annotation to easily define wrapper value classes like our atoms.
 * See <a href="https://immutables.github.io/style.html#custom-immutable-annotation">Style customization</a>
 */
@Value.Style(
        jdkOnly = true,
        jdk9Collections = true,
        jakarta = true,
        defaults = @Value.Immutable(copy = false),
        overshadowImplementation = true,
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        strictBuilder = true,
        allParameters = true
)
public @interface Wrapped {
}
