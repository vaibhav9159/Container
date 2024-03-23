pipeline 
{
    agent any
    
    tools{
    	maven '3.8.6'
        }
        
    environment{
   
        BUILD_NUMBER = "${BUILD_NUMBER}"
   
    }
    

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa done")
            }
        }
             
             
                
                
      stage('Run Docker Image with Regression Tests') {
    steps {
        script {
          
    def exitCode = sh(script:"docker run --name apitesting${BUILD_NUMBER} -e MAVEN_OPTS='-Dsurefire.suiteXmlFiles = src/test/resources/testrunner/testng.xml' vaibhavs07/api:latest", returnStatus: true)
        
            
            if (exitCode != 0) {
                currentBuild.result = 'FAILURE'
            }
           
        }
    }
}



        
         

         
    }
}