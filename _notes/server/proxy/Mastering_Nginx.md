Mastering Nginx
======

### Chapter 1 Installing

### Chapter 2 Configuration

1. NGINX global con guration parameters: A con guration  le can be easily tested by calling NGINX as follows:

   $ nginx -t -c <path-to-nginx.conf>

2. HTTP server section
   
   - Client directives
   
   - File I/O directives

   - Hash directives

   - Socket directives

3. The virtual server section

4. Locations modifier

   - = | Use exact match and terminate search
   - ~ | Case-sensitive regular expression matching.
   - ~* | Case-insensitive regular expression matching.
   - ^~ | Stops processing before regular expressions are checked for a match of this location's string, if it's the most specific match. Note that this is not a regular expression match – its purpose is to preempt regular expression matching.
   
### Chapter 3 Mail module

1. For each proxied connection, NGINX opens a new connection to the mail server. Each of these connections requires a  le descriptor and per mail server IP/port combination, a new TCP port from the ephemeral port range (see the following explanation).

$ ulimit -n ; check the limit of file descriptor

> [set ulimit on ubuntu](http://posidev.com/blog/2009/06/04/set-ulimit-parameters-on-ubuntu/)

First tune the maximum number of open  le descriptors at the operating system level, either for just the user that NGINX runs as or globally. Then, set the worker_rlimit_nofile directive to the new value in the main context of the nginx.conf  le.

If you observe a connection limit due to exhaustion of available TCP ports, you will need to increase the ephemeral port range. This is the range of TCP ports which your operating system maintains for outgoing connections. It can default to as few as 5000, but is typically set to a range of 16384 ports. 

A good description of how to increase this range for various operating systems is provided at http://www.ncftp.com/ ncftpd/doc/misc/ephemeral_ports.html.

### Chapter 4 Reverse Proxy

1. Due to the nature of a reverse proxy, the upstream server doesn't obtain information directly from the client. Some of this information, such as the client's real IP address, is important for debugging purposes, as well as tracking requests. This information may be passed to the upstream server in the form of headers.

2. The client_max_body_size directive, while not strictly a proxy module directive, is mentioned here because of its relevance to proxy con gurations. If this value is set too low, uploaded  les will not make it to the upstream server. When setting this directive, keep in mind that  les uploaded via a web form will usually have a larger  le size than that shown in the  lesystem.

3. Keepalive connections

NGINX need only negotiate the TCP handshake for the initial 32 connections per worker, and will then keep these connections open by not sending a Connection header with the close token. With proxy_http_version, we specify that we'd like to speak HTTP/1.1 with the upstream server. We also clear the contents of the Connection header with proxy_set_header, so that we are not proxying the client connection properties directly.

4. If we were to switch load-balancing algorithms from the default round-robin to either ip_hash or least_conn, we would need to specify this before using the keepalive directive.

(least_conn ) If the upstream servers do not all have the same processing power, this can be indicated using the weight parameter to the server directive. 

5. Load balancer for docker

> [Load balancer for docker](https://medium.com/@lherrera/poor-mans-load-balancing-with-docker-2be014983e5)

   - longest match
   - round-robin

6. Memcache

The memcached NGINX module (enabled by default) is responsible for communicating with a memcached daemon. As such, there is no direct communication between the client and the memcached daemon; that is, NGINX does not act as a reverse-proxy in this sense. The memcached module enables NGINX to speak the memcached protocol, so that a key lookup can be done before a request is passed to an application server

```
location / {
set $memcached_key "$uri?$args"; 
memcached_pass memcaches; 
error_page 404 = @appserver;
}
```  

7. FastCGI

Using a FastCGI server is a popular way to run PHP applications behind an NGINX server. The fastcgi module is compiled in by default, and is activated with the fastcgi_pass directive. This enables NGINX to speak the FastCGI protocol with one or more upstream servers. 

8. SCGI

NGINX can also speak the SCGI protocol by using its built-in scgi module. The principle is the same as for the fastcgi module. NGINX communicates with an upstream server indicated with the scgi_pass directive.

9. uWSGI

The uWSGI protocol has been very popular with Python developers. NGINX provides support for connecting to a Python-based upstream server through its uwsgi module. The con guration is similar to the fastcgi module, using the uwsgi_pass directive instead to indicate an upstream server.

10. try_files simply doesn't work when an if directive is present in the same location.

if creates an implicit location with its own content handler; in this case, the proxy module. So the outer content handler, where try_files is registered, won't ever get invoked.

11. error_page 500 502 503 504 = @fallback;

The "=" notation shown in the preceding error_page line is used to indicate that we want to return the status code resulting from the last parameter; in this case, the @fallback location.

12. NGINX can also supply an error_page for error codes 400 or greater, when the proxy_intercept_errors directive is set to on.

13. Determining the client's real IP address

proxy_set_header X-Real-IP $remote_addr;
proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

### Chapter 5 Reverse Proxy Advanced Topics

1. Advanced Features

   * NGINX can act as an SSL terminator as well as provide additional access lists and restrictions based on various client attributes.
     ```
     $ allow all/IP;
     $ deny all/IP;
     ```
     

    * Performance of an application may be enhanced through the use of a reverse proxy in several ways. 

      - The reverse proxy can cache and compress content before delivering it out to the client. 

      - NGINX as a reverse proxy can handle more concurrent client connections than a typical application server. 

      - Certain architectures con gure NGINX to serve static content from a local disk cache, passing only dynamic requests to the upstream server to handle. 

      - Clients can keep their connections to NGINX alive, while NGINX terminates the ones to the upstream servers immediately, thus freeing resources on those upstream servers.

2. Security through separation

   - 2.1 The ssl_session_cache directive is set to shared so that all worker processes can bene t from the expensive SSL negotiation that has already been done once per client. 

   - 2.2 Then it is just a matter of specifying the certi cate and key for this host. Note that the permissions of this key  le should be set such that only the master process may read it. 

   - 2.3 It is also possible to encrypt the traf c between the reverse proxy and the upstream server:

       ```
       proxy_pass https://upstream;
       ```

   - A valid client SSL certi cate is one which has been signed by a recognized Certi cate Authority, has a validity date in the future, and has not been revoked:    

3. $ server 10.0.40.10 weight 10; # add weight for reverse proxy server
   $ server 10.0.40.30 down; # mark the server as down inside upstream server

4. the upstream server may in uence buffering by setting the X-Accel-Buffering header. The default value of this header is yes, meaning that responses will be buffered. Setting the value to no is useful for Comet and HTTP streaming applications, where it is important to not buffer the response.

5. calculate how many connections Nginx can handle simultaneously:

   ```
   Eight 4 KB buffers is 32,768 bytes (8 * 4 * 1024) per active connection. (proxy_buffers)

   The 768 MB we allocated to NGINX is 805,306,368 bytes (768 * 1024 * 1024). (On a typical 1 GB machine, where only NGINX runs, most of the memory can be dedicated to its use. Some will be used by the operating system for the  lesystem cache and other needs)

   Dividing the two, we come up with 805306368 / 32768 = 24576 active connections.
   ```

6. Store

   If you are serving large, static  les that will never change, that is, there is no reason to expire the entries, then NGINX offers something called a store to help serve these  les faster.

7. Compressing with GZip

### Chapter 6 The NGINX HTTP Server

1. NGINX's architecture

   - The NGINX master process is responsible for reading the con guration, handling sockets, spawning workers, opening log  les, and compiling embedded Perl scripts. The master process is the one that responds to administrative requests via signals.

   - The NGINX worker process runs in a tight event loop to handle incoming connections. Each NGINX module is built into the worker, so that any request processing,  ltering, handling of proxy connections, and much more is done within the worker process. Due to this worker model, the operating system can handle each process separately and schedule the processes to run optimally on each processor core. If there are any processes that would block a worker, such as disk I/O, more workers than cores can be con gured to handle the load.

   - There are also a small number of helper processes that the NGINX master process spawns to handle dedicated tasks. Among these are the cache loader and cache manager processes. 

2. NGINX reference: [nginx](http://www.aosabook.org/en/nginx.html)   
   - Although the situation with sending content to a slow client might be, to some extent, improved by increasing the size of operating system kernel socket buffers, it's not a general solution to the problem and can have undesirable side effects.

   -  It also allows integrating directly with memcached/Redis or other "NoSQL" solutions, to boost performance when serving a large number of concurrent users.   

   - The only situation where nginx can still block is when there's not enough disk storage performance for a worker process.

   - In computer science, thrashing occurs when a computer's virtual memory subsystem is in a constant state of paging, rapidly exchanging data in memory for data on disk, to the exclusion of most application-level processing.[1] This causes the performance of the computer to degrade or collapse. The situation may continue indefinitely until the underlying cause is addressed.
    
   The term is also used for various similar phenomena, particularly movement between other levels of the memory hierarchy, where a process progresses slowly because significant time is being spent acquiring resources.

3. Nginx worker configuration

   With some disk use and CPU load patterns, the number of nginx workers should be adjusted. The rules are somewhat basic here, and system administrators should try a couple of configurations for their workloads. General recommendations might be the following: if the load pattern is CPU intensive—for instance, handling a lot of TCP/IP, doing SSL, or compression—the number of nginx workers should match the number of CPU cores; if the load is mostly disk I/O bound—for instance, serving different sets of content from storage, or heavy proxying—the number of workers might be one and a half to two times the number of cores. Some engineers choose the number of workers based on the number of individual storage units instead, though efficiency of this approach depends on the type and configuration of disk storage.

4. Using limits to prevent abuse

5. Restricting access

6. Drupal (http://drupal.org) is a popular open source content management platform.

### Chapter 7 NGINX for the Developer

### Chapter 8 Troubleshooting Techniques

1. As with NGINX, there are two major areas where we can initially look for performance problems:  le descriptor limits and network limits.

   - File descriptor 

   - Network buffer

   - Network port range

2. Performance problems

   - One of the most important values relating to network performance is the size of the listen queue for new TCP connections.    

   - The next parameter to change is the size of the send and receive buffers.

3. Using the Stub Status module

### Appendix B Rewrite Rule Guide

### Appendix D Network Tunings (Solaris)

    [Linux](http://opensourceforu.com/2016/10/network-performance-monitoring/)
    [Linux Tools](https://www.ostechnix.com/collection-utilities-simplify-linux-network-troubleshooting-performance-tuning/)
























































