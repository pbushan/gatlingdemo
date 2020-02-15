# Running the test

Run the test using maven `mvn gatling:test`

# Adding grafana monitoring to gatling tests

Default writers in gatling.config file are console and file

```
data {
       writers = [console, file]
```
change it to 
```$xslt
data {
    writers = [console, file, graphite]
```
Add graphite host
```$xslt
graphite {
      #light = false              # only send the all* stats
      host = "10.0.0.0"                  # The host where the Carbon server is located

```