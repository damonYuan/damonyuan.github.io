git_Record
==============

Linux_Record

# init git
  1. $ git init
  2. $ git add .
  3. $ git commit -m "Initial commit"
  4. update the README file
     $ git mv README.rdoc README.md
     $ git commit -a -m "Improve the README"

# git command
  0. $ git status
  1. $ git add -a -> to add all files to staging area
  2. $ git commit -a -m "xxx" -> commit all staged files with message
  3. $ git push origin <branch name>
  4. $ git log -> to see all your commits on that project
  5. add git to github
     $ git remote add origin https://github.com/<username>/xxx_app.git
     $ git push -u origin master -> 
                                    Notes: "Upstream" would refer to the main repo that other people will pulling from. The -u option automatically set that upstream for you, linking your repo to a central one. That way, in the future, Git "knows" where you want to push to and where you want to pull from, so you can use $ git pull or $ git push without argument. 

  6. $ git checkout <branch name>    -> make sure starting on one specific branch
     $ git checkout -b <branck name> -> create a new branch

  3. $ git submodule update


# git default behavious 
  1. $ git config --global push.default matching -> will push all branches locally that have the same name on the remote.(Without regard to your current working branch)
  2. $ git config --global push.default simple -> will only push the current working branch

# git give up locally untracked changess

  $ git checkout . -> all the locally file.  
  $ git clean -df -> give up the changed directory and files

# Delete branch
  
  $ git branch -d the_local_branch (or $ git branch -D the_local_branch -> force delete)
  $ git push origin :the_remote_branch

# .gitkeep file
  Git cannot add a completely empty directory. People who want to track empty directories in Git have created the convention of putting files called ".gitkeep" in these directories.

  .gitignore is also used to list files that should be ignored by Git when looking for untracked files.

# remove a file
  There's a way to tell Git about the removal at the same time using :

  $ git rm public/index.html

# squash a branch's commit
  $ git merge --squash branch_name

# pull request
  $ git co development
  $ git pull origin development
  $ git co -b feature-xxx-pr
  $ git merge --squash feature-xxx
  $ git ci -m "commit msg for the feature"
  $ git push
  // then send PR from feature-xxx-pr br

# $ git reflog
  1. Show all the operation log
  2. find the commit you want and checkout that commit

# $ git branch -d the_local_branch
  $ git push origin :the_remote_branch
  $ git fetch -p (if fail, because of someone else delete the remote branch)

# add submodule
  $ git submodule add <url> <dir>
  eg. $ git submodule add git://github.com/jquery/jquery.git externals/jquery (relative path!!!)
  $ git submodule update --init --recursive

# resolve diff
  $ git mergetool

# Reverting vs. Resetting
  $ git revert <commit>
  It's important to under

# Stash
  $ git stash
  $ git stash list

# git quit Vim
  :wq

# gitignore .idea/workspace.xml
  git rm -f .idea/workspace.xml

# see remote configuration of git
  $ git remote -v

# git workflow
  https://github.com/nvie/gitflow

# ssh -T git@bitbucket.org
  see login info.

# Create a submodule  
  1. git submodule add <submodule link>
  2. Although submodule is a subdirectory in your working directory, Git sees it as a submodule and doesn’t track its contents when you’re not in that directory. Instead, Git sees it as a particular commit from that repository.
  3. 

# Ensure the ssh-agent is running and loaded with your keys
  $ ps -e | grep [s]sh-agent
  $ ssh-add -l
  $ ssh-add ~/.ssh/workid
  $ ssh-add -l

# Find a file
  $ find . -name "adfaf.m"
  $ git log <xxxx>

# git flow
  DO NOT merger branch from each other, which will make the git confused.

  - r-2.4 is checkout form dev, then merge r-2.4 back to dev is okay, but don’t merge dev to r-2.4 again.
  - dev is checkout from master, merge dev to master (actually, is merge r-2.4 to master, cause r-2.4 is checkout from dev) is okay, but don’t merge master to dev.

# git rebase
  $ git rebase --onto target-branch source-branch
  http://makandracards.com/makandra/10173-git-how-to-rebase-your-feature-branch-from-one-branch-to-another

# release
  For release on master, hot fixes -> master, deploy, tag master, merge master into dev

# git flow
  http://nvie.com/img/git-model@2x.png

# markdown
  https://daringfireball.net/projects/markdown/

# To search the commit log (across all branches) for the given text:
  git log --all --grep='Build 0051'

  To search the actual content of commits through a repo's history, use:
  git grep 'Build 0051' $(git rev-list --all)

  Finally, as a last resort in case your commit is dangling and not connected to history at all, you can search the reflog itself with the -g flag (short for --walk-reflogs:
  git log -g --grep='Build 0051'

  git reflog


# .gitattribute
 *.pbxproj binary merge=union

 prevent the file in project is removed from the list.

# If compile issue, delete 

  1. Pods folder
  2. Podfile.lock
  3. .xcworkspace
  4. .xcodeproj pods related things -> General & Build Phases

# git global ignore
  1. $ open ~/.gitignore_global and put the files to be ignore in the file.
  2. $ git config --global core.excludesfile ~/.gitignore_global

# remove sensitive data
  https://help.github.com/articles/remove-sensitive-data/

# git colone into a renamed folder
  $ git clone git://github.com/username/myapp.git code

# git submodule first init:
  $ git submodule update --init submodules