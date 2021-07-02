Docker Network
====

### http://www.dasblinkenlichten.com/docker-networking-101/

1. use `$ iptables -t nat -L -n` to check the network on host
2. use printenv inside docker container to print the ENV
3. link will create:  ‘/etc/hosts’ file we see that docker created a host entry with the correct IP address for the busybox1 container on busybox2.
4. ICC stands for Inter Container Communication. 
   
   Ubuntu: 

   ```
   Create /etc/docker/daemon.json file and add:
   {
       "icc": false,
       "disable-legacy-registry": true
   }
   systemctl restart docker
   ```

   CentOS:

   /etc/sysconfig/docker

5. check Listening ports:
   
   ```
   netstat -plnt
   ```   

### https://docs.docker.com/v1.7/articles/networking/#binding-ports

1. To supply networking options to the Docker server at startup, use the DOCKER_OPTS variable in the Docker upstart configuration file. For Ubuntu, edit the variable in /etc/default/docker or /etc/sysconfig/docker for CentOS.

2. How can Docker supply each container with a hostname and DNS configuration, without having to build a custom image with the hostname written inside? Its trick is to overlay three crucial /etc files inside the container with virtual files where it can write fresh information. You can see this by running mount inside a container.

3. check system resource usage: systemd-cgtop, top, /proc/meminfo (https://goldmann.pl/blog/2014/09/11/resource-management-in-docker/   )

4. Note: The file change notifier relies on the Linux kernel’s inotify feature. Because this feature is currently incompatible with the overlay filesystem driver, a Docker daemon using “overlay” will not be able to take advantage of the /etc/resolv.conf auto-update feature.

5. iptables simpel tutorial (https://www.howtogeek.com/177621/the-beginners-guide-to-iptables-the-linux-firewall/)

6. 