#!/user/bin/env groovy
package com.example

class Docker implements Serialziable {

    /* groovylint-disable-next-line FileEndsWithoutNewline */
    def script
    Docker(script) {
        this.script = script
    }
    // Build a docker image from the current directory's Dockerfile and tag it with "
    def buildDockerImage(String imageName) {
        script.echo 'Building docker image'
        script.withCredentials([ script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
        {
                script.sh "docker build -t $imageName"
                script.sh "echo '${script.PASS} docker login -u '${script.USER} --password-stdin"
                script.sh "docker push $imageName"
        }
    }

}
