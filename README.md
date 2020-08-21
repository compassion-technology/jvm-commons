ERI Commons - Language Extensions
------------------------------------------

![Build](https://github.com/ElderResearch/commons-jvm/workflows/Java%20CI%20with%20Maven/badge.svg)

A "toolbox" of language extensions and utilities for JVM-based languages, like Java. Supports Java 8 and Java 11.

## Maven

You can install this library from [Jipack.io](https://jitpack.io). Add the following repository to your POM:

```xml
<repositories>
   <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
   </repository>
</repositories>
 ```

And then the following dependency:

```xml
<dependency>
	<groupId>com.elderresearch.commons-jvm</groupId>
	<artifactId>commons-jvm</artifactId>
	<version>2.4.6</version>
</dependency>
```

for Java 11+ or

```xml
<dependency>
	<groupId>com.elderresearch.commons-jvm</groupId>
	<artifactId>commons-jvm-java8</artifactId>
	<version>2.4.6</version>
</dependency>
```

for Java 8.

# Dependencies

This sends the following transitive dependencies:
* Apache [Commons Lang](http://commons.apache.org/proper/commons-lang/) and [Commons Text](http://commons.apache.org/proper/commons-text/)
* [jOOλ](https://github.com/jOOQ/jOOL)
* [Guava](https://github.com/google/guava)
* [Jackson](https://github.com/FasterXML/jackson) with [YAML support](https://github.com/FasterXML/jackson-dataformats-text/tree/master/yaml)
* [Log4j2](https://logging.apache.org/log4j/2.x/)

## Overview

Some of the utilities in this project include:
- `Config`, `YAMLConfig`, and `EnvironmentTree`: Powerful configuration that supports a configuration bean via YAML (or any other supported Jackson format) with environment (environment variable and/or system property) overrides.
- `DaemonWorker`: An easy to use wrapper around a daemon thread and a blocking queue for multithreaded, queueable tasks.
- `@Documentation`: Annotation to facilitate code generation and documentation of system components that can be reflected at runtime
- `NumberExtractor` and `DateExtractor`: General-purpose/robust number and date parser/extractor that uses all localized formats available to the JVM to extract values from text.
- `IteratorCloseable`, `IteratorMultithreaded`, and `IteratorWithSize`: Variants on the standard `Iterator` pattern offering deterministic progress, closeability, and parallelism.
- `LambdaUtils`: Utilities for using Java 8 lambdas
- `ReflectionUtils`: Wrapper around the Java reflection APIs, simplifying their use and absorbing exceptions.
- `StatusMonitor`/`StatusListener`: "Transactional" status API for long-running tasks.  You can set the task state, progress, or message in atomic operations continually, but listeners will only be notified at fixed time intervals (or when certain state changes regardless of time). You can poll a status monitor to know if the user canceled the task.
- `StopWatch`: Enhanced/improved version of Apache's stop watch functionality
- `StringMatcher`: Utility for programmatically matching strings using starts with, ends with, contains, equals, regular expressions, and ignore case.
- `UnicodeChars`: Constant declarations of most unicode characters

## Contribution

We welcome pull requests and issues!