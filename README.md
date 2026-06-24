# NAGP 2026 — Kubernetes, DevOps & FinOps Assignment

A two-tier application deployed on **Azure Kubernetes Service (AKS)**: a Spring Boot
**Service/API tier** that reads records from a **MySQL database tier** over an internal
Service, exposed externally through an NGINX **Ingress**.

## Links

| What | URL |
|------|-----|
| Code repository | `https://github.com/ekta182/k8s-devops-nagp-assignment` |
| Docker Hub image | `https://hub.docker.com/r/ekta182/k8s-finops-api` |
| Live Service API (records) | `http://4.247.243.117/api/employees` |

## Architecture


            Internet
               │
        ┌──────▼───────┐   ingressClassName: nginx
        │   Ingress    │   (Azure public LoadBalancer)
        └──────┬───────┘
        ┌──────▼───────┐   Service (ClusterIP :80 -> 8080)
        │   api svc    │
        └──────┬───────┘
   ┌────┬──────┼──────┬────┐   Deployment: 4 replicas + HPA
   ▼    ▼      ▼      ▼    ▼   Spring Boot, HikariCP pool, Actuator probes
  api  api    api    api ...
        │  DB_HOST=mysql (Service DNS, never a pod IP)
        ▼
   ┌──────────┐   headless Service (ClusterIP: None), internal only
   │  mysql   │   StatefulSet: 1 replica + PVC (managed-csi)
   └────┬─────┘
        ▼
   PersistentVolume (data survives pod deletion)


## Repository layout


app/           Spring Boot source + multi-stage Dockerfile
db/init/        seed.sql (schema + 8 records)  [same SQL lives in the ConfigMap]
k8s/           all Kubernetes manifests 
docs/          comprehensive documentation (.docx)

