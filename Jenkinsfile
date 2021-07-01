pipeline {
    agent any
    tools { 
        maven 'MAVEN_HOME' 
        jdk 'JAVA_HOME' 
    }
    stages {
        stage ('Compile Stage') {

            steps {
                    cd CPbackEnd
                    bat "mvn clean compile"

            }
        }

        stage ('Testing Stage') {

            steps {
                    cd CPbackEnd
                    bat "mvn test"

            }
        }


        /*stage ('Deployment Stage') {
            steps {

                    bat "mvn deploy"

            }
        }*/
    }
}
