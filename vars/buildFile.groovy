#!/usr/bin/env groovy

def call(def buildTool) {
	
	if( ${buildToll}==snap )
	{
		echo "snapsnot_build"
		def mvnHome = tool "${buildTool}";
	sh "${mvnHome}/bin/mvn "+"${datas.mavenGoals}"+" -Dbuild.number=${BUILD_NUMBER}"
	}
	else
	{
		echo "release_build"
		def mvnHome = tool "${buildTool}";
	sh "${mvnHome}/bin/mvn "+"${datas.mavenGoals}"+" -Dbuild.number=${BUILD_NUMBER}"
	}
}
		
}


