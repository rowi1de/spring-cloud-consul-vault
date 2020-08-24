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
#### UI
* `http://localhost:8500/ui/localhost/kv`
* create `config/`
    * create `spring-boot-1-8080/`
        * create `cloud.hello` add some nice greeting
    * create `spring-boot-2-8081/`
        * create `cloud.hello` add some nice greeting
#### CLI
*  `consul kv put config/spring-boot/cloud.hello "hello from some app"`        
*  `consul kv put config/spring-boot-8080/cloud.hello "hello from app 1"`
*  `consul kv put config/spring-boot-8081/cloud.hello "hello from app 2"`

        
### Vault
#### UI
* `http://localhost:8200/ui/vault/secrets/secret/list`
* create `spring-boot`
  * create `vault.shared` and add your shared secret
* create `spring-boot`
  * create `vault.own` and add your specific secret
#### CLI
* `vault login -address=http://localhost:8200`
* `vault kv put  -address=http://localhost:8200 secret/application vault.shared="everyone knows"`
* `vault kv put  -address=http://localhost:8200 secret/spring-boot vault.own="My secret"`

### The spring App(s)
- replace vault token
- start spring-boot-app-1 (8080) and/or spring-boot-app-2 (8081) (see RunConfigs)
- services show up `http://localhost:8500/ui/localhost/services`

#### Endpoints
- `/hello` SSE Endpoint value of "cloud.hello"
- `/events` SSE Endpoint of all refresh event
- `/services` SSE Endpoint of all services + ui
- `/secret` Shared Vault Secret

# Notes / TODOs
- All services run in DEV Mode .. don't use in PROD

# CLI Commands:
- `brew install consul && brew install vault`


## AWS Vault IAM/EC2 Auth
- [IAM](https://cloud.spring.io/spring-cloud-vault/reference/html/#vault.config.authentication.awsiam)
- [EC2](https://cloud.spring.io/spring-cloud-vault/reference/html/#vault.config.authentication.awsec2)
- [AWS SSM](https://cloud.spring.io/spring-cloud-vault/reference/html/#vault.config.backends.aws)
