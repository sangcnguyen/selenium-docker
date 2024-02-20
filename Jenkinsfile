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
          image '3.9.6-eclipse-temurin-11-alpine'
          args '-v $HOME/.m2:/root/.m2'
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
