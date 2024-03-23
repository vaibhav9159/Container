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
            def suiteXmlFilePath = 'src/test/resources/testrunner/testng.xml'
            def dockerCommand = """
                docker run --name apitesting${BUILD_NUMBER} \
                -v \
                vaibhavs07/api:latest \
                /bin/bash -c "mvn test -Dsurefire.suiteXmlFiles=${suiteXmlFilePath}"
            """
            
            def exitCode = sh(script: dockerCommand, returnStatus: true)
            
            if (exitCode != 0) {
                currentBuild.result = 'FAILURE'
            }
           
        }
    }
}



        
         

         
    }
}