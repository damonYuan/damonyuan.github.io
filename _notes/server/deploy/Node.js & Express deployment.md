deploy for Node.js & Express
============================
a
1. Regions and Endpoints
http://docs.aws.amazon.com/general/latest/gr/rande.html?r=1166

2. ec2
   1. linux: http://www.robert-drummond.com/2013/04/25/a-node-js-application-on-the-amazon-cloud-part-1-installing-node-on-an-ec2-instance/
   2. Ubuntu: http://mattgoo.com/blog/?p=83
   3. install node : http://howtonode.org/how-to-install-nodejs
   4. install mongodb: https://github.com/SIB-Colombia/dataportal-explorer/wiki/How-to-install-node-and-mongodb-on-Amazon-EC2 
                       http://mattgoo.com/blog/?p=106
   5.         official: https://docs.mongodb.org/ecosystem/platforms/amazon-ec2/
              file system: http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html
   6. environment vars: http://www.dowdandassociates.com/blog/content/howto-set-an-environment-variable-in-linux/
   7. monitor: https://keymetrics.io/2015/05/18/getting-started-with-keymetrics-and-pm2/
               https://app.keymetrics.io/#/
   8. pm2 cluster mode: 
      http://pm2.keymetrics.io/docs/usage/cluster-mode/
   9. stateless: 
      http://12factor.net/
   10. ssh: ssh-add -K /path/to/private/key.
   11. pm2 update:
       Install the latest pm2 version : $ npm install pm2@latest -g
       Then update the in-memory PM2 : $ pm2 update
   12. maintainence:
       https://docs.mongodb.org/ecosystem/platforms/amazon-ec2/

   13. EC2 storage: http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html
3. todo: 

   https://medium.com/@mikeybadr/deploying-node-apps-with-aws-914790d431b4#.412cq8wmh
   https://ponyfoo.com/articles/deploying-node-apps-to-aws-using-grunt

4. file transfer: 
   $ scp -i myAmazonKey.pem phpMyAdmin-3.4.5-all-languages.tar.gz ec2-user@mec2-50-17-16-67.compute-1.amazonaws.com:~/.

5. node with mysql

6. install ImageMagick in EC2:
   http://www.imagemagick.org/discourse-server/viewtopic.php?t=24125

7. Web Framework Benchmark: 
   http://www.techempower.com/benchmarks/#section=data-r10&hw=peak&test=db

8. run on port 80: 
   http://stackoverflow.com/questions/16573668/best-practices-when-running-node-js-with-port-80-ubuntu-linode
9. redirect port to 3000:
   https://gist.github.com/kentbrew/776580
10. install mysql in ec2: 
    http://www.somacon.com/p572.php

11. installl node 
    $ sudo apt-get update
    $ sudo apt-get install -y curl apt-transport-https ca-certificates &&
      curl --fail -ssL -o setup-nodejs https://deb.nodesource.com/setup_4.x &&
      sudo bash setup-nodejs &&
      sudo apt-get install -y nodejs build-essential

