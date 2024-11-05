FROM bellsoft/liberica-openjdk-alpine:17.0.13
#install curl and jq
RUN apk add curl jq
# workspace
WORKDIR /home/selenium-docker
# Add the required files
# already set workdir so we can use "."
ADD /target/docker-resources        ./
ADD runner.sh                       runner.sh
#Env vars
#Browser
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT

# WINDOWS NOT RUNNING runner.sh
RUN dos2unix runner.sh
# start the runner.sh
ENTRYPOINT sh runner.sh

#- JSONArgsRecommended: JSON arguments recommended for ENTRYPOINT
 #to prevent unintended behavior related to OS signals