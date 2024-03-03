package nl.cms.annotations;

import org.immutables.value.Value;

/**
 * Annotation to define domain models that we would like to generate staged builders for.
 * See the documentation on <a href="https://immutables.github.io/immutable.html#staged-builder">Staged Builders</a> for more information.
 */
@Value.Style(
        jdkOnly = true,
        jdk9Collections = true,
        jakarta = true,
        stagedBuilder = true,
        depluralize = true
)
public @interface Staged {
}
