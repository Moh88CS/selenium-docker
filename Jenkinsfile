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
            sh "docker build -t=mohamedcs88/selenium ."
          }
        }

    stage('Push Image'){
          steps{
            sh "docker push mohamedcs88/selenium"
          }
        }
  }
}