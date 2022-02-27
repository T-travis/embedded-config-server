# embedded-config-server

### Steps to demo
- Get request (original value) -> http://localhost:8080/message/
- Change config message value here -> https://github.com/T-travis/config-repo/blob/main/config.properties
- Post request to update embedded config server -> http://localhost:8080/actuator/refresh
- Get request (updated value) -> http://localhost:8080/message/
