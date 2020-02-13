pipeline {
    agent any

    stages {
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_6_3') {
                    bat 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    bat 'mvn install'
                }
            }
        }
    }
}