# Scheme4GraalVM
[![CircleCI](https://circleci.com/gh/mthmulders/brainfuck-jvm.svg?style=svg)](https://circleci.com/gh/mthmulders/scheme4graalvm)
[![SonarCloud quality gate](https://sonarcloud.io/api/project_badges/measure?project=mthmulders_scheme4graalvm&metric=alert_status)](https://sonarcloud.io/dashboard?id=mthmulders_scheme4graalvm)
[![SonarCloud vulnerability count](https://sonarcloud.io/api/project_badges/measure?project=mthmulders_scheme4graalvm&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=mthmulders_scheme4graalvm)
[![SonarCloud technical debt](https://sonarcloud.io/api/project_badges/measure?project=mthmulders_scheme4graalvm&metric=sqale_index)](https://sonarcloud.io/dashboard?id=mthmulders_scheme4graalvm)
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=mthmulders/scheme4graalvm)](https://dependabot.com)

This project implements [Scheme](https://en.wikipedia.org/wiki/Scheme_(programming_language)) on the JVM, using [GraalVM](https://www.graalvm.org/).

## Status
Work has just begon...

## Getting started

### Install GraalVM
To get started, you need GraalVM.
You can obtain it at [the GraalVM website](https://www.graalvm.org/downloads/).
There are distributions for Windows, Linux and MacOS.

## Project structure
This project has a few modules:
* **parser** - this module contains a parser for the Scheme language.
It is built with [Antlr4](https://www.antlr.org/).
* **language** - this module contains the actual language implementation.
* **launcher** - this module contains a simple command line Scheme launcher.
* **native** - this module builds a native executable for the _launcher_.

## License
This project is licensed under the MIT license.
See `./LICENSE` for details.