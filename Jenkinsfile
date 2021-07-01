pipeline {
    agent any
    tools { 
        maven 'MAVEN_HOME' 
        jdk 'JAVA_HOME' 
    }
    stages {
        stage ('Compile Stage') {

            steps {
                    bat """ cd /d "${C://Windows//System32//config//systemprofile//AppData//Local//Jenkins//.jenkins//workspace//test//CPbackEnd}" """
                    bat "mvn clean compile"

            }
        }

        stage ('Testing Stage') {

            steps {
                    bat """ cd /d "${C://Windows//System32//config//systemprofile//AppData//Local//Jenkins//.jenkins//workspace//test//CPbackEnd}" """
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
