pipeline{
    agent any
    stages{
        stage("getting code") {
            steps {
                git url: 'https://github.com/YoussefJL/TP2Devops.git', branch: 'master',
                credentialsId: 'github-credentials' //jenkins-github-creds
                sh "ls -ltr"   }
        } 
            stage("build de l'application"){
            steps {                
                script {
                    echo "======== executing ========"    
                        sh "mvn clean package"} }
                    } 
         stage("creation de image"){
            steps {                
                script {
                    echo "======== executing ========"     
                        sh "pwd"
                        sh "ls"
                        sh "docker build -t springapp ."}     }
                    }
        stage("push to docker hub") {
            steps {                
                script {
                    echo "======== executing ========"
                        echo "push to hub"
                        withDockerRegistry(credentialsId: 'docker', toolName: 'docker'){
                        sh "docker tag springapp youssefjouili33/spring-app:springapp"
                        sh "docker push youssefjouili33/spring-app:springapp"
                        }
                         }          }
                    }   
        stage("Test"){
            steps {                
                script {
                    echo "======== executing ========"     
                        sh "mvn test"}     }
                    }           
                }

            post{
                success{
                    echo "======== Pipeline is done successfully ========"
                }
                failure{
                    echo "======== Pipeline execution failed ========"
                }
            }
             
        }        
  
