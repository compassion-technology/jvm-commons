ERI Commons - Language Extensions
------------------------------------------

![Build](https://github.com/ElderResearch/commons-jvm/workflows/Java%20CI%20with%20Maven/badge.svg)

A "toolbox" of language extensions and utilities for JVM-based languages, like Java.

This sends the following transitive dependencies:
* Apache [Commons Lang](http://commons.apache.org/proper/commons-lang/) and [Commons Text](http://commons.apache.org/proper/commons-text/)
* [jOOλ](https://github.com/jOOQ/jOOL)
* [Guava](https://github.com/google/guava)
* [JCommander](https://github.com/cbeust/jcommander)
* [Jackson](https://github.com/FasterXML/jackson) with [YAML support](https://github.com/FasterXML/jackson-dataformats-text/tree/master/yaml)

Some of the utilities in this project include:
- `@Documentation`: Annotation to facilitate code generation and documentation of system components that can be reflected at runtime
- `PropertiesKey` and `PreferencesKey`: Support enum-based simple key/value config via a file, the registry, system properties or environment variables
- `NumberExtractor` and `DateExtractor`: General-purpose/robust number and date parser/extractor that uses all localized formats available to the JVM to extract values from text.
- `LambdaUtils`: Utilities for using Java 8 lambdas
- `ReflectionUtils`: Wrapper around the Java reflection APIs, simplifying their use and absorbing exceptions.
- `StatusMonitor`/`StatusListener`: "Transactional" status API for long-running tasks.  You can set the task state, progress, or message in atomic operations continually, but listeners will only be notified at fixed time intervals (or when certain state changes regardless of time). You can poll a status monitor to know if the user canceled the task.
- `StopWatch`: Enhanced/improved version of Apache's stop watch functionality
- `StringMatcher`: Utility for programmatically matching strings using starts with, ends with, contains, equals, regular expressions, and ignore case.
- `UnicodeChars`: Constant declarations of most unicode characters
