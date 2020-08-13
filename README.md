# ✨ Trivago Magazine Automation 
Java project for UI test automation. This skeleton allows to other QAs to automate different scenarios.
This framework was developed and tested on Linux OS (Ubuntu 18.04)

 

## Setup Development Environment

- Install [SDKMan](https://sdkman.io/install) development tools.
- Install JDKs & SDKs

```bash
$ sdk install java 8.0.232-open
$ sdk install gradle <version>
```
- Verify JAVA installation
```bash
$ java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment (build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM (build 25.232-b09, mixed mode)
```

```bash
$ echo $JAVA_HOME
<path-to-java-directory>/.sdkman/candidates/java/8.0.232-open
```

- Install Intellij IDEA
```bash
$ sudo snap install intellij-idea-community --classic
```
- Chrome Driver version ```81.0.4044.138```
- Plugins

| Plugin | README |
| ------ | ------ |
| Gherkin| [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin) |
| Cucumber for Java| [Cucumber](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) |

## 🚀 Usage
Run the following commands at the root of your project:

- Clean & Build environment

```sh
$ gradle clean build
```

- To run UI test cases, execute the following command
```sh
$  gradle cucumber -q -Ptags='@ui'
```

## 📝 Reporting
A `cucumber.json` file is created after each execution and is persisted into `/report_output`. 
This file is parsed by Cucumber report plugin to generate a HTML report. To review HTML report double click on `/report/cucumber-html-reports/overview-features.html` 
The HTML report generated:

<p align="center">
  <img width="720" src="https://user-images.githubusercontent.com/38532498/90182996-ba6b6280-ddaa-11ea-939f-3d9e86a088ba.jpg">
</p>

## 🔨 Build with
- [Gradle](https://gradle.org/) - Dependency Management
