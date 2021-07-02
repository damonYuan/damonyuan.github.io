Docker
======

# Docker machine

1. Set the default docker-machine: 
   The new aws-sandbox instance is running, and it is the active host as indicated by the asterisk (*). When you create a new machine, your command shell automatically connects to it. If for some reason your new machine is not the active host, you’ll need to run docker-machine env aws-sandbox, followed by eval $(docker-machine env aws-sandbox) to connect to it.

   $unset ${!DOCKER_*} if you want to disconnect

2. Create machine in aws ec2
   $ docker-machine create -d amazonec2 --amazonec2-vpc-id vpc-f177c795 --amazonec2-region ap-southeast-1 --amazonec2-zone b --amazonec2-instance-type t2.small --amazonec2-subnet-id subnet-347b1a42 --amazonec2-security-group docker_machine_web aws-sandbox

   TODO: Cannot connect to the Docker daemon. Is the docker daemon running on this host?
   TODO: Error getting SSH command to check if the daemon is up: Something went wrong running an SSH command!

# Swarm mode

# Docker Composer

# Docker Engine

1. Do not pass a service x start command to a detached container. For example, this command attempts to start the nginx service.

    $ docker run -d -p 80:80 my_image service nginx start
    This succeeds in starting the nginx service inside the container. However, it fails the detached container paradigm in that, the root process (service nginx start) returns and the detached container stops as designed. As a result, the nginx service is started but could not be used. Instead, to start a process such as the nginx web server do the following:

    $ docker run -d -p 80:80 my_image nginx -g 'daemon off;'

2. Docker Toolbox and Docker for Mac coexistence
   You can use Docker for Mac and Docker Toolbox together on the same machine. When you want to use Docker for Mac, make sure all DOCKER environment variables are unset. You can do this in bash with unset ${!DOCKER_*}. When you want to use one of the VirtualBox VMs you have set with docker-machine, just run a eval $(docker-machine env default) (or the name of the machine you want to target). This will switch the current command shell to talk to the specified Toolbox machine.

3. show docker container id
   $ docker ps -a --no-trunc -q

4. aws ECR
To install the AWS CLI and Docker and for more information on the steps below, visit the ECR documentation page.
1) Retrieve the docker login command that you can use to authenticate your Docker client to your registry:
aws ecr get-login --region us-east-1

2) Run the docker login command that was returned in the previous step.
3) Build your Docker image using the following command. For information on building a Docker file from scratch see the instructions here. You can skip this step if your image is already built:
docker build -t test .

4) After the build completes, tag your image so you can push the image to this repository:
docker tag test:latest 344940087920.dkr.ecr.us-east-1.amazonaws.com/test:latest

5) Run the following command to push this image to your newly created AWS repository:
docker push 344940087920.dkr.ecr.us-east-1.amazonaws.com/test:latest

5. start when reboot
$ sudo systemctl enable docker

6. cannot upload image to docker Wordpress behind a niginx proxy
client_max_body_size 200M; in nginx.cnf http

7. commands

// docker stop all
$ docker stop $(docker ps -a -q)
// docker remove all
$ docker rm $(docker ps -a -q) 

8. docker shell

docker exec -it <container id> /bin/sh

9. docker init script 

https://get.docker.com/

10. docker tool for monitor

$ brew install ctop
https://github.com/portainer/portainer
https://github.com/google/cadvisor & https://github.com/kubernetes/heapster

11. debug rails in docker

https://stackoverflow.com/questions/35211638/how-to-debug-a-rails-app-in-docker-with-pry

12. add docker to sudoer

* $ sudo groupadd docker
* $ sudo gpasswd -a $USER docker
* Either do a newgrp docker or log out/in to activate the changes to groups.

13. docker restart policy: https://blog.codeship.com/ensuring-containers-are-always-running-with-dockers-restart-policy/

14. command notes

# 重启docker
$ sudo systemctl restart docker
# 对应的旧的命令，其实现在还是支持，效果和上一句一样。
$ sudo service docker restart
# 设置开机启动
$ sudo systemctl enable docker

15. test docker speed

https://jtway.co/docker-network-performance-b95bce32b4b9

use `iperf3` command

16. docker network (https://docs.docker.com/v1.7/articles/networking/#binding-ports)

1. configure the docker0's mtu override the maximum packet length on docker0 (seems not work?????)
   - https://rahulait.wordpress.com/2016/02/28/modifying-default-mtu-for-docker-containers/
   - https://docs.docker.com/engine/userguide/networking/default_network/custom-docker0/
2. Display bridge info: sudo brctl show (sudo apt-get install bridge-utils)
3. --userland-proxy=false and customize the route for performance reasons
4. Remember that the Docker host will not be willing to forward container packets out on to the Internet unless its ip_forward system setting is 1 

17. linux tcp tuning for docker : https://www.cyberciti.biz/faq/linux-tcp-tuning/

18. docker memory: http://blog.opskumu.com/docker-memory-limit.html

