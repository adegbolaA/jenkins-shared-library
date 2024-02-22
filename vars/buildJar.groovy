#!/user/bin/env groovy
def call() {
    echo 'Building'
    sh 'mvn package'
}
