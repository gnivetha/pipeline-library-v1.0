def call(def readpom) {

def pom = new XmlSlurper().parse("pom.xml")
 
pom.dependencies.dependency.each { dependency ->
        println "!path \${mavenRepo}/${dependency.groupId}/${dependency.artifact
Id}/${dependency.version}/${dependency.artifactId}-${dependency.version}.jar"
}
}
