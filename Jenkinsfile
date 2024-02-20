pipeline {
  agent any
  stages {
    stage('Start Grid') {
      steps {
        sh 'docker-compose -f grid.yaml up -d'
      }
    }

    stage('Run test') {
      agent {
        docker {
          image 'maven:3.9.6-eclipse-temurin-17'
        }
      }
      steps {
        sh 'mvn clean test'
      }
    }

  }
  post {
    always {
      sh 'docker-compose -f grid.yaml down'
    }

  }
}
