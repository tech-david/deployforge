# Devops Documentation

## Overview
The purpose of this file is to explain our devops processes with intent to automate the build, test, and deploy process.
We will give the steps required to run the Jenkins pipeline and instructions on how to build and deploy a docker container.

## Plugins
- Install the suggested plugins when creating the jenkins server
	- Docker
	- Maven
	- NodeJs
	- BlueOcean
	- Docker Compose Build Step Plugin
	- Groovy

## Global Tool Configuration
- Configure Maven
	-Set name 'Maven3.6.3'
	-Install version 3.6.3
- Configure NodeJs
	-Set name 'NodeJs12.20'
	-Make sure Install Automatically is checked
	-Install version NodeJS 12.20.0
	-Set global npm packages to install to '@angular/cli'
- Docker
	-Set name 'Docker'
	-Make sure Install Automatically is checked
	
## General Configuration
- Make sure githook gets set up inside of repos
- The EC2 requirements is at least 16GB storage space, 2GB memory
- Docker compose command needs to be installed
- In Jenkins configuration make sure Docker Builder has Docker URL unix:///var/run/docker.sock
	- Test connection, modify as needed

# Files required for Docker
- Dockerfile in SpringBoot application folder
- Dockerfile in Angular application folder
- docker-compose.yml in root repo 
- nginx.conf which configures Ngnix web server
- default.conf which sets controller configuration for spring project

## Configuring Pipeline
- Create New Item
- Set name desired
- Select Pipeline
- Click Ok
### Config Options
- Add description
- Choose Discard old builds option 
	- Days to keep builds: 5
	- Max # of builds to keep: 5
- Github hook trigger for GITScm polling option checked
- Pipeline script will be provided in Jenkinsfile, copy content into script section
- Choose Pipeline script as definition
- Review Git Repos and branches to synchronize desired branch
- Click Save

## Configuring Deployment Build to Docker Container

