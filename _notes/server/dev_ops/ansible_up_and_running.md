Ansible Up and Running
====

### Chapter 1 Introduction

1. idempotence compare with shell script

2. Vagrant with ansible

   ``` $ ansible testserver -b -m service -a "name=nginx \ state=restarted" ```

   -b : get root
   -m : command
   -a : params

   ``` $ vagrant init ubuntu/trusty64 ```

   ``` $ vagrant up ```

   ` $ vagrant destroy --force `
   
   ` $ vagrant ssh-config `

   ` $ for i in `vagrant global-status | grep virtualbox | awk '{ print $1 }'` ; do vagrant destroy $i ; done `

### Chapter 2 Playbooks

1. SSL is an older protocol that was used to secure communications between browsers and web servers, and it has been superseded by a newer protocol named TLS. Although many continue to use the term SSL to refer to the current secure pro‐ tocol, in this book, I use the more accurate TLS.

2. Tradition

   These typically use yes and no when passing arguments to modules (since that’s consistent with the module documentation), and True and False elsewhere in playbooks.

3. ansible-vault for encryption

   [ansible-vault](https://docs.ansible.com/ansible/2.4/vault.html)

4. become

   If true, Ansible will run every task by becoming (by default) the root user. This is useful when managing Ubuntu servers, since by default you cannot SSH as the root user.   

5. modules
   
   - apt
   - copy
   - file
   - service
   - template
   - command
   - debug
   - add_host
   - group_by

   ` $ ansible-doc service `

6. generate tls files for localhost

   ```
   $ openssl req -x509 -nodes -days 3650 -newkey rsa:2048 \
        -subj /CN=localhost \
        -keyout files/nginx.key -out files/nginx.crt
   ```

7. Handlers usually run after all of the tasks are run at the end of the play. They run only once, even if they are notified multiple times. If a play contains multiple handlers, the handlers always run in the order that they are defined in the handlers section, not the notification order.   

The official Ansible docs mention that the only common uses for handlers are for restarting services and for reboots. Personally, I’ve always used them only for restart‐ ing services. 

8. ansible best practice

   [Best Practices](http://docs.ansible.com/ansible/latest/playbooks_best_practices.html)

9. ssh 

   ```
   [ssh_connection]
   ssh_args = -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -o IdentitiesOnly=yes
   ```   

### Chapter 3 Inventory

1. Or, if you’re managing your own servers and are using an automated provisioning system such as Cobbler or Ubuntu Metal as a Service (MAAS), then your provisioning system is already keeping track of your servers. 

2. If the inventory file is marked executable, Ansible will assume it is a dynamic inven‐ tory script and will execute the file instead of reading it.

   ` $ chmod +x dynamic.py `

   An Ansible dynamic inventory script must support two command-line flags:

   ` --host=<hostname> for showing host details `

   ` --list for listing groups `   

   ` $ ./dynamic.py --host=vagrant2 `

3. You can grab these by going to the [Ansible GitHub](https://github.com/ansible/ansible) repo and browsing to the contrib/inventory directory.

4. if any new hosts are added while the playbook is executing, Ansible won’t see them.

5. [using-vagrant-docker-machine-together](https://blog.scottlowe.org/2015/08/04/using-vagrant-docker-machine-together/)

6. [Exploring Performance of etcd, Zookeeper and Consul Consistent Key-value Datastores](https://coreos.com/blog/performance-of-etcd.html)

7. [Go lang](https://golang.org/)

### Chapter 4 Variables and Facts

1. Sometimes it’s useful to do something with the output of a failed task. However, if the task fails, Ansible will stop executing tasks for the failed host. We can use the ignore_errors clause.

### Chapter 6 

1. List tasks

   ```
   $ ansible-playbook --list-tasks mezzanine.yml
   ```

2. ansible_env fact

3. Query the local cache to see what version it knows about

   ```
   $ apt-cache policy libssl-dev
   ```   

   On the command line, the way to bring the local apt cache up-to-date is to run apt- get update. When using the apt Ansible module, the way to bring the local apt cache up-to-date is to pass the `update_cache=yes` argument when invoking the module.

   we can avoid paying the cache update penalty by using the `cache_valid_time` argument to the module. This instructs to update the cache only if it’s older than a certain threshold.

4. To enable agent forwarding, add the following to your ansible.cfg:

   [SSH agent forwarding can be used to make deploying to a server simple. It allows you to use your local SSH keys instead of leaving keys (without passphrases!) sitting on your server.](https://developer.github.com/v3/guides/using-ssh-agent-forwarding/)

   ```
   [ssh_connection]
   ssh_args = -o ControlMaster=auto -o ControlPersist=60s -o ForwardAgent=yes
   ```   

   You can verify that agent forwarding is working by using Ansible to list the known keys:

   ```
   $ ansible web -a "ssh-add -l"
   ```

5. accept_hostkey, which is related to host-key checking.

   The ControlMaster and ControlPersist settings are needed for a performance opti‐ mization called SSH multiplexing. They are on by default, but if you override the ssh_args variable, then you need to explicitly specify them or you will disable this performance boost.

6. If you have an existing virtualenv with the packages installed, you can use the pip freeze command to print out a list of installed packages. 

   ```
   $ pip freeze > requirements.txt
   ```

7. Note that the root account does not have administrative privileges in Postgres by default, so in the playbook, we need to become the Postgres user in order to perform administrative tasks, such as creating users and databases.

8. However, if we want to create a DNS name that resolves to a particular IP address, there’s a convenient service called xip.io, provided free of charge by Basecamp, that we can use so that we don’t have to avoid creating our own DNS records. If AAA.BBB.CCC.DDD is an IP address, the DNS entry AAA.BBB.CCC.DDD.xip.io will resolve to AAA.BBB.CCC.DDD.

Alternatively, you can simply add entries to the /etc/ hosts file on your local machine, which also works when you’re offline.

9. In most cases, if we needed some custom Python code, I’d write a custom Ansible module. However, as far as I know, Ansible doesn’t let you execute a module in the context of a virtualenv, so that’s out.

10. [supervisor with django and gunicorn](http://agiliq.com/blog/2014/05/supervisor-with-django-and-gunicorn/)

### Chapter 7

1. When Ansible first introduced support for roles, there was only one place to define role variables, in vars/main.yml. Variables defined in this location have a higher precedence than those defined in the vars section of a play, which meant you couldn’t override the variable unless you explicitly passed it as an argument to the role.

Ansible later introduced the notion of default role variables that go in defaults/ main.yml. This type of variable is defined in a role, but has a low precedence, so it will be overridden if another variable with the same name is defined in the playbook.

If you think you might want to change the value of a variable in a role, use a default variable. If you don’t want it to change, use a regular variable.

2. Creating Role Files and Directories with ansible-galaxy

   Its primary purpose is to download roles that have been shared by the Ansi‐ ble community (more on that later in the chapter). 

   ```
   $ ansible-galaxy init playbooks/roles web
   ```

3. NTP stands for Network Time Protocol, used for synchronizing clocks.

   ```
   dependencies:
     - { role: web }
     - { role: memcached }
   ```

4. https://galaxy.ansible.com/

### Chapter 8

1. `failed_when: False` clause so that the execution doesn’t stop even if the module returns failure.   

   `changed_when`

2. Ansible has a feature called lookups that allows you to read in configuration data from various sources and then use that data in your playbooks and template.

   Ansible has a feature called lookups that allows you to read in configuration data from various sources and then use that data in your playbooks and template.

3. More Complicated Loops

   `with_items`
   `with_lines`      

4. Error Handling with blocks

5. Vault
  
   `$ ansible-vault encrypt secrets.yml`   

   `$ ansible-playbook mezzanine.yml --ask-vault-pass`

   `$ ansible-playbook mezzanine --vault-password-file ~/password.txt`

### Chapter 9

### Chapter 10

### Chapter 11

### Chapter 12

### Chapter 13

### Chapter 14

1. classless interdomain routing (CIDR) notation














