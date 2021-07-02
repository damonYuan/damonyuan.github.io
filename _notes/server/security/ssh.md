ssh
====

1. ssh config example

```
#IdentitiesOnly=yes

# --- SourceTree Generated ---
Host damonYuan-GitHub
	HostName github.com
	User damonYuan
	PreferredAuthentications publickey
	IdentityFile /Users/damon/.ssh/damonYuan-GitHub
	UseKeychain yes
	AddKeysToAgent yes
# ----------------------------

# --- SourceTree Generated ---
Host damonYuan-Bitbucket
	HostName bitbucket.org
	User damonYuan
	PreferredAuthentications publickey
	IdentityFile /Users/damon/.ssh/damonYuan-Bitbucket
	UseKeychain yes
	AddKeysToAgent yes
# ----------------------------

# --- asterisk ---
Host asterisk-cluster-jp
    HostName 52.199.252.98
    User ubuntu
    IdentityFile ~/.ssh/voip-jp.pem
    IdentitiesOnly yes

# --- asterisk-cluster-staging ---
Host asterisk-cluster-staging
    HostName 52.220.251.73
    User ubuntu
    IdentityFile ~/.ssh/voip-staging.pem
    IdentitiesOnly yes
```

2. SSH reverse tunnel

https://juejin.im/post/59fc55e36fb9a0451b03e7db

ssh -NTf -R 8080:127.0.0.1:8080 username@12.34.56.78

N参数：表示只连接远程主机，不打开远程shell；
T参数：表示不为这个连接分配TTY；
f参数：表示连接成功后，转入后台运行；