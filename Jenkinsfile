pipeline {
    agent any  // Use any available agent or node

    tools {
        maven 'Maven_3.9.8'  // Name of the Maven installation from Jenkins global tools
    }

    environment {
        JAVA_HOME = 'C:/Program Files/Java/jdk-17/bin'  // Set the Java version (adjust as needed)
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Cloning the repository...'
                git url: 'https://github.com/Ind20/testng-parallel.git', branch: 'master'
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Building the project with Maven...'
                sh 'mvn clean test -P smoke'  // Clean, compile, run tests, and package the project
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the project...'
                sh 'mvn package'  // Creates the final artifact (e.g., .jar or .war)
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
        always {
            echo 'Cleaning workspace...'
            cleanWs()  // Cleans the workspace after the build
        }
    }
}
