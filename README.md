# Android Lab 4
**Software Design & Development**

Manual Deserialization

The [Instructions](Lab4_Deserialization.pdf) will guide you through the lab.


Recap on `git` commands:

`git clone url` copies an online (remote) repository to your machine

`git checkout branchname` switches to an **existing** branch

`git checkout -b branchname` creates a **new** branch, and switches to it

`git add .` adds all changed files to the ready-to-commit stage

`git commit -m "message"` commits all staged files

`git push origin branchname` pushes all new commits to the remote repository

### Saving your work:

- `git add .` stages all your changes
- `git commit -m "work in progress"` saves your changes
- `git push origin branchname` uploads your changes to the remote repository

### Continuing your work

If you are working on the same computer (and no one deleted your work!), you can just keep working.

If you are working on a different computer:
- `git clone url` to clone the repository fresh
If you are working on a computer that already has the project, but it's old:
- `git pull` to update an existing repository

`git checkout branchname` to switch to your existing branch  
(note we are __not__ using `-b` in this command)

You can now continue where you left off.

### Other useful git commands

`git branch` displays your branches, and which one you're on

`git status` will show you which files are add/changed/deleted

`git log` will show you the history of commits to the current branch

