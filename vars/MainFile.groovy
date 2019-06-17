#!/usr/bin/env groovy

def call()
{
	pipeline {
    agent any
	
	options {
    skipDefaultCheckout(true)
	}
    stages {
    
	    
	    
	    
	    stage('Checkout') {
		    
		    
			steps {
				scmFile("master","https://github.com/gnivetha/maven-project.git")
			}
		}
//	    stage('Read YAML file') {
 //       steps {
//		echo "222222222222222222222222222222222222"
  //          script{ datas = readYaml (file: 'env.yml') }
//		echo datas.branch.toString()
//		echo "333333333333333333333333333333333333"
  //                }
  //  }
	    stage('Read YAML file') {
        		steps {
            			script{ datas = readYaml (file: 'env.yml') }
                  	}
    		} 
	    stage('Build') {
			steps {
				echo "4444444444444444444444444444444444"
				echo datas.buildTool.toString()
				buildFile(datas)
				echo "5555555555555555555555555555555555555"
			}
		}
	    stage('Upload Artifacts') {
			steps {
				uploadArtifactory(datas)
			}
		}
	    stage('Download Artifacts') {
			steps {
				downloadArtifactory(datas)
			}
		}
	    stage('Publish Junit Reports') {
			steps {
				junitFile()
			}
		}

	}

}
}
