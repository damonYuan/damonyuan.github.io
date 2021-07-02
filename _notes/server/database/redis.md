# install and start
https://medium.com/@petehouston/install-and-config-redis-on-mac-os-x-via-homebrew-eb8df9a4f298

1. Launch when start up
$ ln -sfv /usr/local/opt/redis/*.plist ~/Library/LaunchAgents

2. start and stop in background
$ launchctl load ~/Library/LaunchAgents/homebrew.mxcl.redis.plist
$ launchctl unload ~/Library/LaunchAgents/homebrew.mxcl.redis.plist

3. start in current terminal 
$ redis-server /usr/local/etc/redis.conf

4. location of config file
/usr/local/etc/redis.conf

5. uninstall 
$ brew uninstall redis
$ rm ~/Library/LaunchAgents/homebrew.mxcl.redis.plist

6. $ brew info redis

7. check if redis is running
$ redis-cli ping

----

# Seven db in Seven weeks

1. cluster mode and Master-Slave mode

2. Benchmark for slow queries

   $ redis-benchmark -n 100000