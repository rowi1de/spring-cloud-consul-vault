# HashiCorp Consul, Vault, Spring Cloud
Service Discovery, Config Management, Secret Management
Based on [Einsteinish/Docker-compose-Hashicorp-Vault-Consul](https://github.com/Einsteinish/Docker-compose-Hashicorp-Vault-Consul)
## Quickstart
* `git clone https://github.com/Einsteinish/Docker-compose-Hashicorp-Vault-Consul.git`
* `docker-compose up -d && docker-compose logs -f`
* `docker-compose exec vault bash`
* `vault operator init`
* `vault operator unseal K1,K2,K3` (separate)
* `vault login token`

### Consul
* `http://localhost:8500/ui/localhost/kv`
* create `config/`
    * create `spring-boot-8080/`
        * create `cloud.hello` add some nice greeting
    * create `spring-boot-8081/`
        * create `cloud.hello` add some nice greeting

### The spring App(s)
- start spring-boot-app-1 (8080) and/or spring-boot-app-2 (8081) (see RunConfigs)
- services show up `http://localhost:8500/ui/localhost/services`

#### Endpoints
- `/hello` SSE Endpoint value of "cloud.hello"
- `/events` SSE Endpoint of all refresh event
- `/service` SSE Endpoint of all services + ui