pipeline{
  agent any

  stages{
    stage('Build Jar'){
      steps{
        sh "mvn clean package -DskipTests"
      }
    }

    stage('Build Image'){
          steps{
            sh "docker build -t=mohamedcs88/selenium:latest ."
          }
        }

    stage('Push Image'){
          environment{
            DOCKER_HUB = credentials('dockerhub-creds')
          }
          steps{
            //sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}' user safer way below
            sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin' // may not work windows with bat
            sh 'docker push mohamedcs88/selenium:latest'
            sh "docker tag mohamedcs88/selenium:latest mohamedcs88/selenium:${env.BUILD_NUMBER}"
            sh "docker push mohamedcs88/selenium:${env.BUILD_NUMBER}"
          }
        }
  }

  post {
    always {
      sh "docker logout"
    }
  }
}