---
title:  "SpringCloud/Netflix vs Kubernetes"
description: "Comparison between SpringCloud/Netflix and Kubernetes"
hidden: true
date: 2019-01-12 15:04:23
categories: [Tech]
tags: [SpringCloud Netflix Kubernetes Microservice]
---

# Development patterns

## Configuration Management

Spring Cloud Config vs Spring Cloud Kubernetes Config

## Async Messaging

# Routing patterns

## Service Discovery

Netflix Eureka vs DNS

## API Gateway


# Client resiliency patterns

# Build deployment patterns

# Logging patterns

# Security patterns

----

## Spring Cloud

- Eureaka

## Kubernetes

- api server ??
- dns
- how to do service registration in k8s

## docker

- dns?

----

https://www.quora.com/Does-Kubernetes-perform-a-client-side-load-balancing-or-a-server-side


### Spring Cloud

- client side load balancing (Ribbon), HTTP layer (layer 7)
- circuit breaker pattern (Hystrix)

  fail fast to prevent calling a problematic service continuously.

- fallback pattern (Hystrix)

  provide a option when something bad happens.

- bulkhead pattern (Hystrix)

  protect the resource by isolating the threads a type of service call can consume.

### K8S

- communication between pods
  - overlay network
  - veth0 on pod provided by pause container and shared among other containers
  - bridge (cbr0 on node)
  - eth0 on node
  - top route
- communication between services
  - service name is resolved using DNS and the service's Cluster IP will be returned
  - kube-proxy, run on every node as daemonset, netfilter rules are updated accordingly, TCP/UDP layer (layer 3)
  - kubelet to check the health of a pod, run on every node
  - api server to update kube-proxy and receive events from kubelets
  - cluster IP
  - difference with docker swarm
- pod and bridge network (10.0.0.0/14); eth0 and top route network (10.100.0.0/24); Service cloud IP network (10.3.240.0/20)  
- how to implement circuit breaker pattern?
- how to implement fallback pattern?
- how to implement bulkhead pattern?

## docker

- docker composer
- docker swarm

----


### Spring Cloud

- gateway with zuul
  - route
  - filters
  - single point of failure?

### K8S

> https://medium.com/google-cloud/kubernetes-nodeport-vs-loadbalancer-vs-ingress-when-should-i-use-what-922f010849e0

- ClusterIP with kubernetes proxy

   The cluster IP of a service is only reachable from a node’s ethernet interface.

- NodePort (30000–32767)
- LoadBalancer

  LoadBalancer cannot handle mixed protocols like UDP and TCP while NodePorts can.

- ingress

  It seems pretty clear that any mechanism we use to allow external clients to call into our pods has to make use of this same routing infrastructure. That is, those external clients have to end up calling the cluster IP and port, because that is the “front end” for all the machinery we’ve talked about up to this point that makes it possible for us not to care where a pod is running at any given time.

  The implementation follows a basic kubernetes pattern: a resource type and a controller to manage that type.

  - Type: Ingress
  - Controller: There are ingress controller implementations for GCE load balancers, AWS elastic load balancers, and for popular proxies such as nginx and haproxy.
  - Note that mixing Ingress resources with LoadBalancer services can cause subtle issues in some environments.
  - HostPort:ContainerPort,  In the early days of the platform before the addition of DaemonSets and StatefulSets this was a trick that could be used to make sure only one container of a type ran on any given node.
  - HostNetwork property of a pod. When set to true this has the same effect as the --network=host argument to docker run.  

## docker

- container expose port
- service expose port
