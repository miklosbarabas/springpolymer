
Maven (3.x) + Spring Boot (1.4.1) + Polymer (1.6) + Tomcat

``` HTTP/2 needs ALPN lib loaded to the JVM when starting the app ```

java -Xbootclasspath/p:lib/alpn-boot-8.1.7.v20160121.jar ...


``` IntelliJ IDEA ```

The automatic Update Resources functionality only works if the web resources are in the <projectdir>/static directory.
If multiple instances of spring-boot app are running at the same time, this functionality will only work for the 1st one.
Ways to mitigate this issue:
--File Settings Compiler -> Make project automatically (only works while not running/debugging)
--Bind CTRL + S to Make project (as IntelliJ IDEA by default saves all changes automatically)

If you are using spring-boot-devtools livereload also only gets triggered if you Make the project
